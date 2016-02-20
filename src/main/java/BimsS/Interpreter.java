package BimsS;
import BimsS.Absyn.*;
import java.util.*;

public class Interpreter {
    public static String buffer = "";

    Interpreter() {
        buffer = "";
    }

    public static String exec(Program p) {
        p.accept(new ExecProgram(), new State());
        return buffer;
    }

    private static State exec(ListStm ls, State st) {
        for(Stm s : ls) {
            st = exec(s, st);
        }
        return st;
    }

    private static State exec(Stm s, State st) {
        return s.accept(new ExecStm(), st);
    }

    private static String exec(Var v, State st) {
        return v.accept(new ExecVar(), st);
    }

    private static boolean exec(BExp b, State st) {
        return b.accept(new ExecBExp(), st);
    }

    private static Integer exec(AExp a, State st) {
        return a.accept(new ExecAExp(), st);
    }


    public static class ExecProgram implements Program.Visitor<State, State> {
        public State visit(PDefs p, State st) {
            return exec(p.liststm_, st);
        }
    }

    public static class ExecStm implements Stm.Visitor<State, State> {
        public State visit(SAss s, State st) {
            String id = exec(s.var_, st);
            if (!(st.exists(id))) {
                System.out.printf("'%s' is not Variable.\n", id);
                return st;
            }

            Integer a = exec(s.aexp_, st);
            st.update(id, a);
            return st;
        }
        public State visit(SSkip s, State st) {
            // なにもしないよ！
            return st;
        }
        public State visit(SIf s, State st) {
            if (exec(s.bexp_, st)) {
                st = exec(s.liststm_1, st);
            }else {
                st = exec(s.liststm_2, st);
            }
            return st;
        }
        public State visit(SWhile s, State st) {
            while(exec(s.bexp_, st)) {
                st = exec(s.liststm_, st);
            }
            return st;
        }
        public State visit(SPrint s, State st) {
            String id = exec(s.var_, st);
            if (!(st.exists(id))) {
                System.out.printf("'%s' is not a Variable.\n", id);
                return st;
            }

            int a = st.lookup(id);
            String out = String.format("%d\n", a);
            buffer += out;
            return st;
        }
        public State visit(SInt s, State st) {
            String id = s.ident_;
            if (st.exists(id)) {
                System.out.printf("'%s' is already used for Variable.\n", id);
                return st;
            }
            st.update(id, 0);
            return st;
        }
        public State visit(SIntArr s, State st) {
            int size = exec(s.aexp_, st);
            String prefix = s.ident_;
            // String[] ids = new String[0];
            ArrayList<String> ids = new ArrayList<String>();

            for (int i=0; i<size; i++){
                String id = String.format("%s[%d]", prefix, i);
                ids.add(id);
                if (st.exists(id)) {
                    System.out.printf("'%s' is already used for Variable.\n", id);
                }
            }

            for (String id : ids) {
                st.update(id, 0);
            }
            return st;
        }
    }

    public static class ExecVar implements Var.Visitor<String, State> {
        public String visit(VSolo v, State st) {
            String id = v.ident_;
            return id; // 変数を識別する文字列
        }
        public String visit(VMult v, State st) {
            String prefix = v.ident_;
            int count = exec(v.aexp_, st).intValue();
            String id = String.format("%s[%d]", prefix, count);
            return id; // 変数を識別する文字列
        }
    }

    public static class ExecBExp implements BExp.Visitor<Boolean, State> {
        public Boolean visit(BEq b, State st) {
            int l = exec(b.aexp_1, st).intValue();
            int r = exec(b.aexp_2, st).intValue();
            return l == r;
        }
        public Boolean visit(BGt b, State st) {
            int l = exec(b.aexp_1, st).intValue();
            int r = exec(b.aexp_2, st).intValue();
            return l < r;
        }
        public Boolean visit(BNeg b, State st) {
            return !(exec(b.bexp_, st));
        }
        public Boolean visit(BAnd b, State st) {
            boolean l = exec(b.bexp_1, st);
            boolean r = exec(b.bexp_2, st);

            return (l && r);
        }
    }

    public static class ExecAExp implements AExp.Visitor<Integer, State> {
        public Integer visit(APlus a, State st) {
            Integer l = exec(a.aexp_1, st);
            Integer r = exec(a.aexp_2, st);
            return l + r;
        }
        public Integer visit(AMinus a, State st) {
            Integer l = exec(a.aexp_1, st);
            Integer r = exec(a.aexp_2, st);
            return l - r;
        }
        public Integer visit(ATimes a, State st) {
            Integer l = exec(a.aexp_1, st);
            Integer r = exec(a.aexp_2, st);
            return l * r;
        }
        public Integer visit(AVar a, State st) {
            String id = exec(a.var_, st);
            Integer r = st.lookup(id);
            return r;
        }
        public Integer visit(AInt a, State st) {
            return a.integer_;
        }
    }
}
