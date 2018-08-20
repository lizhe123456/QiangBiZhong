package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.ui.me.activity.MyOrderActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/16.
 */

public class PayStuActivity extends BaseActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_pay_stu)
    TextView tvPayStu;
    @BindView(R.id.tv_to_order)
    TextView tvToOrder;

    private int type;

    public static void start(Context context, int type) {
        Intent starter = new Intent(context, PayStuActivity.class);
        starter.putExtra("type", type);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_pay_stu;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        type = getIntent().getIntExtra("type",0);
        tvTitle.setText("支付结果");
        if (type == 0){
            tvPayStu.setText("购买失败");
            tvToOrder.setText("返回重新购买");
        }else if (type == 1){
            tvPayStu.setText("购买成功");
            tvToOrder.setText("查看订单详情");
        }
    }


    @OnClick({R.id.iv_back, R.id.tv_to_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_to_order:
                if (type == 1){
                    MyOrderActivity.start(this,4);
                }else if (type == 0){
                    this.finish();
                }
                break;
        }
    }
}
