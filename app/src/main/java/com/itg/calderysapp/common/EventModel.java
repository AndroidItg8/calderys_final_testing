package com.itg.calderysapp.common;

public class EventModel {
    boolean isSuccess;
    String error;

    public EventModel(boolean isSuccess, String error) {
        this.isSuccess = isSuccess;
        this.error = error;
    }
}
