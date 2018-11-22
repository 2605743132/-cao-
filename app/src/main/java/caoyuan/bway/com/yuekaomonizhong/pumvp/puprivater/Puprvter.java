package caoyuan.bway.com.yuekaomonizhong.pumvp.puprivater;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import caoyuan.bway.com.yuekaomonizhong.bean.PuBean;
import caoyuan.bway.com.yuekaomonizhong.net.ICallBack;
import caoyuan.bway.com.yuekaomonizhong.pumvp.pumodel.PuBiz;
import caoyuan.bway.com.yuekaomonizhong.pumvp.puview.PuIView;

public class Puprvter {
    private PuBiz puBiz;
    private PuIView puIView;
    public void attar(PuIView puIView){
        this.puIView = puIView;
        puBiz = new PuBiz();

    }
    public void getProuter(){
        Type type = new TypeToken<PuBean>()
        {

        }.getType();
       puBiz.getPuList("http://www.xieast.com/api/news/news.php", new ICallBack() {
           @Override
           public void onSuccess(Object o) {
               PuBean bean = (PuBean) o;
               if (bean!=null){
                   puIView.onSuese(bean.getData());

               }
           }

           @Override
           public void onFailed(IOException e) {
            puIView.onFill();
           }
       },type);
    }
    public void onDestroy(){
        if (puIView != null){
            puIView = null;
        }
}


}
