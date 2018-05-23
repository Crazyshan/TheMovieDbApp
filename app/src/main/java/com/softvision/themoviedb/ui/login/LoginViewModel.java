package com.softvision.themoviedb.ui.login;

import android.annotation.*;
import android.text.*;

import com.softvision.themoviedb.data.*;
import com.softvision.themoviedb.data.model.auth.*;
import com.softvision.themoviedb.ui.base.*;
import com.softvision.themoviedb.utils.rx.*;

import java.util.*;

import io.reactivex.*;
import io.reactivex.functions.*;

public class LoginViewModel extends BaseViewModel< LoginNavigator > {

    private static final String TAG = "";

    public LoginViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super( dataManager, schedulerProvider );

    }

    public void doLogin() {
        getNavigator( ).tokenRequest( );
    }

    public boolean validateUserNameAndPassword(String userName, String passwordInput) {
        // validate email and password
        if ( TextUtils.isEmpty( userName ) ) {
            return false;
        }
       /* if ( !CommonUtils.isEmailVaild( emailInput ) ) {
            return false;
        }*/
        return !TextUtils.isEmpty( passwordInput );
    }

    @SuppressLint ( "NewApi" )
    public void getRequestToken(String userName, String password) {
        setIsLoading( true );
        getCompositeDisposable( )
                .add( getDataManager( )
                        .requestToken( )
                        .subscribeOn( getSchedulerProvider( ).computation( ) )
                        .filter( (response) -> response != null && response.getSuccess( ))
                        .doOnNext( response -> {
                            getDataManager( ).setAppTokenId( response.getRequestToken( ) );
                        } )
                        .flatMap( ( Function< RequestTokenResponse, ObservableSource<
                                LoginResponse > > ) response -> getDataManager( ).loginRequest( userName,
                                                password, response.getRequestToken( ) ) )
                        .filter( Objects::nonNull )
                        .doOnNext( loginResponse -> {
                            getDataManager( ).setUserName( userName );
                        } )
                        .flatMap( ( Function< LoginResponse, ObservableSource< SessionResponse >
                                > ) loginResponse -> getDataManager( )
                                        .createSession( loginResponse.getRequestToken( ) ) )
                        .filter( (sessionResponse) -> sessionResponse != null && sessionResponse
                                .getSuccess( ))

                        .observeOn( getSchedulerProvider( ).ui( ) )
                        .doOnComplete( () -> setIsLoading( false ) )
                        .doOnTerminate( () -> setIsLoading( false ) )
                        .doOnNext( sessionResponse -> {
                            getDataManager( ).setAppSessionId( sessionResponse.getSessionId( ) );
                            getNavigator( ).onLoginSuccess( );
                        } )
                        .doOnError( throwable -> {
                            setIsLoading( false );
                            getNavigator( ).handleError( throwable );
                        } )
                        .subscribe()

                );
    }


}
