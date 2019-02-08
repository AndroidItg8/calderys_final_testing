package com.itg.calderysapp.caldNet.newIndent.home;


import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itg.calderysapp.R;


import java.util.List;

public class GenericViewPagerAdapter extends android.support.v4.view.PagerAdapter {


    private final Context mContext;
    private final List<AdapterStringModel> mItems;
    private int position=-1;

    public GenericViewPagerAdapter(Context context, List<AdapterStringModel> items) {
        this.mContext = context;
        this.mItems = items;
//        this.listener = listener;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((TextView) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1 ,container, false);
        this.position = position;
        final TextView mTextTitle = (TextView) itemView.findViewById(android.R.id.text1);
        mTextTitle.setText(mItems.get(position).getTitle());

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            mTextTitle.setText(Html.fromHtml(mItems.get(position).getTitle(), Html.FROM_HTML_MODE_COMPACT));
//        } else {
//            mTextTitle.setText(Html.fromHtml(mItems.get(position).getTitle()));
//        }


        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((TextView) object);
    }

    public  int getItemPosition(){
        if(mItems!=null ){
            return this.position;
        }
        return -1;
    }

}
