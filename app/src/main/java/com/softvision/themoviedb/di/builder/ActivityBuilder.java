package com.softvision.themoviedb.di.builder;

import com.softvision.themoviedb.ui.landing.*;
import com.softvision.themoviedb.ui.login.*;
import com.softvision.themoviedb.ui.splash.*;

import dagger.*;
import dagger.android.*;

@Module
public abstract class ActivityBuilder {
   /* @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {DetailActivityModule.class, DetailFragmentProvider.class})
    abstract com.softvision.themoviedb.ui.detail.DetailActivity bindDetailActivity();*/

    @ContributesAndroidInjector(modules = SplashActivityModule.class)
    abstract SplashActivity bindSplashActivity();

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {AppLandingActivityModule.class})
    abstract AppLandingActivity bindDetailActivity();

}

