package com.whmnrc.qiangbizhong.ui.me.fragment.order;


import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.widget.CustomerServiceDialog;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class Order1Fragment extends BaseOrderFragment {



    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter(){
            @Override
            public void customerServicePhoneClick(OrderListBean item) {
                CustomerServiceDialog customerServiceDialog = new CustomerServiceDialog(mContext, R.style.AlertDialogStyle);
                customerServiceDialog.show();
            }
        });
    }

    @Override
    public String request() {
        return "1";
    }

}
