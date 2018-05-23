package com.softvision.themoviedb.data.local.prefs;

import android.content.*;

import com.softvision.themoviedb.di.scope.*;

import javax.inject.*;

public class AppPreferencesHelper implements PreferencesHelper {

    private static final String PREF_KEY_TOKEN = "TOKEN";
    private static final String PREF_KEY_NAME="NAME";
    private static final String PREF_KEY_EMAIL="EMAIL";
    private static final String PREF_KEY_SESSION="SESSION";



    private final SharedPreferences mPrefs;

    @Override
    public String getAppTokenId() {
        return mPrefs.getString(PREF_KEY_TOKEN, "");
    }

    @Override
    public void setAppTokenId(String token) {
        mPrefs.edit().putString( PREF_KEY_TOKEN,token ).apply();

    }

    @Override
    public String getAppSessionId() {
        return mPrefs.getString(PREF_KEY_SESSION, "");
    }

    @Override
    public void setAppSessionId(String sessionId) {
        mPrefs.edit().putString( PREF_KEY_SESSION,sessionId ).apply();
    }

    @Override
    public String getUserName() {
        return mPrefs.getString(PREF_KEY_NAME,null  );
    }

    @Override
    public void setUserEmail(String email) {
        mPrefs.edit().putString( PREF_KEY_EMAIL,email ).apply();
    }

    @Override
    public String getUserEmail() {
        return mPrefs.getString(PREF_KEY_EMAIL,null  );
    }

    @Override
    public void setUserName(String name) {

        mPrefs.edit().putString( PREF_KEY_NAME,name ).apply();
    }

    @Inject
    public AppPreferencesHelper(@ApplicationContext Context context, @PreferenceInfo String prefFileName){
           mPrefs = context.getSharedPreferences( prefFileName,Context.MODE_PRIVATE );
    }




}
