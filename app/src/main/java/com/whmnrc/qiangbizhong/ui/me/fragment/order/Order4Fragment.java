package com.whmnrc.qiangbizhong.ui.me.fragment.order;


import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.ui.shop.activity.FlashSaleDetailsActivity;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class Order4Fragment extends BaseOrderFragment implements OrderPresenter.CancelCall,OrderPresenter.CollectCall{


    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter(){
            @Override
            public void toQiangGou(OrderListBean item) {
                FlashSaleDetailsActivity.start(getContext(),item.getRushRecord().getRushId(),0);
            }

            @Override
            public void cancel(OrderListBean item) {
                showLoading("取消中..");
                orderPresenter.abandon(item.getRushRecord().getRushId(),Order4Fragment.this);
            }

            @Override
            public void collectGoods(OrderListBean item) {
                orderPresenter.collectgoods(item.getOrder_ID(),Order4Fragment.this);
            }

        });
    }

    @Override
    public String request() {
        return "all";
    }

    @Override
    public void cancelS() {

    }

    @Override
    public void collect() {
        refresh.autoRefresh();
    }
}
