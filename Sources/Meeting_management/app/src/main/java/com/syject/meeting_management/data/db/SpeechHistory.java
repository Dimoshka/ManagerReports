package com.syject.meeting_management.data.db;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by dimoshka on 19.06.15.
 */
@DatabaseTable()
public class SpeechHistory {

    @DatabaseField(generatedId = true)
    public int id;

    @DatabaseField(canBeNull = false, dataType = DataType.DATE)
    public Date date;

    @DatabaseField(canBeNull = false, foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true)
    public UserSpeech userSpeech;

    public SpeechHistory() {

    }

    public SpeechHistory(Date date, UserSpeech userSpeech) {
        this.date = date;
        this.userSpeech = userSpeech;
    }
}