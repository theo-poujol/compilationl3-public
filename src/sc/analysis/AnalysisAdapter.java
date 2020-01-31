/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import java.util.*;
import sc.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAProgramme(AProgramme node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListVarOptLdvo(AListVarOptLdvo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListVarOptVideLdvo(AListVarOptVideLdvo node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListVarMainLdv(AListVarMainLdv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListVarMainVideLdv(AListVarMainVideLdv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListeVarLdvAlt(AListeVarLdvAlt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAListeVideVarLdvAlt(AListeVideVarLdvAlt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdfDvLdf(ALdfDvLdf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdfVideLdf(ALdfVideLdf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADefFctDf(ADefFctDf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdiIbloc(ALdiIbloc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdiListLdi(ALdiListLdi node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdiVideLdi(ALdiVideLdi node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIappInstBloc(AIappInstBloc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIaffInstBloc(AIaffInstBloc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIsiInstBloc(AIsiInstBloc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAItqInstBloc(AItqInstBloc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAIretInstBloc(AIretInstBloc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEcritureInstBloc(AEcritureInstBloc node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAppIapp(AAppIapp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAppLdeApp(AAppLdeApp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAffIaff(AAffIaff node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstSiIsi(AInstSiIsi node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstSinonSinon(AInstSinonSinon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASinonVideSinon(ASinonVideSinon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstTqItq(AInstTqItq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAInstRetIret(AInstRetIret node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVSimpleVar(AVSimpleVar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAVDerivVar(AVDerivVar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADvSimpleDvar(ADvSimpleDvar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADvDeriveDvar(ADvDeriveDvar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdeListLde(ALdeListLde node)
    {
        defaultCase(node);
    }

    @Override
    public void caseALdeVideLde(ALdeVideLde node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprOuExpr(AExprOuExpr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpr1Expr(AExpr1Expr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprEtExpr1(AExprEtExpr1 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpr2Expr1(AExpr2Expr1 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprEqExpr2(AExprEqExpr2 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpInfExpr2(AExpInfExpr2 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpr3Expr2(AExpr3Expr2 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprPlusExpr3(AExprPlusExpr3 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprMoinsExpr3(AExprMoinsExpr3 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpr4Expr3(AExpr4Expr3 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprMultExpr4(AExprMultExpr4 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprDivExpr4(AExprDivExpr4 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpr5Expr4(AExpr5Expr4 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprNonExpr5(AExprNonExpr5 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExpr6Expr5(AExpr6Expr5 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprParExpr6(AExprParExpr6 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprNbExpr6(AExprNbExpr6 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAExprVarExpr6(AExprVarExpr6 node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAEcrExprEcrire(AEcrExprEcrire node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEgal(TEgal node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMoins(TMoins node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMult(TMult node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTDiv(TDiv node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTInf(TInf node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEt(TEt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTOu(TOu node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNon(TNon node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPvir(TPvir node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTVir(TVir node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAccO(TAccO node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAccF(TAccF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCrochO(TCrochO node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCrochF(TCrochF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTParO(TParO node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTParF(TParF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSin(TSin node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSi(TSi node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTAl(TAl node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTTq(TTq node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFai(TFai node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRet(TRet node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTFct(TFct node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEcr(TEcr node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLir(TLir node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEnt(TEnt node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTId(TId node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNombre(TNombre node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTEspace(TEspace node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTCommentaire(TCommentaire node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
