package com.example.mydeleteadapter.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;

import androidx.annotation.RequiresApi;

import com.example.mydeleteadapter.R;

public class MyScrollView extends HorizontalScrollView {

    int btn_width;
    Button btn;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOverScrollMode(OVER_SCROLL_NEVER);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(changed) {

            btn = findViewById(R.id.myDelete);
            btn_width = btn.getWidth();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                changeScrollx();            //根据滑动距离判断是否显示删除按钮
                return false;
            default:
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void changeScrollx(){
        //触摸滑动的距离大于删除按钮宽度的一半
        if(getScrollX() >= (btn_width/2)){
            //显示删除按钮
            this.smoothScrollTo(btn_width, 0);
        }else{
            //隐藏删除按钮
            this.smoothScrollTo(0, 0);
        }
    }
}
