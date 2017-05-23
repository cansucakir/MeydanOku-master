package com.example.androidproje;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by CASPER on 8.05.2017.
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        final ImageView iv=(ImageView) findViewById(R.id.imageView2);
        final ImageView iv2=(ImageView) findViewById(R.id.imageView3);
        final ImageView iv3=(ImageView) findViewById(R.id.imageView);
        final ImageView iv4=(ImageView) findViewById(R.id.imageView4);

        final Animation an= AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
        final Animation an2= AnimationUtils.loadAnimation(getBaseContext(),R.anim.abc_fade_out);
        // final Animation an3= AnimationUtils.loadAnimation(getBaseContext(),R.anim.slide_up);
        iv.startAnimation(an);
        iv2.startAnimation(an);
        iv3.startAnimation(an);
        iv4.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {


            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                finish();
                Intent i = new Intent(getBaseContext(), Login.class);
                startActivity(i);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }}