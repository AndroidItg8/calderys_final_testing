package com.itg.calderysapp.common;


import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.pds.model.FamilyGroupData;
import com.itg.calderysapp.caldConnect.pds.model.PDSModel;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.IndentController;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.Indents;
import com.itg.calderysapp.caldNet.newIndent.Deetails.model.IntentDetailModel;
import com.itg.calderysapp.caldNet.newIndent.Deetails.sa_model.SAPModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.MaterialModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.SaveMaterialModel;
import com.itg.calderysapp.caldNet.newIndent.addmaterial.model.TransportModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeListModel;
import com.itg.calderysapp.caldNet.newIndent.consignee.model.ConsigneeModel;
import com.itg.calderysapp.caldNet.newIndent.createIntent.model.SpinnerGenericModel;
import com.itg.calderysapp.caldNet.newIndent.home.AdapterStringModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.MessageModel;
import com.itg.calderysapp.caldNet.newIndent.home.model.StroiesModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DealerModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.DispachedModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.IndentsModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.PaginationModel;
import com.itg.calderysapp.caldNet.newIndent.intent.model.ViewDraftModel;
import com.itg.calderysapp.db.DatabaseCallback;
import com.itg.calderysapp.db.FamilyGroupRepository;
import com.itg.calderysapp.db.model.ProductTypeViewModel;
import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;
import com.itg.calderysapp.home.model.GalleryData;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.BufferedSink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkUtility {

    private static final String TAG = "NetworkUtility";
    private static final String STATUS = "status";
    private static final String DATABASE_NAME = "CalderysAppDatabase";
    private static RetroController controller;
    ProductTypeViewModel viewModel;
    List<com.itg.calderysapp.caldConnect.pds.model.Datum> datumList = null;
    private FamilyGroupRepository mTypeRepository;
    private Disposable disposable;

    public NetworkUtility(NetworkBuilder builder) {
        controller = Retro.getInstance().getController(builder.token);
    }

    public void login(String email, String password, final ResponseListener responseListener) {
        Call<ResponseBody> call = controller.login(email, password);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 400) {
                    responseListener.onFailure("Invalid Credential");
                    return;
                }
                if (response.body() == null) {
                    responseListener.onFailure("Failed to login");
                }
                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        String res = null;
                        try {
                            res = response.body().string();
                            JSONObject object = new JSONObject(res);
                            if (object.has("status")) {
                                if (object.getString("status").equalsIgnoreCase("1")) {
                                    Prefs.putString(CommonMethod.IS_LOGGIN, object.getString("status"));
                                    if (object.has("accesses_level")) {
                                        Prefs.putString(CommonMethod.USER_TYPE, object.getString("accesses_level"));
                                    }
                                    responseListener.onSuccess(object.getString("msg"));
                                } else {
                                    responseListener.onFailure(object.getString("msg"));
                                }

                            } else {
                                responseListener.onFailure(object.getString("msg"));
                            }
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });

    }

    public void addUpdateData(String tile, String description, String date, String filePath, String id, ResponseListener responseListener) {

        Call<ResponseBody> call;
        if (id == null)
            call = controller.sendAddForm(tile, description, date, filePath, date, Prefs.getString(CommonMethod.USER_TYPE));
        else
            call = controller.editUpdateData(tile, description, date, filePath, date, Prefs.getString(CommonMethod.USER_TYPE), id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                if (response.code() == 400) {
                    responseListener.onFailure(response.message());
                    return;
                }
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        String res = null;
                        try {
                            res = response.body().string();
                            JSONObject object = new JSONObject(res);
                            if (object.has("status")) {
                                if (object.getString("status").equalsIgnoreCase("1")) {
                                    if (object.has("msg")) {

                                        if (object.has("data")) {
                                            Datum datum = new Gson().fromJson(object.getJSONObject("data").toString(), Datum.class);
                                            responseListener.onSuccess(datum);
                                        } else {
                                            responseListener.onSuccess(object.getString("msg"));
                                        }
                                    }

                                } else {
                                    responseListener.onFailure(object.getString("msg"));
                                }

                            } else {
                                responseListener.onFailure(object.getString("msg"));
                            }
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });

    }

    public void uploadFile(File absoluteFile, final ResponseListener responseListener) {
        RequestBody requestFolder =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), "announcement_files");

        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/*"), absoluteFile);
        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part fileMultiPart = MultipartBody.Part.createFormData("file_upload", absoluteFile.getName(), requestFile);

        Call<ResponseBody> call = controller.uploadFile(fileMultiPart, requestFolder);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 400) {
                    responseListener.onFailure(response.message());
                    return;
                }
                if (response.isSuccessful()) {
                    if (response.body() != null) {


                        String res = null;
                        try {
                            res = response.body().string();
                            JSONObject object = new JSONObject(res);
                            if (object.has("status")) {

                                if (object.getString("status").equalsIgnoreCase("1")) {
                                    if (object.has("filepath")) {
                                        Log.d(TAG, "onResponse: filePath" + object.getString("filepath"));
                                        responseListener.onSuccess(object.getString("filepath"));
                                    }

                                } else {
                                    responseListener.onFailure(object.getString("msg"));
                                }

                            } else {
                                responseListener.onFailure(object.getString("msg"));
                            }
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });


    }

    public Disposable getUpdateList(String tableName, int perPage, int pageNumber, ResponseListener responseListener) {
        io.reactivex.Observable<ResponseBody> controllerUpdateList = controller.getUpdateList(tableName, perPage, pageNumber);

      disposable=  controllerUpdateList.flatMap(new Function<ResponseBody, ObservableSource<List<Datum>>>() {
            private List<Datum> datumList;

            @Override
            public ObservableSource<List<Datum>> apply(ResponseBody responseBody) throws Exception {
                if (responseBody != null) {
                    String s = responseBody.string();
                    JSONObject object = new JSONObject(s);
                    if (object.has("Status") && object.has("Errorcode")) {
                        if (object.getString("Errorcode").equalsIgnoreCase("200")
                                && object.getString("Status").equalsIgnoreCase("1")) {
                            if (object.has("data")) {
                                String jsonString = new Gson().toJson(object.getString("data"));
                                Object json = new JSONTokener(jsonString).nextValue();

                                datumList = new Gson().fromJson(json.toString(), new TypeToken<List<Datum>>() {
                                }.getType());
                            }

                        }
                    }
                }


                return io.reactivex.Observable.just(datumList);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Datum>>() {
                    @Override
                    public void accept(List<Datum> data) throws Exception {
                        responseListener.onSuccess(data);

                    }
                },e -> {  e.printStackTrace();
                    responseListener.onFailure(e.getMessage());
                });



        return  disposable;
    }

    public void uploadRxFile(File absoluteFile, final ResponseListener responseListener) {
        RequestBody requestFolder =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), "announcement_files");

        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/*"), absoluteFile);
        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part fileMultiPart = MultipartBody.Part.createFormData("file_upload", absoluteFile.getName(), requestFile);

        io.reactivex.Observable<ResponseBody> call = controller.uploadRxFile(fileMultiPart, requestFolder);
        call.flatMap(new Function<ResponseBody, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(ResponseBody responseBody) throws Exception {
                return null;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void downloadProductType(NetworkUtility.ResponseListener listener) {

//
//        Observable.zip(getProductType( listener).subscribeOn(Schedulers.newThread()), getFamilyGroup(listener).subscribeOn(Schedulers.newThread()), new BiFunction<List<TblProductType>, List<TblFamilyGroup>, CompleteResultModel>() {
//            @Override
//            public CompleteResultModel apply(List<TblProductType> tblProductTypes, List<TblFamilyGroup> tblFamilyGroups) throws Exception {
//
//                return new CompleteResultModel(tblProductTypes, tblFamilyGroups);
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<CompleteResultModel>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(CompleteResultModel s) {
//                        listener.onSuccess(s);
//
//                    }
//
//
//                    @Override
//                    public void onError(Throwable e) {
//                        e.printStackTrace();
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


    }

    public Disposable getProductType(ResponseListener listener) {
        viewModel = new ProductTypeViewModel(MyApplication.getInstance());

        Observable<ResponseBody> observable = controller.getPDSProductList(CommonMethod.PRODUCT_TYPE);
        List<TblProductType> tblProductTypeList = new ArrayList<>();
       disposable=   observable.flatMap(new Function<ResponseBody, Observable<List<TblProductType>>>() {
            @Override
            public Observable<List<TblProductType>> apply(ResponseBody responseBody) throws Exception {

                if (responseBody != null) {
                    String s = responseBody.string();
                    JSONObject object = new JSONObject(s);
                    if (object.has("Status") && object.has("Errorcode")) {
                        if (object.getString("Errorcode").equalsIgnoreCase("200")
                                && object.getString("Status").equalsIgnoreCase("1")) {
                            if (object.has("data")) {
                                String jsonString = new Gson().toJson(object.getString("data"));
                                Object json = new JSONTokener(jsonString).nextValue();

                                datumList = new Gson().fromJson(json.toString(), new TypeToken<List<com.itg.calderysapp.caldConnect.pds.model.Datum>>() {
                                }.getType());
                            }


                            if (datumList != null) {
                                for (com.itg.calderysapp.caldConnect.pds.model.Datum datum : datumList) {
                                    tblProductTypeList.add(datum.copyData());

                                }

                                viewModel.deleteAll(new DatabaseListener() {
                                    @Override
                                    public void onProductTypeAdded() {

                                    }

                                    @Override
                                    public void onProductDeleted() {


                                        viewModel.insertAll(tblProductTypeList, new DatabaseListener() {
                                            @Override
                                            public void onProductTypeAdded() {
                                                Log.d(TAG, "onProductTypeAdded:  AddProductList");

                                            }

                                            @Override
                                            public void onProductDeleted() {

                                            }
                                        });
                                    }
                                });


                            }

                        }
                    }


                }

                return Observable.just(tblProductTypeList);
            }



        }).subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Consumer  <List<TblProductType>>() {
                   @Override
                   public void accept(  List<TblProductType> data) throws Exception {
                       listener.onSuccess(data);

                   }
               },e->{  e.printStackTrace();
//                   responseListener.onFailure(e.getMessage());
                   listener.onFailure(e.getMessage());
                   e.printStackTrace();
               });


//               .onErrorReturn(new Function<Throwable, List<TblProductType>>() {
//            @Override
//            public List<TblProductType> apply(Throwable throwable) throws Exception {
//
//                return null;
//            }
//        });

        return disposable;

    }

    public void  getFamilyGroup(ResponseListener listener) {

        mTypeRepository = new FamilyGroupRepository(MyApplication.getInstance());
        List<TblFamilyGroup> tblFamilyGroups = new ArrayList<>();
        io.reactivex.Observable<ResponseBody> responseBodyObservable = controller.getPDSFamilyList(CommonMethod.FAMILY_TYPE);

        disposable=  responseBodyObservable.flatMap(new Function<ResponseBody, Observable<List<TblFamilyGroup>>>() {
            String objectData = null;
            List<FamilyGroupData> listFamilyGroupe =null;



            @Override
            public Observable<List<TblFamilyGroup>> apply(ResponseBody responseBody) throws Exception {

                if (responseBody != null) {
                    String response = responseBody.string();
                    JSONObject jsonObject = new JSONObject(response);
                    if (jsonObject.has("Status") && jsonObject.has("Errorcode")) {

                        if (jsonObject.getString("Status").equalsIgnoreCase("1") &&
                                jsonObject.getString("Errorcode").equalsIgnoreCase("200")) {

                            if (jsonObject.has("data")) {
                                objectData = jsonObject.getString("data");
                                String jsonString = new Gson().toJson(objectData);
                                Object json = new JSONTokener(jsonString).nextValue();

                                 listFamilyGroupe = new Gson().fromJson(json.toString(), new TypeToken<List<FamilyGroupData>>() {

                                }.getType());

                                if (listFamilyGroupe != null) {

                                    for (FamilyGroupData data : listFamilyGroupe
                                            ) {
                                        tblFamilyGroups.add(data.copyData());

                                        mTypeRepository.addFamilyGroup(data.copyData(), new DatabaseCallback() {
                                            @Override
                                            public void onProductTypeAdded() {
                                                Log.d(TAG, "onProductTypeAdded: ");
                                            }

                                            @Override
                                            public void onDataNotAvailable(Throwable e) {
                                                e.printStackTrace();
                                            }

                                            @Override
                                            public void onProductDeleted() {
                                                Log.d(TAG, "onProductDeleted: ");

                                            }

                                            @Override
                                            public void onUpdateProductType() {
                                                Log.d(TAG, "onUpdateProductType: ");

                                            }
                                        });


                                    }
                                }
                            }
                        }
                    }
                }
                return Observable.just(tblFamilyGroups);


            }


        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer  <List<TblFamilyGroup>>() {
                    @Override
                    public void accept(  List<TblFamilyGroup> data) throws Exception {
                        listener.onSuccess(data);
//                        listener.onSuccess(tblFamilyGroups);


                    }
                },e->{  e.printStackTrace();
//                   responseListener.onFailure(e.getMessage());
                    listener.onFailure(e.getMessage());
                    e.printStackTrace();
                });


    }

    public void uploadFileProgress(File absoluteFile, String from, ResponseListener responseListener, ProgressListner listner) {
        String folderName = null;
        try {
            ProgressResponseBody progressResponseBody = new ProgressResponseBody(absoluteFile, new ProgressResponseBody.UploadCallbacks() {
                @Override
                public void onProgressUpdate(int percentage) {
                    listner.onProgressUpdate(percentage);
                }

                @Override
                public void onError() {
                    listner.onFailded();
                }

                @Override
                public void onFinish() {
                    listner.onFinished();
                }
            });
            if (from.equalsIgnoreCase(CommonMethod.UPDATE)) {
                folderName = CommonMethod.UPDATE_FILE_FOLDER;
            } else {
                folderName = CommonMethod.PDS_FILE_FOLDER;
            }
            RequestBody requestFolder =
                    RequestBody.create(
                            MediaType.parse("multipart/form-data"), folderName);

            RequestBody requestFile =
                    RequestBody.create(MediaType.parse("multipart/*"), absoluteFile);
            // MultipartBody.Part is used to send also the actual file name
            MultipartBody.Part fileMultiPart = MultipartBody.Part.createFormData("file_upload", absoluteFile.getName(), progressResponseBody);
            Call<ResponseBody> call = controllerForFIleUpload().uploadFile(fileMultiPart, requestFolder);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.code() == 400) {
                        responseListener.onFailure(response.message());
                        return;
                    }
                    if (response.isSuccessful()) {
                        if (response.body() != null) {


                            String res = null;
                            try {
                                res = response.body().string();

                                Log.d(TAG, "onResponse: " + res);
                                JSONObject object = new JSONObject(res);
                                if (object.has("status")) {

                                    if (object.getString("status").equalsIgnoreCase("1")) {
                                        if (object.has("filepath")) {
//                                        if (object.has("filePath")) { // for local file upload
                                            responseListener.onSuccess(object.getString("filepath"));
//                                            responseListener.onSuccess(object.getString("filepath"));// for local
                                        }

                                    } else {
                                        responseListener.onFailure(object.getString("msg"));
                                    }

                                } else {
                                    responseListener.onFailure(object.getString("msg"));
                                }
                            } catch (IOException | JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    t.printStackTrace();
                    responseListener.onFailure(t.getMessage());

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private RetroController controllerForFIleUpload() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.MINUTES);
        if (MyApplication.getInstance().isLoggingNeeded)
            builder.addInterceptor(interceptor);
        builder.readTimeout(5, TimeUnit.MINUTES);
//        if(header!=null)
//            builder.addInterceptor(getHeader(header));

        OkHttpClient client = builder.build();
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit;
        Log.d(TAG, "getController: " + AppType.getUrl());
        retrofit = new Retrofit.Builder()
                .baseUrl(AppType.getUrl())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();


        return retrofit.create(RetroController.class);


    }

    public void addPDS(String productName, String productType, String familyGroup, String fileName, String date, String share, String id, ResponseListener responseListener) {
        //    product_name:AC 3030
////    family_group:AC bricks
////    product_type:Dense bricks
////    file:PDS AC 30 Word.pdf
////    uploaded_date:28/10/2018
////    share:Public
////    insertBy:admin
////    created:2018-10-28 15:09:48

        Call<ResponseBody> call;
        if (id == null)
            call = controller.addPDS(productName, familyGroup, productType, fileName, date, share, Prefs.getString(CommonMethod.USER_TYPE), date);
        else
            call = controller.editPDS(productName, familyGroup, productType, fileName, date, share, Prefs.getString(CommonMethod.USER_TYPE), date, id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                if (response.code() == 400) {
                    responseListener.onFailure(response.message());
                    return;
                }
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        String res = null;
                        try {
                            res = response.body().string();
                            Log.d(TAG, "onResponse: "+res);
                            JSONObject object = new JSONObject(res);
                            if (object.has("status")) {
                                if (object.getString("status").equalsIgnoreCase("1")) {
                                    if (object.has("msg")) {


                                        responseListener.onSuccess(object.getString("msg"));

                                    }

                                } else {
                                    responseListener.onFailure(object.getString("msg"));
                                }

                            } else {
                                responseListener.onFailure(object.getString("msg"));
                            }
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });

    }

    public void getPDSList(String tableName, int perPage, int pageNumber, ResponseListener responseListener) {

        io.reactivex.Observable<ResponseBody> controllerUpdateList = controller.getUpdateList(tableName, perPage, pageNumber);
      disposable =  controllerUpdateList.flatMap(new Function<ResponseBody, ObservableSource<List<Data>>>() {
            private List<Data> dataLists = new ArrayList<>();

            @Override
            public ObservableSource<List<Data>> apply(ResponseBody responseBody) throws Exception {
                if (responseBody != null) {
                    String s = responseBody.string();
                    JSONObject object = new JSONObject(s);
                    if (object.has("Status") && object.has("Errorcode")) {
                        if (object.getString("Errorcode").equalsIgnoreCase("200")
                                && object.getString("Status").equalsIgnoreCase("1")) {
                            PDSModel busModel = new Gson().fromJson(s, PDSModel.class);
                            String jsonString = new Gson().toJson(busModel.getData());
                            Object json = new JSONTokener(jsonString).nextValue();
                            if (json instanceof JSONObject) {
                                Data data = new Gson().fromJson(json.toString(), Data.class);
                                dataLists.add(data);

                            } else if (json instanceof JSONArray) {

                                List<Data> dataList = new Gson().fromJson(json.toString(), new TypeToken<List<Data>>() {
                                }.getType());
                                dataLists.addAll(dataList);

                            }


                        }
                    }
                }


                return io.reactivex.Observable.just(dataLists);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Data>>() {
                    @Override
                    public void accept(List<Data> data) throws Exception {
                        responseListener.onSuccess(data);

                    }
                },e->{  e.printStackTrace();
                    responseListener.onFailure(e.getMessage());
                });



    }

    public void DeleteData(String tbleName, String id, ResponseListener responseListener) {

        Call<ResponseBody> call = controller.deleteUpdateData(tbleName, id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.code() == 400) {
                    responseListener.onFailure(response.message());
                    return;
                }
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        String res = null;
                        try {
                            res = response.body().string();
                            JSONObject object = new JSONObject(res);
                            if (object.has("status")) {
                                if (object.getString("status").equalsIgnoreCase("1")) {
                                    if (object.has("msg")) {
                                        responseListener.onSuccess(object.getString("msg"));
                                    }

                                } else {
                                    responseListener.onFailure(object.getString("msg"));
                                }

                            } else {
                                responseListener.onFailure(object.getString("msg"));
                            }
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });
    }

    public Disposable DownloadGallery(String tbleName, ResponseListener responseListener) {

        io.reactivex.Observable<ResponseBody> controllerUpdateList = controller.getGallery(tbleName, 10, 1);

         disposable = controllerUpdateList.flatMap(new Function<ResponseBody, Observable<List<GalleryData>>>() {
            private List<GalleryData> galleryDataList;

            @Override
            public Observable<List<GalleryData>> apply(ResponseBody responseBody) throws Exception {
                if (responseBody != null) {
                    String s = responseBody.string();
                    Log.d(TAG, "apply: s"+s);
                    JSONObject object = new JSONObject(s);
                    if (object.has("Status") && object.has("Errorcode")) {
                        if (object.getString("Errorcode").equalsIgnoreCase("200")
                                && object.getString("Status").equalsIgnoreCase("1")) {
                            if (object.has("data")) {
                                String jsonString = new Gson().toJson(object.getString("data"));
                                Object json = new JSONTokener(jsonString).nextValue();

                                galleryDataList = new Gson().fromJson(json.toString(), new TypeToken<List<GalleryData>>() {
                                }.getType());
                            }

                        }
                    }
                }


                return Observable.just(galleryDataList);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<GalleryData>>() {
                    @Override
                    public void accept(List<GalleryData> data) throws Exception {
                        responseListener.onSuccess(data);
                    }
                },e-> { e.printStackTrace();
                    responseListener.onFailure(e.getMessage());});

return disposable;

    }

    public void uploadFileImageProgress(File absoluteFile, String filderImages, ResponseListener responseListener, ProgressListner progressListner) {


        ProgressResponseBody progressResponseBody = new ProgressResponseBody(absoluteFile, new ProgressResponseBody.UploadCallbacks() {
            @Override
            public void onProgressUpdate(int percentage) {
                progressListner.onProgressUpdate(percentage);
            }

            @Override
            public void onError() {
                progressListner.onFailded();
            }

            @Override
            public void onFinish() {
                progressListner.onFinished();
            }
        });

        RequestBody requestFolder =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), filderImages);

        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/*"), absoluteFile);
        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part fileMultiPart = MultipartBody.Part.createFormData("file_upload", absoluteFile.getName(), progressResponseBody);
        Call<ResponseBody> call = controllerForFIleUpload().uploadFile(fileMultiPart, requestFolder);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 400) {
                    responseListener.onFailure(response.message());
                    return;
                }
                if (response.isSuccessful()) {
                    if (response.body() != null) {


                        String res = null;
                        try {
                            res = response.body().string();
                            JSONObject object = new JSONObject(res);
                            if (object.has("status")) {

                                if (object.getString("status").equalsIgnoreCase("1")) {
                                    if (object.has("filepath")) {
                                        Log.d(TAG, "onResponse: filePath" + object.getString("filepath"));
                                        responseListener.onSuccess(object.getString("filepath"));
                                    }

                                } else {
                                    responseListener.onFailure(object.getString("msg"));
                                }

                            } else {
                                responseListener.onFailure(object.getString("msg"));
                            }
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });


    }

    public void addGalleryData(String tile, String description, String date, String eventDate, String filePath, String id, ResponseListener responseListener) {

//        title:image add test
//        Discription:image add test description
//        upload_date:03/21/2018
//        date:03/21/2018
//        insertBy:admin
//        file:download 66.jpg


//
        Call<ResponseBody> call;
        if (id == null)
            call = controller.addImages(tile, description, date, eventDate, Prefs.getString(CommonMethod.USER_TYPE), filePath);
        else
            call = controller.editImages(tile, description, date, eventDate, Prefs.getString(CommonMethod.USER_TYPE), filePath, id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                if (response.code() == 400) {
                    responseListener.onFailure(response.message());
                    return;
                }
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        String res = null;
                        try {
                            res = response.body().string();
                            JSONObject object = new JSONObject(res);
                            if (object.has("status")) {
                                if (object.getString("status").equalsIgnoreCase("1")) {
                                    if (object.has("msg")) {
                                        responseListener.onSuccess(object.getString("msg"));
                                    }

                                } else {
                                    responseListener.onFailure(object.getString("msg"));
                                }

                            } else {
                                responseListener.onFailure(object.getString("msg"));
                            }
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });

    }

    public void getUpdateListForSearch(String tblUpdate, int page, String searchWord, int limit, ResponseListener responseListener) {

        //    pageno:2
//    tablename:announcement
//    searchkeyword:products
//    perpage:10
//    field[0]:title
//    field[1]:Discription


//        @Field("product_name") String productName,
//        @Field("family_group") String familyGroup,
//        @Field("product_type") String productType,
//        else {
////
////            observable = controller.getSearchListFromPDS(page, tblUpdate, searchWord, limit, "product_name", "family_group", "product_type");
////        }
        Observable<ResponseBody> observable = null;


        observable = controller.getSearchListFromUpdate(page, tblUpdate, searchWord, limit, "title", "Discription");
//        }

        observable.flatMap(new Function<ResponseBody, Observable<List<Datum>>>() {
            private List<Datum> datumList = new ArrayList<>();

            @Override
            public Observable<List<Datum>> apply(ResponseBody responseBody) throws Exception {
                if (responseBody != null) {
                    String s = responseBody.string();
                    JSONObject object = new JSONObject(s);
                    if (object.has("Status") && object.has("Errorcode")) {
                        if (object.getString("Errorcode").equalsIgnoreCase("200")
                                && object.getString("Status").equalsIgnoreCase("1")) {
                            if (object.has("data")) {
                                String jsonString = new Gson().toJson(object.getString("data"));
                                Object json = new JSONTokener(jsonString).nextValue();
                                List<Datum> bus = new Gson().fromJson(json.toString(), new TypeToken<List<Datum>>() {
                                }.getType());
                                datumList.addAll(bus);
                                Log.d(TAG, "apply: search" + datumList.size());


//                                return Observable.just(datumList);
                            }

                        }

                    }

                }

                return Observable.just(datumList);

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Datum>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Datum> data) {
                        responseListener.onSuccess(data);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void getPDSListForSearch(String tableUpadte, int page, String searchWord, int limit, ResponseListener responseListener) {
        Observable<ResponseBody> observable = controller.getSearchListFromPDS(page, tableUpadte, searchWord, limit, "product_name", "family_group", "product_type");


        observable.flatMap(new Function<ResponseBody, Observable<List<Data>>>() {
            private List<Data> datumList = new ArrayList<>();

            @Override
            public Observable<List<Data>> apply(ResponseBody responseBody) throws Exception {
                if (responseBody != null) {
                    String s = responseBody.string();
                    JSONObject object = new JSONObject(s);
                    if (object.has("Status") && object.has("Errorcode")) {
                        if (object.getString("Errorcode").equalsIgnoreCase("200")
                                && object.getString("Status").equalsIgnoreCase("1")) {
                            if (object.has("data")) {
                                String jsonString = new Gson().toJson(object.getString("data"));
                                Object json = new JSONTokener(jsonString).nextValue();
                                List<Data> bus = new Gson().fromJson(json.toString(), new TypeToken<List<Data>>() {
                                }.getType());
                                datumList.addAll(bus);
                                Log.d(TAG, "apply: search" + datumList.size());


//                                return Observable.just(datumList);
                            }

                        }

                    }

                }

                return Observable.just(datumList);

            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Data>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Data> data) {
                        responseListener.onSuccess(data);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }


    /**
     * CaldNet Webservices Called  for CaldNet User
     **/
    public void loginCaldNet(String emailId, String password, ResponseListener responseListener) {
        //[{"User_ID":"1000000007","Password":"123","UserType":"D","MSG":"Save Successfully","statuscode":200}]
//        [{"User_ID":"admin","Password":"@rahman786$","UserType":"S","MSG":"Save Successfully","statuscode":200}]
//        {
//            "User_ID": "admin",
//                "First_Name": "CaldNet",
//                "Last_Name": "Administrator",
//                "Password": "@rahman786$",
//                "Email_ID": "Sohailur.Rahman@calderys.com",
//                "Password_Last_Modified_Date": "2013-09-30T15:41:07.467",
//                "Deleted": "0",
//                "IsExpired": "0",
//                "UserType": "S",
//                "SalesContactPerson": "0",
//                "MSG": "Save Successfully",
//                "statuscode": "200"
//        }
        Call<ResponseBody> call = controller.loginCaldNet(emailId, password);
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                String res = null;
                if (response.code() == 400) {
                    responseListener.onFailure("Invalid Credential");
                    return;
                }

                try {
                   // Log.d(TAG, "onResponse: "+new Gson().toJson(response));
                    res = response.body().string();

                    if (res.equalsIgnoreCase("null")) {
                        responseListener.onFailure("Invalid Credential ");
                        return;
                    }
                    if (response.isSuccessful()) {
                        if (response.body() != null) {
                            JSONObject object1 = null;
//                            if (res.equalsIgnoreCase( null)) {
//                                responseListener.onFailure("Invalid Credentials");
//                                return;
//                            }
                            try {
                                object1 = new JSONObject(res);
                                if (object1.has("statuscode")) {
                                    if (object1.getString("statuscode").equalsIgnoreCase("200")) {

                                        MyApplication.getInstance().saveUserDetails(res);

                                        Prefs.putString(CommonMethod.IS_LOGGIN, object1.getString("statuscode"));
                                        if (object1.has("UserType")) {
                                            Prefs.putString(CommonMethod.USER_TYPE, object1.getString("UserType"));
                                        }
                                        if (object1.has("User_ID")) {
                                            Prefs.putString(CommonMethod.USER_ID, object1.getString("User_ID"));
                                        }
                                        if (object1.has("Email_ID")) {
                                            Prefs.putString(CommonMethod.EMAIL_ID, object1.getString("Email_ID"));

                                        }

                                        responseListener.onSuccess(object1.getString("MSG"));
                                    } else {
                                        responseListener.onFailure(object1.getString("MSG"));
                                    }

                                } else {
                                    responseListener.onFailure("Invalid Credentials");
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }


                    }
//                            String jsonString = new Gson().toJson(res);
//                            Object json = new JSONTokener(jsonString).nextValue();

//                          String s = responseBody.string();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });
    }

    public void getMyIndent(PaginationModel model, ResponseListener responseListener) {
        Observable<List<IndentModel>> call;
//        model.setParameter(getDealerCode());
//        model.setParameter2(getQuery());
//    }
        if (model.getParameter() != null) {
            if (model.getParameter2() == null)
                call = controller.getApproveIntentList(model.getLimit(), model.getPageNo(), Prefs.getString(CommonMethod.USER_ID), model.getParameter());
            else {
                call = controller.getApproveSearchIntentList(model.getLimit(), model.getPageNo(), model.getParameter2(), model.getParameter());
            }
        } else {
            call = controller.getIndentList(model.getLimit(), model.getPageNo(), Prefs.getString(CommonMethod.USER_ID));
        }
        List<IndentModel> listIndent = new ArrayList<>();

        call.flatMap(new Function<List<IndentModel>, Observable<List<IndentModel>>>() {
            @Override
            public Observable<List<IndentModel>> apply(List<IndentModel> indentModels) throws Exception {

                listIndent.addAll(indentModels);
                return io.reactivex.Observable.just(listIndent);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<IndentModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<IndentModel> indentModels) {
                        responseListener.onSuccess(indentModels);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void getDispachedList(PaginationModel model, ResponseListener responseListener) {
        //    PageSize:2
//    PageNo:1
//    POnumber:AGA/0509
        Observable<List<DispachedModel>> call = controller.getDispachedList(model.getLimit(), model.getPageNo(), model.getParameter());
        List<DispachedModel> listIndent = new ArrayList<>();

        call.flatMap(new Function<List<DispachedModel>, Observable<List<DispachedModel>>>() {
            @Override
            public Observable<List<DispachedModel>> apply(List<DispachedModel> indentModels) throws Exception {

                listIndent.addAll(indentModels);
                return io.reactivex.Observable.just(listIndent);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<DispachedModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<DispachedModel> indentModels) {
                        responseListener.onSuccess(indentModels);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void getDealerList(PaginationModel model, ResponseListener responseListener) {

        Observable<List<DealerModel>> call;

        if (model.getParameter() == null)
            call = controller.getDealerList(model.getLimit(), model.getPageNo(), Prefs.getString(CommonMethod.USER_ID));
        else
            call = controller.getDealerListBySearch(model.getLimit(), model.getPageNo(), model.getParameter());

        List<DealerModel> listIndent = new ArrayList<>();

        call.flatMap(new Function<List<DealerModel>, Observable<List<DealerModel>>>() {
            @Override
            public Observable<List<DealerModel>> apply(List<DealerModel> indentModels) throws Exception {

                listIndent.addAll(indentModels);
                return io.reactivex.Observable.just(listIndent);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<DealerModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<DealerModel> indentModels) {
                        responseListener.onSuccess(indentModels);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void getSingleIndentItem(PaginationModel modell, ResponseListener responseListener) {

//        PageSize:2
//        PageNo:1
//        dealer_code:1000000005

        Observable<List<IndentModel>> call = controller.getSingleIntent(modell.getLimit(), modell.getPageNo(), modell.getParameter());
        List<IndentModel> listIndent = new ArrayList<>();

        call.flatMap(new Function<List<IndentModel>, Observable<List<IndentModel>>>() {
            @Override
            public Observable<List<IndentModel>> apply(List<IndentModel> indentModels) throws Exception {

                listIndent.addAll(indentModels);
                return io.reactivex.Observable.just(listIndent);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<IndentModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<IndentModel> indentModels) {
                        responseListener.onSuccess(indentModels);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void getImportantMessage(String type, ResponseListener responseListener) {

        Observable<List<MessageModel>> call = controller.getImportantMessage(type);
        List<MessageModel> listIndent = new ArrayList<>();

        call.flatMap(new Function<List<MessageModel>, Observable<List<MessageModel>>>() {
            @Override
            public Observable<List<MessageModel>> apply(List<MessageModel> indentModels) throws Exception {

                listIndent.addAll(indentModels);
                return io.reactivex.Observable.just(listIndent);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MessageModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<MessageModel> indentModels) {
                        responseListener.onSuccess(indentModels);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void getStroiesList(String tbleName, String type, ResponseListener responseListener) {

        Observable<List<StroiesModel>> call = controller.getStroiesList(type);
        List<StroiesModel> listIndent = new ArrayList<>();

        call.flatMap(new Function<List<StroiesModel>, Observable<List<StroiesModel>>>() {
            @Override
            public Observable<List<StroiesModel>> apply(List<StroiesModel> indentModels) throws Exception {

                listIndent.addAll(indentModels);
                return io.reactivex.Observable.just(listIndent);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<StroiesModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<StroiesModel> indentModels) {
                        responseListener.onSuccess(indentModels);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void getViewDraftList(PaginationModel model, ResponseListener responseListener) {
        Observable<List<ViewDraftModel>> call = controller.getViewDraftList(model.getLimit(), model.getPageNo(), model.getParameter());
        List<ViewDraftModel> listIndent = new ArrayList<>();

        call.flatMap(new Function<List<ViewDraftModel>, Observable<List<ViewDraftModel>>>() {
            @Override
            public Observable<List<ViewDraftModel>> apply(List<ViewDraftModel> indentModels) throws Exception {

                listIndent.addAll(indentModels);
                return io.reactivex.Observable.just(listIndent);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<ViewDraftModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<ViewDraftModel> indentModels) {
                        responseListener.onSuccess(indentModels);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void getIndentByDate(PaginationModel model, ResponseListener responseListener) {
        Observable<List<IndentModel>> call = null;
        if (model.getParameter5() == null)
            call = controller.getApproveList(model.getLimit(), model.getPageNo(), model.getParameter(), model.getParameter2(), model.getParameter3(), model.getParameter4(), Prefs.getString(CommonMethod.USER_ID));
        else
            call = controller.getViewIndent(model.getLimit(), model.getPageNo(), model.getParameter(), model.getParameter2(), model.getParameter3(), model.getParameter4(), model.getParameter5());

        call.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<IndentModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(List<IndentModel> indentModels) {
                        responseListener.onSuccess(indentModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void getViewPalntIndents(PaginationModel model, ResponseListener responseListener) {

//        PageSize:10
//        PageNo:1
//        PlantCode:krw
//        sdate:01/06/2013
//        EDate:28/11/2018

        Observable<List<IndentModel>> call = controller.getViewPlantIntent(model.getLimit(), model.getPageNo(), model.getParameter(), model.getParameter2(), model.getParameter3());
        List<IndentModel> listIndent = new ArrayList<>();

        call.flatMap(new Function<List<IndentModel>, Observable<List<IndentModel>>>() {
            @Override
            public Observable<List<IndentModel>> apply(List<IndentModel> indentModels) throws Exception {

                listIndent.addAll(indentModels);
                return io.reactivex.Observable.just(listIndent);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<IndentModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<IndentModel> indentModels) {
                        responseListener.onSuccess(indentModels);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        model.setTbleName(e.toString());
                        responseListener.onFailure(model);

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void cancelViewDraft(ViewDraftModel model, ResponseListener responseListener) {

        Call<ResponseBody> call;
//
//        {
//            "Type":"12",
//                "IndentCode":"1000000070-1310-0013",
//                "IndentDate":"22/10/2013"
//        }
        JsonObject jsonObject = new JsonObject();


        jsonObject.addProperty("Type", "12");
        jsonObject.addProperty("IndentCode", model.getIndentCode());
        jsonObject.addProperty("IndentDate", CommonMethod.convertDateToString(CommonMethod.convertStringToDate(model.getIndentDate())));
        call = controller.deleteViewDraft(jsonObject);

        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 400) {
                    responseListener.onFailure("Bad Request");
                    return;
                }
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        String res = null;


                        try {
                            res = response.body().string();
                            JSONArray arr = null;
                            arr = new JSONArray(res);
                            if (arr.length() > 0) {
                                JSONObject object = arr.getJSONObject(0);

                                if (object.has("Status")) {
                                    if (object.getString("Status").equalsIgnoreCase("200")) {
                                        model.setTax(object.getString("Message"));

                                        responseListener.onSuccess(model);
                                    } else {
                                        responseListener.onFailure(object.getString("Message"));
                                    }

                                } else {
                                    responseListener.onFailure(object.getString("Message"));
                                }

                            }

                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });


    }

    public void deleteSettingModel(AdapterStringModel model, ResponseListener responseListener) {


        Call<ResponseBody> call;
//        {
//            "Type":"D",
//                "IMID":1005,
//        }
        JsonObject jsonObject = new JsonObject();


        if (model.getFrom().equalsIgnoreCase(CommonMethod.FROM_MESSAGE)) {

            jsonObject.addProperty("Type", "D");
            jsonObject.addProperty("IMID", model.getId());
            call = controller.deleteSettingMessage(jsonObject);
        } else {
            jsonObject.addProperty("Type", "D");
            jsonObject.addProperty("SSID", model.getId());
            call = controller.deleteSettingStories(jsonObject);

        }
        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 400) {
                    responseListener.onFailure("Bad Request");
                    return;
                }
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        String res = null;


                        try {
                            res = response.body().string();
                            JSONArray arr = null;
                            arr = new JSONArray(res);
                            if (arr.length() > 0) {
                                JSONObject object = arr.getJSONObject(0);

                                if (object.has("Status")) {
                                    if (object.getString("Status").equalsIgnoreCase("200")) {
                                        model.setTitle(object.getString("Message"));

                                        responseListener.onSuccess(model);
                                    } else {
                                        responseListener.onFailure(model);
                                    }

                                } else {
                                    responseListener.onFailure(object.getString("Message"));
                                }

                            }

                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });


    }

    public void editSettingModel(AdapterStringModel model, ResponseListener responseListener) {


        Call<ResponseBody> call;
//        {
//        "Type": "U",
//        "SSID": 1,
//        "Description": "Good Evening",
//        "CreatedBy": "Admin",
//        "CreatedOn": "26-11-2018 17:25:38",
//        "UpdatedBy": "Atul",
//        "UpdatedOn": "26-11-2018 17:25:38",
//        "Active": true
//    }
        JsonObject jsonObject = new JsonObject();


        if (model.getFrom().equalsIgnoreCase(CommonMethod.FROM_MESSAGE)) {

//            {
//                "Type": "U",
//                    "SSID": 1,
//                    "Description": "Good Evening",
//                    "CreatedBy": "Admin",
//                    "CreatedOn": "26-11-2018 17:25:38",
//                    "UpdatedBy": "Atul",
//                    "UpdatedOn": "26-11-2018 17:25:38",
//                    "Active": true
//            }

            jsonObject.addProperty("Type", "U");
            jsonObject.addProperty("IMID", model.getId());
            jsonObject.addProperty("Description", model.getTitle());
            jsonObject.addProperty("CreatedBy", "Admin");
            jsonObject.addProperty("CreatedOn", model.getDate());
            jsonObject.addProperty("UpdatedBy", Prefs.getString(CommonMethod.USER_ID));
            jsonObject.addProperty("UpdatedOn", model.getDate());
            jsonObject.addProperty("Active", model.isActive());
            call = controller.updateSettingMessage(jsonObject);
        } else {
            jsonObject.addProperty("Type", "U");
            jsonObject.addProperty("SSID", model.getId());
            jsonObject.addProperty("Description", model.getTitle());
            jsonObject.addProperty("CreatedBy", "Admin");
            jsonObject.addProperty("CreatedOn", model.getDate());
            jsonObject.addProperty("UpdatedBy", Prefs.getString(CommonMethod.USER_ID));

            jsonObject.addProperty("UpdatedOn", model.getDate());
            jsonObject.addProperty("Active", model.isActive());
            call = controller.updateSettingStories(jsonObject);

        }

        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.code()==400){

                    responseListener.onFailure("Failed to update");
                    return;
                }
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        String res = null;



                        try {
                            res = response.body().string();
                            if(res ==null || TextUtils.isEmpty(res)){
                                responseListener.onFailure("Failed To Update Important Message");
                                return;
                            }
                            JSONArray arr = null;
                            arr = new JSONArray(res);
                            if (arr.length() > 0) {
                                JSONObject object = arr.getJSONObject(0);

                                if (object.has("Status")) {
                                    model.setTitle(object.getString("Message"));
                                    if (object.getString("Status").equalsIgnoreCase("200")) {


                                        responseListener.onSuccess(model);
                                    } else {
                                        responseListener.onFailure(object.getString("Message"));
                                    }

                                } else {
                                    responseListener.onFailure(object.getString("Message"));
                                }

                            }else {
                                responseListener.onFailure("Failed To Update Important Message");
                            }

                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });


    }

    public void addSettingModel(AdapterStringModel model, ResponseListener responseListener) {


        Call<ResponseBody> call;
//        {
//            "Type":"I",
//                "Description":"Heloo",
//                "CreatedBy":"Admin",
//                "Active":true
//        }

        JsonObject jsonObject = new JsonObject();

        jsonObject.addProperty("Type", "I");
        jsonObject.addProperty("Description", model.getTitle());
        jsonObject.addProperty("CreatedBy", "Admin");
        jsonObject.addProperty("Active", model.isActive());

        if (model.getFrom().equalsIgnoreCase(CommonMethod.FROM_MESSAGE)) {

            call = controller.postSettingMessage(jsonObject);
        } else {

            call = controller.postSettingStories(jsonObject);

        }

        call.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 400) {
                    responseListener.onFailure("Bad Request");
                    return;
                }
                if (response.body() != null) {

                    String res = null;


                    try {
                        res = response.body().string();
                        JSONArray arr = null;
                        arr = new JSONArray(res);
                        if (arr.length() > 0) {
                            JSONObject object = arr.getJSONObject(0);

                            if (object.has("Status")) {
                                if (object.getString("Status").equalsIgnoreCase("200")) {
                                    model.setTitle(object.getString("Message"));
                                    responseListener.onSuccess(model);
                                } else {
                                    responseListener.onFailure(model);
                                }

                            } else {
                                responseListener.onFailure(object.getString("Message"));
                            }

                        }

                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }


                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
                responseListener.onFailure(t.getMessage());

            }
        });
    }

    public void getApprovedIndent(PaginationModel model, ResponseListener responseListener) {
//        PageSize:10
//        PageNo:1
//        IndentCode:1000008352-1406-0001
//        dealer_code:1000008352
//        sdate:01/06/2013
//        EDate:27/11/2018
////

//        model =  new PaginationModel();
//        model.setParameter(dealerCode);
//        model.setParameter2(indentCode);
//        model.setTbleName(srtDate);
//        model.setLimit(Integer.parseInt(endDate));
//
        Observable<List<IndentModel>> call = controller.getApprovedIndent(10, model.getPageNo(), model.getParameter2(), model.getParameter(), model.getTbleName(), String.valueOf(model.getLimit()));
        List<IndentModel> listIndent = new ArrayList<>();

        call.flatMap(new Function<List<IndentModel>, Observable<List<IndentModel>>>() {
            @Override
            public Observable<List<IndentModel>> apply(List<IndentModel> indentModels) throws Exception {

                listIndent.addAll(indentModels);
                return io.reactivex.Observable.just(listIndent);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<IndentModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<IndentModel> indentModels) {

                        responseListener.onSuccess(indentModels);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void getEditViewDraftModel(ViewDraftModel model, ResponseListener responseListener) {

//        IndentCode:1000000070-1310-0013
//        IndentDate:22/10/2013

        ;
        Observable<ResponseBody> call = controller.getEditDraftModel(model.getIndentCode(), CommonMethod.convertDateToString(CommonMethod.convertStringToDate(model.getIndentDate())));

        call.flatMap(new Function<ResponseBody, Observable<Indents>>() {
            @Override
            public Observable<Indents> apply(ResponseBody responseBody) throws Exception {


                com.itg.calderysapp.caldNet.newIndent.Deetails.model.Indents indentsModel = null;
                if (responseBody != null) {
                    String res = null;
                    res = responseBody.string();
                    IndentController controller = new IndentController(res);
                    indentsModel = controller.getModel();
                    JSONObject jsonObject = new JSONObject(res);
//                    if (jsonObject.has("IndentInfo")) {
//                        if (jsonObject.getJSONObject("IndentInfo").has("Indents")) {
//                            JSONObject jsonObject1 = jsonObject.getJSONObject("IndentInfo").getJSONObject("Indents");
//                            String jsonString = new Gson().toJson(jsonObject1);
//                            Object json = new JSONTokener(jsonString).nextValue();
//                            indentsModel = new Gson().fromJson(json.toString(), com.itg.calderysapp.caldNet.newIndent.Deetails.model.Indents.class);
//
//                        }
//                    }


                }


                return io.reactivex.Observable.just(indentsModel);
            }

////        }).flatMap(new Function<Indents, Observable<Indents>>() {
////            @Override
////            public Observable<Indents> apply(Indents indents) throws Exception {
////                if(indents!=null){
////                    Indents indentsModel =new Indents();
////                    List<Product_> product_list =null;
////                    List<Consignee_> consignee_list =null;
////
////
////                    if(indents.getProduct()!=null){
////                        String res = null;
////                        res = indents.getProduct().getProduct().toString();
////                        Object json = new JSONTokener(res).nextValue();
////                        if(json instanceof  JSONObject){
////                            Product_ product_ = new Gson().fromJson(json.toString(), Product_.class);
////                            product_list.add(product_);
////
////                            }else if(json instanceof JSONArray){
////                             Product_ list = new Gson().fromJson(json.toString(), new TypeToken<List<Product_>>() {
////                            }.getType());
////
////                             product_list.addAll((Collection<? extends Product_>) list);
////
////                        }
////
////
////                    }
////
////
////                    Product product = new Product();
////                    product.setProduct(product_list);
////                     indentsModel.setProduct(product);
////
////
////                     if(indents.getConsignee()!=null){
////                         String res = null;
////                         res = indents.getConsignee().toString();
////
////
////                         Object json = new JSONTokener(res).nextValue();
////                         if(json instanceof  JSONObject){
////                             Consignee_ product_ = new Gson().fromJson(json.toString(), Consignee_.class);
////                             consignee_list.add(product_);
////
////                         }else if(json instanceof JSONArray){
////                             Product_ list = new Gson().fromJson(json.toString(), new TypeToken<List<Product_>>() {
////                             }.getType());
////
////                             product_list.addAll( list);
////
////                         }
////
////
////                     }
//                     return io.reactivex.Observable.just(indentsModel);
//
//
//                }
//                return io.reactivex.Observable.just(indents);
//            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Indents>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Indents o) {
                        responseListener.onSuccess(o);

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        responseListener.onFailure(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public Disposable downloadContries(ResponseListener responseListener) {
        Observable<ResponseBody> observable = controller.downloadCountries();
        disposable= observable.flatMap(new Function<ResponseBody, Observable<List<SpinnerGenericModel>>>() {
            @Override
            public Observable<List<SpinnerGenericModel>> apply(ResponseBody responseBody) throws Exception {
                String response = responseBody.string();
                if (response == null)
                    return Observable.just(new ArrayList<>());
                JSONArray jsonArray = new JSONArray(response);
                JSONObject obj;
                List<SpinnerGenericModel> allContries = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    obj = jsonArray.getJSONObject(i);
                    if (obj.has("CountryName")) {
                        allContries.add(new SpinnerGenericModel(obj.getString("CountryCode"), obj.getString("CountryName")));
                    }
                }
                return Observable.just(allContries);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<SpinnerGenericModel>>() {
                    @Override
                    public void accept(List<SpinnerGenericModel> spinnerGenericModel) throws Exception {
                        if (spinnerGenericModel.size() <= 0) {
                            responseListener.onFailure("No response");
                        } else {
                            responseListener.onSuccess(spinnerGenericModel);
                        }
                    }
                }, responseListener::onSomethingWrong);

        return disposable;
    }

    public Disposable downloadRegion(String id, ResponseListener responseListener) {
        Observable<ResponseBody> observable = controller.downloadRegion(id);
        return observable.flatMap(new Function<ResponseBody, Observable<List<SpinnerGenericModel>>>() {
            @Override
            public Observable<List<SpinnerGenericModel>> apply(ResponseBody responseBody) throws Exception {
                String response = responseBody.string();
                if (response == null)
                    return Observable.just(new ArrayList<>());
                JSONArray jsonArray = new JSONArray(response);
                JSONObject obj;
                List<SpinnerGenericModel> allContries = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    obj = jsonArray.getJSONObject(i);
                    if (obj.has("Region")) {
                        allContries.add(new SpinnerGenericModel(obj.getString("RegionCode"), obj.getString("Region")));
                    }
                }
                return Observable.just(allContries);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<SpinnerGenericModel>>() {
                    @Override
                    public void accept(List<SpinnerGenericModel> spinnerGenericModel) throws Exception {
                        if (spinnerGenericModel.size() <= 0) {
                            responseListener.onFailure("No response");
                        } else {
                            responseListener.onSuccess(spinnerGenericModel);
                        }
                    }
                }, responseListener::onSomethingWrong);
    }

    public Disposable addConsignee(ConsigneeModel model, ResponseListener responseListener) {
        Observable<ResponseBody> responseBodyObservable = controller.storeConsignee(model);
        disposable= responseBodyObservable.flatMap(new Function<ResponseBody, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(ResponseBody responseBody) throws Exception {
                String s = responseBody.string();
                JSONArray jsonArray = new JSONArray(s);
                if (jsonArray != null && jsonArray.length() > 0) {
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    if (jsonObject.has("MSg")) {
                        return Observable.just(1);
                    }
                }
                return Observable.just(0);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        if ((int) o == 1) {
                            responseListener.onSuccess(o);
                        } else {
                            responseListener.onFailure("Fail To Save Data");
                        }
                    }
                }, responseListener::onSomethingWrong);
        return disposable;
    }

    public Disposable updateIndentStatus(IntentDetailModel model, String status, ResponseListener responseListener) {
//        {
//            "UserType":"DD",
//                "indent_code":"dfsdf",
//                "UserID":"sdfs",
//                "IsRejection":"dsfsd",
//                "SO_Type":"sdfsd",
//                "indent_status":"S",
//                "ApprovedBy":"fdsf",
//                "Comments":"sdfsd",
//                "SO_number":"sfd",
//                "Sales_Org":"",
//                "DistChannel":"",
//                "Division":"",
//                "SalesOffice":"",
//                "SalesGroup":"",
//                "UsageIndicator":"",
//                "SpecialProcIndicator":"",
//                "Partner":"",
//                "ProcessCode":"",
//                "EquipmentCode":"",
//                "SalesPackage":"",
//                "ApprovalType":"y"
//        }


//        {
//            "UserType":"C",
//                "indent_code":"1000008352-1407-0003",
//                "UserID":"Atul.Nandanwar@calderys.com",
//                "IsRejection":"false",
//                "SO_Type":"ZSBB",
//                "indent_status":"S",
//                "ApprovedBy":"Atul.Nandanwar@calderys.com",
//                "Comments":"comments",
//                "SO_number":"ZSBB",
//                "Approve":{
//            "Sales_Org":"KRW",
//                    "DistChannel":"SS",
//                    "Division":"US",
//                    "SalesOffice":"DEL",
//                    "SalesGroup":"TGS",
//                    "UsageIndicator":"CUS",
//                    "SpecialProcIndicator":"ZRMS",
//                    "Partner":"100000098",
//                    "ProcessCode":"CM-001",
//                    "EquipmentCode":"CO0101",
//                    "SalesPackage":"ZPROD_SERV",
//                    "ApprovalIndicator":"null",
//                    "ApprovalType":"Y",
//                    "IndentCode":"null"
//        }
//        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("UserType", model.getUserType());
        jsonObject.addProperty("indent_code", model.getIndentCode());
        jsonObject.addProperty("UserID", Prefs.getString(CommonMethod.USER_ID));
        jsonObject.addProperty("IsRejection", model.getIsRejection());
        jsonObject.addProperty("SO_Type", model.getSoType());
        jsonObject.addProperty("indent_status", status);
        jsonObject.addProperty("ApprovedBy", Prefs.getString(CommonMethod.EMAIL_ID));
        jsonObject.addProperty("Comments", model.getCommentsForAppovedReject());
        jsonObject.addProperty("SO_number", model.getSoNumber());
//        jsonObject.addProperty("ApprovedBy",model.getApprovedBy());

        JsonObject jsonObject1 = new JsonObject();
        jsonObject1.addProperty("Sales_Org", model.getSalesOrganization());
        jsonObject1.addProperty("DistChannel", model.getDistributionChannel());
        jsonObject1.addProperty("Division", model.getDivision()
        );
        jsonObject1.addProperty("SalesOffice", model.getSalesOffice());
        jsonObject1.addProperty("SalesGroup", model.getSalesGroup());
        jsonObject1.addProperty("UsageIndicator", model.getUsaguageIndicator());
        jsonObject1.addProperty("SpecialProcIndicator", model.getSplProcessIndicator());
        jsonObject1.addProperty("Partner", model.getPartner());
        jsonObject1.addProperty("ProcessCode", model.getProcessCode());
        jsonObject1.addProperty("EquipmentCode", model.getEquipmentCode());
        jsonObject1.addProperty("SalesPackage", model.getSalesPackage());
        jsonObject1.addProperty("ApprovalIndicator", "");
        jsonObject1.addProperty("ApprovalType", model.getApprovalType());
        jsonObject1.addProperty("IndentCode", " ");

        jsonObject.add("Approve", jsonObject1);
        Log.d(TAG, "updateIndentStatus: " + new Gson().toJson(jsonObject));

//[
//        {
//            "Status": "200",
//                "Message": "Save Successfully"
//        }
//]

        Observable<ResponseBody> responseBodyObservable = controller.updateIndent(jsonObject);
        disposable= responseBodyObservable.flatMap(new Function<ResponseBody, Observable<?>>() {
            @Override
            public Observable<?> apply(ResponseBody responseBody) throws Exception {
                String s = responseBody.string();
                JSONArray jsonArray = new JSONArray(s);
                if (jsonArray != null && jsonArray.length() > 0) {
                    JSONObject jsonObject = jsonArray.getJSONObject(0);
                    if (jsonObject.has("Status")) {
                        if (jsonObject.getString("Status").equalsIgnoreCase("200"))
                            return Observable.just(1);
                    }
                }
                return Observable.just(0);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        if ((int) o == 1) {
                            responseListener.onSuccess("Update data Successfully");
                        } else {
                            responseListener.onFailure("Fail to update Data");
                        }
                    }
                }, responseListener::onSomethingWrong);
        return disposable;
    }

    public void getViewIntent(PaginationModel model, ResponseListener responseListener) {
        Observable<List<IndentModel>> call;
//        PageSize:3
//        PageNo:1
//        IndentCode:
//        dealer_code:
//        sdate:01/06/2013
//        EDate:28/11/2018
//        Status:

//        model.setLimit(10);
//        model.setPageNo(pageNumber);
//        model.setTbleName(CommonMethod.TBL_VIEWINDENT);
//        model.setParameter(getIndentCode());
//        model.setParameter2(getDealerCode());
//        model.setParameter3(getStartDate());
//        model.setParameter4(getEndDate());
//        model.setParameter5(getStatus());

        call = controller.getViewIndent(model.getLimit(), model.getPageNo(), model.getParameter(), model.getParameter2(), model.getParameter3(), model.getParameter4(), model.getParameter5());


        List<IndentModel> listIndent = new ArrayList<>();

       disposable= call.flatMap(new Function<List<IndentModel>, Observable<List<IndentModel>>>() {
            @Override
            public Observable<List<IndentModel>> apply(List<IndentModel> indentModels) throws Exception {

                listIndent.addAll(indentModels);
                return io.reactivex.Observable.just(listIndent);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<IndentModel>>() {
                    @Override
                    public void accept(List<IndentModel> indentModels) throws Exception {
                        responseListener.onSuccess(indentModels);
                    }
                },e -> { e.printStackTrace();
                    responseListener.onFailure(e);});



    }

    public Disposable downloadPlantCode(ResponseListener responseListener) {
        Observable<ResponseBody> responseBodyObservable = controller.downloadPlants();
        disposable=  responseBodyObservable.flatMap(new Function<ResponseBody, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(ResponseBody responseBody) throws Exception {
                String s = responseBody.string();
                JSONArray jsonArray = new JSONArray(s);
                List<SpinnerGenericModel> list = new ArrayList<>();
                if (jsonArray.length() > 0) {
                    JSONObject jsonObject;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        jsonObject = jsonArray.getJSONObject(i);
                        list.add(new SpinnerGenericModel(jsonObject.getString("plant_code"), "(" + jsonObject.getString("plant_code") + ") " + jsonObject.getString("plant_name")));
                    }
                }
                return Observable.just(list);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        List<SpinnerGenericModel> list = (List<SpinnerGenericModel>) o;
                        if (list.size() > 0)
                            responseListener.onSuccess(list);
                        else
                            responseListener.onFailure("No List");
                    }
                }, responseListener::onSomethingWrong);
        return disposable;
    }

    public Disposable downloadConsignee(PaginationModel model, ResponseListener responseListener) {
        Observable<List<ConsigneeListModel>> observable = controller.downloadConsignee(model.getLimit(), model.getPageNo(), model.getParameter());
        disposable=  observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ConsigneeListModel>>() {
                    @Override
                    public void accept(List<ConsigneeListModel> consigneeListModels) throws Exception {
                        responseListener.onSuccess(consigneeListModels);
                    }
                }, responseListener::onSomethingWrong);
        return disposable;
    }

    public Disposable downloadTransport(PaginationModel model, ResponseListener responseListener) {
//        "{\n" +
//                "  \"Type\":\"16\",\n" +
//                "  \"PageSize\":1000,\n" +
//                "  \"PageNo\":1,\n" +
//                "  \"SearchTransport\":\"\"\n" +
//                "}"
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("Type", model.getParameter());
        jsonObject.addProperty("PageSize", model.getLimit());
        jsonObject.addProperty("PageNo", model.getPageNo());
        jsonObject.addProperty("SearchTransport", model.getParameter2());
        Observable<List<TransportModel>> responseBodyObservable = controller.downloadTransport(jsonObject);
        disposable=  responseBodyObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<TransportModel>>() {
                    @Override
                    public void accept(List<TransportModel> o) throws Exception {
                        if (o != null && o.size() > 0)
                            responseListener.onSuccess(o);
                        else
                            responseListener.onFailure("No List");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        responseListener.onSomethingWrong(throwable);
                    }
                });
        return disposable;
    }

    public Disposable downloadProducts(PaginationModel model, ResponseListener responseListener) {
//        {
//            "Type":"13",
//                "PageSize":10,
//                "PageNo":1,
//                "IndentType":"IS",
//                "PlantCode":"KRW",
//                "Division":"SH"
//        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("PageSize", model.getLimit());
        jsonObject.addProperty("PageNo", model.getPageNo());
        jsonObject.addProperty("Type", model.getParameter());
        jsonObject.addProperty("IndentType", model.getParameter2());
        jsonObject.addProperty("PlantCode", model.getParameter3());
        jsonObject.addProperty("Division", model.getParameter4());
        jsonObject.addProperty("SearchMaterial", model.getParameter5());
        Observable<List<MaterialModel>> products;

        products = controller.searchProductList(jsonObject);

        disposable= products.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<MaterialModel>>() {
                    @Override
                    public void accept(List<MaterialModel> materialModels) throws Exception {
                        if (materialModels != null && materialModels.size() > 0)
                            responseListener.onSuccess(materialModels);
                        else
                            responseListener.onFailure("No List");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        responseListener.onSomethingWrong(throwable);
                    }
                });
        return disposable;
    }

    public void cancelIndentAll(IntentDetailModel indentModel, ResponseListener responseListener) {

        /***
         *
         * Cancel All  Type Indent  FROM Here ...
         *
         *
         */
    }

    public Disposable saveIndent(IndentsModel model, final List<SaveMaterialModel> materiaList, ResponseListener responseListener) {

        final String[] res = {null};
        final Observable<ResponseBody> observable = controller.createIndent(model);
        disposable=  observable.flatMap(new Function<ResponseBody, Observable<String>>() {
            @Override
            public Observable<String> apply(ResponseBody responseBody) throws Exception {
                String s = responseBody.string();
                if (s != null) {
                    JSONArray jsonArray = new JSONArray(s);
                    if (jsonArray.length() > 0) {
                        JSONObject object = jsonArray.getJSONObject(0);
                        if (object != null) {
                            if (object.has("indent_code")) {
                                res[0] = object.toString();
                                String indentCode = object.getString("indent_code");
                                responseListener.onSuccess(object.toString());
                                return Observable.just(indentCode);
                            }
                        }
                    }
                }
                return Observable.just("");
            }
        }).flatMap(new Function<String, Observable<ResponseBody>>() {
            @Override
            public Observable<ResponseBody> apply(String o) throws Exception {
                if (!TextUtils.isEmpty(o)) {
                    for (SaveMaterialModel st : materiaList) {
                        st.setIndentCode(o);
                    }
                }
                return controller.saveProducts(materiaList);

            }
        }).flatMap(new Function<ResponseBody, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(ResponseBody responseBody) throws Exception {
                String s = responseBody.string();
                if (s != null) {
                    JSONArray array = new JSONArray(s);
                    if (array.length() > 0) {
                        JSONObject jsonObject = array.getJSONObject(0);
                        if (jsonObject != null) {
                            if (jsonObject.has("statuscode")) {
                                if ((jsonObject.getString("statuscode")).equalsIgnoreCase("200")) {
                                    return Observable.just(1);
                                }
                            }
                        }
                    }
                }
                return Observable.just(0);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        if ((((int) o) != 0))
                            responseListener.onSuccess(1);

                            else
                            responseListener.onFailure(0);
                    }
                }, responseListener::onSomethingWrong);

        return disposable;
    }

    public Disposable setSAPAPPROVED(SAPModel model, ResponseListener responseListener) {

        Observable<ResponseBody> observable = controller.approvedIndentUsingSAP(model);

        disposable= observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {
                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        if(responseBody!=null){
                            String res = responseBody.string();
                            JSONObject object = new JSONObject(res);
                            if (object.has("statuscode") && object.has("MSG")) {
                                if(object.getString("statuscode").equalsIgnoreCase("200")){
                                    responseListener.onSuccess(object.getString("MSG"));

                                }else{
                                    responseListener.onFailure(object.getString("MSG"));
                                }

                            }
                        }
                    }
                }, responseListener::onSomethingWrong);

return disposable;
    }

    public Disposable downloadEqp(String id,final ResponseListener listener) {
        Observable<ResponseBody> responseBodyObservable=controller.downloadEqp(id);
        return responseBodyObservable.flatMap(new Function<ResponseBody, Observable<List<SpinnerGenericModel>>>() {
            @Override
            public Observable<List<SpinnerGenericModel>> apply(ResponseBody responseBody) throws Exception {

                return null;
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(listener::onSuccess, listener::onSomethingWrong);
    }


    public interface ResponseListener {
        void onSuccess(Object message);

        void onFailure(Object err);


        void onSomethingWrong(Object e);

    }

    public interface DatabaseListener {
        void onProductTypeAdded();

        void onProductDeleted();
    }

    public interface ProgressListner {
        void onProgressUpdate(int percentage);

        void onFinished();

        void onFailded();

    }


    public static final class NetworkBuilder {
        String token;

        public NetworkBuilder setHeader() {
//            token = Prefs.getString(CommonMethod.TOKEN, "-1") + " " + MyApplication.getInstance().getAppToken();
            Log.d(TAG, "setHeader: " + token);
            return this;
        }

        public NetworkUtility build() {
            return new NetworkUtility(this);
        }
    }
    public  void destroyedNetworkCall(){
        if(disposable!=null) {
            if (!disposable.isDisposed())
                disposable.dispose();
        }
    }

    private static class ProgressResponseBody extends RequestBody {

        private static final int DEFAULT_BUFFER_SIZE = 2048;
        private File mFile;
        private String mPath;
        private UploadCallbacks mListener;

        public ProgressResponseBody(final File file, final UploadCallbacks listener) {
            mFile = file;
            mListener = listener;
        }

        @Override
        public MediaType contentType() {
            // i want to upload only images
            return MediaType.parse("multipart/*");
        }

        @Override
        public long contentLength() throws IOException {
            return mFile.length();
        }

        @Override
        public void writeTo(BufferedSink sink) throws IOException {
            long fileLength = mFile.length();
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            FileInputStream in = new FileInputStream(mFile);
            long uploaded = 0;

            try {
                int read;
                Handler handler = new Handler(Looper.getMainLooper());
                while ((read = in.read(buffer)) != -1) {

                    // update progress on UI thread
                    handler.post(new ProgressUpdater(uploaded, fileLength));

                    uploaded += read;
                    sink.write(buffer, 0, read);
                }
            } finally {
                in.close();
            }
        }

        public interface UploadCallbacks {
            void onProgressUpdate(int percentage);

            void onError();

            void onFinish();
        }

        private class ProgressUpdater implements Runnable {
            private long mUploaded;
            private long mTotal;

            public ProgressUpdater(long uploaded, long total) {
                mUploaded = uploaded;
                mTotal = total;
            }

            @Override
            public void run() {
                mListener.onProgressUpdate((int) (100 * mUploaded / mTotal));
            }
        }
    }


}


