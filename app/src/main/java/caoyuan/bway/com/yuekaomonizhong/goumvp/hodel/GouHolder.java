package caoyuan.bway.com.yuekaomonizhong.goumvp.hodel;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import caoyuan.bway.com.yuekaomonizhong.R;


/**
 * Created by 小哥 on 2018/9/22.
 */

public class GouHolder extends RecyclerView.ViewHolder {
    public ImageView mIvItemShopcartShopselect;
    public TextView mTvItemShopcartShopname;
    public RecyclerView recyclerView;
    public GouHolder(View itemView) {
        super(itemView);
        this.mIvItemShopcartShopselect = (ImageView) itemView.findViewById(R.id.iv_item_shopcart_shopselect);
        this.mTvItemShopcartShopname = (TextView) itemView.findViewById(R.id.tv_item_shopcart_shopname);
        recyclerView = itemView.findViewById(R.id.recycler_view);
    }
}
