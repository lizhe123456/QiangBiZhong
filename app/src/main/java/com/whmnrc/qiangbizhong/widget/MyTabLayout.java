package com.whmnrc.qiangbizhong.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import java.lang.reflect.Field;

/**
 * Company 武汉麦诺软创
 * Created by lizhe on 2018/8/10.
 */

public class MyTabLayout extends TabLayout {

    public MyTabLayout(Context context)
    {
        super(context);
    }

    public MyTabLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public MyTabLayout(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void addTab(@NonNull Tab tab, int position, boolean setSelected)
    {
        super.addTab(tab, position, setSelected);
        setTab(tab);
    }

    void setTab(Tab tab)
    {
        try
        {
            Field mViewF = Tab.class.getDeclaredField("mView");
            mViewF.setAccessible(true);
            LinearLayout mView = (LinearLayout) mViewF.get(tab);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            layoutParams.weight = 1;
            mView.setLayoutParams(layoutParams);
        } catch (NoSuchFieldException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}
