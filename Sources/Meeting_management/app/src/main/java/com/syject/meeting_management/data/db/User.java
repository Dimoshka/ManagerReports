package com.syject.meeting_management.data.db;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by dimoshka on 19.06.15.
 */
@DatabaseTable()
public class User {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(canBeNull = false, dataType = DataType.STRING, unique = true)
    public String name;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    public UserGroup userGroup;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    public Meeting meeting;

    @ForeignCollectionField(eager = false)
    public ForeignCollection<Phone> phones;

    @ForeignCollectionField(eager = false)
    public ForeignCollection<UserSpeech> userSpeeches;

    public User() {

    }

    public User(String name, UserGroup userGroup, Meeting meeting) {
        this.name = name;
        this.userGroup = userGroup;
        this.meeting = meeting;
    }
}