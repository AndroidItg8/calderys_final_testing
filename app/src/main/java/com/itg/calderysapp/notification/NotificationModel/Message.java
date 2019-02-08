package com.itg.calderysapp.notification.NotificationModel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Message implements Parcelable {



	@SerializedName("to")
	private String to;

	@SerializedName("notification")
	private Notification notification;

	@SerializedName("data")
	private Data condition;

	public Data getCondition() {
		return condition;
	}

	public void setCondition(Data condition) {
		this.condition = condition;
	}



	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setNotification(Notification notification){
		this.notification = notification;
	}

	public void setData(Data condition){
		this.condition = condition;
	}

	public Message(Notification notification) {
		this.notification = notification;
	}

	@Override
 	public String toString(){
		return 
			"Message{" + 
			"notification = '" + notification + '\'' + 
			",condition = '" + condition + '\'' + 
			"}";
		}


	public Message() {
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.to);
		dest.writeParcelable(this.notification, flags);
		dest.writeParcelable(this.condition, flags);
	}

	protected Message(Parcel in) {
		this.to = in.readString();
		this.notification = in.readParcelable(Notification.class.getClassLoader());
		this.condition = in.readParcelable(Data.class.getClassLoader());
	}

	public static final Creator<Message> CREATOR = new Creator<Message>() {
		@Override
		public Message createFromParcel(Parcel source) {
			return new Message(source);
		}

		@Override
		public Message[] newArray(int size) {
			return new Message[size];
		}
	};
}