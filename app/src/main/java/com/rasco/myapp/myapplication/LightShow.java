package com.rasco.myapp.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Admin on 2/5/2018.
 */

public class LightShow extends View {

    private float roll = 0;

    public LightShow(Context context){
        super(context);
    }

    public void redraw(float roll) {
        this.roll = roll;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        if (roll < -10) {
            paint.setColor(Color.RED);
//            LogUtil.i("Negative roll: " + roll);
        } else if (roll > -10 && roll < 10) {
            paint.setColor(Color.WHITE);
//            LogUtil.i("Negative roll: " + roll);
        } else {
            paint.setColor(Color.BLUE);
//            LogUtil.i("positive roll: " + roll);
        }
        canvas.drawPaint(paint);
    }

}
