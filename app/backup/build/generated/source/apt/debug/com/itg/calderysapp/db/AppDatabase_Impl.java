package com.itg.calderysapp.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Callback;
import android.arch.persistence.db.SupportSQLiteOpenHelper.Configuration;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomOpenHelper;
import android.arch.persistence.room.RoomOpenHelper.Delegate;
import android.arch.persistence.room.util.TableInfo;
import android.arch.persistence.room.util.TableInfo.Column;
import android.arch.persistence.room.util.TableInfo.ForeignKey;
import android.arch.persistence.room.util.TableInfo.Index;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class AppDatabase_Impl extends AppDatabase {
  private volatile DaoProductType _daoProductType;

  private volatile DaoFamilyGroup _daoFamilyGroup;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `PRODUCT_TYPE` (`id` TEXT NOT NULL, `product_type` TEXT, `insert_by` TEXT, `created` TEXT, `modified` TEXT, `ip` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `FAMILY_GROUP` (`id` TEXT NOT NULL, `group_name` TEXT, `insert_by` TEXT, `created` TEXT, `modified` TEXT, `ip` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"80a13a96f2022ff1d55972bb73cb3932\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `PRODUCT_TYPE`");
        _db.execSQL("DROP TABLE IF EXISTS `FAMILY_GROUP`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsPRODUCTTYPE = new HashMap<String, TableInfo.Column>(6);
        _columnsPRODUCTTYPE.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsPRODUCTTYPE.put("product_type", new TableInfo.Column("product_type", "TEXT", false, 0));
        _columnsPRODUCTTYPE.put("insert_by", new TableInfo.Column("insert_by", "TEXT", false, 0));
        _columnsPRODUCTTYPE.put("created", new TableInfo.Column("created", "TEXT", false, 0));
        _columnsPRODUCTTYPE.put("modified", new TableInfo.Column("modified", "TEXT", false, 0));
        _columnsPRODUCTTYPE.put("ip", new TableInfo.Column("ip", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPRODUCTTYPE = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesPRODUCTTYPE = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoPRODUCTTYPE = new TableInfo("PRODUCT_TYPE", _columnsPRODUCTTYPE, _foreignKeysPRODUCTTYPE, _indicesPRODUCTTYPE);
        final TableInfo _existingPRODUCTTYPE = TableInfo.read(_db, "PRODUCT_TYPE");
        if (! _infoPRODUCTTYPE.equals(_existingPRODUCTTYPE)) {
          throw new IllegalStateException("Migration didn't properly handle PRODUCT_TYPE(com.itg.calderysapp.db.table.TblProductType).\n"
                  + " Expected:\n" + _infoPRODUCTTYPE + "\n"
                  + " Found:\n" + _existingPRODUCTTYPE);
        }
        final HashMap<String, TableInfo.Column> _columnsFAMILYGROUP = new HashMap<String, TableInfo.Column>(6);
        _columnsFAMILYGROUP.put("id", new TableInfo.Column("id", "TEXT", true, 1));
        _columnsFAMILYGROUP.put("group_name", new TableInfo.Column("group_name", "TEXT", false, 0));
        _columnsFAMILYGROUP.put("insert_by", new TableInfo.Column("insert_by", "TEXT", false, 0));
        _columnsFAMILYGROUP.put("created", new TableInfo.Column("created", "TEXT", false, 0));
        _columnsFAMILYGROUP.put("modified", new TableInfo.Column("modified", "TEXT", false, 0));
        _columnsFAMILYGROUP.put("ip", new TableInfo.Column("ip", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFAMILYGROUP = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFAMILYGROUP = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFAMILYGROUP = new TableInfo("FAMILY_GROUP", _columnsFAMILYGROUP, _foreignKeysFAMILYGROUP, _indicesFAMILYGROUP);
        final TableInfo _existingFAMILYGROUP = TableInfo.read(_db, "FAMILY_GROUP");
        if (! _infoFAMILYGROUP.equals(_existingFAMILYGROUP)) {
          throw new IllegalStateException("Migration didn't properly handle FAMILY_GROUP(com.itg.calderysapp.db.table.TblFamilyGroup).\n"
                  + " Expected:\n" + _infoFAMILYGROUP + "\n"
                  + " Found:\n" + _existingFAMILYGROUP);
        }
      }
    }, "80a13a96f2022ff1d55972bb73cb3932", "1c4f3368c6f2b75c6a4c40f707c69170");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "PRODUCT_TYPE","FAMILY_GROUP");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `PRODUCT_TYPE`");
      _db.execSQL("DELETE FROM `FAMILY_GROUP`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public DaoProductType daoProductType() {
    if (_daoProductType != null) {
      return _daoProductType;
    } else {
      synchronized(this) {
        if(_daoProductType == null) {
          _daoProductType = new DaoProductType_Impl(this);
        }
        return _daoProductType;
      }
    }
  }

  @Override
  public DaoFamilyGroup duoFamilyGroup() {
    if (_daoFamilyGroup != null) {
      return _daoFamilyGroup;
    } else {
      synchronized(this) {
        if(_daoFamilyGroup == null) {
          _daoFamilyGroup = new DaoFamilyGroup_Impl(this);
        }
        return _daoFamilyGroup;
      }
    }
  }
}
