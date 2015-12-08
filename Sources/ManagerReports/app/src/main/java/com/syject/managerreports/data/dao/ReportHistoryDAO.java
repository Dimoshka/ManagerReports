package com.syject.managerreports.data.dao;

import android.database.SQLException;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.syject.managerreports.data.db.ReportHistory;
import com.syject.managerreports.data.db.User;

/**
 * Created by dimoshka on 19.06.15.
 */
public class ReportHistoryDAO extends BaseDaoImpl<ReportHistory, Integer> {

    public ReportHistoryDAO(ConnectionSource connectionSource,
                            Class<ReportHistory> dataClass) throws SQLException, java.sql.SQLException {
        super(connectionSource, dataClass);
    }


}