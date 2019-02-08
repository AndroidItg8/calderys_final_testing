package com.itg.calderysapp.caldConnect.gallery;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.home.model.GalleryData;
import com.itg.calderysapp.widget.sectionedrecyclerviewadapter.SectionParameters;
import com.itg.calderysapp.widget.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import com.itg.calderysapp.widget.sectionedrecyclerviewadapter.StatelessSection;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GallerySection extends StatelessSection {


    private static final String TAG = "GallerySection";
    private String key=null;
    private List<GalleryData> list=null;
    private SectionedRecyclerViewAdapter sectionAdapter = null;
    private HashMap<String, List<GalleryData>> listHashMap = null;
    private Context context;

    private ItemViewHolder.onItemClickedLisner lisner;


//    public GallerySection(HashMap<String, List<GalleryData>> list, Context context, SectionedRecyclerViewAdapter sectionAdapter, ItemViewHolder.onItemClickedLisner lisner) {
//        super(SectionParameters.builder()
//                .itemResourceId(R.layout.section_ex5_item)
//                .headerResourceId(R.layout.section_ex5_header)
//                .build());
//        this.listHashMap = list;
//
//        this.context = context;
//        this.sectionAdapter = sectionAdapter;
//        this.lisner = lisner;
//    }

    public GallerySection(String dataKey, List<GalleryData> dataValue, Context context, SectionedRecyclerViewAdapter sectionAdapter,  ItemViewHolder.onItemClickedLisner lisner) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.section_ex5_item)
                .headerResourceId(R.layout.section_ex5_header)
                .build());
        this.list = dataValue;
        this.key = dataKey;

        this.context = context;
        this.sectionAdapter = sectionAdapter;
        this.lisner = lisner;

    }

    @Override
    public int getContentItemsTotal() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder) holder;


        itemHolder.tvItem.setText(list.get(position).getTitle());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            itemHolder.tvSubItem.setText(Html.fromHtml(list.get(position).getDiscription(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            itemHolder.tvSubItem.setText(Html.fromHtml(list.get(position).getDiscription()));
        }

//        itemHolder.tvSubItem.setText(list.get(position).getDiscription());



//                String mainPath = CommonMethod.URL_CALDE_CONNECT_MAIN  + CommonMethod.FILDER_IMAGES + "/" + list.get(position).getFile().replaceAll(" ", "%20");
                String mainPath = CommonMethod.URL_CALDE_CONNECT_MAIN +"files/" + CommonMethod.FILDER_IMAGES + "/" + list.get(position).getFile().replaceAll(" ", "%20");
        Log.d(TAG, "onBindItemViewHolder: mainPath"+mainPath);
                mainPath = mainPath.replaceAll(" ", "%20");
//                Log.d(TAG, "instantiateItem: " + mainPath);
                String finalMainPath = mainPath;
                Picasso.get()
                        .load(mainPath)
                        .resize(300, 200)
                        .placeholder(R.drawable.calderys)
                        .error(R.drawable.calderys)
                        .networkPolicy(NetworkPolicy.OFFLINE)
                        .into(itemHolder.imgItem, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError(Exception e) {

                                Picasso.get()
                                        .load(finalMainPath)
                                        .resize(300, 200)
                                        .into(itemHolder.imgItem, new Callback() {
                                            @Override
                                            public void onSuccess() {

                                            }

                                            @Override
                                            public void onError(Exception e) {
                                                Picasso.get()
                                                        .load(R.drawable.calderys)
                                                        .into((itemHolder.imgItem));
                                            }
                                        });

                            }
                        });
                itemHolder.rootView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int i=sectionAdapter.getSectionPosition(sectionAdapter.getSectionForPosition(itemHolder.getAdapterPosition()));
                        int newPos= calculateNewPost(i,itemHolder.getAdapterPosition());
                        Log.d(TAG, "onClick: "+itemHolder.getAdapterPosition()+" calculatedPos : "+(newPos)+" itemSecitonPos : "+i);
                        lisner.onItemClicked(newPos, list.get(position));
                    }
                });


    }

    private int calculateNewPost(int i, int adapterPos) {
        return (adapterPos-i)-1;
    }


    private List<GalleryData> getDataValue(HashMap<String, List<GalleryData>> galleryData) {
        for (Map.Entry<String, List<GalleryData>> entry : galleryData.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
            return entry.getValue();
        }
        return null;
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
        HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

        headerHolder.tvTitle.setText(key);


    }


}

class HeaderViewHolder extends RecyclerView.ViewHolder {

    public final TextView tvTitle;
    public final Button btnMore;

    HeaderViewHolder(View view) {
        super(view);

        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        btnMore = (Button) view.findViewById(R.id.btnMore);
    }
}

class ItemViewHolder extends RecyclerView.ViewHolder {

    public final View rootView;
    public final TextView tvItem;
    public final TextView tvSubItem;
    public final ImageView imgItem;

    ItemViewHolder(View view) {
        super(view);

        rootView = view;
        tvItem = (TextView) view.findViewById(R.id.tvItem);
        tvSubItem = (TextView) view.findViewById(R.id.tvSubItem);
        imgItem = (ImageView) view.findViewById(R.id.imgItem);
    }

    public interface onItemClickedLisner {

        void onItemClicked(int position, GalleryData list);
    }
}
