package caoyuan.bway.com.yuekaomonizhong.fragment;

import android.app.usage.UsageEvents;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.yuekaomonizhong.R;
import caoyuan.bway.com.yuekaomonizhong.adapter.GouAdapter;
import caoyuan.bway.com.yuekaomonizhong.bean.NewBean;
import caoyuan.bway.com.yuekaomonizhong.goumvp.goupresenter.GouPresenter;
import caoyuan.bway.com.yuekaomonizhong.goumvp.gouview.IView;
import caoyuan.bway.com.yuekaomonizhong.net.MyMessage;

public class Fragment3 extends Fragment implements IView{
    private View inflate;
    private RecyclerView mRlvShopcart;
    /**
     * 全选
     */
    private TextView mTvShopcartAddselect;
    /**
     * 总价：¥0
     */
    private TextView mTvShopcartTotalprice;
    /**
     * 共0件商品
     */
    private TextView mTvShopcartTotalnum;
    /**
     * 去结算
     */
    private TextView mTvShopcartSubmit;
    private LinearLayout mLlPay;
    private RelativeLayout mRlShopcartHave;
    private boolean flag;
    private int total = 0;
    private GouPresenter presenter;
    private List<NewBean.DataBean> data;
    private GouAdapter gouAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment3, container, false);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {

        presenter = new GouPresenter();
        presenter.GouPresenters(this);
        presenter.getDatas();

        data = new ArrayList<>();
        //注册EventBus
        EventBus.getDefault().register(this);

        mRlvShopcart.setLayoutManager(new LinearLayoutManager(getActivity()));

        gouAdapter = new GouAdapter(getActivity(), data);

        mRlvShopcart.setAdapter(gouAdapter);

        selectAll(data);

        mTvShopcartAddselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag =! flag;
                selectAll(data);
            }
        });
    }

    private void selectAll(List<NewBean.DataBean> data) {
        if (flag){
            mTvShopcartAddselect.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shopcart_selected,0,0,0);
            for (int i = 0; i < data.size(); i++) {
                for (int j = 0; j < data.get(i).getList().size(); j++) {
                    data.get(i).setSelect(true);
                    data.get(i).getList().get(j).setSelected(1);
                }
            }
        }else{
            mTvShopcartAddselect.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shopcart_unselected,0,0,0);
            for (int i = 0; i < data.size(); i++) {
                for (int j = 0; j < data.get(i).getList().size(); j++) {
                    data.get(i).setSelect(false);
                    data.get(i).getList().get(j).setSelected(0);
                }
            }
        }
        EventBus.getDefault().post(new MyMessage("2"));
        gouAdapter.notifyDataSetChanged();
    }


    private void initView() {
        mRlvShopcart =  inflate.findViewById(R.id.rlv_shopcart);
        mTvShopcartAddselect = (TextView) inflate.findViewById(R.id.tv_shopcart_addselect);
        mTvShopcartTotalprice = (TextView)inflate. findViewById(R.id.tv_shopcart_totalprice);
        mTvShopcartTotalnum = (TextView) inflate.findViewById(R.id.tv_shopcart_totalnum);
        mTvShopcartSubmit = (TextView) inflate.findViewById(R.id.tv_shopcart_submit);
        mLlPay = (LinearLayout) inflate.findViewById(R.id.ll_pay);
        mRlShopcartHave = (RelativeLayout)inflate. findViewById(R.id.rl_shopcart_have);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void AllPrice(MyMessage myMessage){
        total = 0;
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).getList().size(); j++) {
                if (data.get(i).getList().get(j).getSelected() % 2 == 1){
                    total += (int) (data.get(i).getList().get(j).getNum() * data.get(i).getList().get(j).getPrice());
                }
            }
        }
        mTvShopcartTotalprice.setText(String.valueOf(total));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void getData(List<NewBean.DataBean> list) {
        if (list != null){
            data.clear();
            data.addAll(list);
            gouAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getFills() {
        Toast.makeText(getActivity(), "网络异常", Toast.LENGTH_SHORT).show();
    }
}
