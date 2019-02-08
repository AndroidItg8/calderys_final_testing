package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import com.itg.calderysapp.caldNet.newIndent.intent.model.IntentByDateModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.BaseListener;
import com.itg.calderysapp.common.CommonListener;

public class ViewIntentModuleImp implements IntentView.ViewIntentModule {
    @Override
    public void onGetViewIntentListByDate(IntentByDateModel model ,BaseListener listener ) {
        listener.onSuccess("", "");

    }

    @Override
    public void onGetAllViewIntent(PaginationModel model, CommonListener.MyIntentListener listener) {

    }



    @Override
    public void onDestroy() {
    }
}
