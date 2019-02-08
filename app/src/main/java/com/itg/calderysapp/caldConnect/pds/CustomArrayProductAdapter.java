package com.itg.calderysapp.caldConnect.pds;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.db.table.TblProductType;

import java.util.List;

public class CustomArrayProductAdapter extends BaseAdapter {
    private final Context applicationContext;
    private final List<TblProductType> users;
    private int position=-1;
//    private final onItemCLickedListener listener;

    public CustomArrayProductAdapter(Context applicationContext, List<TblProductType> users) {

        this.applicationContext = applicationContext;
        this.users = users;
//        this.listener = listener;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public TblProductType getItem(int position) {
        return (TblProductType) users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        this.position = position;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_spinner_row, null);
        }

        TextView mTxtItem = (TextView )convertView.findViewById(R.id.txt_item);
        mTxtItem.setText(users.get(position).getProductType());

        return convertView;
    }

    public int getItemPosition(String productType, Spinner searchableSpinner) {

            for (int i=0; i< users.size(); i++)
                if (users.get(i).getProductType().equalsIgnoreCase(productType)){
                    return i;

                    }


        return -1;
    }

    public void updateList(List<TblProductType> listProduct) {
        users.clear();
        users.addAll(listProduct);
        notifyDataSetChanged();
    }


    public interface onItemCLickedListener {
        void onItemClicked(int position, TblProductType productType);
    }


}
