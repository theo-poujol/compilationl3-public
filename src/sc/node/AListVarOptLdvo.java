/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AListVarOptLdvo extends PLdvo
{
    private PLdv _ldv_;
    private TPvir _pvir_;

    public AListVarOptLdvo()
    {
        // Constructor
    }

    public AListVarOptLdvo(
        @SuppressWarnings("hiding") PLdv _ldv_,
        @SuppressWarnings("hiding") TPvir _pvir_)
    {
        // Constructor
        setLdv(_ldv_);

        setPvir(_pvir_);

    }

    @Override
    public Object clone()
    {
        return new AListVarOptLdvo(
            cloneNode(this._ldv_),
            cloneNode(this._pvir_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListVarOptLdvo(this);
    }

    public PLdv getLdv()
    {
        return this._ldv_;
    }

    public void setLdv(PLdv node)
    {
        if(this._ldv_ != null)
        {
            this._ldv_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ldv_ = node;
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
            + toString(this._ldv_)
            + toString(this._pvir_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ldv_ == child)
        {
            this._ldv_ = null;
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
        if(this._ldv_ == oldChild)
        {
            setLdv((PLdv) newChild);
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
