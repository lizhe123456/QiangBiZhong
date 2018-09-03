package com.whmnrc.qiangbizhong.ui.yimei.adpter;

import android.content.Context;
import android.graphics.Paint;
import android.view.View;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.YiMeiGoodsBean;
import com.whmnrc.qiangbizhong.ui.yimei.activity.YiMeiGoodsDetailsActivity;
import com.whmnrc.qiangbizhong.util.StringUtil;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/25.
 */

public class YiMeiSearchAdapter extends BaseAdapter<YiMeiGoodsBean>{

    public YiMeiSearchAdapter(Context context) {
        super(context);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, YiMeiGoodsBean item, int position) {
        holder.setGlieuImage(R.id.iv_img,item.getGoods_ImaPath())
                .setText(R.id.tv_title,item.getGoods_Name())
                .setText(R.id.tv_yimei_name,item.getStoreName())
                .setText(R.id.tv_goods_price,StringUtil.wanString(item.getGoods_PriceMin()))
                .setText(R.id.tv_juli, StringUtil.kmString(item.getDistance()));
        TextView tvOldMoeny = holder.getView(R.id.tv_old_goods_price);
        tvOldMoeny.setText("原价："+StringUtil.wanString(item.getGoods_PriceMax()));
        tvOldMoeny.getPaint().setAntiAlias(true);//抗锯齿
        tvOldMoeny.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线
        holder.setOnClickListener(R.id.iv_img, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YiMeiGoodsDetailsActivity.start(getContext(),item.getGoods_ID());
            }
        });
    }

    @Override
    protected int getItemViewLayoutId(int position, YiMeiGoodsBean item) {
        return R.layout.item_yimei_search_goods;
    }
}
