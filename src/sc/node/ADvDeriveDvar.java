/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class ADvDeriveDvar extends PDvar
{
    private TEnt _ent_;
    private TId _id_;
    private TCrochO _crochO_;
    private TNombre _nombre_;
    private TCrochF _crochF_;

    public ADvDeriveDvar()
    {
        // Constructor
    }

    public ADvDeriveDvar(
        @SuppressWarnings("hiding") TEnt _ent_,
        @SuppressWarnings("hiding") TId _id_,
        @SuppressWarnings("hiding") TCrochO _crochO_,
        @SuppressWarnings("hiding") TNombre _nombre_,
        @SuppressWarnings("hiding") TCrochF _crochF_)
    {
        // Constructor
        setEnt(_ent_);

        setId(_id_);

        setCrochO(_crochO_);

        setNombre(_nombre_);

        setCrochF(_crochF_);

    }

    @Override
    public Object clone()
    {
        return new ADvDeriveDvar(
            cloneNode(this._ent_),
            cloneNode(this._id_),
            cloneNode(this._crochO_),
            cloneNode(this._nombre_),
            cloneNode(this._crochF_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADvDeriveDvar(this);
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

    public TCrochO getCrochO()
    {
        return this._crochO_;
    }

    public void setCrochO(TCrochO node)
    {
        if(this._crochO_ != null)
        {
            this._crochO_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._crochO_ = node;
    }

    public TNombre getNombre()
    {
        return this._nombre_;
    }

    public void setNombre(TNombre node)
    {
        if(this._nombre_ != null)
        {
            this._nombre_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._nombre_ = node;
    }

    public TCrochF getCrochF()
    {
        return this._crochF_;
    }

    public void setCrochF(TCrochF node)
    {
        if(this._crochF_ != null)
        {
            this._crochF_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._crochF_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._ent_)
            + toString(this._id_)
            + toString(this._crochO_)
            + toString(this._nombre_)
            + toString(this._crochF_);
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

        if(this._crochO_ == child)
        {
            this._crochO_ = null;
            return;
        }

        if(this._nombre_ == child)
        {
            this._nombre_ = null;
            return;
        }

        if(this._crochF_ == child)
        {
            this._crochF_ = null;
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

        if(this._crochO_ == oldChild)
        {
            setCrochO((TCrochO) newChild);
            return;
        }

        if(this._nombre_ == oldChild)
        {
            setNombre((TNombre) newChild);
            return;
        }

        if(this._crochF_ == oldChild)
        {
            setCrochF((TCrochF) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}