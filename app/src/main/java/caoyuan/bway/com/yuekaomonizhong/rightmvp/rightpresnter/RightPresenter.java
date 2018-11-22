package caoyuan.bway.com.yuekaomonizhong.rightmvp.rightpresnter;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import caoyuan.bway.com.yuekaomonizhong.bean.RightBean;
import caoyuan.bway.com.yuekaomonizhong.net.ICallBack;
import caoyuan.bway.com.yuekaomonizhong.rightmvp.rightmodel.RightBiz;
import caoyuan.bway.com.yuekaomonizhong.rightmvp.rightview.RightView;

public class RightPresenter {

    private RightBiz rightBiz;
    private RightView rightView;

    public void attch(RightView rightView){
        this.rightView = rightView;
        rightBiz = new RightBiz();
    }
    public void getright(String url){
        Type type = new TypeToken<RightBean>(){}.getType();
        rightBiz.getRight(url, new ICallBack() {
            @Override
            public void onSuccess(Object o) {
            RightBean rightBean = (RightBean) o;
            if (rightBean!=null){
                rightView.getrights(rightBean.getData());
            }

            }

            @Override
            public void onFailed(IOException e) {
              rightView.failed(e);
            }
        },type);


}
    public void detach() {
        if (rightView != null) {
            rightView = null;
        }
    }
}
