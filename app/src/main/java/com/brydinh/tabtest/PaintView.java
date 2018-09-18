package com.brydinh.tabtest;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.ViewGroup.LayoutParams;
import android.view.MotionEvent;
import android.util.AttributeSet;


public class PaintView extends View {

    public LayoutParams params;
    private Path path = new Path();
    private Paint brush = new Paint();

    public PaintView(Context context) {
        super(context);
        init(context);
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context){
        brush.setAntiAlias(true);
        brush.setColor(Color.MAGENTA);
        brush.setStyle(Paint.Style.STROKE);
        brush.setStrokeJoin(Paint.Join.ROUND);
        brush.setStrokeWidth(8f);

        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        float pointX = event.getX();
        float pointY = event.getY();

        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(pointX, pointY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(pointX, pointY);
                break;
            default:
                return false;
        }

        postInvalidate();
        return false;

    }

    protected void onClear() {
        path.reset();
        invalidate();
    }

    protected void onColorChange(int newColor){
        brush.setColor(newColor);
    }

    public int GetColor()
    {
        return brush.getColor();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawPath(path, brush);
    }



}
