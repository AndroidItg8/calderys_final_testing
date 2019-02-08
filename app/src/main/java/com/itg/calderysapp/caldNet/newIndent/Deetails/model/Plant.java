
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plant implements Parcelable
{

    @SerializedName("plant")
    @Expose
    private Object plant;
    public final static Creator<Plant> CREATOR = new Creator<Plant>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Plant createFromParcel(Parcel in) {
            return new Plant(in);
        }

        public Plant[] newArray(int size) {
            return (new Plant[size]);
        }

    }
    ;

    protected Plant(Parcel in) {
        this.plant = ((Plant_) in.readValue((Plant_.class.getClassLoader())));
    }

    public Plant() {
    }

    public Object getPlant() {
        return plant;
    }

    public void setPlant(Plant_ plant) {
        this.plant = plant;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(plant);
    }

    public int describeContents() {
        return  0;
    }

}
