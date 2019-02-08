package com.itg.calderysapp.db;

import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;

public interface DatabaseCallback  {

    void onProductTypeAdded();

    void onDataNotAvailable(Throwable e);

    void onProductDeleted();

    void onUpdateProductType();

    public interface ProductDatabaseCallback{
        void onProductType(List<TblProductType> users);

    } public interface FamilyDatabaseCallback{
        void onFamilyGroup(List<TblFamilyGroup> users);

    }





}
