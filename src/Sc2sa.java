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
        AI
        /*SaDecFonc decFonc = null;
        TId nom = null;
        node.getId().apply(this);
        nom = (TId) this.returnValue;*/
    }

    @Override
    public void caseALdiIbloc(ALdiIbloc node) {
        super.caseALdiIbloc(node);
    }

    @Override
    public void caseALdiListLdi(ALdiListLdi node) {
        super.caseALdiListLdi(node);
    }

    @Override
    public void caseALdiVideLdi(ALdiVideLdi node) {
        super.caseALdiVideLdi(node);
    }

    @Override
    public void caseAIappInstBloc(AIappInstBloc node) {
        super.caseAIappInstBloc(node);
    }

    @Override
    public void caseAIaffInstBloc(AIaffInstBloc node) {
        super.caseAIaffInstBloc(node);
    }

    @Override
    public void caseAIsiInstBloc(AIsiInstBloc node) {
        super.caseAIsiInstBloc(node);
    }

    @Override
    public void caseAItqInstBloc(AItqInstBloc node) {
        super.caseAItqInstBloc(node);
    }

    @Override
    public void caseAIretInstBloc(AIretInstBloc node) {
        super.caseAIretInstBloc(node);
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
        super.caseAAppIapp(node);
    }

    @Override
    public void caseAAppLdeApp(AAppLdeApp node) {
        super.caseAAppLdeApp(node);
    }

    @Override
    public void caseAAffIaff(AAffIaff node) {
        super.caseAAffIaff(node);
    }

    @Override
    public void caseAAffLireIaff(AAffLireIaff node) {
        super.caseAAffLireIaff(node);
    }

    @Override
    public void caseAInstSiIsi(AInstSiIsi node) {
        super.caseAInstSiIsi(node);
    }

    @Override
    public void caseAInstSinonSinon(AInstSinonSinon node) {
        super.caseAInstSinonSinon(node);
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
