package iknow.android.utils;

import android.content.Context;

/**
 * Author：J.Chou
 * Date：  2016.07.21 11:45.
 * Email： who_know_me@163.com
 * Describe:
 */
public class BaseUtils {

    private static Context context;

    /**
     * init in Application
     * @param ctx
     */
    public static void init(Context ctx){
        BaseUtils.context = ctx;

        //something to do...


    }

    public static Context getContext() {
        return context;
    }
}
