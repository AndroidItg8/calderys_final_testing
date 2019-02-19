package com.itg.calderysapp.caldNet.newIndent.createIntent.mvp;

import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel;

import java.util.List;

interface EqpDataListener {
    void onEqpDataAvail(List<SpinnerGenericModel> models);
}
