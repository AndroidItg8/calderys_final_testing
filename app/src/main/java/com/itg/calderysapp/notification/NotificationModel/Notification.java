package com.itg.calderysapp.notification.NotificationModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Notification implements Parcelable {

	@SerializedName("body")
	private String body;

	@SerializedName("title")
	private String title;


	protected Notification(Parcel in) {
		body = in.readString();
		title = in.readString();
	}

	public static final Creator<Notification> CREATOR = new Creator<Notification>() {
		@Override
		public Notification createFromParcel(Parcel in) {
			return new Notification(in);
		}

		@Override
		public Notification[] newArray(int size) {
			return new Notification[size];
		}
	};

	public void setBody(String body){
		this.body = body;
	}



	public void setTitle(String title){
		this.title = title;
	}

	@Override
 	public String toString(){
		return 
			"Notification{" + 
			"body = '" + body + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(body);
		dest.writeString(title);
	}
}