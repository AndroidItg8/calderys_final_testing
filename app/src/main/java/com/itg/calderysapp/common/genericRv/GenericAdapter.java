package com.itg.calderysapp.common.genericRv;

import android.databinding.BaseObservable;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.itg.calderysapp.BR;

import java.util.List;

public  class GenericAdapter<T extends BaseObservable,V extends ViewModel,N extends BaseClickListener> extends RecyclerView.Adapter<GenericAdapter.ViewHolder> {

    private List<? extends T> list;
    private V v;
    private N n;
    private static final String TAG = "GenericAdapter";

    public GenericAdapter(List<? extends T> list,V  v, N n) {
        this.list = list;
        this.v=v;
        this.n = n;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        ViewDataBinding bind = DataBindingUtil.bind(LayoutInflater.from(parent.getContext()).inflate(i, parent, false));
        return new ViewHolder<>(bind);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final T model=list.get(i);
        v.setModel(model);
        viewHolder.getBinding().setVariable(BR.model,v);
        viewHolder.getBinding().executePendingBindings();
    }

    @Override
    public int getItemViewType(int position) {
        return v.layoutId();
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: countlist"+list.size());
        return list.size();
    }

    public class ViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {

        V v;

        public ViewHolder(@NonNull V v) {
            super(v.getRoot());
            this.v=v;
            v.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    n.onItemClicked(list.get(getAdapterPosition()));
                }
            });
        }

        public V getBinding(){
            return v;
        }
    }
}