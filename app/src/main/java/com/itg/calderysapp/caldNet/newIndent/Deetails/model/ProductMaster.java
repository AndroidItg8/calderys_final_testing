
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductMaster implements Parcelable
{

    @SerializedName("productMaster")
    @Expose
    private Object productMaster;
    public final static Creator<ProductMaster> CREATOR = new Creator<ProductMaster>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProductMaster createFromParcel(Parcel in) {
            return new ProductMaster(in);
        }

        public ProductMaster[] newArray(int size) {
            return (new ProductMaster[size]);
        }

    }
    ;

    protected ProductMaster(Parcel in) {
        this.productMaster = ((ProductMaster_) in.readValue((ProductMaster_.class.getClassLoader())));
    }

    public ProductMaster() {
    }

    public Object getProductMaster() {
        return productMaster;
    }

    public void setProductMaster(ProductMaster_ productMaster) {
        this.productMaster = productMaster;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(productMaster);
    }

    public int describeContents() {
        return  0;
    }

}
