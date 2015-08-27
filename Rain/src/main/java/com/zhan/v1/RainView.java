package com.zhan.v1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by realsys on 2015/8/25.
 */
public class RainView extends BaseView {

    private int rainNum = 80;
//    private RainItem rainItem;
    private List<RainItem> rainItems = new ArrayList<RainItem>();


    public RainView(Context context) {
        super(context);
    }

    public RainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void drawSub(Canvas canvas) {
//        rainItem.draw(canvas);
        for (RainItem rainItem:rainItems){
            rainItem.draw(canvas);
        }
    }

    @Override
    protected void logic() {
//        rainItem.move();
        for (RainItem rainItem:rainItems){
            rainItem.move();
        }
    }

    @Override
    protected void init() {
//        rainItem = new RainItem(getWidth(), getHeight());
        for (int i = 0; i < rainNum; i++) {
            RainItem rainItem = new RainItem(getWidth(), getHeight());
            rainItems.add(rainItem);
        }
    }
}
