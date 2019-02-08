package com.itg.calderysapp.caldNet.newIndent.intent.appoveIntent.mvp;

import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.caldNet.newIndent.intent.mvp.IntentView;
import com.itg.calderysapp.common.CommonListener;
import com.itg.calderysapp.common.NetworkUtility;

import java.util.List;

public class ApprovedIntentModuleImp implements IntentView.ApprovedIntentModule {


    @Override
    public void onGetApprovedIntentListByDate(PaginationModel model, CommonListener.ApprovedIntentListener listener) {
        new NetworkUtility.NetworkBuilder().setHeader().build().getIndentByDate(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                if(message instanceof List){
                    List<IndentModel> indentModels= (List<IndentModel>) message;
                    listener.onGetAllApprovedIntent(indentModels);
                }
            }

            @Override
            public void onFailure(Object err) {
                listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {
listener.onError(e.toString());

            }
        });
    }


    @Override
    public void onGetAllApprovedIntent(PaginationModel model, CommonListener.ApprovedIntentListener listener) {
        new NetworkUtility.NetworkBuilder().setHeader().build().getMyIndent(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onGetAllApprovedIntent((List<IndentModel>) message);
            }

            @Override
            public void onFailure(Object err) {
                listener.onError(err.toString());

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

    @Override
    public void onGetViewIntentListByDate(PaginationModel model, CommonListener.ApprovedIntentListener listener) {
        new NetworkUtility.NetworkBuilder().setHeader().build().getViewIntent(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onGetAllApprovedIntent((List<IndentModel>) message);
            }

            @Override
            public void onFailure(Object err) {
                listener.onError(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {

            }
        });

    }

    @Override
    public void onCancelIndent(IndentModel model, CommonListener.ApprovedIntentListener listener) {
        ViewDraftModel model1 = new ViewDraftModel();
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
}
