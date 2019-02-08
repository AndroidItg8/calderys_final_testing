package com.itg.calderysapp.common;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.itg.calderysapp.R;
import com.itg.calderysapp.caldConnect.pds.PDSDetailsFragment;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.update.UpdateDetailFragment;
import com.itg.calderysapp.caldConnect.update.model.Datum;

import java.io.File;


public class FileDownloadService extends Service implements CommonMethod.DownloadFileListner {

    private NotificationManager mNotifyManager;
    private NotificationCompat.Builder mBuilder;
    private static final String fromDownloadFailed = "fromDownloadFailed";
    private static final String fromDownloadSuccess = "fromDownloadSuccess";
    private Intent intent;
    private Object object;

    IBinder myBinder=new MyBinder();

    public CommonInterface.DownloadServiceBindListner bindListner;

    public FileDownloadService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.

        return myBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);

    }

    @Override
    public boolean onUnbind(Intent intent) {
        return true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent == null)
            return START_NOT_STICKY;

        object = intent.getParcelableExtra(CommonMethod.FILE_DOWNLOAD_SERVICE);




        return START_NOT_STICKY;
    }


    @Override
    public void onSuccessFile(Object obj) {
        if (obj instanceof Datum) {
            Datum models = (Datum) obj;
            Intent intent = new Intent(CommonMethod.FROM_SERVICE);
            intent.putExtra(CommonMethod.FILE_DOWNLOAD, models);
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        }else if (obj instanceof Data) {
            Data models = (Data) obj;
            Intent intent = new Intent(CommonMethod.FROM_SERVICE);
            intent.putExtra(CommonMethod.FILE_DOWNLOAD, models);
            LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
        }

        if(bindListner!=null){
            bindListner.onDownloadFinished();
        }
    }

    @Override
    public void onProgressShow() {

        if(bindListner!= null)
            bindListner.onDownloadStarted();



    }



    @Override
    public void onDownloadFiled(String message) {
        if(bindListner!= null)
            bindListner.onDownloadFailed(message);


    }

    @Override
    public void onProgressHide() {
if(bindListner!=null){
    bindListner.onDownloadFinished();
}




    }

    @Override
    public void startDownload() {
        if(bindListner!=null){
            bindListner.onDownloadStarted();
        }

//
    }

    @Override
    public void onProgressUpdate(Integer values) {
        if(bindListner!=null)
        {
            bindListner.onDownloadProgress(values);
        }

    }

    private void sendBrodcast(Datum datum) {
        datum.setProgress(true);
        Intent intent = new Intent(CommonMethod.FROM_SERVICE);
        intent.putExtra(CommonMethod.FILE_DOWNLOAD, datum);
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
    }

    private void showNotification() {
        mNotifyManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(getApplicationContext());
        mBuilder.setContentTitle("File Download")
                .setContentText("Download in progress")
                .setAutoCancel(true)
                .setOngoing(false)

                .setSmallIcon(R.mipmap.ic_launcher);
    }

    private void hideDownloadProgress(String message, String from) {
        if (object instanceof Datum) {
            Datum datum = (Datum) object;
            OpenPDFfile(datum.getFile());
        }else if(object instanceof Data){
            Data datum = (Data) object;
            OpenPDFfile(datum.getFile());
        }
        // Removes the progress bar
//        mBuilder.setProgress(0, 0, false);
//
//        if (from.equalsIgnoreCase(fromDownloadSuccess)) {
//            mBuilder.setContentText("Open PDF FILE");
//            //  OpenPDFfile(model.getPath());
//            OpenPDFfile("");
////              PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), )
//            mBuilder.setContentIntent(PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT));
//        } else {
//            mBuilder.setContentText(message);
//        }
//        // mNotifyManager.notify(model.getInvoiceNumber(), mBuilder.build());
//        mNotifyManager.notify(Integer.parseInt(model.getId()
//        ), mBuilder.build());
    }

    public void OpenPDFfile(String filePath) {
        intent = new Intent(Intent.ACTION_VIEW);
        String newFilePath = filePath.replaceAll("%20", " ");
        try {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
                intent.setDataAndType(Uri.parse(newFilePath), "*/*");
            } else {
                Uri uri = Uri.parse(newFilePath);
                File file = new File(uri.getPath());
                if (file.exists()) {
                    uri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".fileprovider", file);
                    intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setDataAndType(uri, "*/*");
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                }
            }
        } catch (Exception e) {
            Log.d(getApplicationContext().getClass().getName(), String.valueOf(e));
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
    }

    public void startDownloadingFile(Object data) {
        new DownloadPdfFile(data, this);
    }

    public class MyBinder extends Binder{
      public   FileDownloadService getService(){

            return FileDownloadService.this;
        }

     }


}
