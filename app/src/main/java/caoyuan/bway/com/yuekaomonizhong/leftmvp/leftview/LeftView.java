package caoyuan.bway.com.yuekaomonizhong.leftmvp.leftview;

import java.util.List;

import caoyuan.bway.com.yuekaomonizhong.bean.LeftBean;
import caoyuan.bway.com.yuekaomonizhong.bean.PuBean;

public interface LeftView {
    void onLeftSuese(List<LeftBean.DataBean> list);

    void onLeftFill();
}
