package com.itg.calderysapp.common;

import com.itg.calderysapp.caldConnect.update.model.Datum;

import java.util.List;

public interface BaseView {
    void onNoInternet();
    void showProgress();
    void hideProgress();

}
