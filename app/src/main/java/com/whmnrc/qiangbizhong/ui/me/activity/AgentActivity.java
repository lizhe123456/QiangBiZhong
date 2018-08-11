package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.model.bean.AgentShopBean;
import com.whmnrc.qiangbizhong.presenter.me.AgentPresenter;
import com.whmnrc.qiangbizhong.ui.me.fragment.AgentRechargeFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.OpenVipFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.RechargeFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.shop.GoodsInfoFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.shop.ShopRFragment;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/11.
 */

public class AgentActivity extends BaseActivity implements AgentPresenter.AgentShopInfoCall{


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_img)
    RoundedImageView ivImg;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    private AgentPresenter agentPresenter;


    public static void start(Context context) {
        Intent starter = new Intent(context, AgentActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_agent;
    }

    @Override
    protected void setData() {
        tvTitle.setText("我的店铺");
        ivBack.setVisibility(View.VISIBLE);
        agentPresenter = new AgentPresenter(this);
        agentPresenter.getagentshopinfo(this);

        SparseArray<Fragment> fragments = new SparseArray<>();
        SparseArray<String> strings = new SparseArray<>();
        strings.append(0,"商品信息");
        strings.append(1,"销售明细");
        fragments.append(0, GoodsInfoFragment.newInstance());
        fragments.append(1, ShopRFragment.newInstance());
        ViewPagerUtil.initViewPage(vpContent,tabLayout,this,fragments,strings,80,0);

    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    @Override
    public void error() {

    }

    @Override
    public void AgentShopInfoaBack(AgentShopBean agentShopBean) {
        if (agentShopBean != null) {
            GlideuUtil.loadImageView(this, agentShopBean.getHeadImage(), ivImg);
            tvName.setText(agentShopBean.getAgentName());
        }
    }
}
