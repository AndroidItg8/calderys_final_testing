package com.itg.calderysapp.caldConnect.pds.mvp;

import com.itg.calderysapp.caldConnect.pds.model.Data;
import com.itg.calderysapp.caldConnect.update.model.Datum;
import com.itg.calderysapp.common.NetworkUtility;

import java.util.List;

public class PDSModuleImp implements PDSMVP.PDSModule {
    @Override
    public void onGetPDSListFromServer(String tableName, int perPage, int PageNumber, PDSMVP.PDSListener listener) {
        new NetworkUtility.NetworkBuilder().build().getPDSList(tableName, perPage, PageNumber, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {

                listener.onGetList((List<Data>) message);
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
        new NetworkUtility.NetworkBuilder().build().destroyedNetworkCall();





    }

    @Override
    public void onSearchQuery(String tableUpadte, int page, String searchWord, int limit, PDSMVP.PDSListener listener) {

        new NetworkUtility.NetworkBuilder().build().getPDSListForSearch(tableUpadte, page, searchWord, limit, new NetworkUtility.ResponseListener() {
            @Override
            public void onSuccess(Object message) {
                listener.onGetSearch((List<Data>) message);


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
