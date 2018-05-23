package com.softvision.themoviedb.data.remote;

import com.softvision.themoviedb.data.model.auth.*;
import com.softvision.themoviedb.data.model.discover.*;
import com.softvision.themoviedb.data.model.movie.castandcrew.*;
import com.softvision.themoviedb.data.model.movie.details.*;
import com.softvision.themoviedb.data.model.movie.keywords.*;
import com.softvision.themoviedb.data.model.movie.videos.*;

import io.reactivex.*;
import retrofit2.http.*;

import static com.softvision.themoviedb.data.remote.ApiEndPoint.*;

public interface ApiHelper {

    @GET ( REQUEST_TOKEN )
    Observable< RequestTokenResponse > requestToken();

    @GET(SESSION)
    Observable<SessionResponse> createSession(@Query( "request_token" ) String token);

    @GET ( LOGIN_REQUEST )
    Observable< LoginResponse > loginRequest(@Query ( "username" ) String userName, @Query (
            "password" ) String password, @Query ( "request_token" ) String requestToken);

    @GET ( DISCOVER_MOVIE )
    Observable< DiscoverMovie > discoverMovies(@Query ( "language" ) String language, @Query (
            "sort_by" ) String sortBy, @Query ( "include_video" ) boolean includeVideo, @Query (
            "page" ) int page, @Query ( "year" ) int year);

    @GET ( MOVIE_DETAIL )
    Observable< MovieDetails > getMovieDetails(@Path ( "movie_id" ) int id, @Query (
            "language" ) String language, @Query ( "append_to_response" ) String appendToResponse);

    @GET ( MOVIE_CREDITS )
    Observable< CastAndCrew > getCastAndCrew(@Path ( "movie_id" ) int id);

    @GET ( MOVIE_KEYWORDS )
    Observable< Keywords > getKeyword(@Path ( "movie_id" ) int id);

    @GET ( VIDEOS )
    Observable< Videos > getVideos(@Path ( "movie_id" ) int id);


}
