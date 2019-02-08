package com.itg.calderysapp.caldNet.newIndent.intent.appoveIntent;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.intent.adapter.IntentAdapter;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.ProgressViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApproveIndentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_PROGRESS = 2;
    private static final int ITEM_MAIN = 1;

    private final List<IndentModel> models;
    private final IntentAdapter.OnItemClickedListner listener;


    public ApproveIndentAdapter(List<IndentModel> models, IntentAdapter.OnItemClickedListner listner) {
        this.models = models;
        this.listener = listner;
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == ITEM_MAIN)
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_approve_indent, viewGroup, false));
        else
            return new ProgressViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_progress, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ViewHolder) {
                ((ViewHolder) viewHolder).txtDate.setText(models.get(i).getIndentDate());
                ((ViewHolder) viewHolder).txtTitles.setText(models.get(i).getIndentCode());
                ((ViewHolder) viewHolder).txtConsigneename.setText(models.get(i).getConsigneeCode());
        }
    }


    public void addItems(List<IndentModel> o) {
        models.addAll(o);
        notifyDataSetChanged();

    }

    public void addFooter() {
        if(models.size()>0) {
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

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.lbl_titles)
        TextView lblTitles;
        @BindView(R.id.txt_titles)
        TextView txtTitles;
        @BindView(R.id.lbl_date)
        TextView lblDate;
        @BindView(R.id.txt_date)
        TextView txtDate;
        @BindView(R.id.lbl_consignee)
        TextView lblConsignee;
        @BindView(R.id.txt_Cognee_name)
        TextView txtConsigneename;
        @BindView(R.id.layoutTable)
        TableLayout layoutTable;
        @BindView(R.id.viewCenter)
        View viewCenter;
        @BindView(R.id.btnAcceptIndent)
        TextView btnAcceptIndent;
        @BindView(R.id.btnRejectIndent)
        TextView btnRejectIndent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(getAdapterPosition(),models.get(getAdapterPosition()),CommonMethod.FROM_APPROVED);
                }
            });
        }
    }
}
