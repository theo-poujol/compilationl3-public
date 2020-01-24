/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AExprParExpr6 extends PExpr6
{
    private TParO _parO_;
    private PExpr _expr_;
    private TParF _parF_;

    public AExprParExpr6()
    {
        // Constructor
    }

    public AExprParExpr6(
        @SuppressWarnings("hiding") TParO _parO_,
        @SuppressWarnings("hiding") PExpr _expr_,
        @SuppressWarnings("hiding") TParF _parF_)
    {
        // Constructor
        setParO(_parO_);

        setExpr(_expr_);

        setParF(_parF_);

    }

    @Override
    public Object clone()
    {
        return new AExprParExpr6(
            cloneNode(this._parO_),
            cloneNode(this._expr_),
            cloneNode(this._parF_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExprParExpr6(this);
    }

    public TParO getParO()
    {
        return this._parO_;
    }

    public void setParO(TParO node)
    {
        if(this._parO_ != null)
        {
            this._parO_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parO_ = node;
    }

    public PExpr getExpr()
    {
        return this._expr_;
    }

    public void setExpr(PExpr node)
    {
        if(this._expr_ != null)
        {
            this._expr_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr_ = node;
    }

    public TParF getParF()
    {
        return this._parF_;
    }

    public void setParF(TParF node)
    {
        if(this._parF_ != null)
        {
            this._parF_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._parF_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._parO_)
            + toString(this._expr_)
            + toString(this._parF_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._parO_ == child)
        {
            this._parO_ = null;
            return;
        }

        if(this._expr_ == child)
        {
            this._expr_ = null;
            return;
        }

        if(this._parF_ == child)
        {
            this._parF_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._parO_ == oldChild)
        {
            setParO((TParO) newChild);
            return;
        }

        if(this._expr_ == oldChild)
        {
            setExpr((PExpr) newChild);
            return;
        }

        if(this._parF_ == oldChild)
        {
            setParF((TParF) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
