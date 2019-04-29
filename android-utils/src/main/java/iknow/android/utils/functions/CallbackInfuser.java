package iknow.android.utils.functions;

/**
 * Author：J.Chou
 * Date：  2016.11.07 11:36 AM
 * Email： who_know_me@163.com
 * Describe:
 */
public class CallbackInfuser {

    private SingleCallback callBack = null;

    private volatile static CallbackInfuser instance;

    public static CallbackInfuser getInstance(){
        if(instance == null) {
            synchronized (CallbackInfuser.class) {
                if (instance == null)
                    instance = new CallbackInfuser();
            }
        }
        return instance;
    }

    public void register(SingleCallback callBack){
        this.callBack = callBack;
    }

    public void unRegister(){
        if(this.callBack != null)
            this.callBack = null;
    }

    public SingleCallback getCallBack(){
        return this.callBack;
    }

}
