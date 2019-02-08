package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.common.CommonListener;
import com.itg.calderysapp.common.NetworkUtility;

import java.util.List;

public class ViewDraftModuleImp implements IntentView.ViewDraftModule {
    @Override
    public void onGetViewDraftList(PaginationModel model, CommonListener.ViewDraftListener listener) {
        new NetworkUtility.NetworkBuilder().setHeader().build().getViewDraftList(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onGetViewDraftsListAvailable((List<ViewDraftModel>) message);
            }

            @Override
            public void onFailure(Object err) {
                listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {

            }
        });

    }


    @Override
    public void onCancelViewDraft(final ViewDraftModel model,  CommonListener.ViewDraftListener listener) {
        new NetworkUtility.NetworkBuilder().setHeader().build().cancelViewDraft(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onSuccessDelete(
                         model);
            }

            @Override
            public void onFailure(Object err) {
                listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {
                 listener.onError(e);

            }
        });

    }



    @Override
    public void onDestroy() {
        new NetworkUtility.NetworkBuilder().build().destroyedNetworkCall();

    }
}
