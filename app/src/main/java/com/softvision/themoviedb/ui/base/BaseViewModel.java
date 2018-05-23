package com.softvision.themoviedb.ui.base;

import android.arch.lifecycle.*;
import android.databinding.*;

import com.softvision.themoviedb.data.*;
import com.softvision.themoviedb.utils.rx.*;

import io.reactivex.disposables.*;


public abstract class BaseViewModel< N > extends ViewModel {
    private final ObservableBoolean mIsLoading = new ObservableBoolean( false );
    private final ObservableBoolean mIsTabLayoutRequired = new ObservableBoolean( false );

    private DataManager mDataManager;
    private SchedulerProvider mSchedulerProvider;
    private N mNavigator;
    private CompositeDisposable mCompositeDisposable;


    public BaseViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable( );
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set( isLoading );
    }
    public ObservableBoolean getIsTabLayoutRequired() {
        return mIsTabLayoutRequired;
    }

    public void setIsTabLayoutRequired(boolean isLoading) {
        mIsTabLayoutRequired.set( isLoading );
    }


    public N getNavigator() {
        return mNavigator;
    }

    public void setNavigator(N mNavigator) {
        this.mNavigator = mNavigator;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose( );
        super.onCleared( );
    }
}
