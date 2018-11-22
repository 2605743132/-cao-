package caoyuan.bway.com.yuekaomonizhong.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import caoyuan.bway.com.yuekaomonizhong.R;
import caoyuan.bway.com.yuekaomonizhong.bean.NewBean;
import caoyuan.bway.com.yuekaomonizhong.goumvp.hodel.WuHolder;
import caoyuan.bway.com.yuekaomonizhong.net.MyMessage;

public class WuAdapter extends RecyclerView.Adapter<WuHolder> {
    private Context context;
    private List<NewBean.DataBean.ListBean> list;
    private WuHolder wuHolder;

    public WuAdapter(Context context, List<NewBean.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public WuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        wuHolder = new WuHolder(inflate);
        return wuHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WuHolder holder, final int position) {
        holder.mTvItemShopcartClothname.setText(list.get(position).getTitle());
        holder.mTvItemShopcartClothPrice.setText(String.valueOf(list.get(position).getPrice()));
        holder.mTvItemShopcartClothColor.setText(list.get(position).getCreatetime());
        holder.mEtItemShopcartClothNum.setText(String.valueOf(list.get(position).getNum()));
        String regex = "\\|";
        String[] split = list.get(position).getImages().split(regex);
        Uri parse = Uri.parse(split[0]);
        holder.mIvItemShopcartClothPic.setImageURI(parse);
//        选中
        if (list.get(position).getSelected() % 2 == 1){
            holder.mTvItemShopcartClothselect.setImageResource(R.drawable.shopcart_selected);
            EventBus.getDefault().post(new MyMessage("2"));
        }else{
            holder.mTvItemShopcartClothselect.setImageResource(R.drawable.shopcart_unselected);
            EventBus.getDefault().post(new MyMessage("2"));
        }
        holder.mTvItemShopcartClothselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = list.get(position).getSelected();
                selected++;
                int i = selected % 2;
                list.get(position).setSelected(i);
                notifyDataSetChanged();
            }
        });
        //加
        holder.mIvItemShopcartClothAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = list.get(position).getNum();
                if (num<= 30){
                    num ++ ;
                    list.get(position).setNum(num);
                    EventBus.getDefault().post(new MyMessage("2"));
                    notifyDataSetChanged();
                }
            }
        });
        //减
        holder.mIvItemShopcartClothMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num = list.get(position).getNum();
                if (num >= 1){
                    num --;
                    list.get(position).setNum(num);
                    EventBus.getDefault().post(new MyMessage("2"));
                    notifyDataSetChanged();
                }
            }
        });
        //删除
        holder.mIvItemShopcartClothDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(position);
                EventBus.getDefault().post(new MyMessage("2"));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
