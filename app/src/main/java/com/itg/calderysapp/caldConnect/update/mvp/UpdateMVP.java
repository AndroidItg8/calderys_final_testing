package com.itg.calderysapp.caldConnect.update.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.itg.calderysapp.caldConnect.update.UpdateFragment;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.BaseView;

import java.io.File;
import java.util.List;

public interface UpdateMVP {
  public interface AddUpdateView extends BaseView {
    String getTitles();

    String getDescription();

    String getFilePath();

    void onSuccess(String message);

    void onSuccessFile(String message);

    void onFail(String message);

    void onError(Object t);

    void showFabProgress();

    void hideFabProgress();

    void onTitleInvalid(String err);

    void onDescriptionInvalid(String err);

    void onFileInvalid(String err);

    void onProgressUpdate(int prrogress);

    void failedFileUpload();

    void onFinishedFileUpload();

    String getID();
  }

  public interface AddUpdatePresenter {
    void onDestroy();

    void onAddUpdateClicked(AddUpdateView view);

    void onFileUpload(String absoluteFile, View v);
  }

  public interface AddUpdateListener {
    void onFileSuccess(String message);

    void onSuccess(String message);

    void onFail(String message);

    void onError(Object t);

    void onProgressUpdate(int prrogress);
    void onFailedProgress();
    void onFinished();

    void onSuccessData(Datum message);
  }

  public interface AddUpdateModule {
    void onStartAddUpdateCall(String tile, String description, String date, String filePath, String id, AddUpdateListener listener);

    void onDestroy();

    void onUploadFileToServer(File absoluteFile, UpdateMVP.AddUpdateListener listener);
  }


  public interface UpdateView extends BaseView {
    void onFail(String message);

    void onError(Object t);

    void onShowPaginationLoading(boolean show);

    void onNoMoreList();

    void onGetListAvailable(List<com.itg.calderysapp.caldConnect.update.model.Datum> o);

    void onSearchDataAvaiable(List<Datum> message);

    void onNoItemFound();

    void clearListAdapter();

    void checkPageNo(int page, boolean b);
  }

  public interface UpdatePresenter {
    void onGetUpdateList(UpdateView view, String tbleName, String perPage, int PageNumber);

    void onDestroy();

    void onLoadMore(String from);

    void onLoadMoreItem(String from);

    RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager, String from);


    void onSearchQuery(String searchWord);

    void setViewAllAvailable(UpdateView updateFragment);
  }

  public interface UpdateListener {
    void onFail(String message);

    void onError(Object t);

    void onNoMoreList();

    void onPaginationError();

    void onGetList(List<com.itg.calderysapp.caldConnect.update.model.Datum> message);

    void onGetSearch(List<Datum> message);
  }

  public interface UpdateModule {
    void onGetUpdateListFromServer(String tableName, int perPage, int PageNumber, UpdateMVP.UpdateListener listener);

    void onDestroy();

    void onSearchQuery(String tableUpdate, int page, String searchWord, int limit, UpdateMVP.UpdateListener listener );

  }




}
