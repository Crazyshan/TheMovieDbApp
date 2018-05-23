package com.softvision.themoviedb.ui.splash;

import com.softvision.themoviedb.data.*;
import com.softvision.themoviedb.utils.rx.*;

import dagger.*;

@Module
public abstract class SplashActivityModule {

    @Provides
    static SplashViewModel providesSplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider ){
        return new SplashViewModel(dataManager,schedulerProvider);
    }
}
