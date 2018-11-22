package caoyuan.bway.com.yuekaomonizhong.goumvp.goupresenter;


import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import caoyuan.bway.com.yuekaomonizhong.bean.NewBean;
import caoyuan.bway.com.yuekaomonizhong.goumvp.goumodel.GouBiz;
import caoyuan.bway.com.yuekaomonizhong.goumvp.gouview.IView;
import caoyuan.bway.com.yuekaomonizhong.net.ICallBack;

public class GouPresenter {
    private IView iv;
    private GouBiz gouBiz;

    public void GouPresenters(IView iv) {
        this.iv = iv;
         gouBiz = new GouBiz();
    }
    public void getDatas(){
        Type type = new TypeToken<NewBean>() {
        }.getType();
        gouBiz.getGou("http://www.zhaoapi.cn/product/getCarts?uid=71", new ICallBack() {
            @Override
            public void onSuccess(Object o) {
           NewBean newBean   =(NewBean) o;
           if (newBean!=null){
               iv.getData(newBean.getData());

           }

            }

            @Override
            public void onFailed(IOException e) {
iv.getFills();
            }
        },type);
    }
}
