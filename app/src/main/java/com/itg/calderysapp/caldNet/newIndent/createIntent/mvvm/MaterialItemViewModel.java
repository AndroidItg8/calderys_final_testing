package com.itg.calderysapp.caldNet.newIndent.createIntent.mvvm;

import android.databinding.BaseObservable;
import android.view.View;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.viewmodel.ConsigneeListViewModel;
import com.itg.calderysapp.common.genericRv.ViewModel;

public class MaterialItemViewModel extends BaseObservable implements ViewModel<SaveMaterialModel> {

    public SaveMaterialModel model;
    private ConsigneeListViewModel.OnItemClickListner listener;

    public MaterialItemViewModel() {
    }

    @Override
    public int layoutId() {
        return R.layout.item_rv_intent_material;
    }

    @Override
    public void setModel(SaveMaterialModel saveMaterialModel) {
        this.model=saveMaterialModel;
    }

    public void setListener(ConsigneeListViewModel.OnItemClickListner listener){
        this.listener = listener;
    }

    public void onClick(View view){
        this.listener.onItemClicked(model);
    }



}
