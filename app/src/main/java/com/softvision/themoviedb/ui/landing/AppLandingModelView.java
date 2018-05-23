package com.softvision.themoviedb.ui.landing;

import android.databinding.*;
import android.text.*;

import com.softvision.themoviedb.data.*;
import com.softvision.themoviedb.ui.base.*;
import com.softvision.themoviedb.utils.rx.*;

public class AppLandingModelView extends BaseViewModel< AppLandingNavigator > {

    private final ObservableField< String > toolbarTitle = new ObservableField<>( );
    private final ObservableField< String > appVersion = new ObservableField<>( );
    private final ObservableField< String > userName = new ObservableField<>( );
    private final ObservableField< String > userEmail = new ObservableField<>( );

    public AppLandingModelView(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super( dataManager, schedulerProvider );
    }

    public ObservableField< String > getToolbarTitle() {
        return toolbarTitle;
    }

    public ObservableField< String > getAppVersion() {
        return appVersion;
    }

    public ObservableField< String > getUserName() {
        return userName;
    }

    public ObservableField< String > getUserEmail() {
        return userEmail;
    }

    public void updateAppVersion(String version) {
        appVersion.set(version);
    }

    public void onNavMenuCreated() {
        final String currentUserName = getDataManager().getUserName();
        if (!TextUtils.isEmpty(currentUserName)) {
            userName.set(currentUserName);
        }

        final String currentUserEmail = getDataManager().getUserEmail();
        if (!TextUtils.isEmpty(currentUserEmail)) {
            userEmail.set(currentUserEmail);
        }

       /* final String profilePicUrl = getDataManager().getCurrentUserProfilePicUrl();
        if (!TextUtils.isEmpty(profilePicUrl)) {
            userProfilePicUrl.set(profilePicUrl);
        }*/
    }
}
