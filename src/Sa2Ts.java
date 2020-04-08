import sa.*;
import ts.Ts;
import ts.TsItemFct;
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


        if (this.tableLocale == null) {
            if (this.tableGlobale.getVar(node.getNom()) == null)
                node.tsItem = this.tableGlobale.addVar(node.getNom(), 10);
        }


        else {
            if (this.tableLocale.getVar(node.getNom()) != null) {
                if (!(this.tableLocale.getVar(node.getNom()).isParam)) {
                    if (this.tableGlobale.getVar(node.getNom()) == null)
                        node.tsItem = this.tableGlobale.addVar(node.getNom(), 10);
                }
            }
        }




        return null;
    }

    @Override
    public Void visit(SaDecFonc node) {


        this.tableLocale = new Ts();
        int nbArgs = 0;


        if (tableGlobale.getFct(node.getNom()) == null)
        {

            if (node.getParametres() != null) {

                nbArgs = node.getParametres().length();
                this.tableLocale.addParam(node.getParametres().getTete().getNom());


                if (node.getParametres().getQueue() != null) {
                    addRecursivesParams(node.getParametres().getQueue());
                }

                node.getParametres().accept(this);
            }

            if (node.getVariable() != null) {

                addRecursiveVar(node.getVariable());
            }


            if (node.getCorps() != null) node.getCorps().accept(this);

            node.tsItem  = tableGlobale.addFct(node.getNom(), nbArgs,tableLocale,node);

        }




        this.tableLocale = null;
        return null;
    }



    public void addRecursivesParams(SaLDec lDec) {
        this.tableLocale.addParam(lDec.getTete().getNom());
        if (lDec.getQueue() != null) addRecursivesParams(lDec.getQueue());
    }

    public void addRecursiveVar(SaLDec lDec) {
        lDec.getTete().accept(this);
//        this.tableLocale.addVar("BEN",100);
        if (lDec.getQueue() != null) addRecursiveVar(lDec.getQueue());
    }





    @Override
    public Void visit(SaDecVar node) {

//        if (this.tableLocale != null) {
//            if (this.tableLocale.getVar(node.getNom()) != null) {
//                if (!(this.tableLocale.getVar(node.getNom()).isParam)) {
//                    if (this.tableGlobale.getVar(node.getNom()) == null)
//                        node.tsItem = this.tableGlobale.addVar(node.getNom(),1);
//                }
//            }
//        }



        if (this.tableLocale == null) {

            if (this.tableGlobale.getVar(node.getNom()) == null)
                node.tsItem = this.tableGlobale.addVar(node.getNom(), 1);
        }

        else {

            if (this.tableLocale.getVar(node.getNom()) == null) {
                node.tsItem = this.tableLocale.addVar(node.getNom(), 1);
            }


        }


//        else {
//            if (this.tableLocale.getVar(node.getNom()) != null) {
//                if (!(this.tableLocale.getVar(node.getNom()).isParam)) {
//                    if (this.tableGlobale.getVar(node.getNom()) == null) {
//                        node.tsItem = this.tableGlobale.addVar(node.getNom(), 1);
//                    }
//
//                }
////                else {
////                    if (this.tableGlobale.getVar(node.getNom()) != null) {
////                        this.tableGlobale.variables.remove(node.getNom());
////                        node.tsItem = this.tableGlobale.addParam(node.getNom());
////                    }
////                }
//            }
//        }

        return null;
    }

    @Override
    public Void visit(SaVarSimple node) {
//        System.out.println("VAR SIMPLE 1");
//        if (!(this.tableLocale.getVar(node.getNom()).isParam)) {
//            System.out.println("VAR SIMPLE 2");
//            node.tsItem = this.tableGlobale.addVar(node.getNom(),1);
//        }
//        node.tsItem = this.tableGlobale.addVar(node.getNom(),1);




        if (this.tableLocale != null) {
            if (this.tableLocale.getVar(node.getNom()) != null)
                node.tsItem = this.tableLocale.getVar(node.getNom());
        }

        if (this.tableGlobale.getVar(node.getNom()) != null)
            node.tsItem = this.tableGlobale.getVar(node.getNom());
        return null;
    }

    @Override
    public Void visit(SaAppel node) {



        if (this.tableGlobale.getFct(node.getNom()) != null) {
            node.tsItem = this.tableGlobale.getFct(node.getNom());
            if (node.tsItem.nbArgs != 0) {
                node.getArguments().accept(this);
//                node.tsItem.saDecFonc.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visit(SaVarIndicee node) {

//        System.out.println("VAR INDICEE");
//        if (!(this.tableLocale.getVar(node.getNom()).isParam)) {
//            node.tsItem = this.tableGlobale.addVar(node.getNom(),10);
//            node.getIndice().accept(this);
//        }

//        node.tsItem = this.tableGlobale.addVar(node.getNom(),10);
//        node.getIndice().accept(this);

        if (this.tableLocale != null) {
            if (this.tableLocale.getVar(node.getNom()) != null)
                node.tsItem = this.tableLocale.getVar(node.getNom());
        }

        if (this.tableGlobale.getVar(node.getNom()) != null)
            node.tsItem = this.tableGlobale.getVar(node.getNom());

        if (node.getIndice() != null)
            node.getIndice().accept(this);
        return null;
    }


    public Ts getTableGlobale() {
        return tableGlobale;
    }

}