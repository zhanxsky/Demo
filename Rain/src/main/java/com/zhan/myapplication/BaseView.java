package com.zhan.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by realsys on 2015/8/25.
 */
public abstract class BaseView extends View {

    private MyThread myThread;

    Random random = new Random();

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected abstract void drawSub(Canvas canvas);
    protected abstract void logic();
    @Override
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (myThread == null) {
            myThread = new MyThread();
            myThread.start();
        } else {
            drawSub(canvas);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        running = false;
        super.onDetachedFromWindow();
    }

    private boolean running = true;
    class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            while (running) {
                logic();
                try {
                    postInvalidate();
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
