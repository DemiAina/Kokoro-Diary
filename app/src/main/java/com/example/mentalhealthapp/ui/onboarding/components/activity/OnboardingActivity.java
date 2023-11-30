package com.example.mentalhealthapp.ui.onboarding.components.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.adapter.viewPageAdapter.OnBoardingApdater;
import com.example.mentalhealthapp.repository.dataProvider.onboardingDataProvider;
import com.example.mentalhealthapp.ui.MainActivity;
import com.example.mentalhealthapp.ui.onboarding.components.onBoardingPage;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class OnboardingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<onBoardingPage> onBoardingPages = onboardingDataProvider.getOnboardingPages();
        setContentView(R.layout.pager_onboarding);

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        OnBoardingApdater adapter = new OnBoardingApdater (this, onBoardingPages);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabDots);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {}).attach();
        Button confirmButton = findViewById(R.id.btn_confirm);
        confirmButton.setOnClickListener(view -> {
            SharedPreferences prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
            prefs.edit().putBoolean("OnboardingCompleted", true).apply();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
