package com.whmnrc.qiangbizhong.ui.home.adapter;

import android.content.Context;
import android.net.ParseException;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawBean;
import com.whmnrc.qiangbizhong.ui.home.activity.AwardDetailActivity;
import com.whmnrc.qiangbizhong.util.UserManage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class LuckDrawItemAdapter extends BaseAdapter<LuckDrawBean.GoodsBean> {

    private int width;


    public LuckDrawItemAdapter(Context context) {
        super(context);
        width = ((ScreenUtils.getScreenWidth() - 45) / 2);
    }

    @Override
    protected void bindDataToItemView(BaseViewHolder holder, LuckDrawBean.GoodsBean item, int position) {
        // 需要解析的日期字符串
        String dateStr = item.getAwardTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1 = "";
        String date2 = "";
        String end = item.getAwardTime();
        long lend = com.whmnrc.qiangbizhong.util.TimeUtils.string2Milliseconds(end, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String serverTime = UserManage.getInstance().getServerTime();
        long now = com.whmnrc.qiangbizhong.util.TimeUtils.string2Milliseconds(serverTime, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        long time = lend - now;
        try {
            if (time > 0) {
                long day = time / (24 * 60 * 60 * 1000);
                long hour = (time / (60 * 60 * 1000) - day * 24);
                long min = ((time / (60 * 1000)) - day * 24 * 60 - hour * 60);
                long ss = (time / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
                date1 = (hour < 10 ? "0" + hour : hour) +":"+ (min < 10 ? "0" + min : min) + ":"+ (ss < 10 ? "0" + ss : ss);
            }
            Date date = format.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH)+1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int mm = calendar.get(Calendar.MINUTE);

            date2 = month +"月"+day+"日 "+hour+":"+mm;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }


        holder.setText(R.id.tv_goods_name, item.getGoods_Name())
                .setText(R.id.tv_renshu, "总需人数："+item.getNeedCount()+ "")
                .setText(R.id.tv_time,  "距开奖仅剩："+ date1).setText(R.id.tv_edit, item.getNeedCount() + "")
                .setText(R.id.tv_date, date2).setText(R.id.tv_edit,"已报名人数："+item.getAwardPeopleCount());
        holder.setGlieuImage(R.id.iv_img, item.getGoods_ImaPath());
        ImageView imageView = holder.getView(R.id.iv_img);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        imageView.setLayoutParams(layoutParams);
        holder.setOnClickListener(R.id.rl_confirm, v -> AwardDetailActivity.start(getContext(),item.getAwardId()));
    }

    @Override
    protected int getItemViewLayoutId(int position, LuckDrawBean.GoodsBean item) {
        return R.layout.item_luck_draw;
    }
}
