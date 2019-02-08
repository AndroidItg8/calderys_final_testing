package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import com.itg.calderysapp.caldNet.newIndent.intent.model.DispachedModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.CommonListener;
import com.itg.calderysapp.common.NetworkUtility;

import java.util.List;

public class DispachedModuleImp implements IntentView.DispacheModule {


    @Override
    public void onGetDispached(PaginationModel model, CommonListener.DispachedListener listener) {
        new NetworkUtility.NetworkBuilder().setHeader().build().getDispachedList(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onGetAllDispachedList((List<DispachedModel>) message);

            }

            @Override
            public void onFailure(Object err) {
                listener.onError(err);

            }

            @Override
            public void onSomethingWrong(Object e) {

            }
        });
    }

    @Override
    public void onDestroy() {
        new NetworkUtility.NetworkBuilder().build().destroyedNetworkCall();

    }
}
