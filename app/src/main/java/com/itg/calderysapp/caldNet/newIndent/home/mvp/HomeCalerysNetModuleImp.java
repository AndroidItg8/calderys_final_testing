package com.itg.calderysapp.caldNet.newIndent.home.mvp;


import com.itg.calderysapp.caldNet.newIndent.home.AdapterStringModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.MessageModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.StroiesModel;
import com.itg.calderysapp.common.NetworkUtility;

import java.util.List;

public class HomeCalerysNetModuleImp implements HomeCalderysNetMVP.HomeCalderysNetModule {

    @Override
    public void onGetImportantMessagesListAvailable(String TbleName, int limit, int page, String type, HomeCalderysNetMVP.HomeCalderysNetListener listener) {

        new NetworkUtility.NetworkBuilder().setHeader().build().getImportantMessage(type,new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onGetImportantMessagesListAvailable((List<MessageModel>) message);

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
    public void onGetSuccessStoriesListAvailable(String TbleName, int limit, int page, String type, HomeCalderysNetMVP.HomeCalderysNetListener listener) {

        new NetworkUtility.NetworkBuilder().setHeader().build().getStroiesList(TbleName, type,new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onGetSuccessStoriesListAvailable((List<StroiesModel>) message);

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
    public void onDestroy() {
        new NetworkUtility.NetworkBuilder().build().destroyedNetworkCall();

    }

    @Override
    public void onEditSettingModel(AdapterStringModel model, HomeCalderysNetMVP.HomeCalderysNetListener listener) {
        new NetworkUtility.NetworkBuilder().setHeader().build().editSettingModel(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onSuccess(message);

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
    public void onDeleteSettingModel(AdapterStringModel model, HomeCalderysNetMVP.HomeCalderysNetListener listener) {


        new NetworkUtility.NetworkBuilder().setHeader().build().deleteSettingModel(model, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onSuccess(message);

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
