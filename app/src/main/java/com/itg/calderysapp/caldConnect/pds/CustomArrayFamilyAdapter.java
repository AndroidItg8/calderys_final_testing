package com.itg.calderysapp.caldConnect.pds;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.itg.calderysapp.R;
import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;

import java.util.List;

public class CustomArrayFamilyAdapter extends BaseAdapter {
    private final Context applicationContext;
    private final List<TblFamilyGroup> users;
//    private final onItemCLickedListener listener;

    public CustomArrayFamilyAdapter(Context context, List<TblFamilyGroup> users) {

        this.applicationContext = context;
        this.users = users;
//        this.listener = listener;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public TblFamilyGroup getItem(int position) {
        return (TblFamilyGroup) users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_spinner_row, null);
        }
        TextView mTxtItem = (TextView )convertView.findViewById(R.id.txt_item);

        mTxtItem.setText(users.get(position).getGroupName());


        return convertView;
    }
    public int getItemPosition(String productType, Spinner searchableSpinner) {

        for (int i=0; i< users.size(); i++)
            if (users.get(i).getGroupName().equalsIgnoreCase(productType)){
                return i;

            }


        return -1;
    }

    public void updateList(List<TblFamilyGroup> listFamily) {
        users.clear();
        users.addAll(listFamily);
        notifyDataSetChanged();
    }

    public interface onItemCLickedListener {
        void onItemClicked(int position, TblProductType productType);
    }


}
