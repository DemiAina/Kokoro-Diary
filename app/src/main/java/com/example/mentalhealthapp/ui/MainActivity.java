package com.example.mentalhealthapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.ui.moodtracking.fragments.moodTrackingFragment;
import com.example.mentalhealthapp.ui.onboarding.components.activity.OnboardingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView feelingCard = findViewById(R.id.feeling_card);
        feelingCard.setOnClickListener(v -> {
            findViewById(R.id.main_acc).setVisibility(View.GONE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mood_layout, new moodTrackingFragment())
                    .addToBackStack(null)
                    .commit();
            }
        );
    }
    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            findViewById(R.id.main_acc).setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }
}