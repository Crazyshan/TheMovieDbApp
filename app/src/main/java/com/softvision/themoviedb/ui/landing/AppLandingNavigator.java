package com.softvision.themoviedb.ui.landing;

public interface AppLandingNavigator {

   void onLoadFragment(String tag);

    void showMessage(String message);

    void lockDrawer();

    void setNavigationMenu();

    void setUpToolBar();

    void initNavigation();


}
