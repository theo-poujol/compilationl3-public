/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AInstTqItq extends PItq
{
    private TTq _tq_;
    private PExpr _expr_;
    private TFai _fai_;
    private PIbloc _ibloc_;

    public AInstTqItq()
    {
        // Constructor
    }

    public AInstTqItq(
        @SuppressWarnings("hiding") TTq _tq_,
        @SuppressWarnings("hiding") PExpr _expr_,
        @SuppressWarnings("hiding") TFai _fai_,
        @SuppressWarnings("hiding") PIbloc _ibloc_)
    {
        // Constructor
        setTq(_tq_);

        setExpr(_expr_);

        setFai(_fai_);

        setIbloc(_ibloc_);

    }

    @Override
    public Object clone()
    {
        return new AInstTqItq(
            cloneNode(this._tq_),
            cloneNode(this._expr_),
            cloneNode(this._fai_),
            cloneNode(this._ibloc_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAInstTqItq(this);
    }

    public TTq getTq()
    {
        return this._tq_;
    }

    public void setTq(TTq node)
    {
        if(this._tq_ != null)
        {
            this._tq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tq_ = node;
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

    public TFai getFai()
    {
        return this._fai_;
    }

    public void setFai(TFai node)
    {
        if(this._fai_ != null)
        {
            this._fai_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._fai_ = node;
    }

    public PIbloc getIbloc()
    {
        return this._ibloc_;
    }

    public void setIbloc(PIbloc node)
    {
        if(this._ibloc_ != null)
        {
            this._ibloc_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._ibloc_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tq_)
            + toString(this._expr_)
            + toString(this._fai_)
            + toString(this._ibloc_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tq_ == child)
        {
            this._tq_ = null;
            return;
        }

        if(this._expr_ == child)
        {
            this._expr_ = null;
            return;
        }

        if(this._fai_ == child)
        {
            this._fai_ = null;
            return;
        }

        if(this._ibloc_ == child)
        {
            this._ibloc_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tq_ == oldChild)
        {
            setTq((TTq) newChild);
            return;
        }

        if(this._expr_ == oldChild)
        {
            setExpr((PExpr) newChild);
            return;
        }

        if(this._fai_ == oldChild)
        {
            setFai((TFai) newChild);
            return;
        }

        if(this._ibloc_ == oldChild)
        {
            setIbloc((PIbloc) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
