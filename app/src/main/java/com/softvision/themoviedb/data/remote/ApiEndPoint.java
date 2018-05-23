package com.softvision.themoviedb.data.remote;

public final class ApiEndPoint {

    public static final String REQUEST_TOKEN = "authentication/token/new";
    public static final String SESSION="authentication/session/new";
    public static final String LOGIN_REQUEST = "authentication/token/validate_with_login";
    public static final String DISCOVER_MOVIE = "discover/movie";
    public static final String MOVIE_DETAIL = "movie/{movie_id}";
    public static final String MOVIE_CREDITS = "movie/{movie_id}/credits";
    public static final String MOVIE_KEYWORDS = "movie/{movie_id}/keywords";
    public static final String VIDEOS="movie/{movie_id}/videos";


}
