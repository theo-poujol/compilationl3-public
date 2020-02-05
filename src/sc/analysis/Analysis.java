/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import sc.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProgramme(AProgramme node);
    void caseAListVarOptLdvo(AListVarOptLdvo node);
    void caseAListVarOptVideLdvo(AListVarOptVideLdvo node);
    void caseAListVarMainLdv(AListVarMainLdv node);
    void caseAListVarMainVideLdv(AListVarMainVideLdv node);
    void caseAListeVarLdvAlt(AListeVarLdvAlt node);
    void caseAListeVideVarLdvAlt(AListeVideVarLdvAlt node);
    void caseALdfDvLdf(ALdfDvLdf node);
    void caseALdfVideLdf(ALdfVideLdf node);
    void caseADefFctDf(ADefFctDf node);
    void caseALdiIbloc(ALdiIbloc node);
    void caseALdiListLdi(ALdiListLdi node);
    void caseALdiVideLdi(ALdiVideLdi node);
    void caseAIappInstBloc(AIappInstBloc node);
    void caseAIaffInstBloc(AIaffInstBloc node);
    void caseAIsiInstBloc(AIsiInstBloc node);
    void caseAItqInstBloc(AItqInstBloc node);
    void caseAIretInstBloc(AIretInstBloc node);
    void caseAEcritureInstBloc(AEcritureInstBloc node);
    void caseAAppIapp(AAppIapp node);
    void caseAAppLdeApp(AAppLdeApp node);
    void caseAAffIaff(AAffIaff node);
    void caseAInstSiIsi(AInstSiIsi node);
    void caseAInstSinonSinon(AInstSinonSinon node);
    void caseASinonVideSinon(ASinonVideSinon node);
    void caseAInstTqItq(AInstTqItq node);
    void caseAInstRetIret(AInstRetIret node);
    void caseAParamParams(AParamParams node);
    void caseAParamVideParams(AParamVideParams node);
    void caseAVSimpleVar(AVSimpleVar node);
    void caseAVDerivVar(AVDerivVar node);
    void caseADvSimpleDvar(ADvSimpleDvar node);
    void caseADvDeriveDvar(ADvDeriveDvar node);
    void caseALdeAltLdeAlt(ALdeAltLdeAlt node);
    void caseALdeAltVideLdeAlt(ALdeAltVideLdeAlt node);
    void caseALdeListLde(ALdeListLde node);
    void caseALdeListVirLde(ALdeListVirLde node);
    void caseALdeVideLde(ALdeVideLde node);
    void caseAExprOuExpr(AExprOuExpr node);
    void caseAExpr1Expr(AExpr1Expr node);
    void caseAExprEtExpr1(AExprEtExpr1 node);
    void caseAExpr2Expr1(AExpr2Expr1 node);
    void caseAExprEqExpr2(AExprEqExpr2 node);
    void caseAExpInfExpr2(AExpInfExpr2 node);
    void caseAExpr3Expr2(AExpr3Expr2 node);
    void caseAExprPlusExpr3(AExprPlusExpr3 node);
    void caseAExprMoinsExpr3(AExprMoinsExpr3 node);
    void caseAExpr4Expr3(AExpr4Expr3 node);
    void caseAExprMultExpr4(AExprMultExpr4 node);
    void caseAExprDivExpr4(AExprDivExpr4 node);
    void caseAExpr5Expr4(AExpr5Expr4 node);
    void caseAExprNonExpr5(AExprNonExpr5 node);
    void caseAExpr6Expr5(AExpr6Expr5 node);
    void caseAExprParExpr6(AExprParExpr6 node);
    void caseAExprNbExpr6(AExprNbExpr6 node);
    void caseAExprVarExpr6(AExprVarExpr6 node);
    void caseAEcrAppelEcrire(AEcrAppelEcrire node);
    void caseAEcrExprEcrire(AEcrExprEcrire node);

    void caseTPlus(TPlus node);
    void caseTEgal(TEgal node);
    void caseTMoins(TMoins node);
    void caseTMult(TMult node);
    void caseTDiv(TDiv node);
    void caseTInf(TInf node);
    void caseTEt(TEt node);
    void caseTOu(TOu node);
    void caseTNon(TNon node);
    void caseTPvir(TPvir node);
    void caseTVir(TVir node);
    void caseTAccO(TAccO node);
    void caseTAccF(TAccF node);
    void caseTCrochO(TCrochO node);
    void caseTCrochF(TCrochF node);
    void caseTParO(TParO node);
    void caseTParF(TParF node);
    void caseTSin(TSin node);
    void caseTSi(TSi node);
    void caseTAl(TAl node);
    void caseTTq(TTq node);
    void caseTFai(TFai node);
    void caseTRet(TRet node);
    void caseTFct(TFct node);
    void caseTEcr(TEcr node);
    void caseTLir(TLir node);
    void caseTEnt(TEnt node);
    void caseTId(TId node);
    void caseTNombre(TNombre node);
    void caseTEspace(TEspace node);
    void caseTCommentaire(TCommentaire node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}
