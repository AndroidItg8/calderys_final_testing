package com.itg.calderysapp.home.mvp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.BaseView;
import com.itg.calderysapp.home.HomeFragment;
import com.itg.calderysapp.home.model.GalleryData;
import com.itg.calderysapp.home.model.GalleryModel;

import java.util.List;

import io.reactivex.disposables.Disposable;

public interface HomeMVP {
     public interface HomeView extends BaseView{
         void onSuccessImages(List<GalleryData> model);
         void onShowPaginationLoading(boolean show);

         void onGetListAvailable(List<Datum> o);

         void onNoMoreList();

         void onFail(String message);

         void onError(Object t);



     }
     public  interface HomePresenter {
         void onDownloadImages(String tbleName);
         void onDestroy();

         void onLoadMore();

         void onLoadMoreItem();

         RecyclerView.OnScrollListener scrollListener(LinearLayoutManager layoutManager);


         void setAllViewAvailable(HomeView view);
     }

    public interface HomeListener {
        void onFail(String message);

        void onError(Object t);


        void onPaginationError();

        void onGetList(List<Datum> message);
        void onGetImagesGallery(List<GalleryData> models);
    }

    public interface HomeModule {
        void onGetUpdateListFromServer(String tableName, int perPage, int PageNumber, HomeListener listener);
        void onGetGalleryModels(String tbleName, HomeListener listener);

        void onDestroy();

    }
}
