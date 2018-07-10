package com.whmnrc.qiangbizhong.ui.me;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import com.whmnrc.qiangbizhong.base.BasePresenter;
import com.whmnrc.qiangbizhong.base.BaseView;
import com.whmnrc.qiangbizhong.base.adapter.BaseAdapter;
import com.whmnrc.qiangbizhong.model.bean.MineBean;
import com.whmnrc.qiangbizhong.ui.me.activity.AccountRechargeActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.AddressManageActivity;
import com.whmnrc.qiangbizhong.ui.me.adapter.OderMenuAdapter;
import com.whmnrc.qiangbizhong.ui.me.adapter.OptionAdapter;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/6.
 */

public class MineFragment extends BaseFragment {

    @BindView(R.id.iv_scan)
    ImageView ivScan;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_purchase_restrictions)
    TextView tvPurchaseRestrictions;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_yudou)
    TextView tvYudou;
    @BindView(R.id.rv_menu)
    RecyclerView rvMenu;
    @BindView(R.id.rv_option)
    RecyclerView rvOption;

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initData() {
        MineBean mineBean = new MineBean();
        mineBean.initMineBean();
        initMenu(mineBean.getMenuBeans());
        initOption(mineBean.getItemBeans());
    }

    private void initOption(List<MineBean.ItemBean> itemBeans) {
        rvOption.setLayoutManager(new LinearLayoutManager(getContext()));
        rvOption.setNestedScrollingEnabled(false);
        OptionAdapter optionAdapter = new OptionAdapter(getContext());
        rvOption.setAdapter(optionAdapter);
        optionAdapter.addFirstDataSet(itemBeans);
        optionAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onClick(View view, Object item, int position) {
                switch (position){
                    case 0:
                        //赠送记录

                        break;
                    case 1:
                        //我的抵用券
                        break;
                    case 2:
                        //成为会员
                        AccountRechargeActivity.start(getContext(),1);
                        break;
                    case 3:
                        //我是代理商
                        break;
                    case 4:
                        //商品发布
                        break;
                    case 5:
                        //我的收藏
                        break;
                    case 6:
                        //收货信息
                        AddressManageActivity.start(getContext());
                        break;
                    case 7:
                        //意见反馈
                        break;
                    case 8:
                        //设置
                        break;
                }
            }
        });
    }


    private void initMenu(List<MineBean.MenuBean> menuBeans) {
        OderMenuAdapter oderMenuAdapter = new OderMenuAdapter(getContext());
        rvMenu.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMenu.setNestedScrollingEnabled(false);
        rvMenu.setAdapter(oderMenuAdapter);
        oderMenuAdapter.addFirstDataSet(menuBeans);

    }


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }


    @OnClick({R.id.iv_scan, R.id.iv_head, R.id.tv_purchase_restrictions})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_scan:
                break;
            case R.id.iv_head:
                break;
            case R.id.tv_purchase_restrictions:
                break;
        }
    }
}
