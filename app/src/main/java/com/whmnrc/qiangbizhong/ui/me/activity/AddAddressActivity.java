package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/10.
 */

public class AddAddressActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;


    public static void start(Context context) {
        Intent starter = new Intent(context, AddAddressActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_add_address;
    }

    @Override
    protected void setData() {
        tvTitle.setText("新增收货地址");
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
