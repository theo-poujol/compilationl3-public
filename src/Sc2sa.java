import sa.*;
import sc.analysis.DepthFirstAdapter;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;

    @Override
    public void caseAProgramme(AProgramme node) {
        SaLDec decVar = null;
        SaLDec decFonc = null;
        node.getLdvo().apply(this);
        decVar = (SaLDec) this.returnValue;
        node.getLdf().apply(this);
        decFonc = (SaLDec) this.returnValue;

        this.returnValue = new SaProg(decVar,decFonc);
    }

    @Override
    public void caseAListVarOptLdvo(AListVarOptLdvo node) {
        SaDecVar decVar = null;
        node.getLdv().apply(this);
        decVar = (SaDecVar) this.returnValue;

        this.returnValue = new SaDecVar(decVar.getNom());
    }

    @Override
    public void caseAListVarOptVideLdvo(AListVarOptVideLdvo node) {
        SaDecVar decVar = null;
        node.apply(this);
        decVar = (SaDecVar) this.returnValue;

        this.returnValue = new SaDecVar(decVar.getNom());
    }

    @Override
    public void caseAListVarMainLdv(AListVarMainLdv node) {
        SaDecVar decVar = null;
        SaLDec lDec = null;
        node.getDvar().apply(this);
        decVar = (SaDecVar) this.returnValue;
        node.getLdvAlt().apply(this);
        lDec = (SaLDec) this.returnValue;

        this.returnValue = new SaLDec(decVar, lDec);
    }

    @Override
    public void caseAListVarMainVideLdv(AListVarMainVideLdv node) {
        SaDecVar decVar = null;
        SaLDec lDec = null;
        node.apply(this);
        decVar = (SaDecVar) this.returnValue;
        node.apply(this);
        lDec = (SaLDec) this.returnValue;

        this.returnValue = new SaLDec(decVar, lDec);
    }

    @Override
    public void caseAListeVarLdvAlt(AListeVarLdvAlt node) {
        SaDecVar decVar = null;
        SaLDec lDec = null;
        node.getDvar().apply(this);
        decVar = (SaDecVar) this.returnValue;
        node.getLdvAlt().apply(this);
        lDec = (SaLDec) this.returnValue;


        this.returnValue = new SaLDec(decVar, lDec);
    }

    @Override
    public void caseAListeVideVarLdvAlt(AListeVideVarLdvAlt node) {
        SaDecVar decVar = null;
        SaLDec lDec = null;
        node.apply(this);
        decVar = (SaDecVar) this.returnValue;
        node.apply(this);
        lDec = (SaLDec) this.returnValue;

        this.returnValue = new SaLDec(decVar, lDec);
    }

    @Override
    public void caseALdfDvLdf(ALdfDvLdf node) {
        SaDecFonc decFonc = null;
        node.getDf().apply(this);
        decFonc = (SaDecFonc) this.returnValue;

        this.returnValue = new SaDecFonc(decFonc.getNom(), decFonc.getParametres(), decFonc.getVariable(), decFonc.getCorps());
    }

    @Override
    public void caseALdfVideLdf(ALdfVideLdf node) {
        SaDecFonc decFonc = null;
        node.apply(this);
        decFonc = (SaDecFonc) this.returnValue;

        this.returnValue = new SaDecFonc(decFonc.getNom(), decFonc.getParametres(), decFonc.getVariable(), decFonc.getCorps());
    }

    @Override
    public void caseADefFctDf(ADefFctDf node) {
        SaLDec ldv;
        SaLDec ldvo;
        SaInstBloc ibloc;
        node.getLdv().apply(this);
        ldv = (SaLDec) this.returnValue;
        node.getLdvo().apply(this);
        ldvo = (SaLDec) this.returnValue;
        node.getIbloc().apply(this);
        ibloc = (SaInstBloc)this.returnValue;

        this.returnValue = new SaDecFonc(node.getId().getText(),ldv,ldvo,ibloc);

    }

    @Override
    public void caseALdiIbloc(ALdiIbloc node) {
        SaLInst ldi;
        node.getLdi().apply(this);
        ldi = (SaLInst) this.returnValue;
        this.returnValue = new SaInstBloc(ldi);
    }

    @Override
    public void caseALdiListLdi(ALdiListLdi node) {
        SaInstBloc instBloc;
        SaLInst ldi;
        node.getInstBloc().apply(this);
        instBloc = (SaInstBloc) this.returnValue;
        node.getLdi().apply(this);
        ldi = (SaLInst) this.returnValue;
        this.returnValue = new SaLInst(instBloc,ldi);

    }

    @Override
    public void caseALdiVideLdi(ALdiVideLdi node) {

        SaInstBloc instBloc = null;
        SaLInst ldi = null;
        node.apply(this);
        instBloc = (SaInstBloc) this.returnValue;
        node.apply(this);
        ldi = (SaLInst) this.returnValue;
        this.returnValue = new SaLInst(instBloc,ldi);

    }

    @Override
    public void caseAIappInstBloc(AIappInstBloc node) {
        SaAppel app = null;
        node.getIapp().apply(this);
        app = (SaAppel) this.returnValue;
        this.returnValue = new SaAppel(app.getNom(),app.getArguments());
        this.returnValue = app;
    }

    @Override
    public void caseAIaffInstBloc(AIaffInstBloc node) {
        SaInstAffect aff = null;
        node.getIaff().apply(this);
        aff = (SaInstAffect) this.returnValue;
        this.returnValue = aff;

    }

    @Override
    public void caseAIsiInstBloc(AIsiInstBloc node) {
        SaInstSi si = null;
        node.getIsi().apply(this);
        si = (SaInstSi) this.returnValue;
        this.returnValue = si;
    }

    @Override
    public void caseAItqInstBloc(AItqInstBloc node) {

        SaInstTantQue tq = null;
        node.getItq().apply(this);
        tq = (SaInstTantQue) this.returnValue;
        this.returnValue = tq;
    }

    @Override
    public void caseAIretInstBloc(AIretInstBloc node) {
        SaInstRetour ret = null;
        node.getIret().apply(this);
        ret = (SaInstRetour) this.returnValue;
        this.returnValue = ret;

    }

    @Override
    public void caseAEcritureInstBloc(AEcritureInstBloc node) {
        super.caseAEcritureInstBloc(node);
    }

    @Override
    public void caseALireInstBloc(ALireInstBloc node) {
        super.caseALireInstBloc(node);
    }

    @Override
    public void caseAAppIapp(AAppIapp node) {

        SaAppel app = null;
        node.getApp().apply(this);
        app = (SaAppel) this.returnValue;
        this.returnValue = app;
    }

    @Override
    public void caseAAppLdeApp(AAppLdeApp node) {

        SaLExp lde = null;
        node.getLde().apply(this);
        lde = (SaLExp) this.returnValue;
        this.returnValue = new SaAppel(node.getId().getText(),lde);

    }

    @Override
    public void caseAAffIaff(AAffIaff node) {

        SaVar var =null;
        SaExp exp = null;
        node.getVar().apply(this);
        var = (SaVar) this.returnValue;
        node.getExpr().apply(this);
        exp = (SaExp) this.returnValue;
        this.returnValue = new SaInstAffect(var,exp);
    }

    @Override
    public void caseAAffLireIaff(AAffLireIaff node) {
        super.caseAAffLireIaff(node);
    }

    @Override
    public void caseAInstSiIsi(AInstSiIsi node) {

        SaExp exp = null;
        node.getExpr().apply(this);
        SaLInst alors = null;
        node.ge



    }

    @Override
    public void caseAInstSinonSinon(AInstSinonSinon node) {


    }

    @Override
    public void caseASinonVideSinon(ASinonVideSinon node) {
        super.caseASinonVideSinon(node);
    }

    @Override
    public void caseAInstTqItq(AInstTqItq node) {
        super.caseAInstTqItq(node);
    }

    @Override
    public void caseAInstRetIret(AInstRetIret node) {
        super.caseAInstRetIret(node);
    }

    @Override
    public void caseAParamParams(AParamParams node) {
        super.caseAParamParams(node);
    }

    @Override
    public void caseAParamVideParams(AParamVideParams node) {
        super.caseAParamVideParams(node);
    }

    @Override
    public void caseAVSimpleVar(AVSimpleVar node) {
        super.caseAVSimpleVar(node);
    }

    @Override
    public void caseAVDerivVar(AVDerivVar node) {
        super.caseAVDerivVar(node);
    }

    @Override
    public void caseADvSimpleDvar(ADvSimpleDvar node) {
        super.caseADvSimpleDvar(node);
    }

    @Override
    public void caseADvDeriveDvar(ADvDeriveDvar node) {
        super.caseADvDeriveDvar(node);
    }

    @Override
    public void caseALdeAltLdeAlt(ALdeAltLdeAlt node) {
        super.caseALdeAltLdeAlt(node);
    }

    @Override
    public void caseALdeAltVideLdeAlt(ALdeAltVideLdeAlt node) {
        super.caseALdeAltVideLdeAlt(node);
    }

    @Override
    public void caseALdeListLde(ALdeListLde node) {
        super.caseALdeListLde(node);
    }

    @Override
    public void caseALdeListVirLde(ALdeListVirLde node) {
        super.caseALdeListVirLde(node);
    }

    @Override
    public void caseALdeVideLde(ALdeVideLde node) {
        super.caseALdeVideLde(node);
    }

    @Override
    public void caseAExprOuExpr(AExprOuExpr node) {
        super.caseAExprOuExpr(node);
    }

    @Override
    public void caseAExpr1Expr(AExpr1Expr node) {
        super.caseAExpr1Expr(node);
    }

    @Override
    public void caseAExprEtExpr1(AExprEtExpr1 node) {
        super.caseAExprEtExpr1(node);
    }

    @Override
    public void caseAExpr2Expr1(AExpr2Expr1 node) {
        super.caseAExpr2Expr1(node);
    }

    @Override
    public void caseAExprEqExpr2(AExprEqExpr2 node) {
        super.caseAExprEqExpr2(node);
    }

    @Override
    public void caseAExpInfExpr2(AExpInfExpr2 node) {
        super.caseAExpInfExpr2(node);
    }

    @Override
    public void caseAExpr3Expr2(AExpr3Expr2 node) {
        super.caseAExpr3Expr2(node);
    }

    @Override
    public void caseAExprPlusExpr3(AExprPlusExpr3 node) {
        super.caseAExprPlusExpr3(node);
    }

    @Override
    public void caseAExprMoinsExpr3(AExprMoinsExpr3 node) {
        super.caseAExprMoinsExpr3(node);
    }

    @Override
    public void caseAExpr4Expr3(AExpr4Expr3 node) {
        super.caseAExpr4Expr3(node);
    }

    @Override
    public void caseAExprMultExpr4(AExprMultExpr4 node) {
        super.caseAExprMultExpr4(node);
    }

    @Override
    public void caseAExprDivExpr4(AExprDivExpr4 node) {
        super.caseAExprDivExpr4(node);
    }

    @Override
    public void caseAExpr5Expr4(AExpr5Expr4 node) {
        super.caseAExpr5Expr4(node);
    }

    @Override
    public void caseAExprNonExpr5(AExprNonExpr5 node) {
        super.caseAExprNonExpr5(node);
    }

    @Override
    public void caseAExpr6Expr5(AExpr6Expr5 node) {
        super.caseAExpr6Expr5(node);
    }

    @Override
    public void caseAExprParExpr6(AExprParExpr6 node) {
        super.caseAExprParExpr6(node);
    }

    @Override
    public void caseAExprNbExpr6(AExprNbExpr6 node) {
        super.caseAExprNbExpr6(node);
    }

    @Override
    public void caseAExprVarExpr6(AExprVarExpr6 node) {
        super.caseAExprVarExpr6(node);
    }

    @Override
    public void caseAEcrAppelEcrire(AEcrAppelEcrire node) {
        super.caseAEcrAppelEcrire(node);
    }

    @Override
    public void caseAEcrExprEcrire(AEcrExprEcrire node) {
        super.caseAEcrExprEcrire(node);
    }

    @Override
    public void caseALireLire(ALireLire node) {
        super.caseALireLire(node);
    }

}
