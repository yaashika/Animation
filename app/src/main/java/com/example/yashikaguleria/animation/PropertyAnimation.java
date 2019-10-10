package com.example.yashikaguleria.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

public class PropertyAnimation extends View {

    float  radius,x,y;
    Paint paint;
    final int AnimationDuration = 4000;
    final int AnimationDelay = 1000;
    final int ColorAdjust = 5;
    AnimatorSet animatorSet;  //for multiple animaitons(for proper order) animationset notin proper order

    public PropertyAnimation(Context context, AttributeSet attrs) { //2 parameter constructor coz of xml (we are adding from xml)
        super(context, attrs);
        paint = new Paint();
        animatorSet = new AnimatorSet();
    }

    public PropertyAnimation(Context context){
        super(context);
        paint = new Paint();
        animatorSet = new AnimatorSet();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(x, y, radius, paint);
        super.onDraw(canvas);
    }

    void setRadius(float r) {
        radius = r;
        paint.setColor(Color.RED + (int) radius / ColorAdjust);
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) { //initialize position and radius taget,property(corresponding setter method)
        super.onSizeChanged(w, h, oldw, oldh);

        ObjectAnimator growAnimator = ObjectAnimator.ofFloat(this, "radius", 0, getWidth());  //ofFloat we are using as new se nahi initialize kr rhe hai
        growAnimator.setDuration(AnimationDuration);
        growAnimator.setInterpolator(new LinearInterpolator());

        ObjectAnimator shrinkAnimator = ObjectAnimator.ofFloat(this, "radius", getWidth(), 0);
        shrinkAnimator.setDuration(AnimationDuration);
        shrinkAnimator.setInterpolator(new LinearInterpolator());
        shrinkAnimator.setStartDelay(AnimationDelay);
        animatorSet.play(growAnimator).before(shrinkAnimator); //here the sequence of animation is defined
        animatorSet.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x = event.getX();
                y = event.getY();
                if (animatorSet != null && animatorSet.isRunning()) {
                    animatorSet.cancel();

                }
                animatorSet.start();
        }

        return super.onTouchEvent(event);
    }


}