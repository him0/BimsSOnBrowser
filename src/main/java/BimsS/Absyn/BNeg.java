package BimsS.Absyn; // Java Package generated by the BNF Converter.

public class BNeg extends BExp {
  public final BExp bexp_;
  public BNeg(BExp p1) { bexp_ = p1; }

  public <R,A> R accept(BimsS.Absyn.BExp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof BimsS.Absyn.BNeg) {
      BimsS.Absyn.BNeg x = (BimsS.Absyn.BNeg)o;
      return this.bexp_.equals(x.bexp_);
    }
    return false;
  }

  public int hashCode() {
    return this.bexp_.hashCode();
  }


}
