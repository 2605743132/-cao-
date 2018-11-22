package caoyuan.bway.com.yuekaomonizhong.rightmvp.rightview;

import java.util.List;

import caoyuan.bway.com.yuekaomonizhong.bean.RightBean;

public interface RightView {

    void getrights(List<RightBean.DataBean> list);

    void failed(Exception e);

}
