
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductMaster_ implements Parcelable
{

    @SerializedName("ProductName")
    @Expose
    private String productName;
    public final static Creator<ProductMaster_> CREATOR = new Creator<ProductMaster_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProductMaster_ createFromParcel(Parcel in) {
            return new ProductMaster_(in);
        }

        public ProductMaster_[] newArray(int size) {
            return (new ProductMaster_[size]);
        }

    }
    ;

    protected ProductMaster_(Parcel in) {
        this.productName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ProductMaster_() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(productName);
    }

    public int describeContents() {
        return  0;
    }

}
