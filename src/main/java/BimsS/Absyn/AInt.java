package BimsS.Absyn; // Java Package generated by the BNF Converter.

public class AInt extends AExp {
  public final Integer integer_;
  public AInt(Integer p1) { integer_ = p1; }

  public <R,A> R accept(BimsS.Absyn.AExp.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof BimsS.Absyn.AInt) {
      BimsS.Absyn.AInt x = (BimsS.Absyn.AInt)o;
      return this.integer_.equals(x.integer_);
    }
    return false;
  }

  public int hashCode() {
    return this.integer_.hashCode();
  }


}