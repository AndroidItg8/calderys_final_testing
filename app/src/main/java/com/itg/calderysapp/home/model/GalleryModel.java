
package com.itg.calderysapp.home.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GalleryModel implements Parcelable
{

    @SerializedName("Status")
    @Expose
    private Integer status;
    @SerializedName("Errorcode")
    @Expose
    private Integer errorcode;
    @SerializedName("data")
    @Expose
    private List<GalleryData> data = null;
    public final static Creator<GalleryModel> CREATOR = new Creator<GalleryModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GalleryModel createFromParcel(Parcel in) {
            return new GalleryModel(in);
        }

        public GalleryModel[] newArray(int size) {
            return (new GalleryModel[size]);
        }

    }
    ;

    protected GalleryModel(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.errorcode = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.data, (GalleryData.class.getClassLoader()));
    }

    public GalleryModel() {
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

    public List<GalleryData> getData() {
        return data;
    }

    public void setData(List<GalleryData> data) {
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
