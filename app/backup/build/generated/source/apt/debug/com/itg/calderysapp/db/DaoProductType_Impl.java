package com.itg.calderysapp.db;

import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EmptyResultSetException;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.arch.persistence.room.SharedSQLiteStatement;
import android.database.Cursor;
import com.itg.calderysapp.db.table.TblProductType;
import io.reactivex.Single;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings("unchecked")
public class DaoProductType_Impl implements DaoProductType {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfTblProductType;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfTblProductType;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfTblProductType;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public DaoProductType_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTblProductType = new EntityInsertionAdapter<TblProductType>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `PRODUCT_TYPE`(`id`,`product_type`,`insert_by`,`created`,`modified`,`ip`) VALUES (?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TblProductType value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getProductType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductType());
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
    this.__deletionAdapterOfTblProductType = new EntityDeletionOrUpdateAdapter<TblProductType>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `PRODUCT_TYPE` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TblProductType value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
      }
    };
    this.__updateAdapterOfTblProductType = new EntityDeletionOrUpdateAdapter<TblProductType>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `PRODUCT_TYPE` SET `id` = ?,`product_type` = ?,`insert_by` = ?,`created` = ?,`modified` = ?,`ip` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, TblProductType value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getProductType() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getProductType());
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
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM product_type";
        return _query;
      }
    };
  }

  @Override
  public long insertProductType(TblProductType note) {
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfTblProductType.insertAndReturnId(note);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertAll(List<TblProductType> tblProductTypes) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfTblProductType.insert(tblProductTypes);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteTask(TblProductType productType) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfTblProductType.handle(productType);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateTask(TblProductType productType) {
    __db.beginTransaction();
    try {
      __updateAdapterOfTblProductType.handle(productType);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAll() {
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public Single<List<TblProductType>> getAllProductType() {
    final String _sql = "SELECT * FROM product_type";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return Single.fromCallable(new Callable<List<TblProductType>>() {
      @Override
      public List<TblProductType> call() throws Exception {
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfId = _cursor.getColumnIndexOrThrow("id");
          final int _cursorIndexOfProductType = _cursor.getColumnIndexOrThrow("product_type");
          final int _cursorIndexOfInsertBy = _cursor.getColumnIndexOrThrow("insert_by");
          final int _cursorIndexOfCreated = _cursor.getColumnIndexOrThrow("created");
          final int _cursorIndexOfModified = _cursor.getColumnIndexOrThrow("modified");
          final int _cursorIndexOfIp = _cursor.getColumnIndexOrThrow("ip");
          final java.util.List<com.itg.calderysapp.db.table.TblProductType> _result = new java.util.ArrayList<com.itg.calderysapp.db.table.TblProductType>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final com.itg.calderysapp.db.table.TblProductType _item;
            _item = new com.itg.calderysapp.db.table.TblProductType();
            final java.lang.String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final java.lang.String _tmpProductType;
            _tmpProductType = _cursor.getString(_cursorIndexOfProductType);
            _item.setProductType(_tmpProductType);
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
}
