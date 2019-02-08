
package com.itg.calderysapp.caldNet.newIndent.intent.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ViewDraftEditModel implements Parcelable
{

    @SerializedName("Indents")
    @Expose
    private List<IndentsModel> indents;

    public ViewDraftEditModel() {
    }

    public List<IndentsModel> getIndents() {
        return indents;
    }

    public void setIndents(List<IndentsModel> indents) {
        this.indents = indents;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.indents);
    }

    protected ViewDraftEditModel(Parcel in) {
        this.indents = in.createTypedArrayList(IndentsModel.CREATOR);
    }

    public static final Creator<ViewDraftEditModel> CREATOR = new Creator<ViewDraftEditModel>() {
        @Override
        public ViewDraftEditModel createFromParcel(Parcel source) {
            return new ViewDraftEditModel(source);
        }

        @Override
        public ViewDraftEditModel[] newArray(int size) {
            return new ViewDraftEditModel[size];
        }
    };
}
