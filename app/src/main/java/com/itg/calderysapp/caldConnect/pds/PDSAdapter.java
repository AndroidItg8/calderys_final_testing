package com.itg.calderysapp.caldConnect.pds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.caldNet.newIndent.intent.adapter.IntentAdapter;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.ProgressViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PDSAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private Context context;
    private final PDSFragment pdsFragment;
    OnItemClickedListner listner;
    private final List<Data> models;
    private static final int ITEM_MAIN = 1;
    private static final int ITEM_PROGRESS = 2;

    public PDSAdapter(Context context, PDSFragment pdsFragment, OnItemClickedListner listner) {

        this.context = context;
        this.pdsFragment = pdsFragment;
        this.listner = listner;
        this.models = new ArrayList<>();
    }

    @Override
    public int getItemViewType(int position) {
        if (models.get(position) == null)
            return ITEM_PROGRESS;
        else
            return ITEM_MAIN;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (i == ITEM_MAIN) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_pds, parent, false);
            UpdateViewHolder vi = new UpdateViewHolder(view);
            return vi;
        } else {
            return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_progress, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UpdateViewHolder) {

            ((UpdateViewHolder) holder).txtTitles.setText(models.get(position).getProductName());
//            ((UpdateViewHolder) holder).mTxtProductType.setText(models.get(position).getProductType());
//            ((UpdateViewHolder) holder).mTxtFamilyGroup.setText(models.get(position).getFamilyGroup());
            CommonMethod.setLeftRightDrawable(((UpdateViewHolder) holder).txtDate, R.drawable.ic_date, 0);
            ((UpdateViewHolder) holder).txtDate.setText(models.get(position).getUploadedDate());


//
//            if (models.get(position).getFile() != null && !TextUtils.isEmpty(models.get(position).getFile())) {
//                ((UpdateViewHolder) holder).mImgDownload.setVisibility(View.VISIBLE);
//            } else {
//                ((UpdateViewHolder) holder).mImgDownload.setVisibility(View.GONE);
//
//            }
        } else {
            ((ProgressViewHolder) holder).progress.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return models.size();
    }
    public void addItems(List<Data> o) {
        models.addAll(o);
        notifyDataSetChanged();

    }

    public void addFooter() {
        models.add(null);
        notifyItemInserted(models.size() - 1);
    }

    public void removeFooter() {
        if(models.size()>0) {
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
    public void serachItemAdd(List<Data> message) {
//        duplicateModels.addAll(models);
//        models.clear();
        models.addAll(message);
        notifyDataSetChanged();


    }

    public class UpdateViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_titles)
        TextView txtTitles;
        @BindView(R.id.img_attach)
        ImageView imgAttach;

        @BindView(R.id.txt_date)
        TextView txtDate;

        public UpdateViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClicked(getAdapterPosition(), models.get(getAdapterPosition()));
                }
            });
        }


    }

    public interface OnItemClickedListner {
        void onItemDownloadFileClicked(int position, Data datum);

        void onItemClicked(int position, Data datum);
    }
}
