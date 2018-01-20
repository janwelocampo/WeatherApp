package com.dstudio.janwelocampo.mvparchitecture.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dstudio.janwelocampo.mvparchitecture.R;
import com.dstudio.janwelocampo.mvparchitecture.ui.dashboard.MainActivity;

/**
 * Created by Janwel Ocampo on 19/01/2018.
 */

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                MainActivity.startAsIntent(SplashActivity.this);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
