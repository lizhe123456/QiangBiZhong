package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseActivity;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/28.
 */

public class StatusActivity extends BaseActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_state_img)
    ImageView ivStateImg;
    @BindView(R.id.tv_state)
    TextView tvState;


    public static void start(Context context,int imgRes,String state,String title) {
        Intent starter = new Intent(context, StatusActivity.class);
        starter.putExtra("imgRes",imgRes);
        starter.putExtra("state",state);
        starter.putExtra("title",title);
        context.startActivity(starter);
    }

    @Override
    protected int setLayout() {
        return R.layout.activity_status;
    }

    @Override
    protected void setData() {
        ivBack.setVisibility(View.VISIBLE);
        String title = getIntent().getStringExtra("title");
        String state = getIntent().getStringExtra("state");
        int img = getIntent().getIntExtra("imgRes",0);
        tvState.setText(state);
        tvTitle.setText(title);
        ivStateImg.setImageResource(img);
    }


    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }
}
