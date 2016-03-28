package com.syject.meeting_management.data.dao;

import android.database.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.syject.meeting_management.data.db.City;
import com.syject.meeting_management.data.db.Meeting;

/**
 * Created by dimoshka on 19.06.15.
 */
public class CityDAO extends BaseDaoImpl<City, Integer> {

    public CityDAO(ConnectionSource connectionSource,
                   Class<City> dataClass) throws SQLException, java.sql.SQLException {
        super(connectionSource, dataClass);
    }


}
