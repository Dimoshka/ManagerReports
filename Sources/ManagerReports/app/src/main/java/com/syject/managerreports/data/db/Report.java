package com.syject.managerreports.data.db;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by dimoshka on 19.06.15.
 */
@DatabaseTable()
public class Report {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(canBeNull = false, dataType = DataType.INTEGER)
    public int number;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING)
    public String name;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    public User user;

    public Report() {

    }

    public Report(int number, String name) {
        this.number=number;
        this.name=name;
    }
}