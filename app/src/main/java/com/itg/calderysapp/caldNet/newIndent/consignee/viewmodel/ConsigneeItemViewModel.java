package com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel;
import com.itg.calderysapp.BR;

public class ConsigneeItemViewModel extends BaseObservable {
    public ConsigneeListModel model;
    private Context context;
    private ConsigneeListViewModel.OnItemClickListner listner;

    public ConsigneeItemViewModel(ConsigneeListModel model, Context context, ConsigneeListViewModel.OnItemClickListner listner) {
        this.model = model;
        this.context = context;
        this.listner = listner;
    }

    public void setModel(ConsigneeListModel model) {
        this.model = model;
        notifyPropertyChanged(BR.model);
    }

    @Bindable
    public ConsigneeListModel getModel() {
        return model;
    }

    public void itemClicked(View view){
        listner.onItemClicked(this.model);
    }


}
