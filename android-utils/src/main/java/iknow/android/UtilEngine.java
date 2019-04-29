package iknow.android;

import android.content.Context;
import java.lang.ref.WeakReference;

/**
 * author : J.Chou
 * e-mail : who_know_me@163.com
 * time   : 2019/01/13 1:10 PM
 * version: 1.0
 * description:
 */
public class UtilEngine {
  private static final String ERROR_INIT = "Please initialize BaseUtils with invoke UtilEngine.init() on Application onCreate()";
  private static WeakReference<Context> mWeakReferenceContext;

  public static void init(Context ctx) {
    mWeakReferenceContext = new WeakReference<>(ctx);
    //something to do...
  }

  public static Context getContext() {
    if (mWeakReferenceContext == null || mWeakReferenceContext.get() == null) {
      throw new IllegalArgumentException(ERROR_INIT);
    }
    return mWeakReferenceContext.get().getApplicationContext();
  }
}
