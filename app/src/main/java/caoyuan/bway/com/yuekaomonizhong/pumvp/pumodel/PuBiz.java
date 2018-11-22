package caoyuan.bway.com.yuekaomonizhong.pumvp.pumodel;

import java.lang.reflect.Type;

import caoyuan.bway.com.yuekaomonizhong.net.HttpUtils;
import caoyuan.bway.com.yuekaomonizhong.net.ICallBack;

public class PuBiz {
    public void getPuList(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }
}
