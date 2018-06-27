package com.gallery.myapplication;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by yuan.zhen.xing on 2018-06-27.
 */

public class MyRecyclerView extends RecyclerView {
    private View currentView;

    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.setOnScrollListener(this);
    }



    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 滚动时回调的接口
     */
    private OnItemScrollChangeListener mItemScrollChangeListener;

    public void setOnItemScrollChangeListener(OnItemScrollChangeListener mItemScrollChangeListener) {
        this.mItemScrollChangeListener = mItemScrollChangeListener;
    }

    public interface OnItemScrollChangeListener {
        void onChange(View view, int position);
    }
    private void setOnScrollListener(MyRecyclerView myRecyclerView) {

    }


    @Override
    public void onScrolled(int dx, int dy) {
        View newView = getChildAt(0);
        if (mItemScrollChangeListener != null) {
            if (newView != null && newView != currentView) {
                currentView = newView ;
                mItemScrollChangeListener.onChange(currentView, getChildPosition(currentView));
            }
        }
    }
}
