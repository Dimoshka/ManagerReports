package com.syject.meeting_management.data.dao;

import android.database.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.syject.meeting_management.data.db.Speech;
import com.syject.meeting_management.data.db.UserSpeech;

/**
 * Created by dimoshka on 19.06.15.
 */
public class UserSpeechDAO extends BaseDaoImpl<UserSpeech, Integer> {

    public UserSpeechDAO(ConnectionSource connectionSource,
                         Class<UserSpeech> dataClass) throws SQLException, java.sql.SQLException {
        super(connectionSource, dataClass);
    }


}
