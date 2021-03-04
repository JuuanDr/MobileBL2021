package AnimasiProperty;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
public class ViewAnimasi extends View {
    private static final int durasi = 2000; //1 second = 1 * 10^3 milliseconds
    private static final long delay = 1000;
    private static final int aturWarna = 5;
    private float mX, mY, mRadius;
    private final Paint mPaint = new Paint();
    private AnimatorSet animSet = new AnimatorSet();

    public ViewAnimasi(Context context) {
        super(context);
    }
    public ViewAnimasi(Context ctx, @Nullable AttributeSet attr){
        super(ctx, attr);
    }

    public void onSizeChanged(int w, int h, int oldW, int oldH){
        ObjectAnimator membesar = ObjectAnimator.ofFloat(this, "radius", 0, getWidth());
        membesar.setDuration(durasi);
        membesar.setInterpolator(new LinearInterpolator());

        ObjectAnimator mengecil = ObjectAnimator.ofFloat(this, "radius", getWidth(), 0);
        mengecil.setDuration(durasi);
        mengecil.setInterpolator(new LinearInterpolator());
        mengecil.setStartDelay(delay);

        ObjectAnimator ulang = ObjectAnimator.ofFloat(this, "radius", 0, getWidth());
        ulang.setStartDelay(delay);
        ulang.setDuration(durasi);
        ulang.setRepeatCount(1);
        ulang.setRepeatMode(ValueAnimator.REVERSE); //value = 2
        animSet.play(membesar).before(mengecil);
        animSet.play(ulang).after(mengecil);
    }

    public void setRadius(float radius){
        mRadius = radius;
        mPaint.setColor(Color.GREEN + (int)radius / aturWarna);
        invalidate();
    }

    protected  void  onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawCircle(mX, mY, mRadius, mPaint);
    }

    public boolean onTouchEvent(MotionEvent evt){
        if(evt.getActionMasked() == MotionEvent.ACTION_DOWN){
            mX = evt.getX();
            mY = evt.getY();
            if(animSet != null && animSet.isRunning()){
                animSet.cancel();
            }
            animSet.start();
        }
        return super.onTouchEvent(evt);
    }
}
