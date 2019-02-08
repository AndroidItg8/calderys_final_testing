package com.itg.calderysapp.caldNet.newIndent.createIntent.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ProductItem;
import com.itg.calderysapp.common.genericRv.BaseViewHolder;
import com.itg.calderysapp.databinding.ItemRvIntentMaterialBinding;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MaterialIndentAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final int ITEM_PROGRESS = 2;
    private static final int ITEM_MAIN = 1;
    private final Context context;
    private final List<SaveMaterialModel> models;

    OnItemClickedListner listner;

    public MaterialIndentAdapter(Context context, List<SaveMaterialModel> list, OnItemClickedListner listner) {

        this.context = context;
        this.models = list;
        this.listner = listner;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        ItemRvIntentMaterialBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_rv_intent_material, parent, false);
        MaterialViewHolder vi = new MaterialViewHolder(binding);
        return vi;
    }


    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        if (holder instanceof MaterialViewHolder) {
            ((MaterialViewHolder)holder).bind(models.get(position));
        }
    }


    @Override
    public int getItemCount() {
        return models.size();
    }


    public interface OnItemClickedListner {
        void onItemClicked(int position, ProductItem datum);
    }

    public class MaterialViewHolder extends BaseViewHolder<SaveMaterialModel> {


        public MaterialViewHolder(@NonNull  ItemRvIntentMaterialBinding itembind) {
            super(itembind);
        }


        @Override
        public void setBindable(ViewDataBinding bindable) {

        }

        @Override
        public void bind(SaveMaterialModel object) {

        }
    }
}
