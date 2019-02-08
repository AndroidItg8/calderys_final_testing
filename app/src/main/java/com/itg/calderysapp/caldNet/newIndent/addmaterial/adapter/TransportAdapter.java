package com.itg.calderysapp.caldNet.newIndent.addmaterial.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm.TransportItemViewModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel;
import com.itg.calderysapp.common.ProgressViewHolder;
import com.itg.calderysapp.databinding.ItemRvTransportBinding;

import java.util.List;

public class TransportAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_PROGRESS=1;
    private static final int ITEM_MAIN=2;
    List<TransportModel> models;
    private ConsigneeListViewModel.OnItemClickListner listner;

    public TransportAdapter(List<TransportModel> models) {
        this.models = models;
    }

    public void addModels(List<TransportModel> models) {
        this.models.addAll(models);
    }

    public void addFooter() {
        if(models.size()>0) {
            if(models.get(models.size()-1)!=null) {
                this.models.add(null);
                notifyItemInserted(models.size() - 1);
            }
        }
    }

    public void removeFooter() {
        if (models.size() > 0)
            if (models.get(models.size() - 1) == null) {
                final int itemRemoved = models.size() - 1;
                models.remove(itemRemoved);
                notifyItemRemoved(itemRemoved);
                notifyItemRangeChanged(itemRemoved, models.size());
            }
    }

    @Override
    public int getItemViewType(int position) {
        return models.get(position)==null?ITEM_PROGRESS:ITEM_MAIN;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemType) {
        LayoutInflater inflater=LayoutInflater.from(viewGroup.getContext());
        if(itemType==ITEM_MAIN){
             ItemRvTransportBinding binding= DataBindingUtil.inflate(inflater, R.layout.item_rv_transport, viewGroup, false);
           return new TransportViewHolder(binding);
        }else
        {
            return new ProgressViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_progress, viewGroup, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof TransportViewHolder){
            ((TransportViewHolder)viewHolder).setBinding(models.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void setListener(ConsigneeListViewModel.OnItemClickListner listner) {
        this.listner = listner;
    }

    private class TransportViewHolder extends RecyclerView.ViewHolder {
        private ItemRvTransportBinding binding;

        public TransportViewHolder(ItemRvTransportBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setBinding(TransportModel transportModel) {
            if(binding.getTransportModel()==null){
                binding.setTransportModel(new TransportItemViewModel(transportModel,listner));
            }else {
                binding.getTransportModel().setModel(transportModel);
            }
        }
    }
}
