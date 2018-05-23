package com.softvision.themoviedb.di.module;

import android.app.*;
import android.content.*;

import com.google.gson.*;
import com.softvision.themoviedb.data.*;
import com.softvision.themoviedb.data.local.prefs.*;
import com.softvision.themoviedb.data.remote.*;
import com.softvision.themoviedb.di.scope.*;
import com.softvision.themoviedb.utils.*;
import com.softvision.themoviedb.utils.rx.*;

import javax.inject.*;

import dagger.*;
import uk.co.chrisjenx.calligraphy.*;

@Module
public class AppModule {

    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder( )
                .setDefaultFontPath( "fonts/source-sans-pro/SourceSansPro-Regular.ttf" )
                .setFontAttrId( R.attr.fontPath )
                .build( );
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @PreferenceInfo
    String providesPreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providesPreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;

    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder( ).excludeFieldsWithoutExposeAnnotation( ).create( );
    }

    @Provides
    SchedulerProvider providesSchedulerProvider() {
        return new AppSchedulerProvider( );
    }

    @Provides
    @Singleton
    DataManager providesDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    ClientModuleImplement providesClientModuleImplement() {
        return new ClientModule( );
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }


}
