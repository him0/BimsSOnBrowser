package BimsS.Absyn; // Java Package generated by the BNF Converter.

public class BEq extends BExp {
  public final AExp aexp_1, aexp_2;
  public BEq(AExp p1, AExp p2) { aexp_1 = p1; aexp_2 = p2; }

  public <R,A> R accept(BimsS.Absyn.BExp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof BimsS.Absyn.BEq) {
      BimsS.Absyn.BEq x = (BimsS.Absyn.BEq)o;
      return this.aexp_1.equals(x.aexp_1) && this.aexp_2.equals(x.aexp_2);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.aexp_1.hashCode())+this.aexp_2.hashCode();
  }


}
