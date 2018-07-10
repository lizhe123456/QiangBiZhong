package com.whmnrc.qiangbizhong.ui.me.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import com.whmnrc.qiangbizhong.R;
import com.whmnrc.qiangbizhong.base.BaseFragment;
import butterknife.BindView;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/7/9.
 * 代理商充值
 */

public class AgentRechargeFragment extends BaseFragment {

    @BindView(R.id.rv_list)
    RecyclerView rvList;

    public static AgentRechargeFragment newInstance() {
        Bundle args = new Bundle();
        AgentRechargeFragment fragment = new AgentRechargeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_agent_recharge;
    }

    @Override
    protected void initData() {

    }


}
