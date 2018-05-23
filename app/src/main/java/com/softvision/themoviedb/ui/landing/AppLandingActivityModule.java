package com.softvision.themoviedb.ui.landing;

import android.arch.lifecycle.*;

import com.softvision.themoviedb.*;
import com.softvision.themoviedb.data.*;
import com.softvision.themoviedb.utils.rx.*;

import dagger.*;

@Module
public class AppLandingActivityModule {

    @Provides
    ViewModelProvider.Factory mainViewModelProvider(AppLandingModelView appLandingModelView) {
        return new ViewModelProviderFactory<>(appLandingModelView);
    }

    @Provides
    static AppLandingModelView providesLandingModelView(DataManager dataManager, SchedulerProvider schedulerProvider){

        return new AppLandingModelView( dataManager,schedulerProvider ) ;
    }
}
