package myview2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by realsys on 2015/8/25.
 */
public class LogicView extends View {
    private Paint paint = new Paint();
    private float rx = 0;
    private MyThread myThread;
    private RectF rectF = new RectF(0,60,100,160);
    private int sweetAngle;

    public LogicView(Context context) {
        super(context);
    }

    public LogicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LogicView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setTextSize(30);
        canvas.drawText("LogicView", rx, 30, paint);
        canvas.drawArc(rectF,0,sweetAngle,true,paint);
        if (myThread == null) {
            myThread = new MyThread();
            myThread.start();
        }

    }

    class MyThread extends Thread {
        Random random = new Random();
        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    rx += 3;
                    if(rx > getWidth()){
                        rx = 0 - paint.measureText("LogicView");
                    }
                    sweetAngle ++;
                    if(sweetAngle > 360) {
                        sweetAngle = 0;
                    }
                    paint.setARGB(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
                    postInvalidate();
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
