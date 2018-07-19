package com.whmnrc.qiangbizhong.ui.me.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import com.whmnrc.qiangbizhong.presenter.me.UserPresenter;
import butterknife.BindView;
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
    @BindView(R.id.tv_title)
    TextView tvTitle;
    UserPresenter userPresenter;


    public static void start(Activity context, String name) {
        Intent starter = new Intent(context, UpdatePassV2Activity.class);
        starter.putExtra("name", name);
        context.startActivityForResult(starter,101);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_update_nick_name;
    }

    @Override
    protected void setData() {
        tvMenu.setText("保存");
        tvTitle.setText("修改昵称");
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
                if (TextUtils.isEmpty(etNickText.getText().toString())) {
                    ToastUtils.showShort("请输入昵称");
                    return;
                }
                userPresenter.updateNickName(etNickText.getText().toString());
                setResult(102,new Intent().putExtra("name",etNickText.getText().toString()));
                this.finish();
                break;
        }
    }

}
