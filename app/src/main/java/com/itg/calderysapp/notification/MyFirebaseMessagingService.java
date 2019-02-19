package com.itg.calderysapp.notification;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.itg.calderysapp.R;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Indents;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.common.CommonMethod;
import com.itg.calderysapp.common.Prefs;
import com.itg.calderysapp.common.UserType;
import com.itg.calderysapp.home.HomeActivity;
import com.itg.calderysapp.notification.NotificationModel.Data;
import com.itg.calderysapp.notification.NotificationModel.Message;


/**
 * Created by itg_Android on 12/3/2016.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "MyFirebaseMsgService";
    private static final int NOTIFICATION_ID = 101;
    private static final String TITLE = "title";
    public static final String MY_CHANNEL_ID_01 = "my_channel_id_01";
    private String message = "";
    private NotificationManager mNotificationManager;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            Log.d(TAG, "From: " + remoteMessage.getFrom());
            Log.d(TAG, "onMessageReceived: " + new Gson().toJson(remoteMessage.getData()));
            Log.d(TAG, "Notification Message: " + remoteMessage.getData().get("title"));
            if(remoteMessage.getData().get("classtype")!=null) {
                if (Integer.parseInt(remoteMessage.getData().get("classtype")) == CommonMethod.CREATE_INDENT) {
                    Data message = new Data();
                    message.setTitle(remoteMessage.getData().get("title"));
                    message.setData(remoteMessage.getData().get("data"));
                    message.setMessage(remoteMessage.getData().get("message"));
                    message.setSalesContactPerson(remoteMessage.getData().get("salesContactPerson"));
                    message.setClasstype(Integer.parseInt(remoteMessage.getData().get("classtype")));
                    Message message1 = new Message();
                    message1.setData(message);
                     if(Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase( UserType.C.name()) && Prefs.getString(CommonMethod.USER_ID).equalsIgnoreCase(message.getSalesContactPerson()))
                            showStandardNotification(getApplicationContext(), message1);

                } else if((Integer.parseInt(remoteMessage.getData().get("classtype")) == CommonMethod.UPDATE_ITEM) ||Integer.parseInt(remoteMessage.getData().get("classtype")) == CommonMethod.PDS_ITEM) {
                    Data message = new Data();
                    message.setTitle(remoteMessage.getData().get("title"));
                    message.setData(remoteMessage.getData().get("data"));
                    message.setMessage(remoteMessage.getData().get("message"));
                    message.setClasstype(Integer.parseInt(remoteMessage.getData().get("classtype")));
                    Message message1 = new Message();
                    message1.setData(message);
                    showStandardNotification(getApplicationContext(), message1);
                }
                 else if(Integer.parseInt(remoteMessage.getData().get("classtype")) == CommonMethod.INDENT_STATUS)
                {
                    Data message = new Data();
                    message.setTitle(remoteMessage.getData().get("title"));
                    message.setData(remoteMessage.getData().get("data"));
                    message.setMessage(remoteMessage.getData().get("message"));
                    message.setClasstype(Integer.parseInt(remoteMessage.getData().get("classtype")));
                    Message message1 = new Message();
                    message1.setData(message);
                    IndentModel model =new Gson().fromJson(message.getData() ,IndentModel.class);
                     if((Prefs.getString(CommonMethod.USER_TYPE).equalsIgnoreCase( UserType.D.name()))
                             && model.getDealerCode().equalsIgnoreCase(Prefs.getString(CommonMethod.USER_ID))){

                         showStandardNotification(getApplicationContext(), message1);
                     }
                }
                 else if(Integer.parseInt(remoteMessage.getData().get("classtype")) == CommonMethod.GALLERY_ITEM)
                {
                    Data message = new Data();
                    message.setTitle(remoteMessage.getData().get("title"));
                    message.setData(remoteMessage.getData().get("data"));
                    message.setMessage(remoteMessage.getData().get("message"));
                    message.setClasstype(Integer.parseInt(remoteMessage.getData().get("classtype")));
                    Message message1 = new Message();
                    message1.setData(message);
                    showStandardNotification(getApplicationContext(), message1);
                }

            }
        }
    }


    public void showStandardNotification(Context context, Message message1) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra(CommonMethod.FROM_NOTIFICATION, message1);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        showNotiication(context, message1);
    }




  public   void showNotiication(Context mContext, Message message) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(mContext.getApplicationContext(), "notify_001");
        Intent ii = new Intent(mContext.getApplicationContext(), HomeActivity.class);
//        ii.putExtra(CommonMethod.FROM_NOTIFICATION, message);

        PendingIntent pendingIntent = PendingIntent.getActivity(mContext, 0, ii, 0);

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.setBigContentTitle(message.getCondition().getTitle());
        bigText.setSummaryText(message.getCondition().getMessage());

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        mBuilder.setContentTitle(message.getCondition().getTitle());
        mBuilder.setContentText(message.getCondition().getMessage());
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mBuilder.setStyle(bigText);
        mBuilder.setAutoCancel(true);

        mNotificationManager =
                (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("notify_001",
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            mNotificationManager.createNotificationChannel(channel);
        }

        mNotificationManager.notify(0, mBuilder.build());
    }

    private void showNotiication(Context mContext, Message message, PendingIntent pendingIntent) {

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(mContext.getApplicationContext(), MY_CHANNEL_ID_01);
        Intent ii = new Intent(mContext.getApplicationContext(), HomeActivity.class);

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.setBigContentTitle(message.getCondition().getTitle());
        bigText.setSummaryText(message.getCondition().getMessage());

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        mBuilder.setContentTitle(message.getCondition().getTitle());
        mBuilder.setContentText(message.getCondition().getMessage());
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mBuilder.setStyle(bigText);

        mNotificationManager =
                (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(MY_CHANNEL_ID_01,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            mNotificationManager.createNotificationChannel(channel);
        }

        mNotificationManager.notify(0, mBuilder.build());
    }

    private void showNotification(Context context, Notification notification, int id, Message message1) {


        mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(MY_CHANNEL_ID_01,
                    "Channel human readable title",
                    NotificationManager.IMPORTANCE_DEFAULT);
            mNotificationManager.createNotificationChannel(channel);
        }

        mNotificationManager.notify(id, notification);
    }

    public NotificationCompat.Builder createNotificationBuider(Context context,
                                                               Message message, PendingIntent pendingIntent) {
        Bitmap largeIcon = BitmapFactory.decodeResource(context.getResources(),
                R.mipmap.ic_launcher);
//        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.O) {
//            return new NotificationCompat.Builder(context)
//                    .setSmallIcon(R.mipmap.ic_launcher)
//                    .setContentTitle(message.getCondition().getTitle())
//                    .setContentText(message.getCondition().getMessage())
//                    .setLargeIcon(largeIcon)
//                    .setContentIntent(pendingIntent)
//                    .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
////                    .setStyle(new NotificationCompat
////                    .BigTextStyle()
////                    .setSummaryText(message.getCondition().getTitle())
////                    .setBigContentTitle(message.getCondition().getTitle())
////                    .bigText(message.getCondition().getMessage()))
//                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
//                    .setAutoCancel(true);
//        }else {
//            return new NotificationCompat.Builder(context, MY_CHANNEL_ID_01)
//                    .setSmallIcon(R.mipmap.ic_launcher)
//                    .setContentTitle(message.getCondition().getTitle())
//                    .setContentText(message.getCondition().getMessage())
//                    .setLargeIcon(largeIcon)
//                    .setContentIntent(pendingIntent)
//                    .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
////                    .setStyle(new NotificationCompat
////                            .BigTextStyle()
////                            .setSummaryText(message.getCondition().getTitle())
////                            .setBigContentTitle(message.getCondition().getTitle())
////                            .bigText(message.getCondition().getMessage()))
//                    .setPriority(NotificationCompat.PRIORITY_MAX)
//
//                    .setAutoCancel(true);
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context.getApplicationContext(), MY_CHANNEL_ID_01);
        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.setBigContentTitle(message.getCondition().getTitle());
        bigText.setSummaryText(message.getCondition().getMessage());

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.drawable.ic_add_black_24dp);
        mBuilder.setContentTitle(message.getCondition().getTitle());
        mBuilder.setContentText(message.getCondition().getMessage());
        mBuilder.setPriority(Notification.PRIORITY_MAX);
        mBuilder.setStyle(bigText);
        return mBuilder;


//        }
    }
    private void sendNotification(Message body, String title) {
//

//
//        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//        final Notification.Builder notificationBuilder = new Notification.Builder(this);
//        final int id = 0;
//        Bitmap placeHolder = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
//        notificationBuilder
//                .setSmallIcon(R.mipmap.ic_launcher)
//                .setContentTitle(title)
//                .setContentText("ss")
//                .setAutoCancel(true)
//                .setSound(defaultSoundUri)
//                .setContentIntent(pendingIntent)
//                .setStyle(new Notification.BigPictureStyle());


        //       createNotificationBuider(context,
//                message1, pendingIntent);
//        showNotification(context, notification.build(), 0, message1);
//        showNotiication(context, message1, pendingIntent);

    }


}
