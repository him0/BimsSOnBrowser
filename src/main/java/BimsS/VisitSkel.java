package BimsS;
import BimsS.Absyn.*;
/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/
/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use. 
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ProgramVisitor<R,A> implements Program.Visitor<R,A>
  {
    public R visit(BimsS.Absyn.PDefs p, A arg)
    { /* Code For PDefs Goes Here */
      for (Stm x: p.liststm_)
      { /* ... */ }
      return null;
    }
  }
  public class StmVisitor<R,A> implements Stm.Visitor<R,A>
  {
    public R visit(BimsS.Absyn.SAss p, A arg)
    { /* Code For SAss Goes Here */
      p.var_.accept(new VarVisitor<R,A>(), arg);
      p.aexp_.accept(new AExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(BimsS.Absyn.SSkip p, A arg)
    { /* Code For SSkip Goes Here */
      return null;
    }    public R visit(BimsS.Absyn.SIf p, A arg)
    { /* Code For SIf Goes Here */
      p.bexp_.accept(new BExpVisitor<R,A>(), arg);
      for (Stm x: p.liststm_1)
      { /* ... */ }
      for (Stm x: p.liststm_2)
      { /* ... */ }
      return null;
    }    public R visit(BimsS.Absyn.SWhile p, A arg)
    { /* Code For SWhile Goes Here */
      p.bexp_.accept(new BExpVisitor<R,A>(), arg);
      for (Stm x: p.liststm_)
      { /* ... */ }
      return null;
    }    public R visit(BimsS.Absyn.SPrint p, A arg)
    { /* Code For SPrint Goes Here */
      p.var_.accept(new VarVisitor<R,A>(), arg);
      return null;
    }    public R visit(BimsS.Absyn.SInt p, A arg)
    { /* Code For SInt Goes Here */
      //p.ident_;
      return null;
    }    public R visit(BimsS.Absyn.SIntArr p, A arg)
    { /* Code For SIntArr Goes Here */
      //p.ident_;
      p.aexp_.accept(new AExpVisitor<R,A>(), arg);
      return null;
    }
  }
  public class VarVisitor<R,A> implements Var.Visitor<R,A>
  {
    public R visit(BimsS.Absyn.VSolo p, A arg)
    { /* Code For VSolo Goes Here */
      //p.ident_;
      return null;
    }    public R visit(BimsS.Absyn.VMult p, A arg)
    { /* Code For VMult Goes Here */
      //p.ident_;
      p.aexp_.accept(new AExpVisitor<R,A>(), arg);
      return null;
    }
  }
  public class BExpVisitor<R,A> implements BExp.Visitor<R,A>
  {
    public R visit(BimsS.Absyn.BEq p, A arg)
    { /* Code For BEq Goes Here */
      p.aexp_1.accept(new AExpVisitor<R,A>(), arg);
      p.aexp_2.accept(new AExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(BimsS.Absyn.BGt p, A arg)
    { /* Code For BGt Goes Here */
      p.aexp_1.accept(new AExpVisitor<R,A>(), arg);
      p.aexp_2.accept(new AExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(BimsS.Absyn.BNeg p, A arg)
    { /* Code For BNeg Goes Here */
      p.bexp_.accept(new BExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(BimsS.Absyn.BAnd p, A arg)
    { /* Code For BAnd Goes Here */
      p.bexp_1.accept(new BExpVisitor<R,A>(), arg);
      p.bexp_2.accept(new BExpVisitor<R,A>(), arg);
      return null;
    }            
  }
  public class AExpVisitor<R,A> implements AExp.Visitor<R,A>
  {
    public R visit(BimsS.Absyn.APlus p, A arg)
    { /* Code For APlus Goes Here */
      p.aexp_1.accept(new AExpVisitor<R,A>(), arg);
      p.aexp_2.accept(new AExpVisitor<R,A>(), arg);
      return null;
    }    public R visit(BimsS.Absyn.AMinus p, A arg)
    { /* Code For AMinus Goes Here */
      p.aexp_1.accept(new AExpVisitor<R,A>(), arg);
      p.aexp_2.accept(new AExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(BimsS.Absyn.ATimes p, A arg)
    { /* Code For ATimes Goes Here */
      p.aexp_1.accept(new AExpVisitor<R,A>(), arg);
      p.aexp_2.accept(new AExpVisitor<R,A>(), arg);
      return null;
    }        public R visit(BimsS.Absyn.AVar p, A arg)
    { /* Code For AVar Goes Here */
      p.var_.accept(new VarVisitor<R,A>(), arg);
      return null;
    }    public R visit(BimsS.Absyn.AInt p, A arg)
    { /* Code For AInt Goes Here */
      //p.integer_;
      return null;
    }        
  }
}