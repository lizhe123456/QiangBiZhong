package com.whmnrc.qiangbizhong.ui.home.adapter;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ServiceUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.HomePageBean;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class NewUnveiledsAdapter extends BaseAdapter<HomePageBean.NewUnveiled> {

    private int width;

    public NewUnveiledsAdapter(Context context) {
        super(context);
        width = ((ScreenUtils.getScreenWidth() - 45)/2);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomePageBean.NewUnveiled item, int position) {
        holder.setText(R.id.tv_goods_name,item.getName())
                .setText(R.id.tv_number_of_people,item.getParticipateIn()+"")
                .setText(R.id.tv_time,"距离开奖:" + item.getTime())
                .setGlieuImage(R.id.iv_img,item.getUrl());

        TextView textView = holder.getView(R.id.tv_number_of_people);
        String str = "已有" + item.getParticipateIn()+"人抢购";
        textView.setText(str);
        Spannable span = new SpannableString(textView.getText());
        span.setSpan(new AbsoluteSizeSpan(38), 2, str.length()-3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.goods_price)), 2, str.length()-3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(span);

        ImageView imageView = holder.getView(R.id.iv_img);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        imageView.setLayoutParams(layoutParams);
    }

    @Override
    protected int getItemViewLayoutId(int position, HomePageBean.NewUnveiled item) {
        return R.layout.item_home_new_unveileds;
    }
}
