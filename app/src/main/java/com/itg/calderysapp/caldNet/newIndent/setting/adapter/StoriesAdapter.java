package com.itg.calderysapp.caldNet.newIndent.setting.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.home.AdapterStringModel;
import com.itg.calderysapp.common.CommonMethod;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoriesAdapter extends RecyclerView.Adapter<StoriesAdapter.GenericViewHolder> {
    private final Context activity;
    private final List<AdapterStringModel> list;
    private final OnItemClickedListner listner;

    private boolean isDeleteClicked=false;


    public StoriesAdapter(Context activity, List<AdapterStringModel> list, OnItemClickedListner listner) {
        this.activity = activity;
        this.list = list;
        this.listner = listner;
    }

    @NonNull
    @Override
    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_generic_stories, parent, false);
        GenericViewHolder vi = new GenericViewHolder(view);
        return vi;
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        CommonMethod.setLeftRightDrawable(holder.mTxtDate,R.drawable.ic_date,0);

        holder.mTxtDate.setText(list.get(position).getDate());
        holder.mTxtDealerCode.setText(list.get(position).getTitle());
        if (list.get(position).isActive()) {
            holder.mTxtDealerName.setText("true");
            holder.mTxtDealerName.setTextColor(activity.getResources().getColor(R.color.colorGreen));
        }
        else {
            holder.mTxtDealerName.setText("false");
            holder.mTxtDealerName.setTextColor(activity.getResources().getColor(R.color.red));
        }


        if (list.get(position).isShowProgress())
             if(isDeleteClicked){
                 holder.mProgressDelete.setVisibility(View.VISIBLE);
                 holder.mImgDelete.setVisibility(View.GONE);

             }else{
                 holder.mProgressDelete.setVisibility(View.GONE);
                 holder.mImgDelete.setVisibility(View.VISIBLE);
             }




    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickedListner {
        void onItemClickedEdit(int position, AdapterStringModel model);

        void onItemEnableClicked(int position, AdapterStringModel model);

        void onItemDeleteClicked(int position, AdapterStringModel model);
    }

    public class GenericViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_date)
        TextView mTxtDate;
        @BindView(R.id.img_edit)
        ImageView mImgEdit;
        @BindView(R.id.img_enable)
        ImageView mImgEnable;
        @BindView(R.id.img_delete)
        ImageView mImgDelete;
        @BindView(R.id.rl)
        RelativeLayout mRl;

        @BindView(R.id.view)
        View mView;
        @BindView(R.id.lbl_dealer_code)
        TextView mLblDealerCode;
        @BindView(R.id.txt_dealerCode)
        TextView mTxtDealerCode;
        @BindView(R.id.lbl_dealer_name)
        TextView mLblDealerName;
        @BindView(R.id.txt_dealerName)
        TextView mTxtDealerName;
        @BindView(R.id.progressEnable)
        ProgressBar mProgressEnable;
        @BindView(R.id.progressDelete)
        ProgressBar mProgressDelete;

        public GenericViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mImgEnable.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemEnableClicked(getAdapterPosition(), list.get(getAdapterPosition()));
                }
            });
            mImgEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClickedEdit(getAdapterPosition(), list.get(getAdapterPosition()));
                }
            });
            mImgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isDeleteClicked = true;

                    listner.onItemDeleteClicked(getAdapterPosition(), list.get(getAdapterPosition()));
                }
            });

        }
    }
}
