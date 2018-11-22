package caoyuan.bway.com.yuekaomonizhong.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.yuekaomonizhong.R;
import cn.bingoogolapple.bgabanner.BGABanner;


public class Fragment4 extends Fragment {

    private View view;
    private BGABanner bannr;
    //图片地址数组
    private String[] picUrl = {
            "https://ww1.sinaimg.cn/large/0065oQSqly1fu7xueh1gbj30hs0uwtgb.jpg",
            "http://ww1.sinaimg.cn/large/0065oQSqly1frjd77dt8zj30k80q2aga.jpg",
            "https://ww1.sinaimg.cn/large/0065oQSqly1ftdtot8zd3j30ju0pt137.jpg"};
    //图片内容
    private String[] picDes = {
            "第十三界瑞丽模特大赛",
            "直播封面标准",
            "人气谁最高，金主谁最豪气"
    };
    private List<String> imageUrl;
    private List<String> imageDes;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment4, container, false);
        initView(view);
        initData();
        return view;
    }


    private void initView(View view) {
        bannr = (BGABanner) view.findViewById(R.id.bann);
    }

    private void initData() {


          //创建image和des的集合
          imageUrl = new ArrayList<String>();
          imageDes = new ArrayList<>();
          //循环添加到集合
          for (int a = 0; a < picUrl.length; a++) {
              imageUrl.add(picUrl[a]);
              imageDes.add(picDes[a]);

          }
          //集合传入banner
          bannr.setData(imageUrl, imageDes);


          bannr.setAdapter(new BGABanner.Adapter<ImageView, String>() {
              @Override
              public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable String model, int position) {
//                  ImageLoader.getInstance().displayImage(imageUrl.get(position), itemView);
                  Glide.with(getActivity()).load(imageUrl.get(position)).into(itemView);

              }
          });


    }
}
