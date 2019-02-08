package com.itg.calderysapp.common;

public interface   BaseListener {
    void onFail(String message);

    void onError(Object t);
    void onSuccess(Object o, String approved);
    void onPaginationError();

}
