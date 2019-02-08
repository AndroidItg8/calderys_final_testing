package com.itg.calderysapp.caldNet.newIndent.home.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.caldNet.newIndent.home.AdapterStringModel;
import com.itg.calderysapp.caldNet.newIndent.home.HomeCalderysNetFragment;
import com.itg.calderysapp.caldNet.newIndent.home.model.MessageModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.StroiesModel;
import com.itg.calderysapp.caldNet.newIndent.setting.SettingFragment;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonMethod;

import java.util.List;

public class HomeCalderysNetPresenterImp extends BaseWeakPresenter<HomeCalderysNetMVP.HomeCalderysNetView> implements HomeCalderysNetMVP.HomeCalderysNetListener,HomeCalderysNetMVP.HomeCalderysNetPresenter {
    private HomeCalderysNetMVP.HomeCalderysNetModule module;

    private static final int LIMIT = 10;
    private int page=1;
    private String loadUrl;
    private boolean isLoading;
    private boolean isFinished=false;



    public HomeCalderysNetPresenterImp(HomeCalderysNetMVP.HomeCalderysNetView updateView) {
        super(updateView);
        module = new HomeCalerysNetModuleImp();
    }

    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }




    private HomeCalderysNetMVP.HomeCalderysNetView getUpdateView() {
        return getView();
    }


    @Override
    public void onLoadMore(String tbleName, String type) {
        getItems(page,LIMIT, tbleName, type);
    }

    @Override
    public void onLoadMoreItem(String tableName, String type) {
        onLoadMore(tableName, type);
    }

    @Override
    public void onFail(String message) {
        if(hasView()) {
            getUpdateView().hideProgress();
            getUpdateView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if(hasView()) {
            getUpdateView().hideProgress();
            getUpdateView().onError(t);
        }
    }

    @Override
    public RecyclerView.OnScrollListener scrollListener(final LinearLayoutManager linearLayoutManager, String tbleName) {
        return new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                if (!isLoading && !isFinished)
                {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount && firstVisibleItemPosition >= 0)
                    {

                        page++;

                       // getItems(page,LIMIT, tbleName);
                    }
                }

            }
        };
    }

    @Override
    public void onDownloadImportantMesage(String tblImportantMessage, String type) {
        onLoadMore(tblImportantMessage, type);
    }

    @Override
    public void onDownloadSuccessStories(String tblImportantMessage, String type) {
        onLoadMore(tblImportantMessage, type);


    }




    private void getItems(int page, int limit, String tbleName, String type) {
        if(hasView()){
//            getView().onShowPaginationLoading(true);
//            isLoading=true;
            getUpdateView().showProgress();
            if(tbleName.equalsIgnoreCase(CommonMethod.TBL_IMPORTANT_MESSAGE))
            module.onGetImportantMessagesListAvailable(CommonMethod.TBL_IMPORTANT_MESSAGE,limit,page,type, this);
            else
                module.onGetSuccessStoriesListAvailable(CommonMethod.TBL_SUCCESS_STORIES , limit,page,type,this);

        }
    }





    @Override
    public void onPaginationError() {
        if(hasView()){
            getUpdateView().hideProgress();

            getView().onShowPaginationLoading(false);
        }
    }

    @Override
    public void onGetImportantMessagesListAvailable(List<MessageModel> o) {
        if(hasView()){
//            getView().onShowPaginationLoading(false);
            getUpdateView().hideProgress();

            if(o.size()>0)
                getView().onGetImportantMessagesListAvailable(o);
//            else {
//                getView().onNoMoreList();
//                isFinished=true;
//            }
//            isLoading=false;
        }
    }

    @Override
    public void onGetSuccessStoriesListAvailable(List<StroiesModel> o) {
        if(hasView()){
//            getView().onShowPaginationLoading(false);
            getUpdateView().hideProgress();

            if(o.size()>0)
                getView().onGetSuccessStoriesListAvailable(o);
//            else {
//                getView().onNoMoreList();
//                isFinished=true;
//            }
//            isLoading=false;
        }
    }

    @Override
    public void onEditUploadedSetting(AdapterStringModel model) {
        if(hasView()){
            getUpdateView().showProgress();
            module.onEditSettingModel(model, this);
        }

    }

    @Override
    public void onSuccess(Object object) {
        if(hasView()){
            getUpdateView().hideProgress();

            getUpdateView().onSuccess(object);
        }

    }

    @Override
    public void onDeleteSetting(AdapterStringModel model) {
        if(hasView()){
            getUpdateView().showProgress();
            module.onDeleteSettingModel(model, this);
        }

    }

    @Override
    public void onViewAvail(HomeCalderysNetMVP.HomeCalderysNetView homeCalderysNetFragment) {
        weakViewCreated(homeCalderysNetFragment);
    }
}
