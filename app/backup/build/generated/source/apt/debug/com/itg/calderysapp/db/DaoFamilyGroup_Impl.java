package com.itg.calderysapp.db;

import android.arch.lifecycle.ComputableLiveData;
import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EmptyResultSetException;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.InvalidationTracker.Observer;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;
import android.support.annotation.NonNull;
import com.itg.calderysapp.db.table.TblFamilyGroup;
import io.reactivex.Single;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public class DaoFamilyGroup_Impl implements DaoFamilyGroup {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTblFamilyGroup;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTblFamilyGroup;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTblFamilyGroup;

  public DaoFamilyGroup_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTblFamilyGroup = new EntityInsertionAdapter<TblFamilyGroup>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `FAMILY_GROUP`(`id`,`group_name`,`insert_by`,`created`,`modified`,`ip`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TblFamilyGroup value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getGroupName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGroupName());
        }
        if (value.getInsertBy() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getInsertBy());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModified());
        }
        if (value.getIp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getIp());
        }
      }
    };
    this.__deletionAdapterOfTblFamilyGroup = new EntityDeletionOrUpdateAdapter<TblFamilyGroup>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `FAMILY_GROUP` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TblFamilyGroup value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfTblFamilyGroup = new EntityDeletionOrUpdateAdapter<TblFamilyGroup>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `FAMILY_GROUP` SET `id` = ?,`group_name` = ?,`insert_by` = ?,`created` = ?,`modified` = ?,`ip` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TblFamilyGroup value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getGroupName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getGroupName());
        }
        if (value.getInsertBy() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getInsertBy());
        }
        if (value.getCreated() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getCreated());
        }
        if (value.getModified() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getModified());
        }
        if (value.getIp() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getIp());
        }
        if (value.getId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getId());
        }
      }
    };
  }

  @Override
  public long insertFamilyGroup(TblFamilyGroup note) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfTblFamilyGroup.insertAndReturnId(note);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(TblFamilyGroup... tblProductTypes) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTblFamilyGroup.insert(tblProductTypes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTask(TblFamilyGroup productType) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfTblFamilyGroup.handle(productType);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTask(TblFamilyGroup productType) {
    __db.beginTransaction();
    try {
      __updateAdapterOfTblFamilyGroup.handle(productType);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Single<List<TblFamilyGroup>> getAllFamilyGroup() {
    final String _sql = "SELECT * FROM FAMILY_GROUP";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return Single.fromCallable(new Callable<List<TblFamilyGroup>>() {
      @Override
      public List<TblFamilyGroup> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("group_name");
          final int _cursorIndexOfInsertBy = _cursor.getColumnIndexOrThrow("insert_by");
          final int _cursorIndexOfCreated = _cursor.getColumnIndexOrThrow("created");
          final int _cursorIndexOfModified = _cursor.getColumnIndexOrThrow("modified");
          final int _cursorIndexOfIp = _cursor.getColumnIndexOrThrow("ip");
          final java.util.List<com.itg.calderysapp.db.table.TblFamilyGroup> _result = new java.util.ArrayList<com.itg.calderysapp.db.table.TblFamilyGroup>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final com.itg.calderysapp.db.table.TblFamilyGroup _item;
            _item = new com.itg.calderysapp.db.table.TblFamilyGroup();
            final java.lang.String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final java.lang.String _tmpGroupName;
            _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
            _item.setGroupName(_tmpGroupName);
            final java.lang.String _tmpInsertBy;
            _tmpInsertBy = _cursor.getString(_cursorIndexOfInsertBy);
            _item.setInsertBy(_tmpInsertBy);
            final java.lang.String _tmpCreated;
            _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
            _item.setCreated(_tmpCreated);
            final java.lang.String _tmpModified;
            _tmpModified = _cursor.getString(_cursorIndexOfModified);
            _item.setModified(_tmpModified);
            final java.lang.String _tmpIp;
            _tmpIp = _cursor.getString(_cursorIndexOfIp);
            _item.setIp(_tmpIp);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<TblFamilyGroup> getFamilyGroupByid(int id) {
    final String _sql = "SELECT * FROM FAMILY_GROUP WHERE id =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return new ComputableLiveData<TblFamilyGroup>() {
      private Observer _observer;

      @Override
      protected TblFamilyGroup compute() {
        if (_observer == null) {
          _observer = new Observer("FAMILY_GROUP") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfGroupName = _cursor.getColumnIndexOrThrow("group_name");
          final int _cursorIndexOfInsertBy = _cursor.getColumnIndexOrThrow("insert_by");
          final int _cursorIndexOfCreated = _cursor.getColumnIndexOrThrow("created");
          final int _cursorIndexOfModified = _cursor.getColumnIndexOrThrow("modified");
          final int _cursorIndexOfIp = _cursor.getColumnIndexOrThrow("ip");
          final TblFamilyGroup _result;
          if(_cursor.moveToFirst()) {
            _result = new TblFamilyGroup();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _result.setId(_tmpId);
            final String _tmpGroupName;
            _tmpGroupName = _cursor.getString(_cursorIndexOfGroupName);
            _result.setGroupName(_tmpGroupName);
            final String _tmpInsertBy;
            _tmpInsertBy = _cursor.getString(_cursorIndexOfInsertBy);
            _result.setInsertBy(_tmpInsertBy);
            final String _tmpCreated;
            _tmpCreated = _cursor.getString(_cursorIndexOfCreated);
            _result.setCreated(_tmpCreated);
            final String _tmpModified;
            _tmpModified = _cursor.getString(_cursorIndexOfModified);
            _result.setModified(_tmpModified);
            final String _tmpIp;
            _tmpIp = _cursor.getString(_cursorIndexOfIp);
            _result.setIp(_tmpIp);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }
}
