package com.syject.managerreports.data.db;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dimoshka on 19.06.15.
 */
@DatabaseTable()
public class User {

    @DatabaseField(generatedId = true)
    public int Id;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING)
    public String name;

    @DatabaseField(canBeNull = false, foreign = true)
    public UserGroup userGroup;

    @DatabaseField(canBeNull = false, foreign = true)
    public Meeting meeting;

    @DatabaseField(canBeNull = false, foreign = true)
    public ArrayList<Phone> phoneArrayList;

    @DatabaseField(foreign = true)
    public ArrayList<Report> reportArrayList;

    public User() {

    }
}