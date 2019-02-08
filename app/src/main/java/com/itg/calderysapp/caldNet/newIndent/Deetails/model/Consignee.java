
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Consignee implements Parcelable
{

    @SerializedName("consignee")
    @Expose
    private Object consignee;
    public final static Creator<Consignee> CREATOR = new Creator<Consignee>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Consignee createFromParcel(Parcel in) {
            return new Consignee(in);
        }

        public Consignee[] newArray(int size) {
            return (new Consignee[size]);
        }

    }
    ;

    protected Consignee(Parcel in) {
        this.consignee = ((Consignee_) in.readValue((Consignee_.class.getClassLoader())));
    }

    public Consignee() {
    }

    public Object getConsignee() {
        return consignee;
    }

    public void setConsignee(Consignee_ consignee) {
        this.consignee = consignee;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(consignee);
    }

    public int describeContents() {
        return  0;
    }

}
