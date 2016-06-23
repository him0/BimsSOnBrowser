package BimsS;

import BimsS.Absyn.*;

/** BNFC-Generated All Visitor */
public interface AllVisitor<R,A> extends
  BimsS.Absyn.Program.Visitor<R,A>,
  BimsS.Absyn.Stm.Visitor<R,A>,
  BimsS.Absyn.Var.Visitor<R,A>,
  BimsS.Absyn.BExp.Visitor<R,A>,
  BimsS.Absyn.AExp.Visitor<R,A>
{}
