package com.example.week05_29177;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class CustomView extends View {
    private static String shape = "Path";
    private static int color = Color.rgb(0,0,0);

    private Paint myPaint;
    private Path myPath;
    private Bitmap myBitMap;
    private static Canvas myCanvas;
    private float pathX, pathY, startX, startY, rangeX, rangeY;
    private static final float touchTolerance = 4;
    private boolean clear = false;

    public void changeShape(String newShape){
        shape = newShape;
    }
    public void changeColor(int newRed, int newGreen, int newBlue){
        color = Color.rgb(newRed, newGreen, newBlue);
    }
    public CustomView(Context context) {
        super(context);
    }
    public CustomView(Context context, @Nullable AttributeSet attr) {
        super(context, attr);
        myPaint = new Paint();
        myPaint.setColor(color);
        myPaint.setAntiAlias(true);
        myPaint.setDither(true);
        myPaint.setStyle(Paint.Style.STROKE);
        myPaint.setStrokeJoin(Paint.Join.ROUND);
        myPaint.setStrokeCap(Paint.Cap.ROUND);
        myPaint.setStrokeWidth(12);
        myPath = new Path();
    }
    @Override
    protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight){
        super.onSizeChanged(width, height, oldWidth, oldHeight);
        myBitMap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        myCanvas = new Canvas(myBitMap);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(myBitMap,0,0,null);
        Paint localPaint = new Paint();
        localPaint.setStyle(Paint.Style.FILL);
        localPaint.setColor(Color.RED);
        canvas.drawCircle(50,50,50, localPaint);
        localPaint.setStyle(Paint.Style.STROKE);
        localPaint.setStrokeWidth(10);
        localPaint.setColor(Color.WHITE);
        canvas.drawLine(20,20,80,80, localPaint);
        canvas.drawLine(20,80,80,20, localPaint);
        if(!clear){
            if(shape.equalsIgnoreCase("Rect")){
                canvas.drawRect(startX,startY,rangeX,rangeY,myPaint);
            }
            else if(shape.equalsIgnoreCase("Oval")){
                canvas.drawOval(startX,startY,rangeX,rangeY,myPaint);
            }
            else if(shape.equalsIgnoreCase("Line")){
                canvas.drawLine(startX,startY,rangeX,rangeY,myPaint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent evt) {
        float x = evt.getX();
        float y = evt.getY();

        switch (evt.getAction()){
            case MotionEvent.ACTION_DOWN:
                startTouch(x,y);
                break;
            case MotionEvent.ACTION_MOVE:
                move(x,y);
                break;
            case MotionEvent.ACTION_UP:
                lepas();
                break;
            default:
        }
        return true;
    }

    private void startTouch(float x, float y) {
        if(x <= 100 && y <= 100){
            myCanvas.drawColor(Color.WHITE);
            clear = true;
            invalidate();
        }
        else{
            if(shape.equalsIgnoreCase("Path")){
                myPath.moveTo(x,y);
                pathX = x;
                pathY = y;
            }
            else{
                startX = x;
                startY = y;
            }
            clear = false;
        }
    }
    private void move(float x, float y) {
        float dx = Math.abs(x - pathX);
        float dy = Math.abs(y - pathY);
        if(dx >= touchTolerance || dy >= touchTolerance){
            myPaint.setColor(color);
            if(shape.equalsIgnoreCase("Path")){
                myPath.quadTo(pathX, pathY, (x + pathX) / 2, (y + pathY) / 2 );
                myCanvas.drawPath(myPath, myPaint);
                pathX = x;
                pathY = y;
            }
            else{
                rangeX = x;
                rangeY = y;
            }
        }
        invalidate();
    }
    private void lepas() {
        if(!clear){
            if(shape.equalsIgnoreCase("Path")){
                myPath.reset();
            }
            else if (shape.equalsIgnoreCase("Rect")){
                myCanvas.drawRect(startX, startY, rangeX, rangeY, myPaint);
            }
            else if (shape.equalsIgnoreCase("Oval")){
                myCanvas.drawOval(startX, startY, rangeX, rangeY, myPaint);
            }
            else if (shape.equalsIgnoreCase("Line")){
                myCanvas.drawLine(startX, startY, rangeX, rangeY, myPaint);
            }
        }
    }
}
