package BimsS.Absyn; // Java Package generated by the BNF Converter.

public class SInt extends Stm {
  public final String ident_;
  public SInt(String p1) { ident_ = p1; }

  public <R,A> R accept(BimsS.Absyn.Stm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (o instanceof BimsS.Absyn.SInt) {
      BimsS.Absyn.SInt x = (BimsS.Absyn.SInt)o;
      return this.ident_.equals(x.ident_);
    }
    return false;
  }

  public int hashCode() {
    return this.ident_.hashCode();
  }


}
