
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IndentInfo implements Parcelable
{

    @SerializedName("Indents")
    @Expose
    private Object indents;
    public final static Creator<IndentInfo> CREATOR = new Creator<IndentInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public IndentInfo createFromParcel(Parcel in) {
            return new IndentInfo(in);
        }

        public IndentInfo[] newArray(int size) {
            return (new IndentInfo[size]);
        }

    }
    ;

    protected IndentInfo(Parcel in) {
        this.indents = ((Indents) in.readValue((Indents.class.getClassLoader())));
    }

    public IndentInfo() {
    }

    public Object getIndents() {
        return indents;
    }

    public void setIndents(Indents indents) {
        this.indents = indents;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(indents);
    }

    public int describeContents() {
        return  0;
    }

}
