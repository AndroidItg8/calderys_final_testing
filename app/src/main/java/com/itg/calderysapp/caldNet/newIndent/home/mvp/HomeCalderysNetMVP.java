package com.itg.calderysapp.caldNet.newIndent.home.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.itg.calderysapp.caldNet.newIndent.home.AdapterStringModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.MessageModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.StroiesModel;
import com.itg.calderysapp.caldNet.newIndent.setting.SettingFragment;
import com.itg.calderysapp.common.BaseView;


import java.util.List;

public interface HomeCalderysNetMVP {

    public interface HomeCalderysNetView extends BaseView {
        void onShowPaginationLoading(boolean show);

        void onGetImportantMessagesListAvailable(List<MessageModel> o);
        void onGetSuccessStoriesListAvailable(List<StroiesModel> o);

        void onNoMoreList();

        void onFail(String message);

        void onError(Object t);
        void onSuccess(Object object);




    }
    public  interface HomeCalderysNetPresenter {
        void onDestroy();

        void onLoadMore(String tbleName,  String type);

        void onLoadMoreItem(String tbleName, String type);

        RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager, String TbleName);


        void onDownloadImportantMesage(String tblImportantMessage, String type);

        void onDownloadSuccessStories(String tblImportantMessage, String type);

        void onEditUploadedSetting(AdapterStringModel model);

        void onDeleteSetting(AdapterStringModel model);

        void onViewAvail(HomeCalderysNetView view);

    }

    public interface HomeCalderysNetListener  {
        void onFail(String message);

        void onError(Object t);


        void onPaginationError();
         void onSuccess(Object object);

        void onGetImportantMessagesListAvailable(List<MessageModel> o);
        void onGetSuccessStoriesListAvailable(List<StroiesModel> o);
    }

    public interface HomeCalderysNetModule {
        void onGetImportantMessagesListAvailable(String TbleName, int limit, int page, String type, HomeCalderysNetListener listener);
        void onGetSuccessStoriesListAvailable(String TbleName, int limit, int page, String type, HomeCalderysNetListener listener);

        void onDestroy();

        void onEditSettingModel(AdapterStringModel model, HomeCalderysNetListener listener );

        void onDeleteSettingModel(AdapterStringModel model,  HomeCalderysNetListener listener );
    }


    public interface HomeCalderysNetSaveView extends BaseView {
        String getDescption();
        boolean isActive ();
        void onSuccess(Object message);
        void onFail(String message);
        void onError(Object t);

        void onDesciptionInvalid(String err);

        void onIsActiveInvalid(String err);


        int getFromWhere();

        boolean isFromEdit();

        String getId();
    }

    public interface  HomeCalderysNetSavePresenter{
        void onDestroy();
        void onLoginClicked(View view);

    }

    public interface  HomeCalderysNetSaveListener{
        void onSuccess(Object message);
        void onFail(String message);
        void onError(Object t);

    }

    public interface HomeCalderysNetSaveModule{
        void onStartSubmitCall(AdapterStringModel model ,HomeCalderysNetMVP.HomeCalderysNetSaveListener listener);
        void onDestroy();

        void onAddSetting(AdapterStringModel model , HomeCalderysNetMVP.HomeCalderysNetSaveListener listener);
    }
}
