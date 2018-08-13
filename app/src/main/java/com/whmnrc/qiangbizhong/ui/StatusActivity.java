package com.whmnrc.qiangbizhong.ui;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.qiangbizhong.MainActivity;
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

    private int type;

    public static void start(Context context,int type,String state,String title) {
        Intent starter = new Intent(context, StatusActivity.class);
        starter.putExtra("type",type);
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
        type = getIntent().getIntExtra("type",0);
        tvState.setText(state);
        tvTitle.setText(title);
        if (type == 0){
            ivStateImg.setImageResource(R.drawable.ic_e);
        }else if (type == 1){
            ivStateImg.setImageResource(R.drawable.ic_s);
        }

    }

    /**
     * 监听Back键按下事件,方法2:
     * 注意:
     * 返回值表示:是否能完全处理该事件
     * 在此处返回false,所以会继续传播该事件.
     * 在具体项目中此处的返回值视情况而定.
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            MainActivity.start(this, 2);
            return false;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }




        @OnClick(R.id.iv_back)
    public void onViewClicked() {
        MainActivity.start(this,2);
    }
}
