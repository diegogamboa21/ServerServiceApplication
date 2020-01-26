package com.app.serverserviceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    LottieAnimationView lottieAnimationViewLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottieAnimationViewLoading = (LottieAnimationView) findViewById(R.id.loadingLAV);

        startCheckAnimation();

    }

    private void startCheckAnimation() {
        lottieAnimationViewLoading.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.e("Animation:","start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.e("Animation:","end");
                //Your code for remove the fragment
                try {
                    //Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), HomepageActivity.class);
                    startActivity(intent);
                } catch(Exception ex) {
                    ex.toString();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.e("Animation:","cancel");
                Intent intent = new Intent(getBaseContext(), HomepageActivity.class);
                startActivity(intent);

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.e("Animation:","repeat");
            }
        });
    }
}
