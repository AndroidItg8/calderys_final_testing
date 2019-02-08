
package com.itg.calderysapp.caldNet.newIndent.Deetails.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product implements Parcelable
{

    @SerializedName("product")
    @Expose
    private List<Product_> product = null;

    public Product() {
    }



    public List<Product_> getProduct() {
        return product;
    }

    public void setProduct(List<Product_> product) {
        this.product = product;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable((Parcelable) this.product, flags);
    }

    protected Product(Parcel in) {
        this.product = in.readParcelable(Object.class.getClassLoader());
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
