/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AInstRetIret extends PIret
{
    private TRet _ret_;
    private PExpr _expr_;
    private TPvir _pvir_;

    public AInstRetIret()
    {
        // Constructor
    }

    public AInstRetIret(
        @SuppressWarnings("hiding") TRet _ret_,
        @SuppressWarnings("hiding") PExpr _expr_,
        @SuppressWarnings("hiding") TPvir _pvir_)
    {
        // Constructor
        setRet(_ret_);

        setExpr(_expr_);

        setPvir(_pvir_);

    }

    @Override
    public Object clone()
    {
        return new AInstRetIret(
            cloneNode(this._ret_),
            cloneNode(this._expr_),
            cloneNode(this._pvir_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInstRetIret(this);
    }

    public TRet getRet()
    {
        return this._ret_;
    }

    public void setRet(TRet node)
    {
        if(this._ret_ != null)
        {
            this._ret_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ret_ = node;
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

    public TPvir getPvir()
    {
        return this._pvir_;
    }

    public void setPvir(TPvir node)
    {
        if(this._pvir_ != null)
        {
            this._pvir_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._pvir_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ret_)
            + toString(this._expr_)
            + toString(this._pvir_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ret_ == child)
        {
            this._ret_ = null;
            return;
        }

        if(this._expr_ == child)
        {
            this._expr_ = null;
            return;
        }

        if(this._pvir_ == child)
        {
            this._pvir_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._ret_ == oldChild)
        {
            setRet((TRet) newChild);
            return;
        }

        if(this._expr_ == oldChild)
        {
            setExpr((PExpr) newChild);
            return;
        }

        if(this._pvir_ == oldChild)
        {
            setPvir((TPvir) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
