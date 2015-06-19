package com.syject.managerreports.app;

import com.syject.managerreports.helper.DbHelperFactory;
import com.syject.managerreports.manager.AnalyticsTrackers;
import com.syject.managerreports.properties.Preferences_;

import org.androidannotations.annotations.EApplication;
import org.androidannotations.annotations.sharedpreferences.Pref;

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
