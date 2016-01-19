package BimsS;
import java_cup.runtime.*;
import BimsS.*;
import BimsS.Absyn.*;
import java.io.*;

public class Interpret {
    public static String buffer = "";

    public Interpret() {
        buffer = "";
    }

    public static void main(String args[]) throws Exception {
        Yylex l = new Yylex(System.in);
        parser p = new parser(l) ;
        BimsS.Absyn.Program parse_tree = p.pProgram();
        buffer = Interpreter.exec(parse_tree);
        System.out.print(buffer);
    }

    public static String exec(String code) throws Exception {
        InputStream input = new ByteArrayInputStream(code.getBytes("utf-8"));
        Yylex l = new Yylex(input);
        parser p = new parser(l) ;
        BimsS.Absyn.Program parse_tree = p.pProgram();
        Interpreter i = new Interpreter();
        buffer = i.exec(parse_tree);
        return buffer;
    }
}

// javac BimsS/Interpret.java
