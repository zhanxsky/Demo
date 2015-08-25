package com.zhan.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

/**
 * Created by realsys on 2015/8/25.
 */
public class RainView extends BaseView {
    private float startX;
    private float startY;
    private float stopX;
    private float stopY;
    private Paint paint;
    private float sizeX;
    private float sizeY;
    public RainView(Context context) {
        super(context);
        sizeX = 10;
        sizeY = 30;
        startX = 100;
        startY = 0;
        stopX = startX +sizeX;
        stopY = startY+sizeY;
        paint = new Paint();
        paint.setColor(0xffffffff);
    }

    public RainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        sizeX = 10;
        sizeY = 30;
        startX = 100;
        startY = 0;
        stopX = startX +sizeX;
        stopY = startY+sizeY;
        paint = new Paint();
        paint.setColor(0xffffffff);
    }

    @Override
    protected void drawSub(Canvas canvas) {

        canvas.drawLine(startX,startY,stopX,stopY,paint);
    }

    @Override
    protected void logic() {
        float dou = 0.3f;
        startX +=sizeX*dou;
        stopX +=sizeX*dou;
        startY += sizeY*dou;
        stopY +=sizeY*dou;



        if(startY > getHeight()){
            startY = 0;
            stopY = startY+sizeY;
            startX = 100;
            stopX = startX +sizeX;
        }
    }
}
