package com.syject.meeting_management.data.db;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by dimoshka on 19.06.15.
 */
@DatabaseTable()
public class Meeting {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING, unique = true)
    public String name;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    public City city;

    public Meeting() {

    }

    public Meeting(String name, City city) {
        this.name = name;
        this.city = city;
    }
}