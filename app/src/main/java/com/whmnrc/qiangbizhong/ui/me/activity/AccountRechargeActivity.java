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
import com.whmnrc.qiangbizhong.ui.me.fragment.AgentRechargeFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.OpenVipFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.RechargeFragment;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 * 账户充值
 */

public class AccountRechargeActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tab_layout)
    TabLayout tlTitle;
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    private SparseArray<Fragment> fragments;
    private SparseArray<String> titles;

    private int page;

    @Override
    protected int setLayout() {
        return R.layout.activity_account_recharge;
    }

    public static void start(Context context,int page) {
        Intent starter = new Intent(context, AccountRechargeActivity.class);
        starter.putExtra("page",page);
        context.startActivity(starter);
    }

    @Override
    protected void setData() {
        tvTitle.setText("账户充值");
        ivBack.setVisibility(View.VISIBLE);
        fragments = new SparseArray<>();
        titles = new SparseArray<>();
        fragments.append(0, OpenVipFragment.newInstance());
        fragments.append(1, RechargeFragment.newInstance());
        titles.append(0,"会员充值");
        titles.append(1,"普通充值");
        page = getIntent().getIntExtra("page",0);
        ViewPagerUtil.initViewPage(vpContent,tlTitle,this,fragments,titles,60,page);

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }


}
