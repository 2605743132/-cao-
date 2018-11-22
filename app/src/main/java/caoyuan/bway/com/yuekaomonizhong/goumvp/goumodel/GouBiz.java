package caoyuan.bway.com.yuekaomonizhong.goumvp.goumodel;

import java.lang.reflect.Type;

import caoyuan.bway.com.yuekaomonizhong.net.HttpUtils;
import caoyuan.bway.com.yuekaomonizhong.net.ICallBack;

public class GouBiz {
    public void getGou(String url, ICallBack iCallBack, Type type){
        HttpUtils.getInstance().get(url,iCallBack,type);

    }
}
