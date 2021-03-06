package caoyuan.bway.com.yuekaomonizhong.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.yuekaomonizhong.R;
import caoyuan.bway.com.yuekaomonizhong.adapter.MyPuAdapter;
import caoyuan.bway.com.yuekaomonizhong.bean.PuBean;
import caoyuan.bway.com.yuekaomonizhong.pumvp.puprivater.Puprvter;
import caoyuan.bway.com.yuekaomonizhong.pumvp.puview.PuIView;


public class Fragment1 extends Fragment implements PuIView {
    private RecyclerView mrecycler;
    private Puprvter mpuprvter;
    private ArrayList<PuBean.DataBean> mpulist;
    private MyPuAdapter adapter;
    private View view;
    private RecyclerView mRecycler;
    private PullToRefreshScrollView mPs;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);
        mrecycler = view.findViewById(R.id.recycler);
        initView(view);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mpuprvter = new Puprvter();
        mpuprvter.attar(this);
        mpuprvter.getProuter();
        mpulist = new ArrayList<>();
        mrecycler.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter = new MyPuAdapter(getActivity(), mpulist);
        mrecycler.setAdapter(adapter);

        mPs.setMode(PullToRefreshBase.Mode.BOTH);
        mPs.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> refreshView) {

                mPs.onRefreshComplete();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> refreshView) {
                 mPs.onRefreshComplete();
            }
        });
    }

    @Override
    public void onSuese(List<PuBean.DataBean> list) {
        if (list != null) {
            mpulist.clear();
            mpulist.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFill() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mpuprvter != null) {
            mpuprvter.onDestroy();
        }
    }

    private void initView(View view) {
        mRecycler = (RecyclerView) view.findViewById(R.id.recycler);
        mPs = (PullToRefreshScrollView) view.findViewById(R.id.ps);
    }
}
