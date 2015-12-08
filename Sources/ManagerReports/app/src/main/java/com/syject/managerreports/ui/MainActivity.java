package com.syject.managerreports.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.syject.managerreports.R;
import com.syject.managerreports.data.db.User;
import com.syject.managerreports.data.db.UserGroup;
import com.syject.managerreports.helper.DbHelperFactory;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;

import java.sql.SQLException;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends BaseActivity {

    private static final String Fragment_Tag = "CurrentHomeFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        User user = new User();
        user.name="testname";
        UserGroup usergroup = new UserGroup();
        usergroup.name="test";
        user.userGroup=usergroup;

        try {
            DbHelperFactory.getHelper().getUserGroupDAO().create(usergroup);
            DbHelperFactory.getHelper().getUserDAO().create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
