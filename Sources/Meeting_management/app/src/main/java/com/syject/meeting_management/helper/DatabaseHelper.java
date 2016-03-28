package com.syject.meeting_management.helper;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.syject.meeting_management.data.dao.CityDAO;
import com.syject.meeting_management.data.dao.MeetingDAO;
import com.syject.meeting_management.data.dao.PhoneDAO;
import com.syject.meeting_management.data.dao.SpeechDAO;
import com.syject.meeting_management.data.dao.SpeechHistoryDAO;
import com.syject.meeting_management.data.dao.UserDAO;
import com.syject.meeting_management.data.dao.UserGroupDAO;
import com.syject.meeting_management.data.dao.UserSpeechDAO;
import com.syject.meeting_management.data.db.City;
import com.syject.meeting_management.data.db.Meeting;
import com.syject.meeting_management.data.db.Phone;
import com.syject.meeting_management.data.db.Speech;
import com.syject.meeting_management.data.db.SpeechHistory;
import com.syject.meeting_management.data.db.User;
import com.syject.meeting_management.data.db.UserGroup;
import com.syject.meeting_management.data.db.UserSpeech;

/**
 * Created by dimoshka on 19.06.15.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "managerreports.sqlite";
    private static final int DATABASE_VERSION = 1;

    //ссылки на DAO соответсвующие сущностям, хранимым в БД
    private CityDAO cityDAO = null;
    private MeetingDAO meetingDAO = null;
    private PhoneDAO phoneDAO = null;
    private SpeechDAO speechDAO = null;
    private SpeechHistoryDAO speechHistoryDAO = null;
    private UserDAO userDAO = null;
    private UserGroupDAO userGroupDAO = null;
    private UserSpeechDAO userSpeechDAO = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Выполняется, когда файл с БД не найден на устройстве
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, City.class);
            TableUtils.createTable(connectionSource, Speech.class);
            TableUtils.createTable(connectionSource, Meeting.class);
            TableUtils.createTable(connectionSource, UserGroup.class);
            TableUtils.createTable(connectionSource, Phone.class);
            TableUtils.createTable(connectionSource, User.class);
            TableUtils.createTable(connectionSource, UserSpeech.class);
            TableUtils.createTable(connectionSource, SpeechHistory.class);
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
            TableUtils.dropTable(connectionSource, City.class, true);
            TableUtils.dropTable(connectionSource, Meeting.class, true);
            TableUtils.dropTable(connectionSource, Phone.class, true);
            TableUtils.dropTable(connectionSource, Speech.class, true);
            TableUtils.dropTable(connectionSource, SpeechHistory.class, true);
            TableUtils.dropTable(connectionSource, UserGroup.class, true);
            TableUtils.dropTable(connectionSource, User.class, true);
            TableUtils.dropTable(connectionSource, UserSpeech.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(TAG, "error upgrading db " + DATABASE_NAME + "from ver " + oldVer);
            throw new RuntimeException(e);
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public CityDAO getCityDAO() throws SQLException, java.sql.SQLException {
        if (cityDAO == null) {
            cityDAO = new CityDAO(getConnectionSource(), City.class);
        }
        return cityDAO;
    }

    public MeetingDAO getMeetingDAO() throws SQLException, java.sql.SQLException {
        if (meetingDAO == null) {
            meetingDAO = new MeetingDAO(getConnectionSource(), Meeting.class);
        }
        return meetingDAO;
    }

    public PhoneDAO getPhoneDAO() throws SQLException, java.sql.SQLException {
        if (phoneDAO == null) {
            phoneDAO = new PhoneDAO(getConnectionSource(), Phone.class);
        }
        return phoneDAO;
    }

    public SpeechDAO getSpeechDAO() throws SQLException, java.sql.SQLException {
        if (speechDAO == null) {
            speechDAO = new SpeechDAO(getConnectionSource(), Speech.class);
        }
        return speechDAO;
    }

    public SpeechHistoryDAO getSpeechHistoryDAO() throws SQLException, java.sql.SQLException {
        if (speechHistoryDAO == null) {
            speechHistoryDAO = new SpeechHistoryDAO(getConnectionSource(), SpeechHistory.class);
        }
        return speechHistoryDAO;
    }

    public UserDAO getUserDAO() throws SQLException, java.sql.SQLException {
        if (userDAO == null) {
            userDAO = new UserDAO(getConnectionSource(), User.class);
        }
        return userDAO;
    }

    public UserGroupDAO getUserGroupDAO() throws SQLException, java.sql.SQLException {
        if (userGroupDAO == null) {
            userGroupDAO = new UserGroupDAO(getConnectionSource(), UserGroup.class);
        }
        return userGroupDAO;
    }

    public UserSpeechDAO getUserSpeechDAO() throws SQLException, java.sql.SQLException {
        if (userSpeechDAO == null) {
            userSpeechDAO = new UserSpeechDAO(getConnectionSource(), UserSpeech.class);
        }
        return userSpeechDAO;
    }


    @Override
    public void close() {
        super.close();
        cityDAO = null;
        meetingDAO = null;
        phoneDAO = null;
        speechDAO = null;
        speechHistoryDAO = null;
        userDAO = null;
        userGroupDAO = null;
        userSpeechDAO = null;
    }
}
