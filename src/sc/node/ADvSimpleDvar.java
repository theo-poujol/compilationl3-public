/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ADvSimpleDvar extends PDvar
{
    private TEnt _ent_;
    private TId _id_;

    public ADvSimpleDvar()
    {
        // Constructor
    }

    public ADvSimpleDvar(
        @SuppressWarnings("hiding") TEnt _ent_,
        @SuppressWarnings("hiding") TId _id_)
    {
        // Constructor
        setEnt(_ent_);

        setId(_id_);

    }

    @Override
    public Object clone()
    {
        return new ADvSimpleDvar(
            cloneNode(this._ent_),
            cloneNode(this._id_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADvSimpleDvar(this);
    }

    public TEnt getEnt()
    {
        return this._ent_;
    }

    public void setEnt(TEnt node)
    {
        if(this._ent_ != null)
        {
            this._ent_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ent_ = node;
    }

    public TId getId()
    {
        return this._id_;
    }

    public void setId(TId node)
    {
        if(this._id_ != null)
        {
            this._id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._id_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ent_)
            + toString(this._id_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._ent_ == child)
        {
            this._ent_ = null;
            return;
        }

        if(this._id_ == child)
        {
            this._id_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._ent_ == oldChild)
        {
            setEnt((TEnt) newChild);
            return;
        }

        if(this._id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
