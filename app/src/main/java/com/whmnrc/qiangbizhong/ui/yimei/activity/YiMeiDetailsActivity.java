package com.whmnrc.qiangbizhong.ui.yimei.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.ui.yimei.fragment.ComprehensiveFragment;
import com.whmnrc.qiangbizhong.ui.yimei.fragment.PriceFragment;
import com.whmnrc.qiangbizhong.ui.yimei.fragment.SalesVolumeFragment;
import com.whmnrc.qiangbizhong.util.GlideuUtil;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import com.whmnrc.qiangbizhong.widget.RoundedImageView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 */

public class YiMeiDetailsActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_img)
    RoundedImageView ivImg;
    @BindView(R.id.tv_yimei_name)
    TextView tvYimeiName;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    ViewPager vpContent;

    @Override
    protected int setLayout() {
        return R.layout.activity_yimei_detail;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("医美详情");
        GlideuUtil.loadImageView(this,"",ivImg);
        tvYimeiName.setText("");
        SparseArray<String> titles = new SparseArray<>();
        SparseArray<Fragment> fragments = new SparseArray<>();
        titles.append(0,"综合");
        titles.append(1,"销量");
        titles.append(2,"价格");
        fragments.append(0, ComprehensiveFragment.newInstance());
        fragments.append(1, SalesVolumeFragment.newInstance());
        fragments.append(2, PriceFragment.newInstance());

        ViewPagerUtil.initViewPage(vpContent,tabLayout,this,fragments,titles,20,0);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
