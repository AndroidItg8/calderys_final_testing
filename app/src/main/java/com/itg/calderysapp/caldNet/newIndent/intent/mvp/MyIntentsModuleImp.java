package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.common.CommonListener;
import com.itg.calderysapp.common.NetworkUtility;

import java.util.List;

public class MyIntentsModuleImp implements IntentView.MyIntentsModule {

    @Override
    public void onGetMyIntent(PaginationModel model, CommonListener.MyIntentListener listener) {
        new NetworkUtility.NetworkBuilder().setHeader().build().getMyIndent(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onGetMyIntentsListAvailable((List<IndentModel>) message);
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
    public void onCancelMyIntent(IndentModel model, CommonListener.MyIntentListener listener) {
        ViewDraftModel  model1 = new ViewDraftModel();
        model1.setIndentCode(model.getIndentCode());
        model1.setIndentDate(model.getIndentDate());
        new NetworkUtility.NetworkBuilder().setHeader().build().cancelViewDraft(model1, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onSuccess(model, "");
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

    @Override
    public void onGetSingleIndent(PaginationModel modell, CommonListener.MyIntentListener listener) {
        new NetworkUtility.NetworkBuilder().setHeader().build().getSingleIndentItem(modell, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onGetMyIntentsListAvailable((List<IndentModel>) message);
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
}
