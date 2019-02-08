package com.itg.calderysapp.common;


import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.update.model.Datum;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Android itg 8 on 10/17/2017.
 */

public class DownloadPdfFile {

    CommonMethod.DownloadFileListner listner;

    private static final String TAG = "Download Task";

    private String downloadUrl = "";
    private String downloadFileName = "";
    private Datum model=null;
    private  Data modelPds=null;
    String  fileName=null ;
    String  folderName=null ;




    public DownloadPdfFile(Object object, CommonMethod.DownloadFileListner listner) {
        if(object instanceof  Datum){
            model = (Datum) object;
            this.fileName = model.getFile();
            this.folderName = CommonMethod.UPDATE_FILE_FOLDER;

        }else if(object instanceof Data) {
            modelPds = (Data) object;
            this.fileName = modelPds.getFile();
            this.folderName = CommonMethod.PDS_FILE_FOLDER;
            //     "https://www.calderysdistributors.com/announcement_files/fileName";
        }
        this.downloadUrl = CommonMethod.URL_CALDE_CONNECT_MAIN +"files/"+folderName+"/"+fileName.replaceAll(" ", "%20");
//          this.downloadUrl = CommonMethod.URL_CALDE_CONNECT_MAIN + "/files/"+folderName+"/"+fileName.replaceAll(" ", "%20");// for testing local
//        downloadFileName = downloadUrl.substring(downloadUrl.lastIndexOf('/'), downloadUrl.length());//Create file name by picking download file name from URL
        downloadFileName = fileName;//Create file name by picking download file name from URL

        this.listner = listner;
        Log.e(TAG, downloadFileName);
        //Start Downloading Task
        new DownloadingTask().execute();
    }

    private class DownloadingTask extends AsyncTask<Void, Integer, String> {

        File apkStorage = null;
        File outputFile = null;

        @Override
        protected void onPreExecute() {
             listner.startDownload();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String result) {
//            try {
//                if (outputFile != null) {
//
//                 //   Toast.makeText(context, "Downloaded Successfully", Toast.LENGTH_SHORT).show();
//
//                  // model.setPath(outputFile.getAbsolutePath());
//                    setListener();
//                    listner.onProgressHide();
//
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//
//                listner.onProgressHide();
//                listner.onDownloadFiled(e.getMessage());
//                Log.e(TAG, "Download Failed with Exception - " + e.getLocalizedMessage());
//
//            }
            listner.onSuccessFile(result);


        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            listner.onProgressUpdate(values[0]);
        }

        @Override
        protected String doInBackground(Void... arg0) {
            try {
                URL url = new URL(downloadUrl);//Create Download URl
                HttpURLConnection c = (HttpURLConnection) url.openConnection();//Open Url Connection
                c.setRequestMethod("POST");//Set Request Method to "GET" since we are grtting data

                c.connect();//connect the URL Connection


                //If Connection response is not OK then show Logs
                if (c.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    Log.e(TAG, "Server returned HTTP " + c.getResponseCode()
                            + " " + c.getResponseMessage());

                }

                listner.onProgressShow();



                //Get File if SD card is present
//                if (CommonMethod.isSDCardPresent()) {

                    apkStorage = new File(
                            Environment.getExternalStorageDirectory() + "/"
                                    +"Caldreys App");
//                }
                //If File is not present create directory
                if (!apkStorage.exists()) {
                    apkStorage.mkdir();
                    Log.e(TAG, "Directory Created.");
                }

                outputFile = new File(apkStorage, downloadFileName);//Create Output file in Main File

                //Create New File if not present
//                if (!outputFile.exists()) {
//                    outputFile.createNewFile();
//                    Log.e(TAG, "File Created");
//                }


                FileOutputStream fos = new FileOutputStream(outputFile);//Get OutputStream for NewFile Location


                InputStream is = null;//Get InputStream for connection
                try {
                    is = c.getInputStream();
                    byte[] buffer = new byte[1024];//Set buffer type
                    int len1 = 0;//init length
                    int total = 0;
                    while ((len1 = is.read(buffer)) != -1) {
                        int lenght =  c.getContentLength();
                        total += len1;
                        // publishing the progress
//                    publishProgress((int)((total*100)/lenght));
                        Log.d(TAG,"lenght:"+lenght+" "+ "total "+total);
                        onProgressUpdate((int)((total*100)/lenght));
                        fos.write(buffer, 0, len1);//Write new file
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    listner.onDownloadFiled(e.getMessage());
                    return "failed";
                }

                //Close all connection after doing task
                fos.close();
                is.close();

                return "Success";

            } catch (Exception e) {

                //Read exception if something went wrong
                e.printStackTrace();

                outputFile = null;
                Log.e(TAG, "Download Error Exception " + e.getMessage());
                listner.onDownloadFiled(e.getMessage());
                return e.getMessage();
            }
        }


    }



    private void setListener() {
        if(model !=null) {
            model.setProgress(false);
            model.setDownload(true);
            listner.onSuccessFile(model);
        }else{
            modelPds.setProgress(false);
            modelPds.setDownload(true);
            listner.onSuccessFile(modelPds);
        }
    }


}

