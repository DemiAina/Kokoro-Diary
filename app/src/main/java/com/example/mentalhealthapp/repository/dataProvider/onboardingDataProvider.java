package com.example.mentalhealthapp.repository.dataProvider;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.ui.onboarding.components.onBoardingPage;

import java.util.ArrayList;

public class onboardingDataProvider {
    public static ArrayList<onBoardingPage> getOnboardingPages() {
        ArrayList<onBoardingPage> pages = new ArrayList<>();

        pages.add(new onBoardingPage(R.drawable.baseline_waving_hand_24, "Welcome to Kokoro Diary", "Your personal journey to mental wellness begins here."));
        pages.add(new onBoardingPage(R.drawable.baseline_mood_24, "Mood tracker", "This app has a mood tracker"));
        pages.add(new onBoardingPage(R.drawable.baseline_book_24, "Journal tracker" , "You have a journal where you can put your thoughts and links to your moods"));
        pages.add(new onBoardingPage(R.drawable.baseline_monitor_heart_24, "Exercise and health tracking", "This helps you monitor your health and how its contributing your mood"));
        pages.add(new onBoardingPage(R.drawable.baseline_book_24, "Location aware", "If you allow the app to have location it will hold a list of locations you have been at and you can pick to while writing in journal "));
        pages.add(new onBoardingPage(R.drawable.sharp_energy_savings_leaf_24, "Relaxation and meditation tips", "The app will give you tips on how to relax and meditate"));
        return pages;
    }
}
