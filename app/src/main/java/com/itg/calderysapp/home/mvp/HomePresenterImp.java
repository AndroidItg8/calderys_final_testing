package com.itg.calderysapp.home.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itg.calderysapp.caldConnect.update.model.Datum;

import com.itg.calderysapp.caldConnect.update.mvp.UpdateMVP;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.home.model.GalleryData;
import com.itg.calderysapp.home.model.GalleryModel;

import java.util.List;

public class HomePresenterImp extends BaseWeakPresenter<HomeMVP.HomeView> implements HomeMVP.HomeListener,HomeMVP.HomePresenter {
    private HomeMVP.HomeModule module;

    private static final int LIMIT = 10;
    private int page=1;
    private String loadUrl;
    private boolean isLoading;
    private boolean isFinished=false;

    @Override
    public void setAllViewAvailable(HomeMVP.HomeView view) {
        weakViewCreated(view);

    }

    public HomePresenterImp(HomeMVP.HomeView updateView) {
        super(updateView);
        module = new HomeModuleImp();
    }

    @Override
    public void onDownloadImages(String tbleName) {
        if(hasView()){
     getView().showProgress();
            module.onGetGalleryModels(tbleName,this);
        }
    }

  @Override
    public void onGetList(List<Datum> o) {
        if(hasView()){
            getView().onShowPaginationLoading(false);
            if(o.size()>0)
                getView().onGetListAvailable(o);
            else {
                getView().onNoMoreList();
                isFinished=true;
            }
            isLoading=false;
        }
    }


    private HomeMVP.HomeView getUpdateView() {
        return getView();
    }
    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }

    @Override
    public void onLoadMore() {
        getItems(page,LIMIT);
    }

    @Override
    public void onLoadMoreItem() {
        onLoadMore();
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
    public RecyclerView.OnScrollListener scrollListener(final LinearLayoutManager linearLayoutManager) {
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

                        getItems(page,LIMIT);
                    }
                }

            }
        };
    }



    private void getItems(int page, int limit) {
        if(hasView()){
            getView().onShowPaginationLoading(true);
            isLoading=true;
            module.onGetUpdateListFromServer("announcement",limit,page,this);
        }
    }





    @Override
    public void onPaginationError() {
        if(hasView()){
            getView().onShowPaginationLoading(false);
        }
    }

    @Override
    public void onGetImagesGallery(List<GalleryData> models) {
        if(hasView()){
            getView().hideProgress();
            getView().onSuccessImages(models);
        }

    }
}
