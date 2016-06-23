package BimsS;
import BimsS.Absyn.*;
/** BNFC-Generated Abstract Visitor */
public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
/* Program */
    public R visit(BimsS.Absyn.PDefs p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(BimsS.Absyn.Program p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Stm */
    public R visit(BimsS.Absyn.SAss p, A arg) { return visitDefault(p, arg); }
    public R visit(BimsS.Absyn.SSkip p, A arg) { return visitDefault(p, arg); }
    public R visit(BimsS.Absyn.SIf p, A arg) { return visitDefault(p, arg); }
    public R visit(BimsS.Absyn.SWhile p, A arg) { return visitDefault(p, arg); }
    public R visit(BimsS.Absyn.SPrint p, A arg) { return visitDefault(p, arg); }
    public R visit(BimsS.Absyn.SInt p, A arg) { return visitDefault(p, arg); }
    public R visit(BimsS.Absyn.SIntArr p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(BimsS.Absyn.Stm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* Var */
    public R visit(BimsS.Absyn.VSolo p, A arg) { return visitDefault(p, arg); }
    public R visit(BimsS.Absyn.VMult p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(BimsS.Absyn.Var p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* BExp */
    public R visit(BimsS.Absyn.BEq p, A arg) { return visitDefault(p, arg); }
    public R visit(BimsS.Absyn.BGt p, A arg) { return visitDefault(p, arg); }

    public R visit(BimsS.Absyn.BNeg p, A arg) { return visitDefault(p, arg); }
    public R visit(BimsS.Absyn.BAnd p, A arg) { return visitDefault(p, arg); }



    public R visitDefault(BimsS.Absyn.BExp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
/* AExp */
    public R visit(BimsS.Absyn.APlus p, A arg) { return visitDefault(p, arg); }
    public R visit(BimsS.Absyn.AMinus p, A arg) { return visitDefault(p, arg); }

    public R visit(BimsS.Absyn.ATimes p, A arg) { return visitDefault(p, arg); }

    public R visit(BimsS.Absyn.AVar p, A arg) { return visitDefault(p, arg); }
    public R visit(BimsS.Absyn.AInt p, A arg) { return visitDefault(p, arg); }


    public R visitDefault(BimsS.Absyn.AExp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
