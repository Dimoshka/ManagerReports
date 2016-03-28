package com.syject.meeting_management.data.dao;

import android.database.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.syject.meeting_management.data.db.Speech;

/**
 * Created by dimoshka on 19.06.15.
 */
public class SpeechDAO extends BaseDaoImpl<Speech, Integer> {

    public SpeechDAO(ConnectionSource connectionSource,
                     Class<Speech> dataClass) throws SQLException, java.sql.SQLException {
        super(connectionSource, dataClass);
    }


}
