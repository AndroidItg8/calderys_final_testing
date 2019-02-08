package com.itg.calderysapp.caldConnect.gallery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.itg.calderysapp.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private final Context context;
    private final Integer[] image_ids;
    private final GalleryItemListener listener;


    public GalleryAdapter(Context context, Integer[] image_ids, GalleryItemListener listener) {
        this.context = context;
        this.image_ids = image_ids;
        this.listener = listener;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_gallerry, viewGroup, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder galleryViewHolder, int position) {
//        Picasso.with(context).load(image_ids[position]).resize(120, 120).into(galleryViewHolder.mImg);
    }

    @Override
    public int getItemCount() {
        return image_ids.length;
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img)
        ImageView mImg;
        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(getAdapterPosition(), image_ids[getAdapterPosition()]);
                }
            });
        }

    }

    public interface GalleryItemListener {
        void onItemClicked(int positon, int img);
    }
}
