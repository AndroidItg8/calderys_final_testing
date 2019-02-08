package com.itg.calderysapp.caldConnect.update.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonMethod;

import java.util.List;

public class UpdateListPresenterImp extends BaseWeakPresenter<UpdateMVP.UpdateView> implements UpdateMVP.UpdateListener,UpdateMVP.UpdatePresenter {
    private UpdateMVP.UpdateModule module;

    private static final int LIMIT = 10;
    private int page=1;
    private String loadUrl;
    private boolean isLoading;
    private boolean isFinished=false;
    private static final String TAG = "UpdateListPresenterImp";
    private String searchWord=null;

//    pageno:2
//    tablename:announcement
//    searchkeyword:products
//    perpage:10
//    field[0]:title
//    field[1]:Discription

    @Override
    public void onGetSearch(List<Datum> message) {
        if(hasView()) {
            getView().onShowPaginationLoading(false);
            if (message.size() > 0)
                getView().onSearchDataAvaiable(message);
            else {
                isFinished=true;
                getView().onNoItemFound();
            }
            isLoading=false;
        }
    }

    @Override
    public void onSearchQuery(String searchWord) {
        if (hasView())
        {
            getView().clearListAdapter();
            this.searchWord = searchWord;
//            getView().onShowPaginationLoading(true);
            isLoading=true;
            module.onSearchQuery(CommonMethod.TABLE_UPADTE,page, searchWord,LIMIT, this);
        }


    }

    @Override
    public void setViewAllAvailable(UpdateMVP.UpdateView updateFragment) {
        weakViewCreated(updateFragment);
    }

    public UpdateListPresenterImp(UpdateMVP.UpdateView updateView) {
        super(updateView);
        module = new UpdateListModuleImp();
    }

    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }




    private UpdateMVP.UpdateView getUpdateView() {
        return getView();
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

    @Override
    public void onGetUpdateList(UpdateMVP.UpdateView view, String tbleName, String perPage, int PageNumber) {

    }


    @Override
    public void onLoadMore(String from) {
        Log.d(TAG, "onLoadMore: page "+page+ " limit "+LIMIT);
        getItems(page,LIMIT, from);
    }

    @Override
    public void onLoadMoreItem(String from) {
        onLoadMore(from);
    }

    @Override
    public RecyclerView.OnScrollListener scrollListener(final LinearLayoutManager linearLayoutManager, String from) {
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

                        getItems(page,LIMIT, from);
                    }
                }

            }
        };
    }



    private void getItems(int page, int limit, String from) {
        if(hasView()){
//            getView().onShowPaginationLoading(true);
            getView().checkPageNo(page, true);
            isLoading=true;
            if(from.equalsIgnoreCase(CommonMethod.FROM_UPDATE))
            module.onGetUpdateListFromServer("announcement",LIMIT,page,this);
            else {
                getView().clearListAdapter();
                module.onSearchQuery(CommonMethod.TBL_PDS, page, searchWord, LIMIT, this);
            }
        }
    }

    @Override
    public void onNoMoreList() {
        if(hasView()){
            getView().onShowPaginationLoading(false);
        }
    }

    @Override
    public void onPaginationError() {
        if(hasView()){
            getView().onShowPaginationLoading(false);
        }
    }
}
