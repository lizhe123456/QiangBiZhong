package com.whmnrc.qiangbizhong.ui.home.adapter;

import android.content.Context;
import android.net.ParseException;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.TimeUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.base.adapter.BaseViewHolder;
import com.whmnrc.qiangbizhong.model.bean.LuckDrawBean;

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
        try {
            Date date = format.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int month = calendar.get(Calendar.MONTH)+1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            date1 = month+"月"+day+"日 "+hour+"0 ：00";

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }


        holder.setText(R.id.tv_goods_name, item.getGoods_Name()).setText(R.id.tv_renshu, item.getAwardPeopleCount() + "").setText(R.id.tv_time,  com.whmnrc.qiangbizhong.util.TimeUtils.getTimeDifference(TimeUtils.getNowString(),item.getAwardTime())).setText(R.id.tv_edit, item.getNeedCount() + "").setText(R.id.tv_date, date1);
        holder.setGlieuImage(R.id.iv_img, item.getGoods_ImaPath());
        ImageView imageView = holder.getView(R.id.iv_img);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = width;
        imageView.setLayoutParams(layoutParams);
    }

    @Override
    protected int getItemViewLayoutId(int position, LuckDrawBean.GoodsBean item) {
        return R.layout.item_luck_draw;
    }
}
