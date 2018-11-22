package caoyuan.bway.com.yuekaomonizhong.leftmvp.leftpresenter;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import caoyuan.bway.com.yuekaomonizhong.bean.LeftBean;
import caoyuan.bway.com.yuekaomonizhong.leftmvp.leftmodel.LeftModel;
import caoyuan.bway.com.yuekaomonizhong.leftmvp.leftview.LeftView;
import caoyuan.bway.com.yuekaomonizhong.net.ICallBack;

public class LeftPresenter {
    private LeftModel leftModel ;
    private LeftView leftView;
    public void leftpresent(LeftView leftView){
        this.leftView = leftView;
        leftModel = new LeftModel();

    }
    public void getLifts(){
        final Type type = new TypeToken<LeftBean>() {
        }.getType();
        leftModel.getLeft("http://www.zhaoapi.cn/product/getCatagory", new ICallBack() {
            @Override
            public void onSuccess(Object o) {
            LeftBean leftBean = (LeftBean) o;
            if (leftBean!=null){

                leftView.onLeftSuese(leftBean.getData());
            }
            }

            @Override
            public void onFailed(IOException e) {

            }
        },type);

    }
    public void onDestroy(){
        if (leftView != null){
            leftView = null;
        }}
}
