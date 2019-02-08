package com.itg.calderysapp.caldConnect.pds.mvp;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.common.BaseWeakPresenter;
import com.itg.calderysapp.common.CommonMethod;

import java.util.List;

public class PDSPresenterImp extends BaseWeakPresenter<PDSMVP.PDSView> implements PDSMVP.PDSListener,PDSMVP.PDSPresenter  {
    private final PDSMVP.PDSModule module;
    private final Context context;
    private static final int LIMIT = 10;
    private int page=1;
    private String loadUrl;
    private boolean isLoading;
    private boolean isFinished=false;
    private static final String TAG = "PDSPresenterImp";
    private String serachWord=null;

    public PDSPresenterImp(PDSMVP.PDSView view, Context context) {
        super(view);
        this.context = context;
        module=new PDSModuleImp();
    }
    @Override
    public void onDestroy() {
        detactView();
        module.onDestroy();
    }




    private PDSMVP.PDSView getPDSView() {
        return getView();
    }

    @Override
    public void onFail(String message) {
        if(hasView()) {
            getPDSView().hideProgress();
            getPDSView().onFail(message);
        }
    }

    @Override
    public void onError(Object t) {
        if(hasView()) {
            getPDSView().hideProgress();
            getPDSView().onError(t);
        }
    }



    @Override
    public void onGetList(List<Data> o) {
        if(hasView()){
            getPDSView().onShowPaginationLoading(false);
            if(o.size()>0)
                getPDSView().onGetListAvailable(o);
            else {
                getPDSView().onNoMoreList();
                isFinished=true;
            }
            isLoading=false;
        }
    }




    @Override
    public void onLoadMore(String from) {
        getItems(page,LIMIT, from);
    }

    @Override
    public void onLoadMoreItem(String from) {
        onLoadMore(from);
    }



    @Override
    public void onSearchQuery(String searchWord) {
        if (hasView())
        {
            getView().clearListAdapter();
            this.serachWord = searchWord;
//            getView().onShowPaginationLoading(true);
            isLoading=true;
            module.onSearchQuery(CommonMethod.TBL_PDS,page, searchWord,LIMIT, this);
        }

    }

    @Override
    public void allViewAvailable(PDSMVP.PDSView view) {
        weakViewCreated(view);
    }

    @Override
    public void onGetSearch(List<Data> message) {
        if(hasView()) {
            getView().hideProgress();
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
                        Log.d(TAG, "onScrolled: page "+page);

                        page++;


                        getItems(page,LIMIT,from);

                    }
                }

            }
        };
    }


    private void getItems(int page, int limit, String from) {
        if(hasView()){
//            getPDSView().onShowPaginationLoading(true);
            getPDSView().getPageNo(page, true);
            isLoading=true;
            if(from.equalsIgnoreCase(CommonMethod.FROM_PDS))
                module.onGetPDSListFromServer("product_data_sheet",limit,page,this);
            else
                module.onSearchQuery(CommonMethod.TBL_PDS,page, serachWord,LIMIT, this);
        }
    }



    @Override
    public void onNoMoreList() {
        if(hasView()){
            getPDSView().onShowPaginationLoading(false);
        }
    }

    @Override
    public void onPaginationError() {
        if(hasView()){
            getPDSView().onShowPaginationLoading(false);
        }
    }
}
