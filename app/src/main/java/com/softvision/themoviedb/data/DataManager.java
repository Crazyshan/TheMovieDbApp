package com.softvision.themoviedb.data;

import com.softvision.themoviedb.data.local.prefs.*;
import com.softvision.themoviedb.data.remote.*;

public interface DataManager extends ApiHelper,PreferencesHelper {

    void updateUserInfo(
            String token,
            String sessionId,
            String userName
            );
}
