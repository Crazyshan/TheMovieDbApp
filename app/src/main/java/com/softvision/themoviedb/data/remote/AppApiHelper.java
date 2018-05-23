package com.softvision.themoviedb.data.remote;

import android.media.*;

import com.softvision.themoviedb.data.local.prefs.*;
import com.softvision.themoviedb.data.model.auth.*;
import com.softvision.themoviedb.data.model.discover.*;
import com.softvision.themoviedb.data.model.movie.castandcrew.*;
import com.softvision.themoviedb.data.model.movie.details.*;
import com.softvision.themoviedb.data.model.movie.keywords.*;
import com.softvision.themoviedb.data.model.movie.videos.*;
import com.softvision.themoviedb.utils.rx.*;

import javax.inject.*;

import io.reactivex.*;

@Singleton
public class AppApiHelper implements ApiHelper {

    private final ClientModuleImplement mClientModule;
    private PreferencesHelper mPreferencesHelper;
    private SchedulerProvider mSchedulerProvider;

    @Inject
    public AppApiHelper(ClientModuleImplement clientModule, PreferencesHelper preferencesHelper,
                        SchedulerProvider schedulerProvider
    ) {
        this.mPreferencesHelper = preferencesHelper;
        this.mClientModule = clientModule;
        this.mSchedulerProvider = schedulerProvider;

    }

    @Override
    public Observable< RequestTokenResponse > requestToken() {
        return mClientModule.createRetrofitBody( ).requestToken( );

    }

    @Override
    public Observable< SessionResponse > createSession(String                                         requestToken) {
        return mClientModule.createRetrofitBody().createSession(requestToken);
    }

    @Override
    public Observable< LoginResponse > loginRequest(String userName, String password, String
            requestToken) {
        return mClientModule.createRetrofitBody( ).loginRequest( userName, password, requestToken );

    }

    @Override
    public Observable< DiscoverMovie > discoverMovies(String language, String sortBy, boolean
            includeVideo, int page, int year) {
        return mClientModule.createRetrofitBody( ).discoverMovies(language,sortBy,includeVideo,page,year  );
    }

    @Override
    public Observable< MovieDetails > getMovieDetails(int movieId, String language, String
            appendToResponse) {
        return mClientModule.createRetrofitBody().getMovieDetails( movieId,language,appendToResponse );
    }

    @Override
    public Observable< CastAndCrew > getCastAndCrew(int id) {
        return  mClientModule.createRetrofitBody().getCastAndCrew( id );
    }

    @Override
    public Observable< Keywords > getKeyword(int id) {
        return  mClientModule.createRetrofitBody().getKeyword( id );
    }

    @Override
    public Observable< Videos > getVideos(int id) {
        return  mClientModule.createRetrofitBody().getVideos( id );
    }


   /* @Override
    public Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectSingle(LoginResponse.class);
    }*/
}
