/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AListVarMainLdv extends PLdv
{
    private PDvar _dvar_;
    private PLdvAlt _ldvAlt_;

    public AListVarMainLdv()
    {
        // Constructor
    }

    public AListVarMainLdv(
        @SuppressWarnings("hiding") PDvar _dvar_,
        @SuppressWarnings("hiding") PLdvAlt _ldvAlt_)
    {
        // Constructor
        setDvar(_dvar_);

        setLdvAlt(_ldvAlt_);

    }

    @Override
    public Object clone()
    {
        return new AListVarMainLdv(
            cloneNode(this._dvar_),
            cloneNode(this._ldvAlt_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListVarMainLdv(this);
    }

    public PDvar getDvar()
    {
        return this._dvar_;
    }

    public void setDvar(PDvar node)
    {
        if(this._dvar_ != null)
        {
            this._dvar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dvar_ = node;
    }

    public PLdvAlt getLdvAlt()
    {
        return this._ldvAlt_;
    }

    public void setLdvAlt(PLdvAlt node)
    {
        if(this._ldvAlt_ != null)
        {
            this._ldvAlt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ldvAlt_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._dvar_)
            + toString(this._ldvAlt_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._dvar_ == child)
        {
            this._dvar_ = null;
            return;
        }

        if(this._ldvAlt_ == child)
        {
            this._ldvAlt_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._dvar_ == oldChild)
        {
            setDvar((PDvar) newChild);
            return;
        }

        if(this._ldvAlt_ == oldChild)
        {
            setLdvAlt((PLdvAlt) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
