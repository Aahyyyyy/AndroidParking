package com.myapplication1.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * @author : Aahyyyyy
 * @date : 2022/3/7 21:17
 */
@SuppressLint("AppCompatCustomView")
public class MyImageView extends ImageView {
    //圆角弧度
    private float[] rids = {15.0f,15.0f,15.0f,15.0f,0.0f,0.0f,0.0f,0.0f,};

    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    protected void onDraw(Canvas canvas) {
        @SuppressLint("DrawAllocation")
        Path path = new Path();
        int w = this.getWidth();
        int h = this.getHeight();
        // 绘制圆角imageview
        path.addRoundRect(new RectF(0,0,w,h),rids, Path.Direction.CW);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
