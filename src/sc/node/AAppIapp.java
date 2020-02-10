/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.node;

import sc.analysis.*;

@SuppressWarnings("nls")
public final class AAppIapp extends PIapp
{
    private PApp _app_;
    private TPvir _pvir_;

    public AAppIapp()
    {
        // Constructor
    }

    public AAppIapp(
        @SuppressWarnings("hiding") PApp _app_,
        @SuppressWarnings("hiding") TPvir _pvir_)
    {
        // Constructor
        setApp(_app_);

        setPvir(_pvir_);

    }

    @Override
    public Object clone()
    {
        return new AAppIapp(
            cloneNode(this._app_),
            cloneNode(this._pvir_));
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAppIapp(this);
    }

    public PApp getApp()
    {
        return this._app_;
    }

    public void setApp(PApp node)
    {
        if(this._app_ != null)
        {
            this._app_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._app_ = node;
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
            + toString(this._app_)
            + toString(this._pvir_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._app_ == child)
        {
            this._app_ = null;
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
        if(this._app_ == oldChild)
        {
            setApp((PApp) newChild);
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