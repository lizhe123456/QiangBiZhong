package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.Order1Fragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.Order2Fragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.Order3Fragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.Order4Fragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.Order5Fragment;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class MyOrderActivity extends BaseActivity {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    ViewPager vpContent;

    SparseArray<Fragment> fragments;
    SparseArray<String> strings;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public static void start(Context context,int page) {
        Intent starter = new Intent(context, MyOrderActivity.class);
        starter.putExtra("page",page);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_my_order;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("我的订单");
        strings = new SparseArray<>();
        fragments = new SparseArray<>();
        strings.append(0,"待发货");
        strings.append(1,"已发货");
        strings.append(2,"已完成");
        strings.append(3,"待评价");
        strings.append(4,"全部订单");
        fragments.append(0,new Order1Fragment());
        fragments.append(1,new Order2Fragment());
        fragments.append(2,new Order3Fragment());
        fragments.append(3,new Order5Fragment());
        fragments.append(4,new Order4Fragment());
        ViewPagerUtil.initViewPage(vpContent,tabLayout,this,fragments,strings,0,getIntent().getIntExtra("page",0));

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
