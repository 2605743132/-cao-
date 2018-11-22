package caoyuan.bway.com.yuekaomonizhong;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.yuekaomonizhong.fragment.Fragment1;
import caoyuan.bway.com.yuekaomonizhong.fragment.Fragment2;
import caoyuan.bway.com.yuekaomonizhong.fragment.Fragment3;

public class MainActivity extends AppCompatActivity {
    private ViewPager mVp;
    private TabLayout mTab;
    private List<Fragment> mlist = new ArrayList();
    private String[] mtitle = {"首页","分类","购物车"};
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         initView();
         initData();
    }



    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mTab = (TabLayout) findViewById(R.id.tab);

    }
    private void initData() {

        mlist.add(new Fragment1());
        mlist.add(new Fragment2());
        mlist.add(new Fragment3());
     adapter = new MyAdapter(getSupportFragmentManager());
     mVp.setAdapter(adapter);
     mTab.setupWithViewPager(mVp);
    }

    private class MyAdapter extends FragmentPagerAdapter{
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return mlist.get(position);
        }


        @Override
        public int getCount() {
            return mlist.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return mtitle[position];
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

        }
    }
}

