package com.itg.calderysapp.caldNet.newIndent.intent.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.pds.model.Datum;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.common.ProgressViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DealerCodeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_MAIN = 1;
    private static final int ITEM_PROGRESS = 2;
    private final Context mContext;
    private final List<Datum> list;
    private final OnItemClickedListner listner;
    private final List<DealerModel> models;


    public DealerCodeAdapter(Context mContext, List<Datum> list, OnItemClickedListner listner) {
        this.mContext = mContext;
        this.list = list;
        this.listner = listner;
        this.models = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (i == ITEM_MAIN) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_dealer_code, parent, false);
            DealerCodeHolder vi = new DealerCodeHolder(view);
            return vi;

        } else {
            return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_progress, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DealerCodeHolder) {
            ((DealerCodeHolder) holder).mTxtDealerName.setText(models.get(position).getDealerCode());
            ((DealerCodeHolder) holder).mTxtDealerCode.setText(models.get(position).getFirstName());

        } else {
            ((ProgressViewHolder) holder).progress.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class DealerCodeHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.lbl_dealer_code)
    TextView mLblDealerCode;
        @BindView(R.id.txt_dealerCode)
        TextView mTxtDealerCode;
        @BindView(R.id.lbl_dealer_name)
        TextView mLblDealerName;
        @BindView(R.id.txt_dealerName)
        TextView mTxtDealerName;
        public DealerCodeHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
             view.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                   listner.onItemClicked(getAdapterPosition(), models.get(getAdapterPosition()));
                 }
             });

        }
    }

    public void addItems(List<DealerModel> o) {
        models.addAll(o);
        notifyDataSetChanged();

    }

    public void addFooter() {
        models.add(null);
        notifyItemInserted(models.size() - 1);
    }

    public void removeFooter() {
        if (models.size() > 0) {
            final int itemRemoved = models.size() - 1;
            models.remove(itemRemoved);
            notifyItemRemoved(itemRemoved);
            notifyItemRangeChanged(itemRemoved, models.size());
        }
    }

    public void clearData() {
        models.clear();
        notifyDataSetChanged();
    }

    public void serachItemAdd(List<DealerModel> message) {
//        duplicateModels.addAll(models);
//        models.clear();
        models.addAll(message);
        notifyDataSetChanged();


    }


    public interface OnItemClickedListner {
        void onItemClicked(int position, DealerModel datum);
    }

    @Override
    public int getItemViewType(int position) {
        if (models.get(position) == null)
            return ITEM_PROGRESS;
        else
            return ITEM_MAIN;
    }
}