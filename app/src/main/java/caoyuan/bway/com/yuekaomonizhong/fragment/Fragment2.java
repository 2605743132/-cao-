package caoyuan.bway.com.yuekaomonizhong.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.yuekaomonizhong.R;
import caoyuan.bway.com.yuekaomonizhong.adapter.LeftAdapter;
import caoyuan.bway.com.yuekaomonizhong.adapter.RightAdapter;
import caoyuan.bway.com.yuekaomonizhong.bean.LeftBean;
import caoyuan.bway.com.yuekaomonizhong.bean.RightBean;
import caoyuan.bway.com.yuekaomonizhong.leftmvp.leftpresenter.LeftPresenter;
import caoyuan.bway.com.yuekaomonizhong.leftmvp.leftview.LeftView;
import caoyuan.bway.com.yuekaomonizhong.rightmvp.rightpresnter.RightPresenter;
import caoyuan.bway.com.yuekaomonizhong.rightmvp.rightview.RightView;

public class Fragment2 extends Fragment implements LeftView,RightView {
    private RecyclerView mRecLeft;
    private LinearLayout mRightLnl;
    private View view;
    private LeftPresenter leftPresenter;
    private List<LeftBean.DataBean> leftbean;
    private List<RightBean.DataBean> rightbean;
    private LeftAdapter leftAdapter;
    private RightPresenter rightPresenter;
    private GridLayoutManager gridLayoutManager;
    private RightAdapter rightAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        gridLayoutManager = new GridLayoutManager(getActivity(), 1, LinearLayoutManager.VERTICAL, false);
        mRecLeft.setLayoutManager(gridLayoutManager);
        leftbean = new ArrayList<>();
         rightbean =  new ArrayList<>();
         leftAdapter = new LeftAdapter(getActivity(), leftbean);

         leftAdapter.setOnItemClickListener(new LeftAdapter.OnItemClickListener() {
             @Override
             public void onItemClick(View itemview, int position) {
                 LeftBean.DataBean dataBean = leftbean.get(position);

                 rightPresenter.getright("http://www.zhaoapi.cn/product/getProductCatagory?cid="+dataBean.getCid());

             }
         });
        mRecLeft.setAdapter(leftAdapter);
        leftPresenter = new LeftPresenter();
          leftPresenter.leftpresent(this);
          leftPresenter.getLifts();

          rightPresenter = new RightPresenter();
          rightPresenter.attch(this);


    }


    private void initView(View view) {
        mRecLeft = (RecyclerView) view.findViewById(R.id.rec_left);
        mRightLnl = (LinearLayout) view.findViewById(R.id.right_lnl);
    }

    @Override
    public void onLeftSuese(List<LeftBean.DataBean> list) {
           if (list!=null){
               leftbean.clear();
               leftbean.addAll(list);
               leftAdapter.notifyDataSetChanged();
           }


    }

    @Override
    public void onLeftFill() {

    }


    @Override
    public void getrights(List<RightBean.DataBean> list) {


        if (list!=null){
             mRightLnl.removeAllViews();
             for (int i=0;i < list.size();i++){
                 TextView textView = new TextView(getActivity());
                 textView.setText(list.get(i).getName());
                 RecyclerView rewx = new RecyclerView(getActivity());
                 GridLayoutManager layoutManager2 = new GridLayoutManager(getActivity(), 3);
                rewx.setLayoutManager(layoutManager2);
                 rightAdapter = new RightAdapter(getActivity(), list.get(i).getList());
                 rewx.setAdapter(rightAdapter);
                 rightbean.clear();
                 rightbean.addAll(list);
                 rightAdapter.notifyDataSetChanged();
                 mRightLnl.addView(textView);
                 mRightLnl.addView(rewx);
             }
           }
    }

    @Override
    public void failed(Exception e) {

    }

    @Override
    public void onResume() {
        super.onResume();
        rightPresenter.getright("http://www.zhaoapi.cn/product/getProductCatagory?cid=1");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (leftPresenter!=null){
            leftPresenter.onDestroy();
        }
    }
}
