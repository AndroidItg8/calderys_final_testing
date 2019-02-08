
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransportMaster implements Parcelable
{

    @SerializedName("TransportMaster")
    @Expose
    private Object transportMaster;
    public final static Creator<TransportMaster> CREATOR = new Creator<TransportMaster>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TransportMaster createFromParcel(Parcel in) {
            return new TransportMaster(in);
        }

        public TransportMaster[] newArray(int size) {
            return (new TransportMaster[size]);
        }

    }
    ;

    protected TransportMaster(Parcel in) {
        this.transportMaster = ((TransportMaster_) in.readValue((TransportMaster_.class.getClassLoader())));
    }

    public TransportMaster() {
    }

    public Object getTransportMaster() {
        return transportMaster;
    }

    public void setTransportMaster(TransportMaster_ transportMaster) {
        this.transportMaster = transportMaster;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(transportMaster);
    }

    public int describeContents() {
        return  0;
    }

}
