import sa.*;
import ts.Ts;
import ts.TsItemVar;

public class Sa2Ts extends SaDepthFirstVisitor<Void> {

    Ts tableGlobale;
    Ts tableLocale;


    Sa2Ts(SaNode node)
    {
        tableLocale = null;
        tableGlobale = new Ts();
        if (node != null)
            node.accept(this);

    }

    @Override
    public Void visit(SaDecTab node) {

        if (this.tableGlobale.getVar(node.getNom()) == null) {
            System.out.println("La variable "+ node.getNom()+"n'existe pas 1");
          node.tsItem = this.tableGlobale.addVar(node.getNom(), 10);
        }



        return null;
    }

    @Override
    public Void visit(SaDecFonc node) {
        this.tableLocale = new Ts();

        int nbArgs = 0;

        if (!(tableGlobale.getFct(node.getNom()) == null)) {
            System.out.println("Fonction déjà existante");
        }
        else
        {
            if (node.getVariable() != null)  node.getVariable().accept(this);
            if (node.getParametres() != null) {
                nbArgs = node.getParametres().length();
                node.getParametres().accept(this);
            }
            if (node.getCorps() != null) node.getCorps().accept(this);
        }

        node.tsItem  = tableGlobale.addFct(node.getNom(), nbArgs,tableLocale,node);
        this.tableLocale = null;
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
            System.out.println("La variable "+ node.getNom()+"n'existe pas 2");
        return null;
    }

    @Override
    public Void visit(SaAppel node) {
        if (this.tableGlobale.getFct(node.getNom()) == null)
            System.out.println("La fonction n'existe pas "+ node.getNom()+"n'existe pas 3");
        return null;
    }

    @Override
    public Void visit(SaVarIndicee node) {

        if (this.tableGlobale.getVar(node.getNom()) == null) {
            System.out.println("La variable "+ node.getNom()+"n'existe pas 4");
            this.tableGlobale.addVar(node.getNom(),10);
        }

        return null;
    }


    public Ts getTableGlobale() {
        return tableGlobale;
    }

}
