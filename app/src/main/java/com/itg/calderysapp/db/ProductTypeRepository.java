package com.itg.calderysapp.db;

import android.app.Application;

import com.itg.calderysapp.caldConnect.pds.model.Datum;
import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class ProductTypeRepository {
    AppDatabase db;


    public ProductTypeRepository(Application application) {
        db = AppDatabase.getAppDatabase(application);
    }


    public void getProductType( final DatabaseCallback.ProductDatabaseCallback databaseCallback) {
Single<List<TblProductType>> single= db.daoProductType().getAllProductType();
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<TblProductType>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // add it to a CompositeDisposable
                    }

                    @Override
                    public void onSuccess(List<TblProductType> users) {
                        // update the UI
                        databaseCallback.onProductType(users);
                    }
                    @Override
                    public void onError(Throwable e) {
                        // show an error message
                        e.printStackTrace();
                    }
                });
//



    }


    public void addProductType(TblProductType type, final DatabaseCallback databaseCallback) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.daoProductType().insertProductType(type);
                AppDatabase.destroyInstance();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
                databaseCallback.onProductTypeAdded();
            }

            @Override
            public void onError(Throwable e) {
                databaseCallback.onDataNotAvailable(e);
            }
        });
    }

    public void deleteProdcutType(final DatabaseCallback databaseCallback, final TblProductType user) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.daoProductType().deleteTask(user);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                databaseCallback.onProductDeleted();
            }

            @Override
            public void onError(Throwable e) {
                databaseCallback.onDataNotAvailable(e);
            }
        });
    }


    public void updateProduct(final DatabaseCallback databaseCallback, final TblProductType user) {

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.daoProductType().updateTask(user);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                databaseCallback.onUpdateProductType();
            }

            @Override
            public void onError(Throwable e) {
                databaseCallback.onDataNotAvailable(e);
            }
        });
    }

    public void deleteAll(DatabaseCallback databaseCallback) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.daoProductType().deleteAll();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                databaseCallback.onProductDeleted();
            }

            @Override
            public void onError(Throwable e) {
                databaseCallback.onDataNotAvailable(e);
            }
        });
    }

    public void addAllProductTypeList(List<TblProductType> tblProductTypeList, DatabaseCallback databaseCallback) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.daoProductType().insertAll(tblProductTypeList);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onComplete() {
                databaseCallback.onProductTypeAdded();
            }

            @Override
            public void onError(Throwable e) {
                databaseCallback.onDataNotAvailable(e);
            }
        });
    }
}
