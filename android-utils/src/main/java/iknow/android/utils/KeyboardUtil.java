package iknow.android.utils;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import iknow.android.utils.callback.SingleCallback;

/**
 * Author：J.Chou
 * Date：  2016.07.20 18:58.
 * Email： who_know_me@163.com
 * Describe:
 */
public final class KeyboardUtil {
    public static void hideKeyboard(Context mContext, View v) {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }

    /**
     * Show the keyboard with callback
     * @param view
     * @param cb
     */
    public static void showKeyboardWithCallback(final View view, final SingleCallback cb){
        new Handler().postDelayed(new Runnable() {
            public void run() {
                view.dispatchTouchEvent(MotionEvent.obtain(
                        SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                        MotionEvent.ACTION_DOWN, 0, 0, 0));
                view.dispatchTouchEvent(MotionEvent.obtain(
                        SystemClock.uptimeMillis(), SystemClock.uptimeMillis(),
                        MotionEvent.ACTION_UP, 0, 0, 0));

                if(cb != null)
                    cb.onSingleCallback();
            }
        }, 250);
    }
}
