package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.common.CommonListener;
import com.itg.calderysapp.common.NetworkUtility;

import java.util.List;

public class DealerModuleImp implements IntentView.DealertViewModule {
    @Override
    public void onGetAllDealerList(PaginationModel model, CommonListener.DealerListener listener) {
         new NetworkUtility.NetworkBuilder().setHeader().build().getDealerList(model , new NetworkUtility.ResponseListener() {
             @Override
             public void onSuccess(Object message) {
                 listener.onGetDealerList((List<DealerModel>) message);

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
