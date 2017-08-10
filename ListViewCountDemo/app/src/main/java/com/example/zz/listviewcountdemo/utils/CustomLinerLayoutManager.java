package com.example.zz.listviewcountdemo.utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

/**
 * 类描述：
 * 创建人：zz
 * 创建时间： 2017/8/9 18:24
 */


public class CustomLinerLayoutManager extends LinearLayoutManager{
    private boolean isScrollEnabled = true;                        //用来控制recyclerview是否可以滑动
    public CustomLinerLayoutManager(Context context) {
        super(context);
    }

    public CustomLinerLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }

    @Override
    public boolean canScrollVertically() {
        return isScrollEnabled && super.canScrollVertically();
    }
}
