package iknow.android.utils.functions;

/**
 * Author：J.Chou
 * Date：  2016.07.20 19:02.
 * Email： who_know_me@163.com
 * Describe:
 */
public interface Callback<T, V> {
  void success(T t);

  void failure(V v);
}
