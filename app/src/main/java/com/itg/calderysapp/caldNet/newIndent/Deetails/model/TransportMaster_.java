
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransportMaster_ implements Parcelable
{

    @SerializedName("TransporterCode")
    @Expose
    private String transporterCode;
    @SerializedName("TransporterName")
    @Expose
    private String transporterName;
    public final static Creator<TransportMaster_> CREATOR = new Creator<TransportMaster_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TransportMaster_ createFromParcel(Parcel in) {
            return new TransportMaster_(in);
        }

        public TransportMaster_[] newArray(int size) {
            return (new TransportMaster_[size]);
        }

    }
    ;

    protected TransportMaster_(Parcel in) {
        this.transporterCode = ((String) in.readValue((String.class.getClassLoader())));
        this.transporterName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TransportMaster_() {
    }

    public String getTransporterCode() {
        return transporterCode;
    }

    public void setTransporterCode(String transporterCode) {
        this.transporterCode = transporterCode;
    }

    public String getTransporterName() {
        return transporterName;
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(transporterCode);
        dest.writeValue(transporterName);
    }

    public int describeContents() {
        return  0;
    }

}
