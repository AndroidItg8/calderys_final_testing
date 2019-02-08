package com.itg.calderysapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.itg.calderysapp.db.table.TblProductType;

import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface DaoProductType {


        @Insert(onConflict = OnConflictStrategy.IGNORE)
        long  insertProductType(TblProductType note);

        @Query("SELECT * FROM "+TblProductType.PRODUCT_TYPE )
        Single<List<TblProductType>> getAllProductType();

//        @Query("SELECT * FROM "+TblProductType.PRODUCT_TYPE+" WHERE id =:id")
//        Single<TblProductType> getProductTypeByid(int id);
        @Update
        void updateTask(TblProductType productType);
        @Delete
        void deleteTask(TblProductType productType);

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insertAll(List<TblProductType> tblProductTypes);

        @Query("DELETE FROM "+TblProductType.PRODUCT_TYPE)
        void deleteAll();


//
}
