package com.itg.calderysapp.caldNet.newIndent.intent.adapter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.ProgressViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IntentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_PROGRESS = 2;
    private static final int ITEM_MAIN = 1;
    private final Context context;
    private final List<IndentModel> models;



    private int from;
    private OnItemClickedListner listner;

    public IntentAdapter(Context context, List<IndentModel> list, int from, OnItemClickedListner listner) {

        this.context = context;
        this.models = new ArrayList<>();
        this.from = from;
        this.listner = listner;
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_intent, parent, false);
            UpdateViewHolder vi = new UpdateViewHolder(view);
            return vi;

        } else {
            return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_progress, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UpdateViewHolder) {


            if (models.get(position).getIndApprvlStatus().equalsIgnoreCase(CommonMethod.CANCEL)) {
                ((UpdateViewHolder) holder).llDetails.setVisibility(View.GONE);
                ((UpdateViewHolder) holder).txtCancel.setVisibility(View.GONE);
                ((UpdateViewHolder) holder).txtEdit.setVisibility(View.GONE);
                ((UpdateViewHolder) holder).txtStatus.setText("Cancel");
                setViewToCenter((UpdateViewHolder) holder);
                }

            else if (models.get(position).getIndApprvlStatus().equalsIgnoreCase(CommonMethod.SO_GENRATED)) {
                ((UpdateViewHolder) holder).llDetails.setVisibility(View.GONE);
                ((UpdateViewHolder) holder).txtCancel.setVisibility(View.GONE);
                ((UpdateViewHolder) holder).txtEdit.setVisibility(View.GONE);
                ((UpdateViewHolder) holder).txtStatus.setText("Approved");

            }else if (models.get(position).getIndApprvlStatus().equalsIgnoreCase(CommonMethod.REJECT)) {
                ((UpdateViewHolder) holder).llDetails.setVisibility(View.GONE);
                ((UpdateViewHolder) holder).txtCancel.setVisibility(View.GONE);
                ((UpdateViewHolder) holder).txtEdit.setVisibility(View.GONE);
                ((UpdateViewHolder) holder).txtStatus.setText("Reject");

            } else if (models.get(position).getIndApprvlStatus().equalsIgnoreCase(CommonMethod.PENDING)) {
                ((UpdateViewHolder) holder).txtStatus.setText("Pending");
                ((UpdateViewHolder) holder).llDetails.setVisibility(View.VISIBLE);
                ((UpdateViewHolder) holder).txtCancel.setVisibility(View.VISIBLE);
                ((UpdateViewHolder) holder).txtEdit.setVisibility(View.VISIBLE);

                if (models.get(position).isDelete()) {
                    ((UpdateViewHolder) holder).progressDelete.setVisibility(View.VISIBLE);
                    ((UpdateViewHolder) holder).txtCancel.setVisibility(View.GONE);
                }else{

                    ((UpdateViewHolder) holder).progressDelete.setVisibility(View.GONE);
                    ((UpdateViewHolder) holder).txtCancel.setVisibility(View.VISIBLE);
                }
                CommonMethod.setLeftRightDrawable(((UpdateViewHolder) holder).txtDate, R.drawable.ic_date, 0);
                setViewToCenter((UpdateViewHolder) holder);


            }


            changeStrokeColor(((UpdateViewHolder) holder).txtEdit, context.getResources().getColor(R.color.colorGreen));
            changeStrokeColor(((UpdateViewHolder) holder).txtCancel, context.getResources().getColor(R.color.red));

            ((UpdateViewHolder) holder).txtDate.setText((models.get(position).getPODate()));
            ((UpdateViewHolder) holder).txtDealerCode.setText((models.get(position).getDealerCode()));
//            SpinnerGenericModel model  =(CommonMethod.getXMLValueById(models.get(position).getIndApprvlStatus(), STATUS));
            ((UpdateViewHolder) holder).txtTitles.setText((models.get(position).getIndentCode()));
            ((UpdateViewHolder) holder).txtSoNumber.setText((models.get(position).getSONumber()));


        } else {
            ((ProgressViewHolder) holder).progress.setVisibility(View.VISIBLE);
        }
    }

    private void changeStrokeColor(View view, int color) {
        GradientDrawable drawable = (GradientDrawable) view.getBackground();
        drawable.setStroke(3, color);
    }

    private void setViewToCenter(@NonNull UpdateViewHolder holder) {
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.gravity = Gravity.CENTER_HORIZONTAL;
//        holder.mTxtIntentDetails.setLayoutParams(lp);
    }


    @Override
    public int getItemCount() {
        return models.size();
    }


    public void addItems(List<IndentModel> o) {
        models.addAll(o);
        notifyDataSetChanged();

    }

    public void addFooter() {
        if (models.size() > 0) {
            if (models.get(models.size() - 1) != null) {
                models.add(null);
                notifyItemInserted(models.size() - 1);
            }
        }

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

    public void removeItem(IndentModel message) {
        if (models != null && models.size() > 0)
            models.remove(message);
    }


    public interface OnItemClickedListner {
        void onItemClicked(int position, IndentModel model, int from);

        void onItemClickedDispatched(int position, IndentModel model, int from);

        void onItemCancel(int adapterPosition, IndentModel indentModel, int from);

        void onItemEdit(int adapterPosition, IndentModel indentModel, int from);
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
        @BindView(R.id.lbl_so_number)
        TextView lblSoNumber;
        @BindView(R.id.txt_dealer_code)
        TextView txtDealerCode;
        @BindView(R.id.lbl_delear_code)
        TextView lblDelearCode;
        @BindView(R.id.txt_so_number)
        TextView txtSoNumber;
        @BindView(R.id.img_delete)
        ImageView imgDelete;
        @BindView(R.id.img_edit)
        ImageView imgEdit;
        @BindView(R.id.rl_edit)
        RelativeLayout rlEdit;
        @BindView(R.id.checkbox)
        AppCompatCheckBox checkbox;
        @BindView(R.id.txt_date)
        TextView txtDate;
        @BindView(R.id.view)
        View view;
        @BindView(R.id.txt_edit)
        TextView txtEdit;
        @BindView(R.id.txt_cancel)
        TextView txtCancel;
        @BindView(R.id.ll_details)
        LinearLayout llDetails;
        @BindView(R.id.progress_delete)
        ProgressBar progressDelete;

        public UpdateViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            txtCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemCancel(getAdapterPosition(), models.get(getAdapterPosition()), from);

                }
            });
            txtEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemEdit(getAdapterPosition(), models.get(getAdapterPosition()), from);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.onItemClicked(getAdapterPosition(), models.get(getAdapterPosition()), from);
                }
            });
        }


    }
}
