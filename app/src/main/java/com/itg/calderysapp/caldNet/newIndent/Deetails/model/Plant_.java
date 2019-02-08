
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Plant_ implements Parcelable
{

    @SerializedName("PlantID")
    @Expose
    private String plantID;
    @SerializedName("plant_code")
    @Expose
    private String plantCode;
    @SerializedName("plant_name")
    @Expose
    private String plantName;
    @SerializedName("active")
    @Expose
    private String active;
    public final static Creator<Plant_> CREATOR = new Creator<Plant_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Plant_ createFromParcel(Parcel in) {
            return new Plant_(in);
        }

        public Plant_[] newArray(int size) {
            return (new Plant_[size]);
        }

    }
    ;

    protected Plant_(Parcel in) {
        this.plantID = ((String) in.readValue((String.class.getClassLoader())));
        this.plantCode = ((String) in.readValue((String.class.getClassLoader())));
        this.plantName = ((String) in.readValue((String.class.getClassLoader())));
        this.active = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Plant_() {
    }

    public String getPlantID() {
        return plantID;
    }

    public void setPlantID(String plantID) {
        this.plantID = plantID;
    }

    public String getPlantCode() {
        return plantCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(plantID);
        dest.writeValue(plantCode);
        dest.writeValue(plantName);
        dest.writeValue(active);
    }

    public int describeContents() {
        return  0;
    }

}
