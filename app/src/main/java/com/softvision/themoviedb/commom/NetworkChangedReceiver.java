package com.softvision.themoviedb.commom;

import android.content.*;

import com.softvision.themoviedb.utils.*;

import javax.inject.*;

public class NetworkChangedReceiver extends BroadcastReceiver {

    public static IConnectivityReceiverListener connectivityReceiverListener;

    @Inject
    public NetworkChangedReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent arg1) {
        boolean isConnected = NetworkUtil.isConnected(context);
        if (connectivityReceiverListener != null) {
            connectivityReceiverListener.onNetworkConnectionChanged(isConnected);
        }
    }
}
