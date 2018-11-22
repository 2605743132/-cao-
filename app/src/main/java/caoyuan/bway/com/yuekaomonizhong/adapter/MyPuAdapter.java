package caoyuan.bway.com.yuekaomonizhong.adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;



import java.util.List;

import caoyuan.bway.com.yuekaomonizhong.R;
import caoyuan.bway.com.yuekaomonizhong.bean.PuBean;


public class MyPuAdapter extends RecyclerView.Adapter<MyPuAdapter.ViewHolder> {
    private static final int NORMAL_VIEW = 0;
    private Context context;
    private List<PuBean.DataBean> list;

    public MyPuAdapter(Context context, List<PuBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.item_pu, null);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        ViewGroup.LayoutParams layoutParams = holder.imageView.getLayoutParams();
        layoutParams.height = (int) ((100) + Math.random() * 200);

        holder.imageView.setLayoutParams(layoutParams);

        Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder.imageView);
        holder.textView.setText(list.get(position).getTitle());
        holder.textView.setTextColor(Color.rgb((int) ((100) + Math.random() * 200),(int) ((300) + Math.random() * 400),(int) ((200) + Math.random() * 600)));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_ne);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

}