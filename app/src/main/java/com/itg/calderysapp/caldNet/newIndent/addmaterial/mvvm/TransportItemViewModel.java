package com.itg.calderysapp.caldNet.newIndent.addmaterial.mvvm;

import android.databinding.BaseObservable;
import android.view.View;

import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel;

public class TransportItemViewModel extends BaseObservable {
    public TransportModel model;
    private ConsigneeListViewModel.OnItemClickListner listner;

    public TransportItemViewModel(TransportModel model, ConsigneeListViewModel.OnItemClickListner listner) {
        this.model = model;
        this.listner = listner;
    }

    public void setModel(TransportModel model) {
        this.model = model;
    }



    public void onClick(View view){
        listner.onItemClicked(model);
    }


}
