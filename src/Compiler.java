import c3a.C3a;
import c3a.C3aEval;
import sc.parser.*;
import sc.lexer.*;
import sc.node.*;
import java.io.*;
import sa.*;
import ts.Ts;
//import ts.*;
//import c3a.*;
//import nasm.*;
//import fg.*;

public class Compiler
{
    public static void main(String[] args)
    {
        PushbackReader br = null;
        String baseName = null;
        try {
            if (0 < args.length) {
                br = new PushbackReader(new FileReader(args[0]));
                baseName = removeSuffix(args[0], ".l");
            }
            else{
                System.out.println("il manque un argument");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // Create a Parser instance.
            Parser p = new Parser(new Lexer(br));
            // Parse the input.
            Start tree = p.parse();

            System.out.println("[SC]");
            tree.apply(new Sc2Xml(baseName));

	    System.out.println("[SA]");
	    Sc2Sa sc2sa = new Sc2Sa();
	    /** ICI **/
	    tree.apply(sc2sa);
	    SaNode saRoot = sc2sa.getRoot();
	    new Sa2Xml(saRoot, baseName);



	    System.out.println("[TABLE SYMBOLES]");
	    Ts table = new Sa2Ts(saRoot).getTableGlobale();
	    table.afficheTout(baseName);

        System.out.print("[EXEC SA] ");
        SaEval saEval = new SaEval(saRoot, table);

        System.out.println("[SA OUT]");
        saEval.affiche(baseName);

	    System.out.println("[C3A]");
	    C3a c3a = new Sc2C3a(saRoot, table).getC3a();
	    c3a.affiche(baseName);


	    System.out.println("[C3A OUT]");
	    C3aEval c3aEval = new C3aEval(c3a, table);
	    c3aEval.affiche(baseName);

	    /*System.out.println("[NASM]");
	    Nasm nasm = new C3a2nasm(c3a, table).getNasm();
	    nasm.affiche(baseName);

	    System.out.println("[FLOW GRAPH]");
	    Fg fg = new Fg(nasm);
	    fg.affiche(baseName);

	    System.out.println("[FLOW GRAPH SOLVE]");
	    FgSolution fgSolution = new FgSolution(nasm, fg);
	    fgSolution.affiche(baseName);*/



        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static String removeSuffix(final String s, final String suffix)
    {
        if (s != null && suffix != null && s.endsWith(suffix)){
            return s.substring(0, s.length() - suffix.length());
        }
        return s;
    }

}
