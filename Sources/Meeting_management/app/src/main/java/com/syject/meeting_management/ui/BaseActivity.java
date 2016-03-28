package com.syject.meeting_management.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.splunk.mint.Mint;
import com.syject.meeting_management.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean useReleaseSplunkMint = getResources().getBoolean(R.bool.useReleaseSplunkMint);
        if (useReleaseSplunkMint) {
            Mint.initAndStartSession(BaseActivity.this, "0c074c20"); // release splunk
        } else {
            Mint.initAndStartSession(BaseActivity.this, "ecb523a5"); // debug splunk
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }


        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}
