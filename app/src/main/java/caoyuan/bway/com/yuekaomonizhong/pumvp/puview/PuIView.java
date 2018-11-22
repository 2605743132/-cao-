package caoyuan.bway.com.yuekaomonizhong.pumvp.puview;

import java.util.List;

import caoyuan.bway.com.yuekaomonizhong.bean.PuBean;

public interface PuIView {

    void onSuese(List<PuBean.DataBean> list);

    void onFill();

}
