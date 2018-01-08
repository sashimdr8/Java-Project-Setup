package com.dharmasun.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import javax.inject.Singleton;

/**
 * Created by brain on 10/10/17.
 */

@Singleton
public class AppPrefs {
    private final SharedPreferences sharedPreferences;
    private SharedPreferences fcmPrefs;

    private Context app;
    private Gson gson;

    private static final String SHARED_FCM_PREFERENCE = "FcmPreference";


    public AppPrefs(Context app, Gson gson) {
        this.app = app;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(app);
        fcmPrefs = app.getSharedPreferences(SHARED_FCM_PREFERENCE, Context.MODE_PRIVATE);
        this.gson = gson;
    }
}
