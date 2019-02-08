package com.itg.calderysapp.caldConnect.pds.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PDSModel implements Parcelable
{

    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("Errorcode")
    @Expose
    private Integer errorcode;
    @SerializedName("data")
    @Expose
    private List<Data> data = null;
    public final static Creator<PDSModel> CREATOR = new Creator<PDSModel>() {


        @SuppressWarnings({
                "unchecked"
        })
        public PDSModel createFromParcel(Parcel in) {
            return new PDSModel(in);
        }

        public PDSModel[] newArray(int size) {
            return (new PDSModel[size]);
        }

    }
            ;

    protected PDSModel(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.errorcode = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.data, (Datum.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public PDSModel() {
    }

    /**
     *
     * @param status
     * @param data
     * @param errorcode
     */
    public PDSModel(Integer status, Integer errorcode, List<Data> data) {
        super();
        this.status = status;
        this.errorcode = errorcode;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(Integer errorcode) {
        this.errorcode = errorcode;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(errorcode);
        dest.writeList(data);
    }

    public int describeContents() {
        return  0;
    }

}