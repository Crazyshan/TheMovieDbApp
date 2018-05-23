package com.softvision.themoviedb;

import android.app.*;
import android.support.multidex.*;

import com.facebook.stetho.*;
import com.softvision.themoviedb.di.component.*;
import com.softvision.themoviedb.utils.*;

import javax.inject.*;

import dagger.android.*;
import uk.co.chrisjenx.calligraphy.*;

public class TheMovieDbApplication extends MultiDexApplication implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    @Inject
    CalligraphyConfig mCalligraphyConfig;
    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
        Stetho.initializeWithDefaults(this);
        AppLogger.init();
      /*  AndroidNetworking.initialize(getApplicationContext());
        if ( BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }*/

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }
}
