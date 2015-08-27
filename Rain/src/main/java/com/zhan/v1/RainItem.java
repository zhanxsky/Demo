package com.zhan.v1;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Random;

/**
 * Created by realsys on 2015/8/27.
 */
public class RainItem {
    private float startX;
    private float startY;
    private float stopX;
    private float stopY;
    private Paint paint;
    private float sizeX;
    private float sizeY;

    private int width;
    private int height;
    private Random random;
    private float opt;

    public RainItem(int width,int height){
        this.width = width;
        this.height = height;
        init();
    }

    public void init() {
        random = new Random();
        sizeX = 1+random.nextInt(10);
        sizeY = 10+random.nextInt(20);
        startX = random.nextInt(width);
        startY = random.nextInt(height);
        stopX = startX + sizeX;
        stopY = startY + sizeY;
        opt = 0.2f + random.nextFloat();
        paint = new Paint();
        paint.setColor(0xffffffff);
    }

    public void move() {
        startX += sizeX * opt;
        stopX += sizeX * opt;
        startY += sizeY * opt;
        stopY += sizeY * opt;
        if (startY > height) {
//            startY = random.nextInt(height);
//            stopY = 0;
//            startX = 100;
//            stopX = startX + sizeX;
            init();
        }
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(startX, startY, stopX, stopY, paint);
    }
}
