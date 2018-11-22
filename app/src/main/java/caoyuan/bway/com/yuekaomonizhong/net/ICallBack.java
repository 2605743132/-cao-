package caoyuan.bway.com.yuekaomonizhong.net;

import java.io.IOException;

public interface ICallBack {

    void onSuccess(Object o);

    void onFailed(IOException e);
}
