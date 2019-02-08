package com.itg.calderysapp.db;

import android.app.Application;

import com.itg.calderysapp.caldConnect.pds.model.FamilyGroupData;
import com.itg.calderysapp.db.table.TblFamilyGroup;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

import io.reactivex.schedulers.Schedulers;

public class FamilyGroupRepository {
    AppDatabase db;


  public FamilyGroupRepository(Application application) {
         db = AppDatabase.getAppDatabase(application);
    }




    public void getFamilyGroup(final DatabaseCallback.FamilyDatabaseCallback databaseCallback) {


        Single<List<TblFamilyGroup>> single = db.duoFamilyGroup().getAllFamilyGroup();
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<TblFamilyGroup>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // add it to a CompositeDisposable
                    }

                    @Override
                    public void onSuccess(List<TblFamilyGroup> users) {
                        // update the UI
                        databaseCallback.onFamilyGroup(users);
                    }
                    @Override
                    public void onError(Throwable e) {
                        // show an error message
                        e.printStackTrace();
                    }
                });
//


    }


    public void addFamilyGroup(TblFamilyGroup type, final DatabaseCallback databaseCallback) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.duoFamilyGroup().insertFamilyGroup(type);
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

    public void deleteFamilyGroup(final DatabaseCallback databaseCallback, final TblFamilyGroup user) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.duoFamilyGroup().deleteTask(user);
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


    public void updatFamilyGroup(final DatabaseCallback databaseCallback, final TblFamilyGroup user) {

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                db.duoFamilyGroup().updateTask(user);
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
}
