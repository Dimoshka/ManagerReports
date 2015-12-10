package com.syject.managerreports.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.j256.ormlite.dao.ForeignCollection;
import com.syject.managerreports.R;
import com.syject.managerreports.data.db.Meeting;
import com.syject.managerreports.data.db.Phone;
import com.syject.managerreports.data.db.Report;
import com.syject.managerreports.data.db.ReportHistory;
import com.syject.managerreports.data.db.User;
import com.syject.managerreports.data.db.UserGroup;
import com.syject.managerreports.helper.DbHelperFactory;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends BaseActivity implements listFragment.OnListFragmentInteractionListener {

    private static final String Fragment_Tag = "CurrentHomeFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        try {

            UserGroup usergroup = new UserGroup("Служебный помошник");
            DbHelperFactory.getHelper().getUserGroupDAO().create(usergroup);

            Meeting meeting = new Meeting("Сосновая горка");
            DbHelperFactory.getHelper().getMeetingDAO().create(meeting);

            Report report = new Report(103, "Ты найдёшь радость в служении Богу.");
            DbHelperFactory.getHelper().getReportDAO().create(report);

            User user = new User("Прилуцкий Дмитрий", usergroup, meeting);
            DbHelperFactory.getHelper().getUserDAO().create(user);

            ReportHistory reportHistory = new ReportHistory();
            Calendar calendar = Calendar.getInstance();
            reportHistory.date=calendar.getTime();
            reportHistory.report=report;
            reportHistory.user = user;
            DbHelperFactory.getHelper().getReportHistoryDAO().create(reportHistory);

            Phone phone = new Phone();
            phone.phone="+380961917060";
            phone.user=user;
            DbHelperFactory.getHelper().getPhoneDAO().create(phone);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        switchFragment(listFragment.newInstance(0));

    }

    @OptionsItem(R.id.action_settings)
    void settings_menuItem_click() {

    }

    public void switchFragment(Fragment fragment) {
        switchFragmentInternal(fragment, true);
    }

    private void switchFragmentInternal(Fragment fragment, boolean addToBackStack) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.container, fragment, Fragment_Tag);

        if(addToBackStack)
            fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

}
