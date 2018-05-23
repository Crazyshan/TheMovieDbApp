package com.softvision.themoviedb.ui.login;

import com.softvision.themoviedb.data.*;
import com.softvision.themoviedb.utils.rx.*;

import dagger.*;

@Module
public abstract class LoginActivityModule {
    @Provides
    static LoginViewModel providesLoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new LoginViewModel(dataManager,schedulerProvider);
    }
}
