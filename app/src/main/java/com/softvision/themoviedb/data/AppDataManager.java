package com.softvision.themoviedb.data;

import android.content.*;

import com.google.gson.*;
import com.softvision.themoviedb.data.local.prefs.*;
import com.softvision.themoviedb.data.model.auth.*;
import com.softvision.themoviedb.data.model.discover.*;
import com.softvision.themoviedb.data.model.movie.castandcrew.*;
import com.softvision.themoviedb.data.model.movie.details.*;
import com.softvision.themoviedb.data.model.movie.keywords.*;
import com.softvision.themoviedb.data.model.movie.videos.*;
import com.softvision.themoviedb.data.remote.*;
import com.softvision.themoviedb.di.scope.*;

import javax.inject.*;

import io.reactivex.*;

@Singleton
public class AppDataManager implements DataManager {

    private final Context mContext;

    private final PreferencesHelper mPreferencesHelper;

    private final Gson mGson;

    private final ClientModuleImplement mClientModuleImplement;

    @Inject
    public AppDataManager(@ApplicationContext Context context, ClientModuleImplement
            clientModule, Gson gson, PreferencesHelper preferencesHelper) {
        mContext = context;
        mGson = gson;
        mPreferencesHelper = preferencesHelper;
        mClientModuleImplement = clientModule;
    }

    @Override
    public Observable< RequestTokenResponse > requestToken() {

        return createRetrofitBody( ).requestToken( );
    }

    @Override
    public Observable< SessionResponse > createSession(String requestToken) {
        return createRetrofitBody().createSession(requestToken);
    }

    @Override
    public Observable< LoginResponse > loginRequest(String userName, String password,
                                                  String requestToken) {
        return createRetrofitBody( ).loginRequest( userName, password, requestToken );
    }

    @Override
    public Observable< DiscoverMovie > discoverMovies(String language, String sortBy, boolean
            includeVideo, int page, int year) {
        return createRetrofitBody( ).discoverMovies( language,sortBy,includeVideo,page,year );
    }

    @Override
    public Observable< MovieDetails > getMovieDetails(int movieId, String language, String
            appendToResponse) {
        return createRetrofitBody( ).getMovieDetails( movieId,language,appendToResponse );
    }

    @Override
    public Observable< CastAndCrew > getCastAndCrew(int id) {
        return createRetrofitBody( ).getCastAndCrew( id );
    }

    @Override
    public Observable< Keywords > getKeyword(int id) {
        return createRetrofitBody( ).getKeyword( id );
    }

    @Override
    public Observable< Videos > getVideos(int id) {
        return createRetrofitBody( ).getVideos( id );
    }

    @Override
    public void updateUserInfo(String Token,String sessionId, String userName) {
        setAppTokenId( Token );
        setAppSessionId( sessionId );
        setUserName( userName );
    }

    public ApiHelper createRetrofitBody() {
        return mClientModuleImplement.createRetrofitBody( );
    }

    @Override
    public String getAppTokenId() {
        return mPreferencesHelper.getAppTokenId();
    }

    @Override
    public void setAppTokenId(String token) {
        mPreferencesHelper.setAppTokenId( token );
    }

    @Override
    public String getAppSessionId() {
        return mPreferencesHelper.getAppSessionId();
    }

    @Override
    public void setAppSessionId(String sessionId) {
        mPreferencesHelper.setAppSessionId( sessionId );
    }

    @Override
    public String getUserName() {
        return mPreferencesHelper.getUserName();
    }

    @Override
    public void setUserEmail(String email) {
        mPreferencesHelper.setUserName( email );
    }

    @Override
    public String getUserEmail() {
        return mPreferencesHelper.getUserEmail();
    }

    @Override
    public void setUserName(String name) {
        mPreferencesHelper.setUserName( name );
    }
}
