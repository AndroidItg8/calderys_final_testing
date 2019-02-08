package com.itg.calderysapp.common.genericRv;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {
    public BaseViewHolder(ViewDataBinding itemView) {
        super(itemView.getRoot());
        setBindable(itemView);
    }

    public abstract void setBindable(ViewDataBinding bindable);

    public abstract void bind(T object);
}
