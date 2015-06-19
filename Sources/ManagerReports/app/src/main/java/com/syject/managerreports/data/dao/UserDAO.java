package com.syject.managerreports.data.dao;

import android.database.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.syject.managerreports.data.db.User;

import java.util.List;

/**
 * Created by dimoshka on 19.06.15.
 */
public class UserDAO extends BaseDaoImpl<User, Integer> {

    public UserDAO(ConnectionSource connectionSource,
                   Class<User> dataClass) throws SQLException, java.sql.SQLException {
        super(connectionSource, dataClass);
    }

    public List<User> getAllRoles() throws SQLException, java.sql.SQLException {
        return this.queryForAll();
    }

}
