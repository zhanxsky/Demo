package v3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

/**
 * Created by realsys on 2015/8/25.
 */
public class LogicView extends BaseView {
    private RectF rectF = new RectF(0,60,100,160);
    private int sweetAngle;
    private Paint paint = new Paint();
    private float rx = 0;
    public LogicView(Context context) {
        super(context);
    }

    public LogicView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        paint.setTextSize(30);
        canvas.drawText("LogicView", rx, 30, paint);
        canvas.drawArc(rectF, 0, sweetAngle, true, paint);
    }

    @Override
    protected void logic() {
        rx += 3;
        if(rx > getWidth()){
            rx = 0 - paint.measureText("LogicView");
        }
        sweetAngle ++;
        if(sweetAngle > 360) {
            sweetAngle = 0;
        }
        paint.setARGB(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

    }
}
