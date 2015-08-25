package com.zhan.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by realsys on 2015/8/25.
 */
public class MyView extends View {

    private Bitmap bitmap;
    public MyView(Context context) {
        super(context);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.github);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.github);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.github);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setTextSize(30);
        //绘制成空心
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawText("this is on Draw", 0, 30, paint);
        canvas.drawLine(0, 60, 100, 60, paint);
//        canvas.drawRect(0, 90, 100, 190, paint);

//        Rect rect = new Rect(0, 90, 100, 190);
//        canvas.drawRect(rect,paint);
//
        RectF rectF = new RectF(0, 90, 100, 190);
//        canvas.drawRect(rectF,paint);

        canvas.drawRoundRect(rectF, 10, 10, paint);

        canvas.drawCircle(50, 270, 50, paint);
        canvas.drawBitmap(bitmap,0,350,paint);
    }
}
