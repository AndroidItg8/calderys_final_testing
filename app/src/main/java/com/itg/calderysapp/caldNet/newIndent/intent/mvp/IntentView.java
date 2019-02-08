package com.itg.calderysapp.caldNet.newIndent.intent.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.caldNet.newIndent.intent.appoveIntent.ApproveIntentFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.fragment.DealerCodeFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.fragment.IntentsSelectionFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.fragment.ViewDispatchedDetailFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.fragment.ViewDraftFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.fragment.ViewIntentFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.fragment.ViewPantIntentFragment;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DispachedModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IntentByDateModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.common.BaseListener;
import com.itg.calderysapp.common.BaseView;
import com.itg.calderysapp.common.CommonListener;

import java.util.List;

public interface IntentView {

    public interface MyIntentsView extends BaseView{

    void onShowPaginationLoading(boolean show);
     boolean  isPaginationLoading();

    void onGetMyIntentsListAvailable(List<IndentModel> o);
    void onSuccess(IndentModel message);

    void onNoMoreList();
        void createPaginationModel(int pageNumber,PaginationModel model);
         String getQuery();
        void onFail(String message);

    void onError(Object t);

        void getPageItem(int pageNo, boolean b);
    }
    public interface MyIntentsPresenter{

        void onDestroy();

        void onLoadMore(PaginationModel model);

        void onLoadMoreItem(PaginationModel model);

        RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager, String TbleName);


        void onDownLoadMyIntents(PaginationModel model );

        void onCancelMyIntent(IndentModel MyIntentId);

        void allViewAvailable(IntentView.MyIntentsView myIntentFragment);


    }



    public interface MyIntentsModule {
        void onGetMyIntent(PaginationModel model, CommonListener.MyIntentListener listener );
        void onCancelMyIntent(IndentModel model , CommonListener.MyIntentListener listener);

        void onDestroy();

        void onGetSingleIndent(PaginationModel modell, CommonListener.MyIntentListener listener);

    }

    public interface DispachedView extends BaseView{

    void onShowPaginationLoading(boolean show);

    void onGetDispachedList(List<DispachedModel> o);
    void onSuccess(String message);

    void onNoMoreList();

    void onFail(String message);

    void onError(Object t);

    }
    public interface DispachedPresenter{

        void onDestroy();

        void onLoadMore(PaginationModel model);

        void onLoadMoreItem(PaginationModel model);

        RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager, String TbleName);


        void setViewAllAvailable(DispachedView view);
    }
        public interface DispacheModule {
        void onGetDispached(PaginationModel model, CommonListener.DispachedListener listener );

        void onDestroy();

    }



    public interface ViewDraftView extends BaseView{

        void onShowPaginationLoading(boolean show);

        void onGetViewDraftListAvailable(List<ViewDraftModel> o);
        void onSuccess(ViewDraftModel message);

        void onNoMoreList();

        void onFail(String message);

        void onError(Object t);

        void onSuccesDelete(ViewDraftModel message);

        void setSwipeForPage(int pageNo, boolean b);
    }
    public interface ViewDraftPresenter {

        void onDestroy();

        void onLoadMore(PaginationModel tbleName);

        void onLoadMoreItem(PaginationModel tbleName);

        RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager);



        void onCancelViewDraft(ViewDraftModel MyIntentId);

        void allViewAvailable(ViewDraftView view);
    }



    public interface ViewDraftModule {
        void onGetViewDraftList(PaginationModel model,CommonListener.ViewDraftListener listener );
        void onCancelViewDraft(ViewDraftModel model,CommonListener.ViewDraftListener listener);

        void onDestroy();

    }



    public interface ApprovedIntentView extends BaseView{

        void onShowPaginationLoading(boolean show);

        void onGetAllApprovedIntent(List<IndentModel> o);
        void onSuccess(IndentModel message);

        void onNoMoreList();

        void onFail(String message);
        void createPaginationModel(int pageNumber,PaginationModel model);
        void onError(Object t);
        String getDealerCode();
        String getIndentCode();

        void onDealerCodeInvalid(String err);

        void onIndentCodeInvalid(String err);
        void onStartDateInvalid(String err);
        void onEndDateInvalid(String err);


        String getStartDate();
        String getEndDate();

        String getStatus();

        void onStatusCodeInvalid(String string);

        void addScrollListener();
    }
    public interface ApprovedIntentPresenter{

        void onDestroy();

        void onLoadMore(PaginationModel tbleName);

        void onLoadMoreItem(PaginationModel tbleName);
        RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager );
        void loadMore();
        void onSubmitApproved(View view, int fromViewIntent);


        void onApproveClicked(IndentModel model);

        void onCancelMyIntent(IndentModel indentModel);

        void allViewAvailable(IntentView.ApprovedIntentView view);

        void setViewAllAvailable(ViewIntentFragment viewIntentFragment);
    }


    public interface ApprovedIntentModule {
        void onGetApprovedIntentListByDate(PaginationModel model, CommonListener.ApprovedIntentListener listener);
        void onGetAllApprovedIntent(PaginationModel model,CommonListener.ApprovedIntentListener listener );
        void onDestroy();

        void onGetViewIntentListByDate(PaginationModel model,  CommonListener.ApprovedIntentListener listener);

        void onCancelIndent(IndentModel indentModel,CommonListener.ApprovedIntentListener listener );
    }

    public interface ViewIntentView extends BaseView{

        void onShowPaginationLoading(boolean show);

        void onGetAllApprovedIntent(List<Datum> o);
        void onSuccess(String message);

        void onNoMoreList();

        void onFail(String message);

        void onError(Object t);


    }
    public interface ViewIntentPresenter{

        void onDestroy();

        void onLoadMore(String tbleName);

        void onLoadMoreItem(String tbleName);

        RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager, String TbleName);


        void onSubmitViewIntent(IntentByDateModel model);


    }



    public interface ViewIntentModule {
        void onGetViewIntentListByDate(IntentByDateModel model, BaseListener listener);
        void onGetAllViewIntent(PaginationModel model,CommonListener.MyIntentListener listener );

        void onDestroy();

    }
    public interface ViewPlantIntentView extends BaseView{

        void onShowPaginationLoading(boolean show);
        void onGetAllViewPlantIntentList(List<IndentModel> o);
        void onSuccess(IndentModel message);
        void onNoMoreList();
        void onFail(PaginationModel message);
        void onError(Object t);
        void onStartDateInvalid(String err);
        void onEndDateInvalid(String err);
        void addScrollListener();


        String getStartDate();
        String getEndDate();

    }
    public interface ViewPlantIntentPresenter{

        void onDestroy();
        void onLoadMore(PaginationModel tbleName);
        void onLoadMoreItem(PaginationModel tbleName);

        RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager, String string);

        void loadMore();
        void onSubmitApproved(View v, String string);

        void onCancelMyIntent(IndentModel indentModel);

        void setViewAllAvailable(ViewPlantIntentView view);
    }

    public interface ViewPlantIntentModule {
        void onGetAllViewIntent(PaginationModel model,CommonListener.MyIntentListener listener );
        void onDestroy();

        void onDeleteIndent(IndentModel indentModel, CommonListener.MyIntentListener listener);
    }




    public interface DealertView extends BaseView{

        void onShowPaginationLoading(boolean show);
        void onGetDealerList(List<DealerModel> o);
        void onSuccess(String message);
        void onNoMoreList();
        void onFail(String message);
        void onError(Object t);
      boolean  isPaginationLoading();

        String getQuery();
    }
    public interface DealerPresenter{

        void onDestroy();
        void onLoadMore(PaginationModel  model);
        void onLoadMoreItem(PaginationModel model);

        RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager, String TbleName);


        void setViewAllAvailable(DealertView view);
    }

    public interface DealertViewModule {
        void onGetAllDealerList(PaginationModel model,CommonListener.DealerListener listener );
        void onDestroy();

    }












}
