package com.syject.managerreports.data.dao;

import android.database.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.syject.managerreports.data.db.Meeting;
import com.syject.managerreports.data.db.User;

/**
 * Created by dimoshka on 19.06.15.
 */
public class MeetingDAO extends BaseDaoImpl<Meeting, Integer> {

    public MeetingDAO(ConnectionSource connectionSource,
                      Class<Meeting> dataClass) throws SQLException, java.sql.SQLException {
        super(connectionSource, dataClass);
    }


}
