package com.brydinh.tabtest;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.util.AttributeSet;
import android.graphics.PorterDuff.Mode;
import android.graphics.Bitmap;


public class PaintView extends View {

    private Path path;
    private Bitmap bitmap;
    private Paint brush;
    private Paint changeColor;
    private Canvas drawingPad;

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.init();

        this.brush.setAntiAlias(true);
        this.brush.setStrokeWidth(8f);
        this.brush.setColor(Color.MAGENTA);
        this.brush.setStyle(Paint.Style.STROKE);
        this.brush.setStrokeJoin(Paint.Join.ROUND);
    }

    private void init() {
        this.brush = new Paint();
        this.path = new Path();
        this.changeColor = new Paint(Paint.DITHER_FLAG);
    }

    public void setColor(int color) {
        this.brush.setColor(color);
    }

    public int GetColor()
    {
        return brush.getColor();
    }

    public void reset() {
        this.drawingPad.drawColor(0, Mode.CLEAR);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(this.bitmap, 0, 0, this.changeColor);
        canvas.drawPath(this.path, this.brush);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.path.moveTo(eventX, eventY);
                break;

            case MotionEvent.ACTION_MOVE:
                this.path.lineTo(eventX, eventY);
                break;

            case MotionEvent.ACTION_UP:
                this.drawingPad.drawPath(this.path, this.brush);
                this.path.reset();
                break;

            default:
                return false;
        }

        invalidate();
        return true;
    }


    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        this.bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.drawingPad = new Canvas(this.bitmap);
    }

}

