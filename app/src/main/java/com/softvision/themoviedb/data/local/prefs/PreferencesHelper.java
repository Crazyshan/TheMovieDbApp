package com.softvision.themoviedb.data.local.prefs;

public interface PreferencesHelper {

    String getAppTokenId();

    void setAppTokenId(String token);

    String getAppSessionId();

    void setAppSessionId(String token);

    String getUserName();

    void setUserEmail(String email);

    String getUserEmail();

    void setUserName(String name);


   /* String getAccessToken();

    void setAccessToken(String accessToken);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);




    String getCurrentUserName();

    void setCurrentUserName(String userName);*/


}
