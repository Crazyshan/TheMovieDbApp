package com.softvision.themoviedb.ui.splash;

import android.os.*;
import android.support.annotation.*;

import com.softvision.themoviedb.*;
import com.softvision.themoviedb.databinding.*;
import com.softvision.themoviedb.ui.base.*;
import com.softvision.themoviedb.ui.login.*;

import javax.inject.*;

public class SplashActivity extends BaseActivity< SplashActivityBinding, SplashViewModel >
        implements SplashNavigator {

    private static final long SPLASH_TIME_OUT = 5000;
    @Inject
    SplashViewModel mSplashViewModel;

    private SplashActivityBinding mSplashScreenBinding;

    @Override
    public int getBindingVariable() {
        return BR.splashview;
    }

    @Override
    public int getLayoutId() {
        return R.layout.splash_screen;
    }

    @Override
    public SplashViewModel getViewModel() {
        return mSplashViewModel;
    }

    @Override
    public void intiBinding() {
        mSplashScreenBinding = getViewDataBinding( );
        mSplashViewModel.setNavigator( this );
        mSplashViewModel.openLoginActivity( );
    }

    @Override
    public void openLoginActivity() {
            new Handler( ).postDelayed( new Runnable( ) {
                @Override
                public void run() {
                    startActivity( LoginActivity.newIntent( SplashActivity.this ) );
                    finish( );
                }
            }, SPLASH_TIME_OUT );


    }

    @Override
    public void openMainActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setTheme( R.style.AppTheme );
        super.onCreate( savedInstanceState );
        intiBinding();


    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        networkStatus( isConnected );
    }
}
