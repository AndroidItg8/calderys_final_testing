package com.itg.calderysapp.caldConnect.pds.mvp;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.itg.calderysapp.caldConnect.pds.PDSFragment;
import com.itg.calderysapp.caldConnect.pds.model.CompleteResultModel;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.update.UpdateDetailFragment;
import com.itg.calderysapp.common.BaseView;
import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;

import java.io.File;
import java.util.List;


public interface PDSMVP {

    public interface PDSAddView  extends BaseView {

        String getProductName();

        String getFileType();

        String getFamilyGroup();

        String getProductType();

        void onSuccess(List<TblProductType> message);

        void onFail(String message);

        void onError(Object t);

        void onProductNameInvalid(String err);

        void onProductTypeInvalid(String err);

        void onProductFamilyGroupInvalid(String err);

        void onProductFileTypeInvalid(String err);

        void showFabProgress();

        void onFileInvalid(String invalid_file_path);

        void hideFabProgress();

        void failedFileUpload();

        void onFinishedFileUpload();

        void onProgressUpdate(int prrogress);
        void onSuccessFile(String message);

        void onSuccessSave(String s);

        String getID();


        String getFilePath();

        void setData(Data message);

        void onSuccessFamilyGroupe(List<TblFamilyGroup> message);
    }

    public interface PDSAddPresenter{

        void onDestroy();
        void onDownloadSpinner();
        void onSubmitbtnClicked(PDSAddView view);
        void  onDownloadedCompelete(CompleteResultModel tableName);


        void onFileUpload(String absoluteFile, View v);

        void getFirstPDSItem();

        void onDownloadFamily();
    }
    public  interface PDSAddListener{
        void onSuccess(  List<TblProductType> message);
        void onFail(String message);
        void onError(Object t);

        void onFileSuccess(String s);

        void onProgressUpdate(int prrogress);

        void onFinished();

        void onFailedProgress();

        void onSuccessSave(String s);

        void onSuccessDataNotification(Data message);

        void onGetItemFirstPDS(List<Data> message);

        void onSuccessFamilyGroupe(List<TblFamilyGroup> message);
    }

    public interface PDSAddModule{

        void onDestroyed();
        void onDownloadProductType(PDSAddListener listener, Context context);
        void onSubmitPDS(String productName,
                         String productType,
                         String FamilyGroup,
                         String FileType,
                         String date,
                         String share,
                         String fromEdit, PDSAddListener listener);


        void onUploadFileToServer(File absoluteFile, PDSMVP.PDSAddListener listener);

        void onGetPDSListFromServer(String tableName, int perPage, int PageNumber, PDSAddListener listener);

        void onDownloadFamilyGroupe(PDSAddListener listener, Context context);
    }


    public interface PDSView extends BaseView {
        void onFail(String message);

        void onError(Object t);

        void onShowPaginationLoading(boolean show);

        void onGetListAvailable(List<Data> o);

        void onNoMoreList();

        void onSearchDataAvaiable(List<Data> message);

        void onNoItemFound();

        void clearListAdapter();

        void getPageNo(int page, boolean b);
    }

    public interface PDSPresenter {
        void onDestroy();


        void onLoadMore(String from);

        void onLoadMoreItem(String fromPds);
        void onGetSearch(List<Data> message);

        RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager, String from);


        void onSearchQuery(String s);

        void allViewAvailable(PDSView view);
    }

    public interface PDSListener {
        void onFail(String message);

        void onError(Object t);

        void onNoMoreList();

        void onPaginationError();

        void onGetList(List<Data> message);

        void onGetSearch(List<Data> message);
    }

    public interface PDSModule {
        void onGetPDSListFromServer(String tableName, int perPage, int PageNumber,PDSMVP.PDSListener listener);

        void onDestroy();

        void onSearchQuery(String tableUpadte, int page, String searchWord, int limit, PDSListener listener);
    }

    public interface PDSDeleteViw extends BaseView{

        void onDeleteSucess(String message);
        void onDownloadFileSucess(String message);
        void onFail(String message);

        void onError(Object t);

    }

    public interface PDSDeletePresenter {
        void onDestroy();


        void deletePDS(String tblUpdate, String id);
        void downloadPdsFile(String tableName, File file);

        void setViewAllAvailable(PDSDeleteViw viewAllAvailable);
    }

    public interface PDSDeleteListener {
        void onFail(String message);

        void onError(Object t);
        void onSucessDelete(String message);
        void onSucessDownload(String fileName);

        ;
    }

    public interface PDSDeleteModule {
        void onDeletePDSFromServer(String tblUpdate, String id, PDSDeleteListener listener);
        void onUploadSuccessPDSFromServer(String tableName, File file, PDSMVP.PDSDeleteListener listener);


        void onDestroyed();
    }


}
