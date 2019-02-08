package com.itg.calderysapp.caldNet.newIndent.intent.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.ProgressViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectIntentCodeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_MAIN = 1;
    private static final int ITEM_PROGRESS = 2;
    private final Context mContext;
    private final List<IndentModel> list;
    private DealerModel dealerModel;
    private final OnItemClickedListner listner;
    private final List<IndentModel> models;


    public SelectIntentCodeAdapter(Context mContext
            , List<IndentModel> list, DealerModel dealerModel, OnItemClickedListner listner) {
        this.mContext = mContext;
        this.list = list;
        this.dealerModel = dealerModel;
        this.listner = listner;
        this.models = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (i == ITEM_MAIN) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_intent_code, parent, false);
            IntentCodeHolder vi = new IntentCodeHolder(view);
            return vi;

        } else {
            return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_progress, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof IntentCodeHolder) {
//            if(dealerModel!=null)
//                mTxtDealerCode.setText(dealerModel.getFirstName());
//            else
CommonMethod.setLeftRightDrawable(((IntentCodeHolder) holder).mTxtDate,R.drawable.ic_date,0);
            ((IntentCodeHolder) holder).mTxtDealerCode.setText(models.get(position).getDealerCode());
            ((IntentCodeHolder) holder).mTxtDealerName.setText(models.get(position).getIndentCode());
            ((IntentCodeHolder) holder).mTxtDate.setText(models.get(position).getIndentDate());

        } else {
            ((ProgressViewHolder) holder).progress.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class IntentCodeHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_date)
        TextView mTxtDate;
        @BindView(R.id.lbl_dealer_code)
        TextView mLblDealerCode;
        @BindView(R.id.txt_dealerCode)
        TextView mTxtDealerCode;
        @BindView(R.id.lbl_dealer_name)
        TextView mLblDealerName;
        @BindView(R.id.txt_dealerName)
        TextView mTxtDealerName;

        public IntentCodeHolder(View view) {
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

    public void addItems(List<IndentModel> o) {
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

    public void serachItemAdd(List<IndentModel> message) {
//        duplicateModels.addAll(models);
//        models.clear();
        models.addAll(message);
        notifyDataSetChanged();


    }


    public interface OnItemClickedListner {
        void onItemClicked(int position, IndentModel datum);
    }

    @Override
    public int getItemViewType(int position) {
        if (models.get(position) == null)
            return ITEM_PROGRESS;
        else
            return ITEM_MAIN;
    }
}