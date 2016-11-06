package org.changs.campus.mobile.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by yincs on 2016/11/5.
 */

public class MyApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }


    static Context getContext() {
        return context;
    }
}
