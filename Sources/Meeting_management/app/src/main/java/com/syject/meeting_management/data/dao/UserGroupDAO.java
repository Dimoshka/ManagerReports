package com.syject.meeting_management.data.dao;

import android.database.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.syject.meeting_management.data.db.UserGroup;

/**
 * Created by dimoshka on 19.06.15.
 */
public class UserGroupDAO extends BaseDaoImpl<UserGroup, Integer> {

    public UserGroupDAO(ConnectionSource connectionSource,
                        Class<UserGroup> dataClass) throws SQLException, java.sql.SQLException {
        super(connectionSource, dataClass);
    }


}
