package com.itg.calderysapp.caldConnect.update;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.ProgressViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class UpdateAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int ITEM_MAIN = 1;
    private static final int ITEM_PROGRESS = 2;
    private final Context context;
    private final UpdateFragment updateFragment;
    private final List<Datum> models;
    OnItemClickedListner listner;


    public UpdateAdapter(Context context, UpdateFragment updateFragment, OnItemClickedListner listner) {
        this.context = context;
        this.updateFragment = updateFragment;
        this.listner = listner;
        models = new ArrayList<>();
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
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_update, parent, false);
            UpdateViewHolder vi = new UpdateViewHolder(view);
            return vi;
        } else {
            return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_progress, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof UpdateViewHolder) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                ((UpdateViewHolder) holder).mTxtTitles.setText(Html.fromHtml(models.get(position).getTitle(), Html.FROM_HTML_MODE_COMPACT));
            } else {
                ((UpdateViewHolder) holder).mTxtTitles.setText(Html.fromHtml(models.get(position).getTitle()));
            }
            ((UpdateViewHolder) holder).mTxtDate.setText(models.get(position).getUploadDate());
            ((UpdateViewHolder) holder).mTxtYear.setText((CommonMethod.calculateDays(models.get(position).getUploadDate())));
        } else {
            ((ProgressViewHolder) holder).progress.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public int getItemCount() {
        return models.size();
    }


    public void addItems(List<Datum> o) {
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
    public void serachItemAdd(List<Datum> message) {
//        duplicateModels.addAll(models);
//        models.clear();
        models.addAll(message);
        notifyDataSetChanged();


    }



    public interface OnItemClickedListner {
        void onItemClicked(int position, Datum datum);
    }

    public class UpdateViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_titles)
        TextView mTxtTitles;
        @BindView(R.id.txt_date)
        TextView mTxtDate;
        @BindView(R.id.txt_year)
        TextView mTxtYear;
        @BindView(R.id.img)
        ImageView mImg;

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
}
