package com.itg.calderysapp.common;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.itg.calderysapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProgressViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.progress)
    public ProgressBar progress;

    public ProgressViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
