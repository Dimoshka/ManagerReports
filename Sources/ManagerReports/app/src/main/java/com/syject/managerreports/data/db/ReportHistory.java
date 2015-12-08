package com.syject.managerreports.data.db;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by dimoshka on 19.06.15.
 */
@DatabaseTable()
public class ReportHistory {

    @DatabaseField(generatedId = true)
    public int Id;

    @DatabaseField(canBeNull = false, dataType = DataType.DATE)
    public Date date;

    @DatabaseField(canBeNull = false, foreign = true)
    public User user;

    @DatabaseField(canBeNull = false, foreign = true)
    public Report report;

    public ReportHistory() {

    }
}