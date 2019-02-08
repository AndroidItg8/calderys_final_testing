package com.itg.calderysapp.caldNet.newIndent.setting.mvp;

import android.text.TextUtils;
import android.view.View;

import com.itg.calderysapp.caldNet.newIndent.home.AdapterStringModel;
import com.itg.calderysapp.caldNet.newIndent.home.mvp.HomeCalderysNetMVP;
import com.itg.calderysapp.caldNet.newIndent.home.mvp.HomeCalerysNetModuleImp;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonMethod;

import java.util.Calendar;

public class HomeCalderysNetSavePresenterImp  extends BaseWeakPresenter<HomeCalderysNetMVP.HomeCalderysNetSaveView> implements HomeCalderysNetMVP.HomeCalderysNetSaveListener,HomeCalderysNetMVP.HomeCalderysNetSavePresenter {
    private static final int FROM_MESSAGE = 1;
    private static final int FROM_STORIES = 2;
    private HomeCalderysNetMVP.HomeCalderysNetSaveModule module;





    public HomeCalderysNetSavePresenterImp(HomeCalderysNetMVP.HomeCalderysNetSaveView updateView) {
        super(updateView);
        module = new HomeCaldNetSaveModuleImp();
    }

    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }

    @Override
    public void onLoginClicked(View view) {
        if(hasView()){
            String description=getView().getDescption();
            String id=getView().getId();
            boolean isActive=getView().isActive();
            if(TextUtils.isEmpty(description)){
                getView().onDesciptionInvalid("Please Enter Message");
                return;
            }
            getView().showProgress();
            if(getView().isFromEdit()) {
                if (getView().getFromWhere() == FROM_MESSAGE)

                    module.onStartSubmitCall(new AdapterStringModel(isActive,Integer.parseInt(id),CommonMethod.FROM_MESSAGE,description , CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance())), this);
                else if(getView().getFromWhere() == FROM_STORIES){
                    //TODO webservice for stories

                    module.onStartSubmitCall(new AdapterStringModel(isActive,Integer.parseInt(id),CommonMethod.FROM_STROIES,description ,CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance())), this);
                }
            }else {
                if (getView().getFromWhere() == FROM_MESSAGE)
                    module.onAddSetting(new AdapterStringModel(isActive, CommonMethod.FROM_MESSAGE, description , CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance())), this);
                else
                    module.onAddSetting(new AdapterStringModel(isActive, CommonMethod.FROM_STROIES, description, CommonMethod.getDDMMYYYYfromDateServer(Calendar.getInstance()) ), this);


            }
        }
    }


    @Override
    public void onSuccess(Object message) {
         if(hasView()){
             getView().hideProgress();
             getView().onSuccess(message);
         }

    }

    @Override
    public void onFail(String message) {
        if(hasView()){
            getView().hideProgress();
            getView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if(hasView()){
            getView().hideProgress();
            getView().onError(t.toString());
        }
    }


}
