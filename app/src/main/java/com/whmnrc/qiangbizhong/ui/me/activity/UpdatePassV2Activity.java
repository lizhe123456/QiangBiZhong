package com.whmnrc.qiangbizhong.ui.me.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.presenter.me.UserPresenter;
import com.whmnrc.qiangbizhong.util.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/18.
 */

public class UpdatePassV2Activity extends BaseActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_menu)
    TextView tvMenu;
    @BindView(R.id.et_nick_text)
    EditText etNickText;

    UserPresenter userPresenter;

    public static void start(Context context,String name) {
        Intent starter = new Intent(context, UpdatePassV2Activity.class);
        starter.putExtra("name",name);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_update_nick_name;
    }

    @Override
    protected void setData() {
        tvMenu.setText("保存");
        userPresenter = new UserPresenter(this);
        String name = getIntent().getStringExtra("name");
        etNickText.setText(name);
        ivBack.setVisibility(View.VISIBLE);
        tvMenu.setVisibility(View.VISIBLE);
    }


    @OnClick({R.id.iv_back, R.id.tv_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_menu:
                if (TextUtils.isEmpty(etNickText.toString())){
                    ToastUtils.showShort("请输入昵称");
                    return;
                }
                userPresenter.updateNickName(etNickText.toString());
                this.finish();
                break;
        }
    }
}
