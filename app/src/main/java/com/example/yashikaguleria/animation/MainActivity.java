package com.example.yashikaguleria.animation;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Drawable frameAnimation;
    Animation anim12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        img.setBackgroundResource(R.drawable.myres);
        frameAnimation = img.getBackground();
        anim12 = AnimationUtils.loadAnimation(this,R.anim.myanimation);

    }

    public void onStart(View view) {
        if(frameAnimation instanceof Animatable){      //is an object of

                ((Animatable) frameAnimation).start();    //typecast

        }
    }

    public void onStop(View view) {

        if(((Animatable)frameAnimation).isRunning()){
            ((Animatable)frameAnimation).stop();
        }
    }

    public void doThis(View view) { //from xml
      img.startAnimation(anim12);


       // RotateAnimation ra = new RotateAnimation(0,360,0.5f,0.5f);

       // ra.setDuration(5000);
        // img.startAnimation(ra);


     //    with respect to center use the constructer below


      // RotateAnimation ra = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,.5f,Animation.RELATIVE_TO_SELF,.5f);
        TranslateAnimation ts = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0.0f,Animation.RELATIVE_TO_SELF,1.0f );
       img.startAnimation(ts);
//AlphaAnimation

    }

    public void drawCircle(View view) {

        AnimationSet animationSet = new AnimationSet(true);

        TranslateAnimation tm = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,0.5f,Animation.RELATIVE_TO_PARENT,0.0f);
        tm.setDuration(5000);
        img.startAnimation(tm);

       // animationSet.addAnimation(tm);
        RotateAnimation rm = new RotateAnimation(0,360,0,0);
               rm.setDuration(5000);
                img.startAnimation(rm);
    }
}
//animatr class to check if animations can be performed or not
//animations to perform animations
/*
alpha is used for transperancy
startoffset starts after the unit is millisecond
repeat count: number of times it would be rpeated +1(cause it will work 1 time)

_____________________

pivotx with respect to which point you wan tto enlarge
toscale inlarge in direction
frm - to large to small (shrink)
small to large (enlarge) with respect to center
 interpolator = rate of change with respwct to time
 with respect to self = image k center se
 wrt pareent = layout k center se
 */