package com.itg.calderysapp.caldNet.newIndent.intent.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.ProgressViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewDraftAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_PROGRESS = 2;
    private static final int ITEM_MAIN = 1;
    private final Context context;
    private final List<ViewDraftModel> models;



    private OnItemClickedListner mListner;
    private boolean isDeleteClicked = false;


    public ViewDraftAdapter(Context context, List<ViewDraftModel> list, OnItemClickedListner listner) {

        this.context = context;
        this.models = new ArrayList<>();
        mListner = listner;
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_view_draft, parent, false);
            UpdateViewHolder vi = new UpdateViewHolder(view);
            return vi;
        } else {
            return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_progress, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UpdateViewHolder) {
            CommonMethod.setLeftRightDrawable(((UpdateViewHolder) holder).txtDate, R.drawable.ic_date, 0);


            ((UpdateViewHolder) holder).txtTitles.setText(models.get(position).getIndentCode());
            ((UpdateViewHolder) holder).txtDate.setText(models.get(position).getIndentDate());
            if(models.get(position).getIndApprvlStatus().equalsIgnoreCase("M"))
                    ((UpdateViewHolder) holder).txtStatus.setText("Save in Draft");

            if (models.get(position).isDelete()) {
                ((UpdateViewHolder) holder).llDetails.setVisibility(View.GONE);
                ((UpdateViewHolder) holder).progressDelete.setVisibility(View.VISIBLE);

            } else {
                ((UpdateViewHolder) holder).llDetails.setVisibility(View.VISIBLE);
                ((UpdateViewHolder) holder).progressDelete.setVisibility(View.GONE);
            }

            changeStrokeColor(((UpdateViewHolder) holder).txtEdit, context.getResources().getColor(R.color.colorGreen));
            changeStrokeColor(((UpdateViewHolder) holder).txtCancel, context.getResources().getColor(R.color.red));



        } else {
            ((ProgressViewHolder) holder).progress.setVisibility(View.VISIBLE);
        }
    }

    private void changeStrokeColor(View view, int color) {
        GradientDrawable drawable = (GradientDrawable) view.getBackground();
        drawable.setStroke(3, color);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }


    public void addItems(List<ViewDraftModel> o) {
        models.clear();
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

    public void serachItemAdd(List<ViewDraftModel> message) {
//        duplicateModels.addAll(models);
//        models.clear();
        models.addAll(message);
        notifyDataSetChanged();


    }



    public void removeModel(ViewDraftModel modell) {
        this.models.remove(modell);
        notifyDataSetChanged();
    }


    public interface OnItemClickedListner {
        void onItemClickedEdit(int position, ViewDraftModel datum);

        void onItemClickedDelete(int position, ViewDraftModel datum);
    }

    public class UpdateViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_titles)
        TextView txtTitles;
        @BindView(R.id.lbl_titles)
        TextView lblTitles;
        @BindView(R.id.lbl_status)
        TextView lblStatus;
        @BindView(R.id.txt_status)
        TextView txtStatus;
        @BindView(R.id.txt_edit)
        TextView txtEdit;
        @BindView(R.id.txt_cancel)
        TextView txtCancel;
        @BindView(R.id.progress_delete)
        ProgressBar progressDelete;
        @BindView(R.id.frm)
        FrameLayout frm;
        @BindView(R.id.ll_details)
        LinearLayout llDetails;
        @BindView(R.id.txt_date)
        TextView txtDate;
        @BindView(R.id.view)
        View view;

        public UpdateViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            txtCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    isDeleteClicked = true;

                    mListner.onItemClickedDelete(getAdapterPosition(), models.get(getAdapterPosition()));
                }
            });
            txtEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListner.onItemClickedEdit(getAdapterPosition(), models.get(getAdapterPosition()));
                }
            });
        }


    }
}
