import sa.*;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2Sa extends DepthFirstAdapter {

    private SaNode returnValue;

    public SaNode getRoot() {
        return this.returnValue;
    }

    @Override
    public void caseStart(Start node) {
        node.getPProgramme().apply(this);
        //caseAProgramme((AProgramme) node.getPProgramme());
    }

    @Override
    public void caseAProgramme(AProgramme node) {
        SaLDec decVar = null;
        SaLDec decFonc = null;
        if (node.getLdvo() != null) {
            node.getLdvo().apply(this);
            decVar = (SaLDec) this.returnValue;
        }

        node.getLdf().apply(this);
        decFonc = (SaLDec) this.returnValue;

        this.returnValue = new SaProg(decVar,decFonc);
    }

    @Override
    public void caseAListVarOptLdvo(AListVarOptLdvo node) {

        SaLDec LdecVar = null;

        node.getLdv().apply(this);
        LdecVar = (SaLDec) this.returnValue;

        this.returnValue = new SaLDec(LdecVar.getTete(), LdecVar.getQueue());
    }

    @Override
    public void caseAListVarOptVideLdvo(AListVarOptVideLdvo node) {


        this.returnValue = null;
    }

    @Override
    public void caseAListVarMainLdv(AListVarMainLdv node) {
        /** ICI LOL **/
        SaDec decVar;
        node.getDvar().apply(this);
        decVar = (SaDec) this.returnValue;

        SaLDec alt = null;

        if (node.getLdvAlt() != null) {
            node.getLdvAlt().apply(this);
            alt = (SaLDec) this.returnValue;
        }

        this.returnValue = new SaLDec(decVar, alt);
    }

    @Override
    public void caseAListVarMainVideLdv(AListVarMainVideLdv node) {


        this.returnValue = null;
    }

    @Override
    public void caseAListeVarLdvAlt(AListeVarLdvAlt node) {
        SaDecVar decVar;
        SaLDec lDec;
        node.getDvar().apply(this);
        decVar = (SaDecVar) this.returnValue;
        node.getLdvAlt().apply(this);
        lDec = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(decVar, lDec);
    }

    @Override
    public void caseAListeVideVarLdvAlt(AListeVideVarLdvAlt node) {


        this.returnValue = null;
    }

    @Override
    public void caseALdfDvLdf(ALdfDvLdf node) {

        SaDecFonc decFonc;
        SaLDec ldf;
        node.getDf().apply(this);
        decFonc = (SaDecFonc) this.returnValue;
        node.getLdf().apply(this);
        ldf = (SaLDec) this.returnValue;
        this.returnValue = new SaLDec(decFonc, ldf);
    }

    @Override
    public void caseALdfVideLdf(ALdfVideLdf node) {
        this.returnValue = null;
    }

    @Override
    public void caseADefFctDf(ADefFctDf node) {
        TId id = node.getId();
        String nom = id.getText();
        SaLDec ldv;
        SaLDec ldvo = null;
        SaInstBloc ibloc;


        node.getLdv().apply(this);
        ldv = (SaLDec) this.returnValue;

        if ( node.getLdvo() != null ) {
            node.getLdvo().apply(this);
            ldvo = (SaLDec) this.returnValue;
        }

        node.getIbloc().apply(this);
        ibloc = (SaInstBloc)this.returnValue;
        this.returnValue = new SaDecFonc(nom,ldv,ldvo,ibloc);
    }

    @Override
    public void caseALdiIbloc(ALdiIbloc node) {
        SaLInst ldi = null;
        if (node.getLdi() != null) {
            node.getLdi().apply(this);
            ldi = (SaLInst) this.returnValue;
            this.returnValue = new SaInstBloc(ldi);
        }
        else {
            this.returnValue = null;
        }
    }

    @Override
    public void caseALdiListLdi(ALdiListLdi node) {

        SaInst instBloc = null;
        SaLInst ldi = null;

        if (node.getInstBloc() != null)
        {
            node.getInstBloc().apply(this);
            instBloc = (SaInst) this.returnValue;
        }


        if (node.getLdi() != null) {
            node.getLdi().apply(this);
            ldi = (SaLInst) this.returnValue;
            this.returnValue = new SaLInst(instBloc,ldi);
        }

        else this.returnValue = null;


    }

    @Override
    public void caseALdiVideLdi(ALdiVideLdi node) {
        this.returnValue = null;
    }

    @Override
    public void caseAIappInstBloc(AIappInstBloc node) {
        //SaAppel appel;
        node.getIapp().apply(this);
        //appel = (SaAppel) this.returnValue;
        //this.returnValue = new SaAppel(appel.getNom(), appel.getArguments());
    }

    @Override
    public void caseAIaffInstBloc(AIaffInstBloc node) {
        //SaInstAffect instAffect;
        node.getIaff().apply(this);
        //instAffect = (SaInstAffect) this.returnValue;
        //this.returnValue = new SaInstBloc(new SaLInst(instAffect,null));
        //this.returnValue = new SaInstAffect(instAffect.getLhs(),instAffect.getRhs());
    }

    @Override
    public void caseAIsiInstBloc(AIsiInstBloc node) {
        //SaInstSi instSi;
        node.getIsi().apply(this);
        //instSi = (SaInstSi)  this.returnValue;
        //this.returnValue = new SaInstSi(instSi.getTest(),instSi.getAlors(),instSi.getSinon());
    }

    @Override
    public void caseAItqInstBloc(AItqInstBloc node) {
        //SaInstTantQue instTantQue;
        node.getItq().apply(this);
        //instTantQue = (SaInstTantQue)  this.returnValue;
        //this.returnValue = new SaInstBloc(new SaLInst(new SaInstTantQue(instTantQue.getTest(),instTantQue.getFaire()),null));
        //this.returnValue = new SaInstTantQue(instTantQue.getTest(),instTantQue.getFaire());
    }

    @Override
    public void caseAIretInstBloc(AIretInstBloc node) {
        //SaInstRetour instRetour;
        node.getIret().apply(this);
        //instRetour = (SaInstRetour)  this.returnValue;

        //this.returnValue = new SaInstRetour(instRetour.getVal());
    }

    @Override
    public void caseAEcritureInstBloc(AEcritureInstBloc node) {
        node.getEcrire().apply(this);
    }

    @Override
    public void caseALireInstBloc(ALireInstBloc node) {
        //SaExpLire lire;
        node.getLire().apply(this);
        //lire = (SaExpLire) this.returnValue;
        //this.returnValue = new SaExpLire();
    }

    @Override
    public void caseAAppIapp(AAppIapp node) {
        SaAppel appel;
        node.getApp().apply(this);
        appel = (SaAppel) this.returnValue;
        this.returnValue = new SaAppel(appel.getNom(), appel.getArguments());
    }

    @Override
    public void caseAAppLdeApp(AAppLdeApp node) {
        SaLExp  lExp;
        node.getLde().apply(this);
        lExp = (SaLExp) this.returnValue;
        this.returnValue = new SaAppel(node.getId().getText(),lExp);
    }

    @Override
    public void caseAAffIaff(AAffIaff node) {
        SaVar var;
        SaExp exp;
        node.getVar().apply(this);
        var = (SaVar) this.returnValue;
        node.getExpr().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = new SaInstAffect(var, exp);
    }

    @Override
    public void caseAAffLireIaff(AAffLireIaff node) {
        SaExpLire lire;
        SaVar var;
        node.getVar().apply(this);
        var = (SaVar) this.returnValue;
        node.getLire().apply(this);
        lire = (SaExpLire) this.returnValue;
        this.returnValue = new SaInstAffect(var,lire);
    }

    @Override
    public void caseAInstSiIsi(AInstSiIsi node) {
        SaExp exp;
        SaInst alors;
        SaInst sinon;
        node.getExpr().apply(this);
        exp = (SaExp) this.returnValue;
        node.getIbloc().apply(this);
        alors = (SaInst) this.returnValue;
        node.getSinon().apply(this);
        sinon = (SaInst) this.returnValue;
        this.returnValue = new SaInstSi(exp, alors, sinon);
    }

    @Override
    public void caseAInstSinonSinon(AInstSinonSinon node) {
        //SaLInst ibloc;
        node.getIbloc().apply(this);
        //ibloc = (SaLInst) this.returnValue;
        //this.returnValue = new SaInstBloc(ibloc);
    }

    @Override
    public void caseASinonVideSinon(ASinonVideSinon node) {
        /*SaLInst ibloc = null;
        node.apply(this);
        ibloc = (SaLInst) this.returnValue;
        this.returnValue = new SaInstBloc(ibloc);*/
        this.returnValue = null;
    }

    @Override
    public void caseAInstTqItq(AInstTqItq node) {

        SaExp exp;
        SaInstBloc faire;
        node.getExpr().apply(this);
        exp = (SaExp) this.returnValue;
        node.getIbloc().apply(this);
        faire = (SaInstBloc) this.returnValue;

        this.returnValue = new SaInstTantQue(exp, faire);
    }

    @Override
    public void caseAInstRetIret(AInstRetIret node) {

        SaExp exp;
        node.getExpr().apply(this);
        exp = (SaExp) this.returnValue;

        this.returnValue = new SaInstRetour(exp);
    }

    @Override
    public void caseAVSimpleVar(AVSimpleVar node) {
        /*node.getId().apply(this);
        //var = (SaVarSimple) this.returnValue;
        this.returnValue = new SaVarSimple(node.getId().getText());*/

        //SaVarSimple var;
        //node.getId().apply(this);
        //var = (SaVarSimple) this.returnValue;

        this.returnValue = new SaVarSimple(node.getId().getText());
    }

    @Override
    public void caseAVDerivVar(AVDerivVar node) {


        //node.getId().apply(this);


        String nom = node.getId().getText();
        SaExp exp = new SaExpInt(Integer.parseInt(node.getNombre().getText()));
        this.returnValue = new SaVarIndicee(nom, exp);
    }

    @Override
    public void caseADvSimpleDvar(ADvSimpleDvar node) {

        //node.getId().apply(this);
        String nom = node.getId().getText();
        this.returnValue = new SaDecVar(nom);
    }

    @Override
    public void caseADvDeriveDvar(ADvDeriveDvar node) {
        String nom = node.getId().getText();
        int taille = Integer.parseInt(node.getNombre().getText());
        this.returnValue = new SaDecTab(nom,taille);
    }

    @Override
    public void caseALdeListLde(ALdeListLde node) {
        SaExp exp;
        SaLExp lExp;
        node.getExpr().apply(this);
        exp = (SaExp) this.returnValue;
        node.getLde().apply(this);
        lExp = (SaLExp) this.returnValue;
        this.returnValue = new SaLExp(exp,lExp);
    }

    @Override
    public void caseALdeListVirLde(ALdeListVirLde node) {
        SaLExp lExp;
        node.getLde().apply(this);
        lExp = (SaLExp) this.returnValue;
        this.returnValue = new SaLExp(lExp.getTete(),lExp.getQueue());
    }

    @Override
    public void caseALdeVideLde(ALdeVideLde node) {
        this.returnValue = null;
    }

    @Override
    public void caseAExprOuExpr(AExprOuExpr node) {
        SaExp op1;
        SaExp op2;
        node.getExpr().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpr1().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpOr(op1,op2);
    }

    @Override
    public void caseAExpr1Expr(AExpr1Expr node) {
        SaExp op1;
        node.getExpr1().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = op1;
    }

    @Override
    public void caseAExprEtExpr1(AExprEtExpr1 node) {
        SaExp op1;
        SaExp op2;
        node.getExpr1().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpr2().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAnd(op1,op2);
    }

    @Override
    public void caseAExpr2Expr1(AExpr2Expr1 node) {
        SaExp op1;
        node.getExpr2().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = op1;
    }

    @Override
    public void caseAExprEqExpr2(AExprEqExpr2 node) {
        SaExp op1;
        SaExp op2;
        node.getExpr2().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpr3().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpEqual(op1,op2);
    }

    @Override
    public void caseAExpInfExpr2(AExpInfExpr2 node) {
        SaExp op1;
        SaExp op2;
        node.getExpr2().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpr3().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpInf(op1,op2);
    }

    @Override
    public void caseAExpr3Expr2(AExpr3Expr2 node) {
        SaExp op1;
        node.getExpr3().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = op1;
    }

    @Override
    public void caseAExprPlusExpr3(AExprPlusExpr3 node) {
        SaExp op1;
        SaExp op2;
        node.getExpr3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpr4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpAdd(op1,op2);
    }

    @Override
    public void caseAExprMoinsExpr3(AExprMoinsExpr3 node) {
        SaExp op1;
        SaExp op2;
        node.getExpr3().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpr4().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpSub(op1,op2);
    }

    @Override
    public void caseAExpr4Expr3(AExpr4Expr3 node) {
        SaExp op1;
        node.getExpr4().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = op1;
    }

    @Override
    public void caseAExprMultExpr4(AExprMultExpr4 node) {
        SaExp op1;
        SaExp op2;
        node.getExpr4().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpr5().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpMult(op1,op2);
    }

    @Override
    public void caseAExprDivExpr4(AExprDivExpr4 node) {
        SaExp op1;
        SaExp op2;
        node.getExpr4().apply(this);
        op1 = (SaExp) this.returnValue;
        node.getExpr5().apply(this);
        op2 = (SaExp) this.returnValue;
        this.returnValue = new SaExpDiv(op1,op2);
    }

    @Override
    public void caseAExpr5Expr4(AExpr5Expr4 node) {
        SaExp op1;
        node.getExpr5().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = op1;
    }

    @Override
    public void caseAExprNonExpr5(AExprNonExpr5 node) {
        SaExpNot op1;
        node.getExpr5().apply(this);
        op1 = (SaExpNot) this.returnValue;
        this.returnValue = op1;
    }

    @Override
    public void caseAExpr6Expr5(AExpr6Expr5 node) {
        SaExp op1;
        node.getExpr6().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = op1;
    }

    @Override
    public void caseAExprParExpr6(AExprParExpr6 node) {
        SaExp op1;
        node.getExpr().apply(this);
        op1 = (SaExp) this.returnValue;
        this.returnValue = op1;
    }

    @Override
    public void caseAExprNbExpr6(AExprNbExpr6 node) {
        node.getNombre().apply(this);
        this.returnValue = new SaExpInt(Integer.parseInt(node.getNombre().getText()));
    }

    @Override
    public void caseAExprVarExpr6(AExprVarExpr6 node) {
        SaVar var;
        node.getVar().apply(this);
        var = (SaVar) this.returnValue;
        this.returnValue = new SaExpVar(var);
        //this.returnValue = var;
    }

    @Override
    public void caseAEcrAppelEcrire(AEcrAppelEcrire node) {

        node.getApp().apply(this);
        SaExpAppel app = new SaExpAppel((SaAppel) this.returnValue);


        this.returnValue = new SaInstEcriture(app);
        //this.returnValue = new SaInstEcriture(null);
    }

    @Override
    public void caseAEcrExprEcrire(AEcrExprEcrire node) {
        SaExp exp;
        node.getExpr().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = new SaInstEcriture(exp);
        //this.returnValue = new SaInstEcriture(null);
    }

    @Override
    public void caseALireLire(ALireLire node) {

        node.getLir().apply(this);
        this.returnValue = new SaExpLire();
    }
}
