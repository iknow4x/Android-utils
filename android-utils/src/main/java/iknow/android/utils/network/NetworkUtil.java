package iknow.android.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import iknow.android.UtilEngine;

/**
 * Author：J.Chou
 * Date：  2016.07.20 11:51.
 * Email： who_know_me@163.com
 * Describe:
 */
public class NetworkUtil {

    public static NetworkInfo getNetworkInfo() {
        ConnectivityManager cm = (ConnectivityManager) UtilEngine.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null ? cm.getActiveNetworkInfo() : null;
    }

    public static boolean isNetworkAvailable() {
        NetworkInfo netInfo = getNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static boolean isConnectedWifi() {
        NetworkInfo info = getNetworkInfo();
        return (isNetworkAvailable() && info.getType() == ConnectivityManager.TYPE_WIFI);
    }

    public static boolean isConnectedMobile() {
        NetworkInfo info = getNetworkInfo();
        return (isNetworkAvailable() && info.getType() == ConnectivityManager.TYPE_MOBILE);
    }
}
