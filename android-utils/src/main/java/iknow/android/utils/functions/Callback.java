package iknow.android.utils.functions;

/**
 * author : J.Chou
 * github : https://github.com/iknow4
 * e-mail : who_know_me@163.com
 * time   : 2019/04/29 17:20
 * version: 1.0
 * description:
 */
public interface Callback<T, V> {
  void onSuccess(T t);
  void onFailure(V v);
}
