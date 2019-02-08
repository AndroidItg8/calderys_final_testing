package com.itg.calderysapp.common;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;
//https://codereview.stackexchange.com/questions/173504/generic-adapter-with-search-and-sort-functionality
public abstract class GenericAdapter<T ,E extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<E> {

    private final List<T> list;
    private final Context context;
    OnRecyclerViewClickListner listener;

    public GenericAdapter(List<T> list , Context context) {
        this.list = list;
        this.context = context;
        listener= setListener();
    }


    @NonNull
    @Override
    public E onCreateViewHolder(@NonNull ViewGroup parent, int i) {
       E holder = setViewHolder(parent , listener);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull E viewHolder, int position) {
        bindViewData(viewHolder, list.get(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }



    protected abstract E setViewHolder(ViewGroup parent, OnRecyclerViewClickListner listner);
    protected abstract void bindViewData(E viewHolder, T val);
    protected abstract OnRecyclerViewClickListner setListener();



    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
    public void addItems(List<T> value){
        list.addAll(value);
        notifyDataSetChanged();
    }


    public void removeFooter() {

    }

    public void addFooter() {

    }
}
