package com.devroid.rashconpharmaconllp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private static final long SPLASH_DELAY = 3000; // 3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                boolean isLoggedIn = pref.getBoolean("flag", false);

                if (isLoggedIn) {
                    Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(mainIntent);
                } else {
                    Intent loginIntent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(loginIntent);
                }
                finish();
            }
        }, SPLASH_DELAY);
    }
}
