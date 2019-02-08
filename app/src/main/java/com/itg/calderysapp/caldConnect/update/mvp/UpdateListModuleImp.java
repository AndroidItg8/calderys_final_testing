package com.itg.calderysapp.caldConnect.update.mvp;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.NetworkUtility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class UpdateListModuleImp implements UpdateMVP.UpdateModule {
    private static final String TAG = "UpdateListModuleImp";

    @Override
    public void onGetUpdateListFromServer(String tableName, int perPage, int PageNumber, UpdateMVP.UpdateListener listener) {
        new NetworkUtility.NetworkBuilder().build().getUpdateList(tableName, perPage, PageNumber, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {

                listener.onGetList((List<Datum>) message);
            }

            @Override
            public void onFailure(Object err) {


                listener.onPaginationError();

            }

            @Override
            public void onSomethingWrong(Object e) {

            }


        });

    }

    @Override
    public void onDestroy() {


    }
    @Override
    public void onSearchQuery(String tableUpdate, int page, String searchWord, int limit, UpdateMVP.UpdateListener listener) {
        new NetworkUtility.NetworkBuilder().build().getUpdateListForSearch(tableUpdate, page, searchWord, limit, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onGetSearch((List<Datum>) message);


                //                Observable.just(message).flatMap(new Function<Object, Observable<List<Datum>>>() {
//                    @Override
//                    public Observable<List<Datum>> apply(Object o) throws Exception {
//                        List<Datum> roleList = new ArrayList<>();
//
//
//                        String jsonString = new Gson().toJson(o);
//                        Object json = new JSONTokener(jsonString).nextValue();
//
////                        if (json instanceof JSONObject) {
////                            Datum bus = new Gson().fromJson(json.toString(), Datum.class);
////                            roleList.add(bus);
////
////                        } else if (json instanceof JSONArray) {
//                            List<Datum> bus = new Gson().fromJson(json.toString(), new TypeToken<List<Datum>>() {
//                            }.getType());
//                            roleList.addAll(bus);
//                            Log.d(TAG, "apply: search" + roleList.size());
////                        }
//                        return Observable.just(bus);
//                    }
//                }).subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Observer<List<Datum>>() {
//                            @Override
//                            public void onSubscribe(Disposable d) {
//
//                            }
//
//                            @Override
//                            public void onNext(List<Datum> data) {
//                                listener.onGetSearch(data);
//
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//                                listener.onError(e.getMessage());
//
//                            }
//
//                            @Override
//                            public void onComplete() {
//
//                            }
//                        });
//
//
//
//
//


            }

            @Override
            public void onFailure(Object err) {
                listener.onFail(err.toString());

            }

            @Override
            public void onSomethingWrong(Object e) {

            }
        });
    }
}
