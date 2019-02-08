package com.itg.calderysapp.common;

public interface CommonInterface {

    public interface hideShowFabListner{
        void onFabShowListner(int navPos);
        void onFabHideListner();
    }
    public interface hideFabListener{
        void onFabHideHomeFragmentListner();
    }

    public interface BackpressListner{
        void onBackPressListener();
    }

    public interface  EasyPermissionListener{
        void onGranted();
        void onDenied();
    }

    public interface DownloadServiceBindListner{
        void onDownloadStarted();
        void onDownloadFinished();
        void onDownloadFailed(String error);
        void onDownloadProgress(int progress);
    }

    public interface SearchDataListener {
     void onSearchQuery(String s);
     void onSearchSubmit(String s);
     void onCloseSearch();

        void onSearchQueryForAll();

        void onCollapsed();
    }

    public interface ShowSettingMenu{
         void onShowSettingMenuForAdmin();


    }
     public  interface ShowSearchMenu{
        void onHideShowSearchMenu();
     }
}
