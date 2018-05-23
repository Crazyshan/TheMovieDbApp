package com.softvision.themoviedb.ui.login;

public interface LoginNavigator {
    void tokenRequest();

    void onLoginSuccess();

    void handleError(Throwable throwable);



}
