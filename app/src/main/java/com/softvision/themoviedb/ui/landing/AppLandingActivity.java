package com.softvision.themoviedb.ui.landing;

import android.arch.lifecycle.*;
import android.content.*;
import android.databinding.*;
import android.os.*;
import android.support.annotation.*;
import android.support.design.widget.*;
import android.support.v4.app.*;
import android.support.v4.view.*;
import android.support.v4.widget.*;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.*;
import android.view.*;

import com.softvision.themoviedb.*;
import com.softvision.themoviedb.BuildConfig;
import com.softvision.themoviedb.R;
import com.softvision.themoviedb.databinding.*;
import com.softvision.themoviedb.ui.base.*;

import javax.inject.*;

import dagger.android.*;

public class AppLandingActivity extends BaseActivity< ActivityAppLandingBinding,
        AppLandingModelView > implements AppLandingNavigator {

    @Inject
    DispatchingAndroidInjector< Fragment > fragmentDispatchingAndroidInjector;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    private AppLandingModelView mAppLandingModelView;
    private ActivityAppLandingBinding mActivityAppLandingBinding;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent( context, AppLandingActivity.class );
        intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_NEW_TASK );
        return intent;
    }

    @Override
    public int getBindingVariable() {
        return BR.appLandingViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.app_landing_layout;
    }

    @Override
    public AppLandingModelView getViewModel() {
        mAppLandingModelView = ViewModelProviders.of( this, mViewModelFactory ).get(
                AppLandingModelView.class );
        return mAppLandingModelView;
    }

    @Override
    public void intiBinding() {
        mDrawerLayout = mActivityAppLandingBinding.drawerLayout;
        mNavigationView = mActivityAppLandingBinding.navigationView;
        mToolbar = mActivityAppLandingBinding.included.toolbar;
        setUpToolBar( );
        initNavigation( );
        setNavigationMenu( );

        String version = getString( R.string.version ) + " " + BuildConfig.VERSION_NAME;
        mAppLandingModelView.updateAppVersion( version );
        mAppLandingModelView.onNavMenuCreated( );


    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

    }



    @Override
    public void onLoadFragment(String tag) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void lockDrawer() {
        if ( mDrawerLayout != null ) {
            mDrawerLayout.setDrawerLockMode( DrawerLayout.LOCK_MODE_LOCKED_CLOSED );
        }
    }

    @Override
    public void setNavigationMenu() {
        NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate( getLayoutInflater( ),
                R.layout.app_nav_drawer, mActivityAppLandingBinding.navigationView, false );
        mActivityAppLandingBinding.navigationView.addHeaderView( navHeaderMainBinding.getRoot( ) );
        navHeaderMainBinding.setAppLandingViewModel( mAppLandingModelView );

        mNavigationView.setNavigationItemSelectedListener(
                item -> {
                    mDrawerLayout.closeDrawer( GravityCompat.START );
                    switch ( item.getItemId( ) ) {
                        case R.id.navItemDiscover:
                            // showAboutFragment();
                            return true;
                        case R.id.navItemMovie:
                            // RateUsDialog.newInstance().show(getSupportFragmentManager());
                            return true;
                        case R.id.navItemTvShows:
                            //  startActivity(FeedActivity.newIntent(MainActivity.this));
                            return true;
                        case R.id.navItemPeople:
                            // mMainViewModel.logout();
                            return true;
                        default:
                            return false;
                    }
                } );
    }

    @Override
    public void setUpToolBar() {
        if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ) {
            updateToolBar( mToolbar, mActivityAppLandingBinding.included.toolbarTitle, "", false );
        }

    }

    @Override
    public void initNavigation() {
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.open_drawer,
                R.string.close_drawer ) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed( drawerView );
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened( drawerView );
                hideKeyboard( );
            }
        };
        mDrawerLayout.addDrawerListener( mDrawerToggle );
        mDrawerToggle.syncState( );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed( );
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mActivityAppLandingBinding = getViewDataBinding( );
        mAppLandingModelView.setNavigator( this );
        intiBinding( );
    }

    @Override
    protected void onResume() {
        super.onResume( );
        if ( mDrawerLayout != null ) {
            mDrawerLayout.setDrawerLockMode( DrawerLayout.LOCK_MODE_UNLOCKED );
        }
    }
}
