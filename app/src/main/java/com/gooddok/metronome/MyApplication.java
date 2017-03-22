package com.gooddok.metronome;

import android.app.Application;
import android.content.Context;

/**
 * Created by Константин on 22.03.2017.
 */

public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }

}
