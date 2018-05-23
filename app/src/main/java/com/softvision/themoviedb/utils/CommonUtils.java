package com.softvision.themoviedb.utils;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.util.*;

import com.softvision.themoviedb.*;

public final class CommonUtils {

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static boolean isEmailVaild(String email) {
        return Patterns.EMAIL_ADDRESS.matcher( email ).matches( );
    }

    public static ProgressDialog showLoadingDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog( context );
        progressDialog.show( );
        if ( progressDialog.getWindow( ) != null ) {
            progressDialog.getWindow( ).setBackgroundDrawable( new ColorDrawable( Color
                    .TRANSPARENT ) );
        }
        progressDialog.setContentView( R.layout.progress_dialog );
        progressDialog.setIndeterminate( true );
        progressDialog.setCancelable( false );
        progressDialog.setCanceledOnTouchOutside( false );
        return progressDialog;
    }
}
