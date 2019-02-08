package com.itg.calderysapp.home;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.update.model.Datum;

import java.util.List;


public class ViewPagerUpdateLinkAdapter extends android.support.v4.view.PagerAdapter {

    private final List<Datum> mItems;
    //    private final List<Fileupload> mItems;
    private ImageClickedListener listener;
    Context mContext;
    private int position=-1;

    public interface ImageClickedListener{
        void onItemClicked(int position, Datum datum);
    }


    public ViewPagerUpdateLinkAdapter(Context context, List<Datum>  items, ImageClickedListener listener) {
        this.mContext = context;
        this.mItems = items;
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((MaterialCardView) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container,  int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.pager_update_item, container, false);
        this.position = position;
        final TextView mTextTitle = (TextView) itemView.findViewById(R.id.txt_titles);
        final TextView mTextDate = (TextView) itemView.findViewById(R.id.txt_date);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mTextTitle.setText(Html.fromHtml(mItems.get(position).getTitle(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            mTextTitle.setText(Html.fromHtml(mItems.get(position).getTitle()));
        }
        mTextDate.setText(mItems.get(position).getDate());

//

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(position, mItems.get(position));

            }
        });

        container.addView(itemView);

        return itemView;

    }
    public  int getItemPosition(){
        if(mItems!=null ){
            return this.position;
        }
        return -1;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((MaterialCardView) object);
    }


}
