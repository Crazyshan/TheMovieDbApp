package com.softvision.themoviedb.di.component;

import android.app.*;

import com.softvision.themoviedb.*;
import com.softvision.themoviedb.di.builder.*;
import com.softvision.themoviedb.di.module.*;

import javax.inject.*;

import dagger.*;
import dagger.android.*;
import dagger.android.DaggerApplication;
import dagger.android.support.*;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,AppModule.class,ActivityBuilder.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    void inject(TheMovieDbApplication app);
    @Override
    void inject(DaggerApplication instance);
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}
