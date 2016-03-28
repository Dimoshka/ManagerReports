package com.syject.meeting_management.data.db;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by dimoshka on 19.06.15.
 */
@DatabaseTable()
public class UserSpeech {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    public User user;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    public Speech speech;

    public UserSpeech() {

    }

    public UserSpeech(User user, Speech speech) {
        this.user = user;
        this.speech = speech;
    }
}