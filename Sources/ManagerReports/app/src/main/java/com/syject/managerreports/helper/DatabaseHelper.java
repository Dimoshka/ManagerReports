package com.syject.managerreports.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.syject.managerreports.data.dao.MeetingDAO;
import com.syject.managerreports.data.dao.PhoneDAO;
import com.syject.managerreports.data.dao.ReportDAO;
import com.syject.managerreports.data.dao.ReportHistoryDAO;
import com.syject.managerreports.data.dao.UserDAO;
import com.syject.managerreports.data.dao.UserGroupDAO;
import com.syject.managerreports.data.db.Meeting;
import com.syject.managerreports.data.db.Phone;
import com.syject.managerreports.data.db.Report;
import com.syject.managerreports.data.db.ReportHistory;
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
    private MeetingDAO meetingDao = null;
    private PhoneDAO phoneDao = null;
    private ReportDAO reportDao = null;
    private ReportHistoryDAO reportHistoryDao = null;
    private UserDAO userDao = null;
    private UserGroupDAO usergroupDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Выполняется, когда файл с БД не найден на устройстве
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, Meeting.class);
            TableUtils.createTable(connectionSource, Phone.class);
            TableUtils.createTable(connectionSource, Report.class);
            TableUtils.createTable(connectionSource, ReportHistory.class);
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
            TableUtils.dropTable(connectionSource, Meeting.class, true);
            TableUtils.dropTable(connectionSource, Phone.class, true);
            TableUtils.dropTable(connectionSource, Report.class, true);
            TableUtils.dropTable(connectionSource, ReportHistory.class, true);
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

    public MeetingDAO getMeetingDAO() throws SQLException, java.sql.SQLException {
        if (meetingDao == null) {
            meetingDao = new MeetingDAO(getConnectionSource(), Meeting.class);
        }
        return meetingDao;
    }

    public PhoneDAO getPhoneDAO() throws SQLException, java.sql.SQLException {
        if (phoneDao == null) {
            phoneDao = new PhoneDAO(getConnectionSource(), Phone.class);
        }
        return phoneDao;
    }

    public ReportDAO getReportDAO() throws SQLException, java.sql.SQLException {
        if (reportDao == null) {
            reportDao = new ReportDAO(getConnectionSource(), Report.class);
        }
        return reportDao;
    }

    public ReportHistoryDAO getReportHistoryDAO() throws SQLException, java.sql.SQLException {
        if (reportHistoryDao == null) {
            reportHistoryDao = new ReportHistoryDAO(getConnectionSource(), ReportHistory.class);
        }
        return reportHistoryDao;
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
        meetingDao = null;
        phoneDao = null;
        reportDao = null;
        reportHistoryDao = null;
        userDao = null;
        usergroupDao = null;
    }
}
