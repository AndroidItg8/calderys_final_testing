package com.itg.calderysapp.caldNet.newIndent.createIntent.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Indents;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.IntentDetailModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.common.BaseView;
import com.itg.calderysapp.common.CommonListener;

public interface CreateIntentMVP {

    public  interface CreatIntentView extends BaseView{


        void onShowPaginationLoading(boolean show);

        void onSuccess(String message, String status);

        void onNoMoreList();

        void onFail(String message);

        void onError(Object t);

        void onGetEditDraft(Indents model);

        String getParner();

        String getApprovedeject();

        void onInvalideApproveReject(String empty);

        void onInvalidePartner(String empty);

        void createNotification(String status);

        void showSnackbar(String model);

        void setSAPModel(IntentDetailModel model);
    }

         public  interface  CreateIntentPresenter{


             void onDestroy();

             void onLoadMore(String tbleName);

             void onLoadMoreItem(String tbleName);

             void onEditViewDraftData(ViewDraftModel model);

             RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager, String TbleName);

             void saveApprove(IntentDetailModel model);
             void saveReject(IntentDetailModel model, View view, int from);

             void sendAllApproved(IntentDetailModel model, View view, int from);

             void onDeletIndent(IntentDetailModel indentModel);

             void setViewAllAvailable(CreatIntentView view);

             void sendAllApprovedDatabase(IntentDetailModel message, View view, int fromApproved);

             void downloadEqpCode(String id);
         }



  public  interface  CreateIntentModule{


      void onDownloadMaterialList(PaginationModel model , CommonListener.CreateIntentListener listener);
      void onDownloadEditViewDraft(ViewDraftModel model,CommonListener.CreateIntentListener listener );


      void onDestroy();

      void onSaveApproved(IntentDetailModel model, CommonListener.CreateIntentListener listener );
      void onSaveReject(IntentDetailModel model, CommonListener.CreateIntentListener listener );

      void onDeleteIndent(IntentDetailModel indentModel, CommonListener.CreateIntentListener listener);

      void downloadEqpCode(String id);
  }




}
