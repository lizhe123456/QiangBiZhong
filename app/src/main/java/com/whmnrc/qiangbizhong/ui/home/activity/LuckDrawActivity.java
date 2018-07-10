package com.whmnrc.qiangbizhong.ui.home.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.FragmentUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.base.BasePresenter;
import com.whmnrc.qiangbizhong.base.BaseView;
import com.whmnrc.qiangbizhong.ui.home.fragment.LuckDrawFragment;
import com.whmnrc.qiangbizhong.ui.home.fragment.MyLuckDrawFragment;
import com.whmnrc.qiangbizhong.ui.home.fragment.RuleFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 */

public class LuckDrawActivity extends BaseActivity {

    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.tv_luck_draw)
    TextView tvLuckDraw;
    @BindView(R.id.tv_my_luck_draw)
    TextView tvMyLuckDraw;
    @BindView(R.id.tv_rule)
    TextView tvRule;

    private final int LUCKDRAW = 0;
    private final int MYLUCKDRAW = 1;
    private final int RULE = 2;


    private Fragment showFragment;
    private int shopIndex = LUCKDRAW;
    private List<Fragment> fragments;

    public static void start(Context context) {
        Intent starter = new Intent(context, LuckDrawActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_luck_draw;
    }

    @Override
    protected void setData() {
        fragments = new ArrayList<>();
        fragments.add(LuckDrawFragment.newInstance());
        fragments.add(MyLuckDrawFragment.newInstance());
        fragments.add(RuleFragment.newInstance());
        FragmentUtils.add(getSupportFragmentManager(), fragments, R.id.fl_content, LUCKDRAW);
        showFragment = fragments.get(LUCKDRAW);
        switchBtn(LUCKDRAW);
    }

    private void switchBtn(int index) {
        tvLuckDraw.setSelected(false);
        tvLuckDraw.setTextColor(getResources().getColor(R.color.tv_navigation));
        tvMyLuckDraw.setSelected(false);
        tvMyLuckDraw.setTextColor(getResources().getColor(R.color.tv_navigation));
        tvRule.setSelected(false);
        tvRule.setTextColor(getResources().getColor(R.color.tv_navigation));
        switch (index){
            case LUCKDRAW:
                tvLuckDraw.setSelected(true);
                tvLuckDraw.setTextColor(getResources().getColor(R.color.tv_navigation_select));
                break;
            case MYLUCKDRAW:
                tvMyLuckDraw.setSelected(true);
                tvMyLuckDraw.setTextColor(getResources().getColor(R.color.tv_navigation_select));
                break;
            case RULE:
                tvRule.setSelected(true);
                tvRule.setTextColor(getResources().getColor(R.color.tv_navigation_select));
                break;
        }
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected BaseView createView() {
        return null;
    }

    private void switchFragment(int index){
        if (index != shopIndex) {
            FragmentUtils.showHide(fragments.get(index), showFragment);
            switchBtn(index);
            showFragment = fragments.get(index);
            shopIndex = index;
        }
    }


    @OnClick({R.id.tv_luck_draw, R.id.tv_my_luck_draw, R.id.tv_rule})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_luck_draw:
                switchFragment(LUCKDRAW);
                break;
            case R.id.tv_my_luck_draw:
                switchFragment(MYLUCKDRAW);
                break;
            case R.id.tv_rule:
                switchFragment(RULE);
                break;
        }
    }


}
