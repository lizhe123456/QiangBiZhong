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
import com.whmnrc.qiangbizhong.presenter.shop.GoodsPresenter;
import com.whmnrc.qiangbizhong.ui.me.fragment.order.goods.AllGoodsFragment;
import com.whmnrc.qiangbizhong.util.UserManage;
import com.whmnrc.qiangbizhong.util.ViewPagerUtil;
import com.whmnrc.qiangbizhong.widget.AlertDialog;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/23.
 * 商品管理
 */

public class GoodsManageActivity extends BaseActivity implements GoodsPresenter.GoodsGoupCall {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.vp_content)
    ViewPager vpContent;

    private int page;
    private GoodsPresenter goodsPresenter;
    private int all;

    public static void start(Context context,int page) {
        Intent starter = new Intent(context, GoodsManageActivity.class);
        starter.putExtra("page",page);
        context.startActivity(starter);
    }


    @Override
    protected int setLayout() {
        return R.layout.activity_goods_manage;
    }

    @Override
    protected void setData() {
        tvTitle.setText("商品管理");
        tvMenu.setVisibility(View.VISIBLE);
        ivBack.setVisibility(View.VISIBLE);
        goodsPresenter = new GoodsPresenter(this);
        SparseArray<Fragment> fragments = new SparseArray<>();
        SparseArray<String> title = new SparseArray<>();
        title.append(0,"所有商品");
        title.append(1,"上架商品");
        title.append(2,"下架商品");
        title.append(3,"已售空");
        fragments.append(0, AllGoodsFragment.newInstance("all"));
        fragments.append(1, AllGoodsFragment.newInstance("1"));
        fragments.append(2, AllGoodsFragment.newInstance("0"));
        fragments.append(3, AllGoodsFragment.newInstance("2"));
        page = getIntent().getIntExtra("page",0);
        ViewPagerUtil.initViewPage(vpContent,tabLayout,this,fragments,title,20,page);

        vpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (vpContent.getCurrentItem() == 1){
                    all = 1;
                    tvMenu.setText("全部下架");
                }else if (vpContent.getCurrentItem() == 2){
                    all = 2;
                    tvMenu.setText("全部上架");
                }else {
                    tvMenu.setText("");
                }
            }

            @Override
            public void onPageSelected(int position) {
//                EventBus.getDefault().post(new Update());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    @OnClick({R.id.iv_back, R.id.tv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_menu:
                //全部下架
                if (all == 1){
                    new AlertDialog(this).builder().setMsg("本次商品确定架吗？")
                            .setNegativeButton("取消", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            }).setPositiveButton("确认", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (UserManage.getInstance().getLoginBean().getStoreInfo() != null) {
                                goodsPresenter.setstoregoodsgoup(UserManage.getInstance().getLoginBean().getStoreInfo().getId(), 0, GoodsManageActivity.this);
                            }
                        }
                    }).show();
                }else if (all == 2){
                    new AlertDialog(this).builder().setMsg("本次商品确定上架吗？")
                            .setNegativeButton("取消", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            }).setPositiveButton("确认", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (UserManage.getInstance().getLoginBean().getStoreInfo() != null) {
                                goodsPresenter.setstoregoodsgoup(UserManage.getInstance().getLoginBean().getStoreInfo().getId(), 1, GoodsManageActivity.this);
                            }
                        }
                    }).show();
                }

                break;
        }
    }

    @Override
    public void error() {

    }

    @Override
    public void goodsgoup() {
        EventBus.getDefault().post(new Update());
    }

    public class Update{

    }
}
