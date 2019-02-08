package com.itg.calderysapp.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.itg.calderysapp.caldConnect.pds.model.Datum;
import com.itg.calderysapp.db.table.TblFamilyGroup;
import com.itg.calderysapp.db.table.TblProductType;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

@Database(entities = {TblProductType.class, TblFamilyGroup.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "CalderysAppDb";
    private static  volatile AppDatabase INSTANCE;
    public abstract DaoProductType daoProductType() ;
    public abstract DaoFamilyGroup duoFamilyGroup() ;
    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }


//
//    private static volatile WordRoomDatabase INSTANCE;
//
//    static WordRoomDatabase getDatabase(final Context context) {
//        if (INSTANCE == null) {
//            synchronized (WordRoomDatabase.class) {
//                if (INSTANCE == null) {
//                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
//                            WordRoomDatabase.class, "word_database")
//                            .build();
//                }
//            }
//        }
//        return INSTANCE;
//    }



    public static void destroyInstance() {
        INSTANCE = null;
    }

}
