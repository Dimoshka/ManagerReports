package com.syject.managerreports.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.syject.managerreports.data.dao.UserDAO;
import com.syject.managerreports.data.dao.UserGroupDAO;
import com.syject.managerreports.data.db.User;
import com.syject.managerreports.data.db.UserGroup;

/**
 * Created by dimoshka on 19.06.15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "managerreports.sqlite";
    private static final int DATABASE_VERSION = 1;

    //ссылки на DAO соответсвующие сущностям, хранимым в БД
    private UserDAO userDao = null;
    private UserGroupDAO usergroupDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Выполняется, когда файл с БД не найден на устройстве
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, UserGroup.class);
            TableUtils.createTable(connectionSource, User.class);
        } catch (SQLException e) {
            Log.e(TAG, "error creating DB " + DATABASE_NAME);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    //Выполняется, когда БД имеет версию отличную от текущей
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer, int newVer) {
        try {
            TableUtils.dropTable(connectionSource, UserGroup.class, true);
            TableUtils.dropTable(connectionSource, User.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(TAG, "error upgrading db " + DATABASE_NAME + "from ver " + oldVer);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDAO getUserDAO() throws SQLException, java.sql.SQLException {
        if (userDao == null) {
            userDao = new UserDAO(getConnectionSource(), User.class);
        }
        return userDao;
    }

    public UserGroupDAO getUserGroupDAO() throws SQLException, java.sql.SQLException {
        if (usergroupDao == null) {
            usergroupDao = new UserGroupDAO(getConnectionSource(), UserGroup.class);
        }
        return usergroupDao;
    }


    @Override
    public void close() {
        super.close();
        userDao = null;
    }
}
