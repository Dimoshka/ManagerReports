package com.syject.managerreports.data.db;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by dimoshka on 19.06.15.
 */
@DatabaseTable(tableName = "user")
public class User {

    public final static String USER_NAME_FIELD_NAME = "name";

    @DatabaseField(generatedId = true)
    private int Id;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING, columnName = USER_NAME_FIELD_NAME)
    private String name;

    @DatabaseField(dataType = DataType.DATE)
    private Date lastEditDate;

    @DatabaseField()
    private UserGroup userGroup;

    public User() {

    }
}