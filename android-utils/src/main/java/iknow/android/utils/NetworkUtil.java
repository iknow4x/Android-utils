package iknow.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Author：J.Chou
 * Date：  2016.07.20 11:51.
 * Email： who_know_me@163.com
 * Describe:
 */
public final class NetworkUtil {

    public static NetworkInfo getNetworkInfo() {
        ConnectivityManager cm = (ConnectivityManager) BaseUtils.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    public static boolean isNetworkAvailable() {
        NetworkInfo netInfo = getNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
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
