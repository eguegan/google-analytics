package com.example.analyticssimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivityTAG_";

    private static final String SCREEN_NAME = "MainActivity";

    private Tracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App application = (App) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d(TAG, "Setting screen name: " + SCREEN_NAME);
        mTracker.setScreenName("Image~" + SCREEN_NAME);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onResume() {
        super.onResume();

        mTracker.send(new HitBuilders.EventBuilder()
                .setCategory("Action")
                .setAction("onResume")
                .build());
    }
}
