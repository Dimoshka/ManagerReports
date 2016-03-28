package com.syject.meeting_management.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.syject.meeting_management.R;
import com.syject.meeting_management.data.db.City;
import com.syject.meeting_management.data.db.Meeting;
import com.syject.meeting_management.data.db.Phone;
import com.syject.meeting_management.data.db.Speech;
import com.syject.meeting_management.data.db.SpeechHistory;
import com.syject.meeting_management.data.db.User;
import com.syject.meeting_management.data.db.UserGroup;
import com.syject.meeting_management.data.db.UserSpeech;
import com.syject.meeting_management.helper.DbHelperFactory;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;

import java.sql.SQLException;
import java.util.Calendar;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends BaseActivity implements SpeechListFragment.OnListFragmentInteractionListener {

    private static final String Fragment_Tag = "CurrentHomeFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        try {

            UserGroup usergroup = new UserGroup("Служебный помошник");
            DbHelperFactory.getHelper().getUserGroupDAO().create(usergroup);



            Meeting meeting = new Meeting("Сосновая горка", new City("Харьков"));
            DbHelperFactory.getHelper().getMeetingDAO().create(meeting);

            Speech speech = new Speech(103, "Ты найдёшь радость в служении Богу.");
            DbHelperFactory.getHelper().getSpeechDAO().create(speech);

            User user = new User("Прилуцкий Дмитрий", usergroup, meeting);
            DbHelperFactory.getHelper().getUserDAO().create(user);

            UserSpeech userSpeech = new UserSpeech(user, speech);
            DbHelperFactory.getHelper().getUserSpeechDAO().create(userSpeech);


            Calendar calendar = Calendar.getInstance();
            SpeechHistory speechHistory = new SpeechHistory(calendar.getTime(), userSpeech);
            DbHelperFactory.getHelper().getSpeechHistoryDAO().create(speechHistory);

            Phone phone = new Phone();
            phone.phone = "+380961917060";
            phone.user = user;
            DbHelperFactory.getHelper().getPhoneDAO().create(phone);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        switchFragment(SpeechListFragment.newInstance());

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

        if (addToBackStack)
            fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }


    @Override
    public void onListFragmentInteraction(SpeechHistory mItem) {

    }
}
