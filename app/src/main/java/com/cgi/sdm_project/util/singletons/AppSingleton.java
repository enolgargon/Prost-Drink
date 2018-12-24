package com.cgi.sdm_project.util.singletons;

import android.app.Application;
import android.content.Context;

public class AppSingleton extends Application {
    private static  AppSingleton app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static AppSingleton getInstance() {
        return app;
    }

    public Context getContext(){
        return app.getApplicationContext();
    }
}
