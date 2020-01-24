/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AExprOuExpr extends PExpr
{
    private PExpr _expr_;
    private TOu _ou_;
    private PExpr1 _expr1_;

    public AExprOuExpr()
    {
        // Constructor
    }

    public AExprOuExpr(
        @SuppressWarnings("hiding") PExpr _expr_,
        @SuppressWarnings("hiding") TOu _ou_,
        @SuppressWarnings("hiding") PExpr1 _expr1_)
    {
        // Constructor
        setExpr(_expr_);

        setOu(_ou_);

        setExpr1(_expr1_);

    }

    @Override
    public Object clone()
    {
        return new AExprOuExpr(
            cloneNode(this._expr_),
            cloneNode(this._ou_),
            cloneNode(this._expr1_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExprOuExpr(this);
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

    public TOu getOu()
    {
        return this._ou_;
    }

    public void setOu(TOu node)
    {
        if(this._ou_ != null)
        {
            this._ou_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ou_ = node;
    }

    public PExpr1 getExpr1()
    {
        return this._expr1_;
    }

    public void setExpr1(PExpr1 node)
    {
        if(this._expr1_ != null)
        {
            this._expr1_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._expr1_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._expr_)
            + toString(this._ou_)
            + toString(this._expr1_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._expr_ == child)
        {
            this._expr_ = null;
            return;
        }

        if(this._ou_ == child)
        {
            this._ou_ = null;
            return;
        }

        if(this._expr1_ == child)
        {
            this._expr1_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._expr_ == oldChild)
        {
            setExpr((PExpr) newChild);
            return;
        }

        if(this._ou_ == oldChild)
        {
            setOu((TOu) newChild);
            return;
        }

        if(this._expr1_ == oldChild)
        {
            setExpr1((PExpr1) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
