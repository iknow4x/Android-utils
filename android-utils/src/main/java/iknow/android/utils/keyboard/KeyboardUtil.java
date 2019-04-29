package iknow.android.utils.keyboard;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import iknow.android.utils.functions.Function;

/**
 * Author：J.Chou
 * Date：  2016.07.20 18:58.
 * Email： who_know_me@163.com
 * Describe:
 */
public  class KeyboardUtil {

    /**
     * @param mContext mContext
     * @param v The view that need to hide keyboard.
     */
    public static void hideKeyboard(Context mContext, View v) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm != null) imm.hideSoftInputFromWindow(v.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }


    /**
     * Just need to enter a context
     * @param context context
     */
    public static void hideKeyboard(Activity context){
        if(context == null || context.getCurrentFocus() == null)
            return;
        InputMethodManager im = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if(im != null && im.isActive())
            im.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * Show the keyboard with callback
     * @param view View
     * @param cb cb
     */
    public static void showKeyboardWithCallback(final View view, final Function<Object,Object> cb){
        new Handler().postDelayed(new Runnable() {
            public void run() {
                view.dispatchTouchEvent(MotionEvent.obtain(
                        SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                        MotionEvent.ACTION_DOWN, 0, 0, 0));
                view.dispatchTouchEvent(MotionEvent.obtain(
                        SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                        MotionEvent.ACTION_UP, 0, 0, 0));

                if(cb != null) {
                    try {
                        cb.apply(null);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 250);
    }
}
