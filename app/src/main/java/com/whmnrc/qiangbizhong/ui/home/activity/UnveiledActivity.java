package com.whmnrc.qiangbizhong.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.ui.home.fragment.OpenLuckDrawFragment;
import com.whmnrc.qiangbizhong.ui.home.fragment.WaitLuckDrawFragment;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class UnveiledActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_menu)
    ImageView ivMenu;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.ll_title)
    RelativeLayout llTitle;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    ViewPager vpContent;

    SparseArray<Fragment> fragments;
    SparseArray<String> strings;

    public static void start(Context context) {
        Intent starter = new Intent(context, UnveiledActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_unveiled;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        strings = new SparseArray<>();
        fragments = new SparseArray<>();
        strings.append(0,"中奖用户");
        strings.append(1,"等待开奖");
        fragments.append(0,new OpenLuckDrawFragment());
        fragments.append(1,new WaitLuckDrawFragment());
        ViewPagerUtil.initViewPage(vpContent,tabLayout,this,fragments,strings,60,0);
        tvTitle.setText("最新揭晓");
        ivBack.setVisibility(View.VISIBLE);

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }



}
