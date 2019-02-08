package com.itg.calderysapp.caldNet.newIndent.consignee.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeItemViewModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeViewModel;
import com.itg.calderysapp.caldNet.newIndent.intent.appoveIntent.ApproveIndentAdapter;
import com.itg.calderysapp.common.ProgressViewHolder;
import com.itg.calderysapp.databinding.ItemRvCosigneeItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ConsigneeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_PROGRESS = 0;
    private static final int ITEM_MAIN = 1;

    private List<ConsigneeListModel> models;
    private ConsigneeListViewModel.OnItemClickListner listner;

    public ConsigneeListAdapter(List<ConsigneeListModel> list) {
        this.models=list;
    }

    public void addModels(List<ConsigneeListModel> models) {
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
        return models.get(position) == null ? ITEM_PROGRESS : ITEM_MAIN;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        if (i == ITEM_MAIN){
            ItemRvCosigneeItemBinding itemBinding =
                    DataBindingUtil.inflate(inflater,R.layout.item_rv_cosignee_item, parent, false);
            return new ConsigneeViewHolder(itemBinding);
        }else {
            return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_progress, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof ConsigneeViewHolder){
            ((ConsigneeViewHolder)viewHolder).bindData(models.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public void setListener(ConsigneeListViewModel.OnItemClickListner listner) {
        this.listner = listner;
    }

    private class ConsigneeViewHolder extends RecyclerView.ViewHolder {
        private ItemRvCosigneeItemBinding binding;

        public ConsigneeViewHolder(ItemRvCosigneeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(ConsigneeListModel consigneeListModel){
            if(binding.getConsigneeModel()==null){
                binding.setConsigneeModel(new ConsigneeItemViewModel(consigneeListModel,itemView.getContext(),listner));
            }else {
                binding.getConsigneeModel().setModel(consigneeListModel);
            }
        }
    }
}
