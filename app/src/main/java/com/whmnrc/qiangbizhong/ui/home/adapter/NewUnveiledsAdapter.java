package com.whmnrc.qiangbizhong.ui.home.adapter;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ServiceUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.HomePageBean;
import com.whmnrc.qiangbizhong.model.bean.HomeResult;
import com.whmnrc.qiangbizhong.ui.LoginActivity;
import com.whmnrc.qiangbizhong.ui.home.activity.AwardDetailActivity;
import com.whmnrc.qiangbizhong.util.DateUtil;
import com.whmnrc.qiangbizhong.util.UserManage;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/7.
 */

public class NewUnveiledsAdapter extends BaseAdapter<HomeResult.GoodsOpenedAwardBean> {

    private int width;

    public NewUnveiledsAdapter(Context context) {
        super(context);
        width = ((ScreenUtils.getScreenWidth() - 45)/2);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, HomeResult.GoodsOpenedAwardBean item, int position) {

        holder.setText(R.id.tv_goods_name,item.getGoods_Name())
                .setText(R.id.tv_time,"距离开奖:" + DateUtil.getDate(item.getAwardTime()))
                .setGlieuImage(R.id.iv_img,item.getGoods_ImaPath());

        TextView textView = holder.getView(R.id.tv_number_of_people);
        String str = "已有" + item.getAwardPeopleCount()+"人抢购";
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

        holder.setOnClickListener(R.id.tv_purchase, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (UserManage.getInstance().getLoginBean() != null) {
                    HomeResult.GoodsOpenedAwardBean goodsNewAwardBean = (HomeResult.GoodsOpenedAwardBean) item;
                    AwardDetailActivity.start(getContext(), goodsNewAwardBean.getAwardId());
                } else {
                    LoginActivity.start(getContext());
                }
            }
        });
    }

    @Override
    protected int getItemViewLayoutId(int position, HomeResult.GoodsOpenedAwardBean item) {
        return R.layout.item_home_new_unveileds;
    }
}
