package com.itg.calderysapp.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface DaoFamilyGroup {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long  insertFamilyGroup(TblFamilyGroup note);

    @Query("SELECT * FROM "+TblFamilyGroup.TABLE_FAMILY_GROUP )
    Single<List<TblFamilyGroup>> getAllFamilyGroup();

    @Query("SELECT * FROM "+TblFamilyGroup.TABLE_FAMILY_GROUP+" WHERE id =:id")
    LiveData<TblFamilyGroup> getFamilyGroupByid(int id);
    @Update
    void updateTask(TblFamilyGroup productType);
    @Delete
    void deleteTask(TblFamilyGroup productType);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(TblFamilyGroup... tblProductTypes);

}
