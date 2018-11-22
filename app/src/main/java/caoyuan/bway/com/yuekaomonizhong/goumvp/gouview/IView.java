package caoyuan.bway.com.yuekaomonizhong.goumvp.gouview;

import java.util.List;

import caoyuan.bway.com.yuekaomonizhong.bean.NewBean;

public interface IView {
    void getData(List<NewBean.DataBean> list);
    void getFills();
}
