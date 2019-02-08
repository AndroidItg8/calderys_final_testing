package com.itg.calderysapp.caldNet.newIndent.home;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public  class AdapterStringModel implements Parcelable {
    private boolean active;
    private int id;
    private String date;
    private boolean showProgress;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    private String from;

    public AdapterStringModel() {
    }

    public AdapterStringModel(boolean active, int id, String from, String title, String date) {
        this.active = active;
        this.id = id;
        this.from = from;
        this.title = title;
        this.date = date;
    } public AdapterStringModel(boolean active, String from, String title, String date) {
        this.active = active;
        this.from = from;
        this.title = title;
        this.date = date;
    }public AdapterStringModel(String from, String title) {
        this.from = from;
        this.title = title;
    }

    public AdapterStringModel(String title) {
        this.title = title;
    }

    public String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void isActive(boolean active) {

        this.active = active;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }


    public void setShowProgress(boolean showProgress) {

        this.showProgress = showProgress;
    }

    public boolean isShowProgress() {
        return showProgress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.active ? (byte) 1 : (byte) 0);
        dest.writeInt(this.id);
        dest.writeString(this.date);
        dest.writeByte(this.showProgress ? (byte) 1 : (byte) 0);
        dest.writeString(this.from);
        dest.writeString(this.title);
    }

    protected AdapterStringModel(Parcel in) {
        this.active = in.readByte() != 0;
        this.id = in.readInt();
        this.date = in.readString();
        this.showProgress = in.readByte() != 0;
        this.from = in.readString();
        this.title = in.readString();
    }

    public static final Parcelable.Creator<AdapterStringModel> CREATOR = new Parcelable.Creator<AdapterStringModel>() {
        @Override
        public AdapterStringModel createFromParcel(Parcel source) {
            return new AdapterStringModel(source);
        }

        @Override
        public AdapterStringModel[] newArray(int size) {
            return new AdapterStringModel[size];
        }
    };
}
