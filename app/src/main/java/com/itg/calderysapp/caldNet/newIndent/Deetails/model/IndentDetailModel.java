
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IndentDetailModel implements Parcelable
{

    @SerializedName("IndentInfo")
    @Expose
    private Object indentInfo;
    public final static Creator<IndentDetailModel> CREATOR = new Creator<IndentDetailModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public IndentDetailModel createFromParcel(Parcel in) {
            return new IndentDetailModel(in);
        }

        public IndentDetailModel[] newArray(int size) {
            return (new IndentDetailModel[size]);
        }

    }
    ;

    protected IndentDetailModel(Parcel in) {
        this.indentInfo = ((IndentInfo) in.readValue((IndentInfo.class.getClassLoader())));
    }

    public IndentDetailModel() {
    }

    public Object getIndentInfo() {
        return indentInfo;
    }

    public void setIndentInfo(IndentInfo indentInfo) {
        this.indentInfo = indentInfo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(indentInfo);
    }

    public int describeContents() {
        return  0;
    }

}
