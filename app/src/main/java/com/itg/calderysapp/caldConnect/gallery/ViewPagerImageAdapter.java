package com.itg.calderysapp.caldConnect.gallery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.home.model.GalleryData;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ViewPagerImageAdapter extends android.support.v4.view.PagerAdapter {
    private static final String TAG = "ViewPagerAdapter";
    Context mContext;
    private Context context;
    private GalleryData item;
    private List<GalleryData> mItems = new ArrayList<>();
    private ImageClickedListener listener;

    public ViewPagerImageAdapter(Context context, List<GalleryData> items, ImageClickedListener listener) {
        this.mContext = context;
        this.listener = listener;
        mItems.addAll(items);
    }

    public ViewPagerImageAdapter(Context context, GalleryData items, ImageClickedListener listener) {

        this.context = context;
        this.listener = listener;
        this.mItems.add(items);
    }

    @Override
    public int getCount() {

        return mItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((FrameLayout) object);
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View itemView = LayoutInflater.from(container.getContext()).inflate(R.layout.pager_item_image, container, false);
        final ImageView imageView = (ImageView) itemView.findViewById(R.id.img_pager_item);
        final TextView mTextTitle = (TextView) itemView.findViewById(R.id.lbl_place_name);

        mTextTitle.setText(mItems.get(position).getTitle());
//        http://192.168.1.56/calderyapp/files/Advertisement/download33.jpg
//        String mainPath = CommonMethod.URL_CALDE_CONNECT_MAIN  + CommonMethod.FILDER_IMAGES + "/" + mItems.get(position).getFile().replaceAll(" ", "%20");
        String mainPath = CommonMethod.URL_CALDE_CONNECT_MAIN  +"files/"+ CommonMethod.FILDER_IMAGES + "/" + mItems.get(position).getFile().replaceAll(" ", "%20");
        mainPath = mainPath.replaceAll(" ", "%20");
//        Log.d(TAG, "instantiateItem: " + mainPath);
        String finalMainPath = mainPath;
        Picasso.get()
                .load(mainPath)
                .placeholder(R.drawable.calderys)
                .error(R.drawable.calderys)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError(Exception e) {

                        Picasso.get()
                                .load(finalMainPath)
                                .resize(300, 200)
                                .into(imageView, new Callback() {
                                    @Override
                                    public void onSuccess() {

                                    }

                                    @Override
                                    public void onError(Exception e) {
                                        Picasso.get()
                                                .load(R.drawable.calderys)
                                                .into((imageView));
                                    }
                                });

                    }
                });


        container.addView(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(position, mItems.get(position));
            }
        });


        return itemView;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, Object object) {
        container.removeView((FrameLayout) object);
    }

    public void setItem(int position) {
        if (mItems != null && position > 0)
            mItems.set(position, mItems.get(position));

    }

    public GalleryData getItemValue(int position) {
        if (mItems != null && position > -1) {
            return mItems.get(position);


        }
        return null;
    }

    public interface ImageClickedListener {
        void onItemClicked(int position, GalleryData datum);

    }
}
