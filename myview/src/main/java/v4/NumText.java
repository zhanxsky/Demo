package v4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.zhan.myapplication.R;

import v3.BaseView;

/**
 * Created by realsys on 2015/8/25.
 */
public class NumText extends BaseView {
    private Paint paint = new Paint();
    private int lineNum = 10;
    private float mx = 0;
    private boolean xScroll = false;
    public NumText(Context context) {
        super(context);
    }

    public NumText(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.NumText);
        lineNum = ta.getInt(R.styleable.NumText_lineNum,1);
        xScroll = ta.getBoolean(R.styleable.NumText_xScroll,false);
        ta.recycle();
    }

    @Override
    protected void drawSub(Canvas canvas) {
        for (int i = 0; i < lineNum; i++) {
            int textSize = 30+i;
            paint.setTextSize(textSize);

            canvas.drawText("极客学院",mx,textSize+textSize*i,paint);
        }

    }

    @Override
    protected void logic() {
        if(xScroll){
            mx += 3;
            if(mx > getWidth()){
                mx = 0 - paint.measureText("极客学院");
            }
        }

    }
}
