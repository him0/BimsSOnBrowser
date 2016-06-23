package BimsS;
import BimsS.Absyn.*;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  BimsS.Absyn.Program.Visitor<BimsS.Absyn.Program,A>,
  BimsS.Absyn.Stm.Visitor<BimsS.Absyn.Stm,A>,
  BimsS.Absyn.Var.Visitor<BimsS.Absyn.Var,A>,
  BimsS.Absyn.BExp.Visitor<BimsS.Absyn.BExp,A>,
  BimsS.Absyn.AExp.Visitor<BimsS.Absyn.AExp,A>
{
/* Program */
    public Program visit(BimsS.Absyn.PDefs p, A arg)
    {
      ListStm liststm_ = new ListStm();
      for (Stm x : p.liststm_)
      {
        liststm_.add(x.accept(this,arg));
      }
      return new BimsS.Absyn.PDefs(liststm_);
    }
/* Stm */
    public Stm visit(BimsS.Absyn.SAss p, A arg)
    {
      Var var_ = p.var_.accept(this, arg);
      AExp aexp_ = p.aexp_.accept(this, arg);
      return new BimsS.Absyn.SAss(var_, aexp_);
    }    public Stm visit(BimsS.Absyn.SSkip p, A arg)
    {
      return new BimsS.Absyn.SSkip();
    }    public Stm visit(BimsS.Absyn.SIf p, A arg)
    {
      BExp bexp_ = p.bexp_.accept(this, arg);
      ListStm liststm_1 = new ListStm();
      for (Stm x : p.liststm_1)
      {
        liststm_1.add(x.accept(this,arg));
      }
      ListStm liststm_2 = new ListStm();
      for (Stm x : p.liststm_2)
      {
        liststm_2.add(x.accept(this,arg));
      }
      return new BimsS.Absyn.SIf(bexp_, liststm_1, liststm_2);
    }    public Stm visit(BimsS.Absyn.SWhile p, A arg)
    {
      BExp bexp_ = p.bexp_.accept(this, arg);
      ListStm liststm_ = new ListStm();
      for (Stm x : p.liststm_)
      {
        liststm_.add(x.accept(this,arg));
      }
      return new BimsS.Absyn.SWhile(bexp_, liststm_);
    }    public Stm visit(BimsS.Absyn.SPrint p, A arg)
    {
      Var var_ = p.var_.accept(this, arg);
      return new BimsS.Absyn.SPrint(var_);
    }    public Stm visit(BimsS.Absyn.SInt p, A arg)
    {
      String ident_ = p.ident_;
      return new BimsS.Absyn.SInt(ident_);
    }    public Stm visit(BimsS.Absyn.SIntArr p, A arg)
    {
      String ident_ = p.ident_;
      AExp aexp_ = p.aexp_.accept(this, arg);
      return new BimsS.Absyn.SIntArr(ident_, aexp_);
    }
/* Var */
    public Var visit(BimsS.Absyn.VSolo p, A arg)
    {
      String ident_ = p.ident_;
      return new BimsS.Absyn.VSolo(ident_);
    }    public Var visit(BimsS.Absyn.VMult p, A arg)
    {
      String ident_ = p.ident_;
      AExp aexp_ = p.aexp_.accept(this, arg);
      return new BimsS.Absyn.VMult(ident_, aexp_);
    }
/* BExp */
    public BExp visit(BimsS.Absyn.BEq p, A arg)
    {
      AExp aexp_1 = p.aexp_1.accept(this, arg);
      AExp aexp_2 = p.aexp_2.accept(this, arg);
      return new BimsS.Absyn.BEq(aexp_1, aexp_2);
    }    public BExp visit(BimsS.Absyn.BGt p, A arg)
    {
      AExp aexp_1 = p.aexp_1.accept(this, arg);
      AExp aexp_2 = p.aexp_2.accept(this, arg);
      return new BimsS.Absyn.BGt(aexp_1, aexp_2);
    }    public BExp visit(BimsS.Absyn.BNeg p, A arg)
    {
      BExp bexp_ = p.bexp_.accept(this, arg);
      return new BimsS.Absyn.BNeg(bexp_);
    }    public BExp visit(BimsS.Absyn.BAnd p, A arg)
    {
      BExp bexp_1 = p.bexp_1.accept(this, arg);
      BExp bexp_2 = p.bexp_2.accept(this, arg);
      return new BimsS.Absyn.BAnd(bexp_1, bexp_2);
    }
/* AExp */
    public AExp visit(BimsS.Absyn.APlus p, A arg)
    {
      AExp aexp_1 = p.aexp_1.accept(this, arg);
      AExp aexp_2 = p.aexp_2.accept(this, arg);
      return new BimsS.Absyn.APlus(aexp_1, aexp_2);
    }    public AExp visit(BimsS.Absyn.AMinus p, A arg)
    {
      AExp aexp_1 = p.aexp_1.accept(this, arg);
      AExp aexp_2 = p.aexp_2.accept(this, arg);
      return new BimsS.Absyn.AMinus(aexp_1, aexp_2);
    }    public AExp visit(BimsS.Absyn.ATimes p, A arg)
    {
      AExp aexp_1 = p.aexp_1.accept(this, arg);
      AExp aexp_2 = p.aexp_2.accept(this, arg);
      return new BimsS.Absyn.ATimes(aexp_1, aexp_2);
    }    public AExp visit(BimsS.Absyn.AVar p, A arg)
    {
      Var var_ = p.var_.accept(this, arg);
      return new BimsS.Absyn.AVar(var_);
    }    public AExp visit(BimsS.Absyn.AInt p, A arg)
    {
      Integer integer_ = p.integer_;
      return new BimsS.Absyn.AInt(integer_);
    }
}