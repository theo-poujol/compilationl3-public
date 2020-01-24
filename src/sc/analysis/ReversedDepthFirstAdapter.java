/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import java.util.*;
import sc.node.*;

public class ReversedDepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getEOF().apply(this);
        node.getPVar().apply(this);
        outStart(node);
    }

    public void inAVSimpleVar(AVSimpleVar node)
    {
        defaultIn(node);
    }

    public void outAVSimpleVar(AVSimpleVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVSimpleVar(AVSimpleVar node)
    {
        inAVSimpleVar(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAVSimpleVar(node);
    }

    public void inAVDerivVar(AVDerivVar node)
    {
        defaultIn(node);
    }

    public void outAVDerivVar(AVDerivVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVDerivVar(AVDerivVar node)
    {
        inAVDerivVar(node);
        if(node.getCrochF() != null)
        {
            node.getCrochF().apply(this);
        }
        if(node.getNombre() != null)
        {
            node.getNombre().apply(this);
        }
        if(node.getCrochO() != null)
        {
            node.getCrochO().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        outAVDerivVar(node);
    }

    public void inADvSimpleDvar(ADvSimpleDvar node)
    {
        defaultIn(node);
    }

    public void outADvSimpleDvar(ADvSimpleDvar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADvSimpleDvar(ADvSimpleDvar node)
    {
        inADvSimpleDvar(node);
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getEspace() != null)
        {
            node.getEspace().apply(this);
        }
        if(node.getEnt() != null)
        {
            node.getEnt().apply(this);
        }
        outADvSimpleDvar(node);
    }

    public void inADvDeriveDvar(ADvDeriveDvar node)
    {
        defaultIn(node);
    }

    public void outADvDeriveDvar(ADvDeriveDvar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADvDeriveDvar(ADvDeriveDvar node)
    {
        inADvDeriveDvar(node);
        if(node.getCrochF() != null)
        {
            node.getCrochF().apply(this);
        }
        if(node.getNombre() != null)
        {
            node.getNombre().apply(this);
        }
        if(node.getCrochO() != null)
        {
            node.getCrochO().apply(this);
        }
        if(node.getId() != null)
        {
            node.getId().apply(this);
        }
        if(node.getEspace() != null)
        {
            node.getEspace().apply(this);
        }
        if(node.getEnt() != null)
        {
            node.getEnt().apply(this);
        }
        outADvDeriveDvar(node);
    }

    public void inAListeVarLdvAlt(AListeVarLdvAlt node)
    {
        defaultIn(node);
    }

    public void outAListeVarLdvAlt(AListeVarLdvAlt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListeVarLdvAlt(AListeVarLdvAlt node)
    {
        inAListeVarLdvAlt(node);
        if(node.getLdvAlt() != null)
        {
            node.getLdvAlt().apply(this);
        }
        if(node.getDvar() != null)
        {
            node.getDvar().apply(this);
        }
        if(node.getVir() != null)
        {
            node.getVir().apply(this);
        }
        outAListeVarLdvAlt(node);
    }

    public void inAListeVideVarLdvAlt(AListeVideVarLdvAlt node)
    {
        defaultIn(node);
    }

    public void outAListeVideVarLdvAlt(AListeVideVarLdvAlt node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListeVideVarLdvAlt(AListeVideVarLdvAlt node)
    {
        inAListeVideVarLdvAlt(node);
        outAListeVideVarLdvAlt(node);
    }

    public void inAListVarMainLdv(AListVarMainLdv node)
    {
        defaultIn(node);
    }

    public void outAListVarMainLdv(AListVarMainLdv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListVarMainLdv(AListVarMainLdv node)
    {
        inAListVarMainLdv(node);
        if(node.getLdvAlt() != null)
        {
            node.getLdvAlt().apply(this);
        }
        if(node.getDvar() != null)
        {
            node.getDvar().apply(this);
        }
        outAListVarMainLdv(node);
    }

    public void inAListVarMainVideLdv(AListVarMainVideLdv node)
    {
        defaultIn(node);
    }

    public void outAListVarMainVideLdv(AListVarMainVideLdv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListVarMainVideLdv(AListVarMainVideLdv node)
    {
        inAListVarMainVideLdv(node);
        outAListVarMainVideLdv(node);
    }

    public void inAListVarOptLdvo(AListVarOptLdvo node)
    {
        defaultIn(node);
    }

    public void outAListVarOptLdvo(AListVarOptLdvo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListVarOptLdvo(AListVarOptLdvo node)
    {
        inAListVarOptLdvo(node);
        if(node.getPvir() != null)
        {
            node.getPvir().apply(this);
        }
        if(node.getLdv() != null)
        {
            node.getLdv().apply(this);
        }
        outAListVarOptLdvo(node);
    }

    public void inAListVarOptVideLdvo(AListVarOptVideLdvo node)
    {
        defaultIn(node);
    }

    public void outAListVarOptVideLdvo(AListVarOptVideLdvo node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAListVarOptVideLdvo(AListVarOptVideLdvo node)
    {
        inAListVarOptVideLdvo(node);
        outAListVarOptVideLdvo(node);
    }

    public void inAExprOuExpr(AExprOuExpr node)
    {
        defaultIn(node);
    }

    public void outAExprOuExpr(AExprOuExpr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprOuExpr(AExprOuExpr node)
    {
        inAExprOuExpr(node);
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        if(node.getOu() != null)
        {
            node.getOu().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        outAExprOuExpr(node);
    }

    public void inAExpr1Expr(AExpr1Expr node)
    {
        defaultIn(node);
    }

    public void outAExpr1Expr(AExpr1Expr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr1Expr(AExpr1Expr node)
    {
        inAExpr1Expr(node);
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        outAExpr1Expr(node);
    }

    public void inAExprEtExpr1(AExprEtExpr1 node)
    {
        defaultIn(node);
    }

    public void outAExprEtExpr1(AExprEtExpr1 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprEtExpr1(AExprEtExpr1 node)
    {
        inAExprEtExpr1(node);
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        if(node.getEt() != null)
        {
            node.getEt().apply(this);
        }
        if(node.getExpr1() != null)
        {
            node.getExpr1().apply(this);
        }
        outAExprEtExpr1(node);
    }

    public void inAExpr2Expr1(AExpr2Expr1 node)
    {
        defaultIn(node);
    }

    public void outAExpr2Expr1(AExpr2Expr1 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr2Expr1(AExpr2Expr1 node)
    {
        inAExpr2Expr1(node);
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAExpr2Expr1(node);
    }

    public void inAExprEqExpr2(AExprEqExpr2 node)
    {
        defaultIn(node);
    }

    public void outAExprEqExpr2(AExprEqExpr2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprEqExpr2(AExprEqExpr2 node)
    {
        inAExprEqExpr2(node);
        if(node.getExpr3() != null)
        {
            node.getExpr3().apply(this);
        }
        if(node.getEgal() != null)
        {
            node.getEgal().apply(this);
        }
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAExprEqExpr2(node);
    }

    public void inAExpInfExpr2(AExpInfExpr2 node)
    {
        defaultIn(node);
    }

    public void outAExpInfExpr2(AExpInfExpr2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpInfExpr2(AExpInfExpr2 node)
    {
        inAExpInfExpr2(node);
        if(node.getExpr3() != null)
        {
            node.getExpr3().apply(this);
        }
        if(node.getInf() != null)
        {
            node.getInf().apply(this);
        }
        if(node.getExpr2() != null)
        {
            node.getExpr2().apply(this);
        }
        outAExpInfExpr2(node);
    }

    public void inAExpr3Expr2(AExpr3Expr2 node)
    {
        defaultIn(node);
    }

    public void outAExpr3Expr2(AExpr3Expr2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr3Expr2(AExpr3Expr2 node)
    {
        inAExpr3Expr2(node);
        if(node.getExpr3() != null)
        {
            node.getExpr3().apply(this);
        }
        outAExpr3Expr2(node);
    }

    public void inAExprPlusExpr3(AExprPlusExpr3 node)
    {
        defaultIn(node);
    }

    public void outAExprPlusExpr3(AExprPlusExpr3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprPlusExpr3(AExprPlusExpr3 node)
    {
        inAExprPlusExpr3(node);
        if(node.getExpr4() != null)
        {
            node.getExpr4().apply(this);
        }
        if(node.getPlus() != null)
        {
            node.getPlus().apply(this);
        }
        if(node.getExpr3() != null)
        {
            node.getExpr3().apply(this);
        }
        outAExprPlusExpr3(node);
    }

    public void inAExprMoinsExpr3(AExprMoinsExpr3 node)
    {
        defaultIn(node);
    }

    public void outAExprMoinsExpr3(AExprMoinsExpr3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprMoinsExpr3(AExprMoinsExpr3 node)
    {
        inAExprMoinsExpr3(node);
        if(node.getExpr4() != null)
        {
            node.getExpr4().apply(this);
        }
        if(node.getMoins() != null)
        {
            node.getMoins().apply(this);
        }
        if(node.getExpr3() != null)
        {
            node.getExpr3().apply(this);
        }
        outAExprMoinsExpr3(node);
    }

    public void inAExpr4Expr3(AExpr4Expr3 node)
    {
        defaultIn(node);
    }

    public void outAExpr4Expr3(AExpr4Expr3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr4Expr3(AExpr4Expr3 node)
    {
        inAExpr4Expr3(node);
        if(node.getExpr4() != null)
        {
            node.getExpr4().apply(this);
        }
        outAExpr4Expr3(node);
    }

    public void inAExprMultExpr4(AExprMultExpr4 node)
    {
        defaultIn(node);
    }

    public void outAExprMultExpr4(AExprMultExpr4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprMultExpr4(AExprMultExpr4 node)
    {
        inAExprMultExpr4(node);
        if(node.getExpr5() != null)
        {
            node.getExpr5().apply(this);
        }
        if(node.getMult() != null)
        {
            node.getMult().apply(this);
        }
        if(node.getExpr4() != null)
        {
            node.getExpr4().apply(this);
        }
        outAExprMultExpr4(node);
    }

    public void inAExprDivExpr4(AExprDivExpr4 node)
    {
        defaultIn(node);
    }

    public void outAExprDivExpr4(AExprDivExpr4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprDivExpr4(AExprDivExpr4 node)
    {
        inAExprDivExpr4(node);
        if(node.getExpr5() != null)
        {
            node.getExpr5().apply(this);
        }
        if(node.getDiv() != null)
        {
            node.getDiv().apply(this);
        }
        if(node.getExpr4() != null)
        {
            node.getExpr4().apply(this);
        }
        outAExprDivExpr4(node);
    }

    public void inAExpr5Expr4(AExpr5Expr4 node)
    {
        defaultIn(node);
    }

    public void outAExpr5Expr4(AExpr5Expr4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr5Expr4(AExpr5Expr4 node)
    {
        inAExpr5Expr4(node);
        if(node.getExpr5() != null)
        {
            node.getExpr5().apply(this);
        }
        outAExpr5Expr4(node);
    }

    public void inAExprNonExpr5(AExprNonExpr5 node)
    {
        defaultIn(node);
    }

    public void outAExprNonExpr5(AExprNonExpr5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprNonExpr5(AExprNonExpr5 node)
    {
        inAExprNonExpr5(node);
        if(node.getExpr5() != null)
        {
            node.getExpr5().apply(this);
        }
        if(node.getNon() != null)
        {
            node.getNon().apply(this);
        }
        outAExprNonExpr5(node);
    }

    public void inAExpr6Expr5(AExpr6Expr5 node)
    {
        defaultIn(node);
    }

    public void outAExpr6Expr5(AExpr6Expr5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExpr6Expr5(AExpr6Expr5 node)
    {
        inAExpr6Expr5(node);
        if(node.getExpr6() != null)
        {
            node.getExpr6().apply(this);
        }
        outAExpr6Expr5(node);
    }

    public void inAExprParExpr6(AExprParExpr6 node)
    {
        defaultIn(node);
    }

    public void outAExprParExpr6(AExprParExpr6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAExprParExpr6(AExprParExpr6 node)
    {
        inAExprParExpr6(node);
        if(node.getParF() != null)
        {
            node.getParF().apply(this);
        }
        if(node.getExpr() != null)
        {
            node.getExpr().apply(this);
        }
        if(node.getParO() != null)
        {
            node.getParO().apply(this);
        }
        outAExprParExpr6(node);
    }
}
