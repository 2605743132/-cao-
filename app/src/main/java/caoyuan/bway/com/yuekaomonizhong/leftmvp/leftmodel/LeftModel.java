package caoyuan.bway.com.yuekaomonizhong.leftmvp.leftmodel;

import java.lang.reflect.Type;

import caoyuan.bway.com.yuekaomonizhong.net.HttpUtils;
import caoyuan.bway.com.yuekaomonizhong.net.ICallBack;

public class LeftModel {
    public void getLeft(String url, ICallBack iCallBack , Type type){
        HttpUtils.getInstance().get(url,iCallBack,type);


    }
}
