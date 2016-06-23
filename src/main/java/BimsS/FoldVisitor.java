package BimsS;

import BimsS.Absyn.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* Program */
    public R visit(BimsS.Absyn.PDefs p, A arg) {
      R r = leaf(arg);
      for (Stm x : p.liststm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Stm */
    public R visit(BimsS.Absyn.SAss p, A arg) {
      R r = leaf(arg);
      r = combine(p.var_.accept(this, arg), r, arg);
      r = combine(p.aexp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(BimsS.Absyn.SSkip p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(BimsS.Absyn.SIf p, A arg) {
      R r = leaf(arg);
      r = combine(p.bexp_.accept(this, arg), r, arg);
      for (Stm x : p.liststm_1)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      for (Stm x : p.liststm_2)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(BimsS.Absyn.SWhile p, A arg) {
      R r = leaf(arg);
      r = combine(p.bexp_.accept(this, arg), r, arg);
      for (Stm x : p.liststm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }
    public R visit(BimsS.Absyn.SPrint p, A arg) {
      R r = leaf(arg);
      r = combine(p.var_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(BimsS.Absyn.SInt p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(BimsS.Absyn.SIntArr p, A arg) {
      R r = leaf(arg);
      r = combine(p.aexp_.accept(this, arg), r, arg);
      return r;
    }

/* Var */
    public R visit(BimsS.Absyn.VSolo p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(BimsS.Absyn.VMult p, A arg) {
      R r = leaf(arg);
      r = combine(p.aexp_.accept(this, arg), r, arg);
      return r;
    }

/* BExp */
    public R visit(BimsS.Absyn.BEq p, A arg) {
      R r = leaf(arg);
      r = combine(p.aexp_1.accept(this, arg), r, arg);
      r = combine(p.aexp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(BimsS.Absyn.BGt p, A arg) {
      R r = leaf(arg);
      r = combine(p.aexp_1.accept(this, arg), r, arg);
      r = combine(p.aexp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(BimsS.Absyn.BNeg p, A arg) {
      R r = leaf(arg);
      r = combine(p.bexp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(BimsS.Absyn.BAnd p, A arg) {
      R r = leaf(arg);
      r = combine(p.bexp_1.accept(this, arg), r, arg);
      r = combine(p.bexp_2.accept(this, arg), r, arg);
      return r;
    }

/* AExp */
    public R visit(BimsS.Absyn.APlus p, A arg) {
      R r = leaf(arg);
      r = combine(p.aexp_1.accept(this, arg), r, arg);
      r = combine(p.aexp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(BimsS.Absyn.AMinus p, A arg) {
      R r = leaf(arg);
      r = combine(p.aexp_1.accept(this, arg), r, arg);
      r = combine(p.aexp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(BimsS.Absyn.ATimes p, A arg) {
      R r = leaf(arg);
      r = combine(p.aexp_1.accept(this, arg), r, arg);
      r = combine(p.aexp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(BimsS.Absyn.AVar p, A arg) {
      R r = leaf(arg);
      r = combine(p.var_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(BimsS.Absyn.AInt p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
