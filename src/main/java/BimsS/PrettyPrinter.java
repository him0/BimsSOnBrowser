package BimsS;
import BimsS.Absyn.*;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  private static final int INDENT_WIDTH = 2;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + INDENT_WIDTH;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       int t;
       _n_ = _n_ - INDENT_WIDTH;
       for(t=0; t<INDENT_WIDTH; t++) {
         backup();
       }
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(BimsS.Absyn.Program foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(BimsS.Absyn.Program foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(BimsS.Absyn.Stm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(BimsS.Absyn.Stm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(BimsS.Absyn.ListStm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(BimsS.Absyn.ListStm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(BimsS.Absyn.Var foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(BimsS.Absyn.Var foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(BimsS.Absyn.BExp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(BimsS.Absyn.BExp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(BimsS.Absyn.AExp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(BimsS.Absyn.AExp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(BimsS.Absyn.Program foo, int _i_)
  {
    if (foo instanceof BimsS.Absyn.PDefs)
    {
       BimsS.Absyn.PDefs _pdefs = (BimsS.Absyn.PDefs) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_pdefs.liststm_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(BimsS.Absyn.Stm foo, int _i_)
  {
    if (foo instanceof BimsS.Absyn.SAss)
    {
       BimsS.Absyn.SAss _sass = (BimsS.Absyn.SAss) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sass.var_, 0);
       render(":=");
       pp(_sass.aexp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.SSkip)
    {
       BimsS.Absyn.SSkip _sskip = (BimsS.Absyn.SSkip) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("skip");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.SIf)
    {
       BimsS.Absyn.SIf _sif = (BimsS.Absyn.SIf) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("if");
       render("(");
       pp(_sif.bexp_, 0);
       render(")");
       render("then");
       render("{");
       pp(_sif.liststm_1, 0);
       render("}");
       render("else");
       render("{");
       pp(_sif.liststm_2, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.SWhile)
    {
       BimsS.Absyn.SWhile _swhile = (BimsS.Absyn.SWhile) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("while");
       render("(");
       pp(_swhile.bexp_, 0);
       render(")");
       render("do");
       render("{");
       pp(_swhile.liststm_, 0);
       render("}");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.SPrint)
    {
       BimsS.Absyn.SPrint _sprint = (BimsS.Absyn.SPrint) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("print");
       pp(_sprint.var_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.SInt)
    {
       BimsS.Absyn.SInt _sint = (BimsS.Absyn.SInt) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("int");
       pp(_sint.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.SIntArr)
    {
       BimsS.Absyn.SIntArr _sintarr = (BimsS.Absyn.SIntArr) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("int");
       pp(_sintarr.ident_, 0);
       render("[");
       pp(_sintarr.aexp_, 0);
       render("]");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(BimsS.Absyn.ListStm foo, int _i_)
  {
     for (java.util.Iterator<Stm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(";");
       } else {
         render("");
       }
     }  }

  private static void pp(BimsS.Absyn.Var foo, int _i_)
  {
    if (foo instanceof BimsS.Absyn.VSolo)
    {
       BimsS.Absyn.VSolo _vsolo = (BimsS.Absyn.VSolo) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vsolo.ident_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.VMult)
    {
       BimsS.Absyn.VMult _vmult = (BimsS.Absyn.VMult) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_vmult.ident_, 0);
       render("[");
       pp(_vmult.aexp_, 0);
       render("]");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(BimsS.Absyn.BExp foo, int _i_)
  {
    if (foo instanceof BimsS.Absyn.BEq)
    {
       BimsS.Absyn.BEq _beq = (BimsS.Absyn.BEq) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_beq.aexp_1, 0);
       render("=");
       pp(_beq.aexp_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.BGt)
    {
       BimsS.Absyn.BGt _bgt = (BimsS.Absyn.BGt) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_bgt.aexp_1, 0);
       render("<");
       pp(_bgt.aexp_2, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.BNeg)
    {
       BimsS.Absyn.BNeg _bneg = (BimsS.Absyn.BNeg) foo;
       if (_i_ > 2) render(_L_PAREN);
       render("not");
       pp(_bneg.bexp_, 3);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.BAnd)
    {
       BimsS.Absyn.BAnd _band = (BimsS.Absyn.BAnd) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_band.bexp_1, 2);
       render("&&");
       pp(_band.bexp_2, 3);
       if (_i_ > 2) render(_R_PAREN);
    }
  }

  private static void pp(BimsS.Absyn.AExp foo, int _i_)
  {
    if (foo instanceof BimsS.Absyn.APlus)
    {
       BimsS.Absyn.APlus _aplus = (BimsS.Absyn.APlus) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_aplus.aexp_1, 1);
       render("+");
       pp(_aplus.aexp_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.AMinus)
    {
       BimsS.Absyn.AMinus _aminus = (BimsS.Absyn.AMinus) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_aminus.aexp_1, 1);
       render("-");
       pp(_aminus.aexp_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.ATimes)
    {
       BimsS.Absyn.ATimes _atimes = (BimsS.Absyn.ATimes) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_atimes.aexp_1, 2);
       render("*");
       pp(_atimes.aexp_2, 3);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.AVar)
    {
       BimsS.Absyn.AVar _avar = (BimsS.Absyn.AVar) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_avar.var_, 0);
       if (_i_ > 3) render(_R_PAREN);
    }
    else     if (foo instanceof BimsS.Absyn.AInt)
    {
       BimsS.Absyn.AInt _aint = (BimsS.Absyn.AInt) foo;
       if (_i_ > 3) render(_L_PAREN);
       pp(_aint.integer_, 0);
       if (_i_ > 3) render(_R_PAREN);
    }
  }


  private static void sh(BimsS.Absyn.Program foo)
  {
    if (foo instanceof BimsS.Absyn.PDefs)
    {
       BimsS.Absyn.PDefs _pdefs = (BimsS.Absyn.PDefs) foo;
       render("(");
       render("PDefs");
       render("[");
       sh(_pdefs.liststm_);
       render("]");
       render(")");
    }
  }

  private static void sh(BimsS.Absyn.Stm foo)
  {
    if (foo instanceof BimsS.Absyn.SAss)
    {
       BimsS.Absyn.SAss _sass = (BimsS.Absyn.SAss) foo;
       render("(");
       render("SAss");
       sh(_sass.var_);
       sh(_sass.aexp_);
       render(")");
    }
    if (foo instanceof BimsS.Absyn.SSkip)
    {
       BimsS.Absyn.SSkip _sskip = (BimsS.Absyn.SSkip) foo;
       render("SSkip");
    }
    if (foo instanceof BimsS.Absyn.SIf)
    {
       BimsS.Absyn.SIf _sif = (BimsS.Absyn.SIf) foo;
       render("(");
       render("SIf");
       sh(_sif.bexp_);
       render("[");
       sh(_sif.liststm_1);
       render("]");
       render("[");
       sh(_sif.liststm_2);
       render("]");
       render(")");
    }
    if (foo instanceof BimsS.Absyn.SWhile)
    {
       BimsS.Absyn.SWhile _swhile = (BimsS.Absyn.SWhile) foo;
       render("(");
       render("SWhile");
       sh(_swhile.bexp_);
       render("[");
       sh(_swhile.liststm_);
       render("]");
       render(")");
    }
    if (foo instanceof BimsS.Absyn.SPrint)
    {
       BimsS.Absyn.SPrint _sprint = (BimsS.Absyn.SPrint) foo;
       render("(");
       render("SPrint");
       sh(_sprint.var_);
       render(")");
    }
    if (foo instanceof BimsS.Absyn.SInt)
    {
       BimsS.Absyn.SInt _sint = (BimsS.Absyn.SInt) foo;
       render("(");
       render("SInt");
       sh(_sint.ident_);
       render(")");
    }
    if (foo instanceof BimsS.Absyn.SIntArr)
    {
       BimsS.Absyn.SIntArr _sintarr = (BimsS.Absyn.SIntArr) foo;
       render("(");
       render("SIntArr");
       sh(_sintarr.ident_);
       sh(_sintarr.aexp_);
       render(")");
    }
  }

  private static void sh(BimsS.Absyn.ListStm foo)
  {
     for (java.util.Iterator<Stm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(BimsS.Absyn.Var foo)
  {
    if (foo instanceof BimsS.Absyn.VSolo)
    {
       BimsS.Absyn.VSolo _vsolo = (BimsS.Absyn.VSolo) foo;
       render("(");
       render("VSolo");
       sh(_vsolo.ident_);
       render(")");
    }
    if (foo instanceof BimsS.Absyn.VMult)
    {
       BimsS.Absyn.VMult _vmult = (BimsS.Absyn.VMult) foo;
       render("(");
       render("VMult");
       sh(_vmult.ident_);
       sh(_vmult.aexp_);
       render(")");
    }
  }

  private static void sh(BimsS.Absyn.BExp foo)
  {
    if (foo instanceof BimsS.Absyn.BEq)
    {
       BimsS.Absyn.BEq _beq = (BimsS.Absyn.BEq) foo;
       render("(");
       render("BEq");
       sh(_beq.aexp_1);
       sh(_beq.aexp_2);
       render(")");
    }
    if (foo instanceof BimsS.Absyn.BGt)
    {
       BimsS.Absyn.BGt _bgt = (BimsS.Absyn.BGt) foo;
       render("(");
       render("BGt");
       sh(_bgt.aexp_1);
       sh(_bgt.aexp_2);
       render(")");
    }
    if (foo instanceof BimsS.Absyn.BNeg)
    {
       BimsS.Absyn.BNeg _bneg = (BimsS.Absyn.BNeg) foo;
       render("(");
       render("BNeg");
       sh(_bneg.bexp_);
       render(")");
    }
    if (foo instanceof BimsS.Absyn.BAnd)
    {
       BimsS.Absyn.BAnd _band = (BimsS.Absyn.BAnd) foo;
       render("(");
       render("BAnd");
       sh(_band.bexp_1);
       sh(_band.bexp_2);
       render(")");
    }
  }

  private static void sh(BimsS.Absyn.AExp foo)
  {
    if (foo instanceof BimsS.Absyn.APlus)
    {
       BimsS.Absyn.APlus _aplus = (BimsS.Absyn.APlus) foo;
       render("(");
       render("APlus");
       sh(_aplus.aexp_1);
       sh(_aplus.aexp_2);
       render(")");
    }
    if (foo instanceof BimsS.Absyn.AMinus)
    {
       BimsS.Absyn.AMinus _aminus = (BimsS.Absyn.AMinus) foo;
       render("(");
       render("AMinus");
       sh(_aminus.aexp_1);
       sh(_aminus.aexp_2);
       render(")");
    }
    if (foo instanceof BimsS.Absyn.ATimes)
    {
       BimsS.Absyn.ATimes _atimes = (BimsS.Absyn.ATimes) foo;
       render("(");
       render("ATimes");
       sh(_atimes.aexp_1);
       sh(_atimes.aexp_2);
       render(")");
    }
    if (foo instanceof BimsS.Absyn.AVar)
    {
       BimsS.Absyn.AVar _avar = (BimsS.Absyn.AVar) foo;
       render("(");
       render("AVar");
       sh(_avar.var_);
       render(")");
    }
    if (foo instanceof BimsS.Absyn.AInt)
    {
       BimsS.Absyn.AInt _aint = (BimsS.Absyn.AInt) foo;
       render("(");
       render("AInt");
       sh(_aint.integer_);
       render(")");
    }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(d); buf_.append(" "); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(d.toString()); }
  private static void sh(Character c) { render(c.toString()); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(" ");
      n--;
    }
  }
  private static void backup()
  {
     if (buf_.charAt(buf_.length() - 1) == ' ') {
      buf_.setLength(buf_.length() - 1);
    }
  }
  private static void trim()
  {
     while (buf_.length() > 0 && buf_.charAt(0) == ' ')
        buf_.deleteCharAt(0); 
    while (buf_.length() > 0 && buf_.charAt(buf_.length()-1) == ' ')
        buf_.deleteCharAt(buf_.length()-1);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

