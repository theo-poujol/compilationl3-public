import c3a.*;
import sa.*;
import ts.Ts;
import ts.TsItemFct;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Sa2C3a extends SaDepthFirstVisitor<C3aOperand> {
    private C3a c3a;
    private Ts ts;

    public Sa2C3a(SaNode root, Ts table) {
        this.c3a = new C3a();
        this.ts = table;
        root.accept(this);
    }


    public C3a getC3a() {
        return this.c3a;
    }

    public Ts getTs() { return this.ts; }

    @Override
    public C3aOperand visit(SaProg node) {
        if (node.getVariables() != null) visit(node.getVariables());
        return visit(node.getFonctions());
    }


    public C3aOperand addRecursiveFunctions(SaLDec ldec) {
        C3aInstFBegin c3aInstFBegin = new C3aInstFBegin(this.ts.getFct(ldec.getTete().getNom()).saDecFonc.tsItem,"entree " + "fonction");
        this.c3a.ajouteInst(c3aInstFBegin);
        if (ldec.getQueue() != null) addRecursiveFunctions(ldec.getQueue());
        return visit(ldec);
    }

    @Override
    public C3aOperand visit(SaDecTab node) {
        return new C3aVar(node.tsItem,new C3aConstant(node.getTaille()));
    }

    @Override
    public C3aOperand visit(SaExp node) {
        return node.accept(this);
//        return this.c3a.newTemp();
//        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpInt node) {

        return new C3aConstant(node.getVal());
    }

    @Override
    public C3aOperand visit(SaExpVar node) {

        if (node.getVar().getTaille() > 1) {
            SaVarIndicee var = (SaVarIndicee) node.getVar();
            return new C3aVar(var.tsItem,visit(var.getIndice()));
        }
        else {
            SaVarSimple var = (SaVarSimple) node.getVar();
            return new C3aVar(var.tsItem, null);
        }
    }

    @Override
    public C3aOperand visit(SaInstEcriture node) {
        C3aOperand op = visit(node.getArg());
        C3aInstWrite w = new C3aInstWrite(op,"");
        this.c3a.ajouteInst(w);
        return op;
//        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstTantQue node) {

        C3aLabel lab0 = this.c3a.newAutoLabel();
        C3aLabel lab1 = this.c3a.newAutoLabel();
        this.c3a.addLabelToNextInst(lab0);
        C3aOperand op = visit(node.getTest());

        C3aInstJumpIfEqual eq = new C3aInstJumpIfEqual(op, new C3aConstant(0),lab1,"");
        this.c3a.ajouteInst(eq);
        visit((SaInstBloc) node.getFaire());

        C3aInstJump jump = new C3aInstJump(lab0,"");
        this.c3a.ajouteInst(jump);
        this.c3a.addLabelToNextInst(lab1);
        return op;
    }

    @Override
    public C3aOperand visit(SaLInst node) {
        /** LINST **/
//        return visit((SaInstEcriture) node.getTete());
//        return node.accept(this);

        return super.visit(node);

    }



    public void addRecursiveParams(SaLDec params) {
        C3aInstParam param = new C3aInstParam(visit((SaDecVar) params.getTete()),"");
        this.c3a.ajouteInst(param);
        if (params.getQueue() != null) addRecursiveParams(params.getQueue());
    }




    @Override
    public C3aOperand visit(SaDecFonc node) {

        C3aInstFBegin c3aInstFBegin = new C3aInstFBegin(node.tsItem,"entree " + "fonction");
        this.c3a.ajouteInst(c3aInstFBegin);

        // On visite les paramètres
        if (node.tsItem.nbArgs != 0) {
            // todo peut-être checker pour les variables, à vérifier
//            addRecursiveParams(node.getParametres());
        }

        C3aOperand op1 = visit((SaInstBloc) node.getCorps());
        C3aFunction function = new C3aFunction(node.tsItem);
        this.c3a.ajouteInst(new C3aInstFEnd(""));
        return function;

    }

    @Override
    public C3aOperand visit(SaDecVar node) {

        C3aVar var;

        System.out.println("taille " + node.tsItem.taille);
        if (node.tsItem.taille > 1) {
            var = new C3aVar(node.tsItem, new C3aConstant(node.tsItem.taille));
        }

        else {
            var = new C3aVar(node.tsItem, null);
        }

        return var;
    }

    @Override
    public C3aOperand visit(SaInstAffect node) {

        String nom = node.getLhs().getNom();
        C3aOperand op = null;

        String fct = "";

        for (String nomFct : this.ts.fonctions.keySet()) {
            fct = nomFct;
        }


        System.out.println("FONCTION " +  fct);
        System.out.println("ARGS " + this.ts.getTableLocale(fct).nbArg());
        System.out.println("VAR " + this.ts.getTableLocale(fct).nbVar());

        if (this.ts.getTableLocale(fct).getVar(nom) != null) {
            if (this.ts.getTableLocale(fct).getVar(nom).taille > 1) {
                op = visit((SaVarIndicee) node.getLhs());
            }

            else {
                op = visit((SaVarSimple) node.getLhs());
            }
        }

        else {
            if (this.ts.getVar(nom).taille > 1) {
                op = visit((SaVarIndicee) node.getLhs());
            }

            else {
                op = visit((SaVarSimple) node.getLhs());
            }
        }

        C3aInstAffect affect = new C3aInstAffect(visit(node.getRhs()),op,"");
        this.c3a.ajouteInst(affect);
        return op;
    }

    @Override
    public C3aOperand visit(SaLDec node) {
//       if (this.ts.getFct(node.getTete().getNom()).saDecFonc.getParametres() != null) {
//           visit(this.ts.getFct(node.getTete().getNom()).saDecFonc.getParametres().getQueue());
//       }

//       System.out.println(node.getTete().getNom());
//       if (this.ts.getVar(node.getTete().getNom()) == null) System.out.println(node.getTete().getNom() + " cest nul frero");
//       if (this.ts.variables.get(node.getTete().getNom()) != null) {
//           if (this.ts.variables.get((node.getTete().getNom())).isParam) {
//               C3aInstParam param = new C3aInstParam(visit((SaExp) node.getTete()),"");
//               this.c3a.ajouteInst(param);
//               if (node.getQueue() != null) {
//                   visit(node.getQueue());
//               }
//           }
//       }


        if (this.ts.getVar(node.getTete().getNom()) != null) {
            System.out.println("VAR " + node.getTete().getNom());
            if (this.ts.getVar(node.getTete().getNom()).taille > 1) visit((SaDecTab) node.getTete());
            else visit((SaDecVar) node.getTete());

            if (node.getQueue() != null) {
                visit(node.getQueue());
            }
        }

        if (this.ts.getFct(node.getTete().getNom()) != null) {
            visit((SaDecFonc) node.getTete());
            if (node.getQueue() != null) {
                visit(node.getQueue());
            }
            return null;
        }
        else return null;
    }

    @Override
    public C3aOperand visit(SaVarSimple node) {
        return new C3aVar(node.tsItem,null);
    }

    @Override
    public C3aOperand visit(SaAppel node) {
        return visit(new SaExpAppel(node));
    }

    @Override
    public C3aOperand visit(SaExpAppel node) {

        C3aTemp temp = this.c3a.newTemp();
        addRecursiveCall(node.getVal().getArguments());

        C3aInstCall call = new C3aInstCall(new C3aFunction(this.ts.getFct(node.getVal().getNom()).saDecFonc.tsItem),temp,"");
        this.c3a.ajouteInst(call);
        return temp;
    }

    public void addRecursiveCall(SaLExp lExp) {
        C3aInstParam param = new C3aInstParam(visit(lExp.getTete()),"");
        this.c3a.ajouteInst(param);
        if (lExp.getQueue() != null) addRecursiveCall(lExp.getQueue());
    }

    @Override
    public C3aOperand visit(SaExpAdd node) {



        C3aOperand op1 = visit(node.getOp1());
        C3aOperand op2 = visit(node.getOp2());
        C3aTemp temp = this.c3a.newTemp();
        C3aInstAdd instAdd =  new C3aInstAdd(op1, op2, temp , "");
        this.c3a.ajouteInst(instAdd);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpSub node) {
        C3aOperand op1 = visit(node.getOp1());
        C3aOperand op2 = visit(node.getOp2());
        C3aTemp temp = this.c3a.newTemp();
        C3aInstSub instSub =  new C3aInstSub(op1, op2, temp, "");
        this.c3a.ajouteInst(instSub);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpMult node) {
        C3aOperand op1 = visit(node.getOp1());
        C3aOperand op2 = visit(node.getOp2());
        C3aTemp temp = this.c3a.newTemp();
        C3aInstMult instMult =  new C3aInstMult(op1, op2, temp, "");
        this.c3a.ajouteInst(instMult);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpDiv node) {
        C3aOperand op1 = visit(node.getOp1());
        C3aOperand op2 = visit(node.getOp2());
        C3aTemp temp = this.c3a.newTemp();
        C3aInstDiv instDiv =  new C3aInstDiv(op1, op2, temp, "");
        this.c3a.ajouteInst(instDiv);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpInf node) {

        C3aTemp res = this.c3a.newTemp();



        C3aOperand op1 = visit(node.getOp1());
        C3aOperand op2 = visit(node.getOp2());

        C3aLabel lab = this.c3a.newAutoLabel();

        C3aInstAffect aff = new C3aInstAffect(new C3aConstant(1), res,"");
        this.c3a.ajouteInst(aff);
        C3aInstJumpIfLess less = new C3aInstJumpIfLess(op1,op2,lab,"");
        this.c3a.ajouteInst(less);

        C3aInstAffect aff2 = new C3aInstAffect(new C3aConstant(0), res,"");
        this.c3a.ajouteInst(aff2);


        this.c3a.addLabelToNextInst(lab);
        return res;
    }

    @Override
    public C3aOperand visit(SaExpEqual node) {
        System.out.println("je rentre dans eq");
        C3aOperand op1 = visit(node.getOp1());
        C3aOperand op2 = visit(node.getOp2());
        C3aTemp temp = this.c3a.newTemp();
        C3aInstJumpIfEqual inst = new C3aInstJumpIfEqual(op1,op2,temp,"");
        this.c3a.ajouteInst(inst);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpAnd node) {

        C3aLabel lab0 = this.c3a.newAutoLabel();
        C3aLabel lab1 = this.c3a.newAutoLabel();

        C3aTemp temp = this.c3a.newTemp();

        C3aOperand op1 = visit(node.getOp1());
        C3aOperand op2 = visit(node.getOp2());

        C3aInstJumpIfEqual ifEqual1 = new C3aInstJumpIfEqual(op1, visit(new SaExpInt(0)),lab1,"");
        this.c3a.ajouteInst(ifEqual1);

        C3aInstJumpIfEqual ifEqual2 = new C3aInstJumpIfEqual(op2, visit(new SaExpInt(0)),lab1,"");
        this.c3a.ajouteInst(ifEqual2);


        C3aInstAffect aff_1 = new C3aInstAffect(new C3aConstant(1), temp, "");
        this.c3a.ajouteInst(aff_1);

        C3aInstJump jump_l0 = new C3aInstJump(lab0,"");
        this.c3a.ajouteInst(jump_l0);

        this.c3a.addLabelToNextInst(lab1);

        C3aInstAffect aff_0 = new C3aInstAffect(new C3aConstant(0), temp, "");
        this.c3a.ajouteInst(aff_0);


        this.c3a.addLabelToNextInst(lab0);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpOr node) {


        C3aLabel lab0 = this.c3a.newAutoLabel();
        C3aLabel lab1 = this.c3a.newAutoLabel();

        C3aOperand op1 = visit(node.getOp1());
        C3aTemp temp = this.c3a.newTemp();
        C3aOperand op2 = visit(node.getOp2());

        C3aInstJumpIfNotEqual ifNotEqualEqual1 = new C3aInstJumpIfNotEqual(op1, visit(new SaExpInt(0)),lab1,"");
        this.c3a.ajouteInst(ifNotEqualEqual1);

        C3aInstJumpIfNotEqual ifNotEqual2 = new C3aInstJumpIfNotEqual(op2, visit(new SaExpInt(0)),lab1,"");
        this.c3a.ajouteInst(ifNotEqual2);

        C3aInstAffect aff_0 = new C3aInstAffect(new C3aConstant(0), temp, "");
        this.c3a.ajouteInst(aff_0);

        C3aInstJump jump_l0 = new C3aInstJump(lab0,"");
        this.c3a.ajouteInst(jump_l0);

        this.c3a.addLabelToNextInst(lab1);

        C3aInstAffect aff_1 = new C3aInstAffect(new C3aConstant(1), temp, "");
        this.c3a.ajouteInst(aff_1);


        this.c3a.addLabelToNextInst(lab0);
        return temp;
    }

    @Override
    public C3aOperand visit(SaExpNot node) {

        C3aOperand temp = visit(node.getOp1());
        C3aInstAffect lastInst = (C3aInstAffect) this.c3a.listeInst.get(this.c3a.listeInst.size() - 1);

        // On fait l'inverse de la réponse

        //this.c3a.listeInst.remove(lastInst);
        //C3aInstAffect newAffect = new C3aInstAffect(newOp,temp,"");
        return new C3aConstant(1 - Integer.parseInt(lastInst.op1.toString()));
    }

    @Override
    public C3aOperand visit(SaExpLire node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstBloc node) {
        return visit(node.getVal());
    }

    @Override
    public C3aOperand visit(SaInstSi node) {

        C3aOperand op = visit(node.getTest());
        C3aLabel lab = this.c3a.newAutoLabel();
        C3aInstJumpIfEqual jump = new C3aInstJumpIfEqual(op, new C3aConstant(0),lab,"");
        this.c3a.ajouteInst(jump);

        visit((SaInstBloc) node.getAlors());
        if (node.getSinon() != null) {
            C3aLabel lab1 = this.c3a.newAutoLabel();
            C3aInstJump jumpSinon = new C3aInstJump(lab1,"");
            this.c3a.ajouteInst(jumpSinon);
            this.c3a.addLabelToNextInst(lab);
            visit((SaInstBloc) node.getSinon());
            this.c3a.addLabelToNextInst(lab1);
        }

        else {
            this.c3a.addLabelToNextInst(lab);
        }

        return op;
    }

    @Override
    public C3aOperand visit(SaInstRetour node) {

        C3aOperand op1 = visit(node.getVal());
        this.c3a.ajouteInst(new C3aInstReturn(op1, ""));
        return op1;
    }

    @Override
    public C3aOperand visit(SaLExp node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaVarIndicee node) {
        return new C3aVar(node.tsItem, visit(node.getIndice()));
    }
}
