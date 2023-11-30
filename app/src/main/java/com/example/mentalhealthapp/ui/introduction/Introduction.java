package com.example.mentalhealthapp.ui.introduction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.mentalhealthapp.ui.MainActivity;
import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.ui.onboarding.components.activity.OnboardingActivity;

public class Introduction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        boolean hasCompletedOnboarding = prefs.getBoolean("OnboardingCompleted", false);

        new Handler().postDelayed(() -> {
            Intent intent;
            if (!hasCompletedOnboarding) {
                intent = new Intent(this, OnboardingActivity.class);
            } else {
                intent = new Intent(this, MainActivity.class);
            }
            startActivity(intent);
            finish();
        }, 3000);
    }
}