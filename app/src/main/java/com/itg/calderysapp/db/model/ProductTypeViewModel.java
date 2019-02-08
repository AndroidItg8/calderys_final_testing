package com.itg.calderysapp.db.model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.itg.calderysapp.caldConnect.pds.model.Datum;
import com.itg.calderysapp.common.NetworkUtility;
import com.itg.calderysapp.db.DatabaseCallback;
import com.itg.calderysapp.db.ProductTypeRepository;
import com.itg.calderysapp.db.table.TblProductType;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;


public class ProductTypeViewModel extends AndroidViewModel {
    private static final String TAG = "ProductTypeViewModel";
    private ProductTypeRepository mTypeRepository;

    public ProductTypeViewModel(@NonNull Application application) {
        super(application);
        mTypeRepository = new ProductTypeRepository(application);
    }

 public List<TblProductType>   getAllProductType(  ) {
        List<TblProductType> list =new ArrayList<>();
        mTypeRepository.getProductType(new DatabaseCallback.ProductDatabaseCallback() {
         @Override
         public void onProductType(List<TblProductType> users) {
             Log.d(TAG, "onProductType: TbleProduct Size"+users);
           list.addAll(users);
         }
     });
return list;
    }

    public void insert(TblProductType word, NetworkUtility.DatabaseListener listener) {

        mTypeRepository.addProductType(word, new DatabaseCallback() {


            @Override
            public void onProductTypeAdded() {
                listener.onProductTypeAdded();


            }

            @Override
            public void onDataNotAvailable(Throwable e) {
                e.printStackTrace();

            }

            @Override
            public void onProductDeleted() {

            }

            @Override
            public void onUpdateProductType() {

            }
        }); }


    public void deleteAll(NetworkUtility.DatabaseListener databaseListener) {
        mTypeRepository.deleteAll(new DatabaseCallback() {
            @Override
            public void onProductTypeAdded() {

            }

            @Override
            public void onDataNotAvailable(Throwable e) {

            }

            @Override
            public void onProductDeleted() {
                databaseListener.onProductDeleted();
            }

            @Override
            public void onUpdateProductType() {

            }
        });
    }

    public void insertAll(List<TblProductType> tblProductTypeList, NetworkUtility.DatabaseListener databaseListener) {
        mTypeRepository.addAllProductTypeList(tblProductTypeList, new DatabaseCallback() {
            @Override
            public void onProductTypeAdded() {
                databaseListener.onProductTypeAdded();
            }

            @Override
            public void onDataNotAvailable(Throwable e) {

            }

            @Override
            public void onProductDeleted() {

            }

            @Override
            public void onUpdateProductType() {

            }
        });
    }
}

