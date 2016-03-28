package com.syject.meeting_management.app;

import com.syject.meeting_management.helper.DbHelperFactory;
import com.syject.meeting_management.manager.AnalyticsTrackers;

import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.sharedpreferences.Pref;

import com.syject.meeting_management.properties.Preferences_;

@EApplication
public class Application extends android.app.Application {

    @Pref
    Preferences_ preferences;

    public Application() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        AnalyticsTrackers.initialize(getApplicationContext());
        DbHelperFactory.setHelper(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        DbHelperFactory.releaseHelper();
        super.onTerminate();
    }

}
