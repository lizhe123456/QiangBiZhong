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
import com.whmnrc.qiangbizhong.ui.me.fragment.shop.GoodsInfoFragment;
import com.whmnrc.qiangbizhong.ui.me.fragment.shop.ShopRFragment;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class MyShopActivity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_img)
    RoundedImageView ivImg;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    ViewPager vpContent;

    public static void start(Context context) {
        Intent starter = new Intent(context, MyShopActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_my_shop;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("代理商");
        SparseArray<Fragment> fragments = new SparseArray<>();
        SparseArray<String> strings = new SparseArray<>();
        strings.append(0,"商品信息");
        strings.append(1,"销售明细");
        fragments.append(0, GoodsInfoFragment.newInstance());
        fragments.append(1, ShopRFragment.newInstance());
        ViewPagerUtil.initViewPage(vpContent,tabLayout,this,fragments,strings,40,0);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
