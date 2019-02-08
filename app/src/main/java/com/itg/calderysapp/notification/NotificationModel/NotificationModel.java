package com.itg.calderysapp.notification.NotificationModel;

import com.google.gson.annotations.SerializedName;

public class NotificationModel{


	@SerializedName("notification")
	private Message message;

	public void setMessage(Message message){
		this.message = message;
	}

	public NotificationModel(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	@Override
 	public String toString(){
		return 
			"NotificationModel{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}