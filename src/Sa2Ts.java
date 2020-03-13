import sa.*;
import ts.Ts;
import ts.TsItem;
import ts.TsItemParam;
import ts.TsItemVar;

public class Sa2Ts extends SaDepthFirstVisitor<Void> {

    Ts tableGlobale;


    Sa2Ts(SaNode node)
    {
        tableGlobale = new Ts();
        node.accept(this);

    }

    @Override
    public Void visit(SaDecTab node) {

        if (this.tableGlobale.getVar(node.getNom()) == null)
            System.out.println("La variable "+ node.getNom()+"n'existe pas");
        return null;
    }

    @Override
    public Void visit(SaDecFonc node) {
        Ts tableLocale = new Ts();

        for (TsItemVar var : tableGlobale.variables.values())
        {
            tableLocale.addVar(var.identif,var.taille);
        }
//
//        for (TsItemParam param : tableGlobale)


        return null;
    }

    @Override
    public Void visit(SaDecVar node) {
        if (this.tableGlobale.getVar(node.getNom()) == null)
            this.tableGlobale.addVar(node.getNom(),node.tsItem.getTaille());

        return null;
    }

    @Override
    public Void visit(SaVarSimple node) {
            if (this.tableGlobale.getVar(node.getNom()) == null)
                System.out.println("La variable "+ node.getNom()+"n'existe pas");
        return null;
    }

    @Override
    public Void visit(SaAppel node) {
        if (this.tableGlobale.getFct(node.getNom()) == null)
            System.out.println("La fonction n'existe pas "+ node.getNom()+"n'existe pas");
        return null;
    }

    @Override
    public Void visit(SaVarIndicee node) {

//        if (this.tableGlobale.getVar()node.getNom()) == null)
//            System.out.println("La variable "+ node.getNom()+"n'existe pas");
        return null;
    }


    public Ts getTableGlobale() {
        return tableGlobale;
    }

}
