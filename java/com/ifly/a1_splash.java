package com.ifly;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class a1_splash extends AppCompatActivity {
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1_splash);

        ImageView logo = findViewById(R.id.a1_app_logo);

        Animation newanimation = AnimationUtils.loadAnimation(a1_splash.this, R.anim.a1_splash_logo);
        logo.startAnimation(newanimation);
        SetStatusBar();
        ProgressbarRun();

        final Handler handler = new Handler();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new Universal().OpenGivenActivity(a1_splash.this,a2_home.class,true);
            }
        }, 1200);


    }

    private void SetStatusBar() {
        //setting status bar color
        Window window;
        window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getColor(R.color.white));
        window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
    }

    public void ProgressbarRun() {
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.a1_progressbar);
        final Timer t = new Timer();


        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter = counter + 1;
                progressBar.setProgress(counter);
                if (counter == 100) {
                    t.cancel();
                }
            }
        };
        t.schedule(tt, 0, 10);
    }
}