package com.syject.meeting_management.data.db;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by dimoshka on 19.06.15.
 */
@DatabaseTable()
public class Speech {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(canBeNull = false, dataType = DataType.INTEGER, unique = true)
    public int number;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING, unique = true)
    public String name;

    public Speech() {

    }

    public Speech(int number, String name) {
        this.number = number;
        this.name = name;
    }
}