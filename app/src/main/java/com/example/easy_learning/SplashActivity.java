package com.example.easy_learning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.easy_learning.databinding.ActivitySplashBinding;
import com.example.easy_learning.preferences.SplashPreferences;

public class SplashActivity extends AppCompatActivity {
    private Button btnstart_splash;
    private SplashPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashBinding binding= DataBindingUtil.setContentView(
                this, R.layout.activity_splash);
        binding.setSpalsh(this);
        preferences=new SplashPreferences(this);
        btnstart_splash=binding.btnstartSplash;
        getSupportActionBar().setTitle("Welcome");
        btnstart_splash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin();
            }
        });
    }

    private void checkLogin() {
        if(preferences.checkLogin()) {
            startActivity(new Intent(SplashActivity.this,LoginActivity.class));
            finish();
        } else {
            startActivity(new Intent(SplashActivity.this,SignupActivity.class));
            finish();
        }
    }
}