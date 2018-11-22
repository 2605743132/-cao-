package caoyuan.bway.com.yuekaomonizhong.rightmvp.rightmodel;

import java.lang.reflect.Type;

import caoyuan.bway.com.yuekaomonizhong.net.HttpUtils;
import caoyuan.bway.com.yuekaomonizhong.net.ICallBack;

public class RightBiz {
    public void getRight(String url, ICallBack iCallBack , Type type){
        HttpUtils.getInstance().get(url,iCallBack,type);

    }
}
