package iknow.android.instrument;

import android.content.Context;
import java.lang.ref.WeakReference;

/**
 * author : J.Chou
 * e-mail : who_know_me@163.com
 * time   : 2019/01/13 12:32 PM
 * version: 1.0
 * description:
 */
public abstract class AbsEngine implements IEngine {
  private static final String ERROR_INIT = "Please initialize BaseUtils with invoke init() on Application onCreate()";
  private static WeakReference<Context> mWeakReferenceContext;
  @Override public void init(Context ctx) {
    mWeakReferenceContext = new WeakReference<>(ctx);
    //something to do...
  }

  public Context getContext() {
    if (mWeakReferenceContext == null || mWeakReferenceContext.get() == null) {
      throw new IllegalArgumentException(ERROR_INIT);
    }
    return mWeakReferenceContext.get().getApplicationContext();
  }
}
