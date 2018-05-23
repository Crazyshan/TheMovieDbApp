package com.softvision.themoviedb.ui.login;

import android.content.*;
import android.os.*;
import android.support.annotation.*;
import android.support.v4.content.*;
import android.widget.*;

import com.mikhaellopez.circularprogressbar.*;
import com.softvision.themoviedb.*;
import com.softvision.themoviedb.R;
import com.softvision.themoviedb.databinding.*;
import com.softvision.themoviedb.ui.base.*;
import com.softvision.themoviedb.ui.landing.*;

import javax.inject.*;

public class LoginActivity extends BaseActivity< ActivityLoginBinding, LoginViewModel >
        implements LoginNavigator {

    @Inject
    LoginViewModel mLoginViewModel;

    ActivityLoginBinding mActivityLoginBinding;
    private String userName;
    private String passwordInput;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent( context, LoginActivity.class );
        intent.setFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP |
                Intent.FLAG_ACTIVITY_NEW_TASK );
        return intent;
    }

    @Override
    public int getBindingVariable() {
        return BR.loginViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.login;
    }

    @Override
    public LoginViewModel getViewModel() {
        return mLoginViewModel;
    }

    @Override
    public void intiBinding() {
        mActivityLoginBinding = getViewDataBinding( );
        mLoginViewModel.setNavigator( this );
    }

    @Override
    public void tokenRequest() {
        hideKeyboard( );
        userName = mActivityLoginBinding.etUserName.getText( ).toString( ).trim( );
        passwordInput = mActivityLoginBinding.etPassword.getText( ).toString( ).trim( );

      /*  CircularProgressBar circularProgressBar = mActivityLoginBinding.progress;
        circularProgressBar.setColor( ContextCompat.getColor(this, R.color.colorPrimary));
        circularProgressBar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        circularProgressBar.setProgressBarWidth(getResources().getDimension(R.dimen.dp_10));
        circularProgressBar.setBackgroundProgressBarWidth(getResources().getDimension(R.dimen.dp_15));
        int animationDuration = 2500; // 2500ms = 2,5s
        circularProgressBar.setProgressWithAnimation(65, animationDuration); // Default duration = 1500ms*/

        if ( mLoginViewModel.validateUserNameAndPassword( userName, passwordInput ) ) {
            mLoginViewModel.getRequestToken( userName, passwordInput );
        } else {
            Toast.makeText( this, getString( R.string.invalid_email_password ), Toast
                    .LENGTH_SHORT ).show( );
        }
    }

    @Override
    public void onLoginSuccess() {
        Toast.makeText( this, "Login Success", Toast.LENGTH_SHORT ).show( );
        startActivity( AppLandingActivity.newIntent( LoginActivity.this ) );
    }

    @Override
    public void handleError(Throwable throwable) {
        Toast.makeText( this, throwable.getMessage( ), Toast.LENGTH_SHORT ).show( );
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        intiBinding();

    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        networkStatus( isConnected );
    }


}
