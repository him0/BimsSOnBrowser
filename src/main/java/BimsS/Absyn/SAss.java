package BimsS.Absyn; // Java Package generated by the BNF Converter.

public class SAss extends Stm {
  public final Var var_;
  public final AExp aexp_;
  public SAss(Var p1, AExp p2) { var_ = p1; aexp_ = p2; }

  public <R,A> R accept(BimsS.Absyn.Stm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof BimsS.Absyn.SAss) {
      BimsS.Absyn.SAss x = (BimsS.Absyn.SAss)o;
      return this.var_.equals(x.var_) && this.aexp_.equals(x.aexp_);
    }
    return false;
  }

  public int hashCode() {
    return 37*(this.var_.hashCode())+this.aexp_.hashCode();
  }


}
