package com.itg.calderysapp.common.genericRv;

public interface ViewModel<T> {
    int layoutId();
    void setModel(T t);
}
