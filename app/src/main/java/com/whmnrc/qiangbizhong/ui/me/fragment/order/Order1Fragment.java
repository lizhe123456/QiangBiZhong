package com.whmnrc.qiangbizhong.ui.me.fragment.order;


import android.text.InputType;
import android.view.View;

import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.model.bean.OrderListBean;
import com.whmnrc.qiangbizhong.presenter.me.OrderPresenter;
import com.whmnrc.qiangbizhong.widget.AlertEditTextDialog;
import com.whmnrc.qiangbizhong.widget.CustomerServiceDialog;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/11.
 */

public class Order1Fragment extends BaseOrderFragment implements OrderPresenter.OrderUpdateCall {



    @Override
    public void setClick() {
        mAdapter.setOnOrderListener(new OnOrderListenerAdapter(){
            @Override
            public void customerServicePhoneClick(OrderListBean item) {
                CustomerServiceDialog customerServiceDialog = new CustomerServiceDialog(mContext, R.style.AlertDialogStyle);
                customerServiceDialog.show();
            }

            @Override
            public void refund(OrderListBean item) {
               new AlertEditTextDialog(mContext).builder().setTitle("是否确认申请退款")
                       .setTvFundZfPwd(false)
                       .setEidtMsg("请输入退款原因")
                       .setInputType(InputType.TYPE_CLASS_TEXT)
                       .setNegativeButton("取消", new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {

                           }
                       })
                       .setPositive1Button("确认", new AlertEditTextDialog.ConfirmListenter() {
                           @Override
                           public void comfrim(String content) {
                               orderPresenter.submitrefund(item.getOrder_ID(),content,Order1Fragment.this);
                           }
                       }).show();
            }


        });
    }

    @Override
    public String request() {
        return "1";
    }

    @Override
    public void updateData() {
        refresh.autoRefresh();
    }
}
