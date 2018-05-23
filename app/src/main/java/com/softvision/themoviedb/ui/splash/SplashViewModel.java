package com.softvision.themoviedb.ui.splash;

import com.softvision.themoviedb.data.*;
import com.softvision.themoviedb.ui.base.*;
import com.softvision.themoviedb.utils.rx.*;

public class SplashViewModel extends BaseViewModel<SplashNavigator> {

    public SplashViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super( dataManager, schedulerProvider );
    }

    public void openLoginActivity() {
        getNavigator().openLoginActivity();
    }


}
