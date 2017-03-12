package com.example.vipul.goingplaces;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class ConnectionDetector {

    Context context;

    public ConnectionDetector(Context context){
        this.context = context;
    }

    public boolean isConnectedToInternet(){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(manager!=null){
            NetworkInfo info = manager.getActiveNetworkInfo();
            if(info!=null && info.isConnected())
                return true;
        }
        return false;
    }

}
