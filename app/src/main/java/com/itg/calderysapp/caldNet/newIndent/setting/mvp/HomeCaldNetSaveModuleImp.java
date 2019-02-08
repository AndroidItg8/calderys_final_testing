package com.itg.calderysapp.caldNet.newIndent.setting.mvp;

import com.itg.calderysapp.caldNet.newIndent.home.AdapterStringModel;
import com.itg.calderysapp.caldNet.newIndent.home.mvp.HomeCalderysNetMVP;
import com.itg.calderysapp.common.NetworkUtility;

class HomeCaldNetSaveModuleImp implements com.itg.calderysapp.caldNet.newIndent.home.mvp.HomeCalderysNetMVP.HomeCalderysNetSaveModule {


    @Override
    public void onDestroy() {
        new NetworkUtility.NetworkBuilder().build().destroyedNetworkCall();

    }

    @Override
    public void onAddSetting(AdapterStringModel model, HomeCalderysNetMVP.HomeCalderysNetSaveListener listener) {
        new NetworkUtility.NetworkBuilder().setHeader().build().addSettingModel(model,
                new NetworkUtility.ResponseListener() {
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
                        listener.onError(e);

                    }
                });

    }

    @Override
    public void onStartSubmitCall(AdapterStringModel model, HomeCalderysNetMVP.HomeCalderysNetSaveListener listener) {
         new NetworkUtility.NetworkBuilder().setHeader().build().editSettingModel(model,
        new NetworkUtility.ResponseListener() {
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
                listener.onError(e);

            }
        });

    }
}
