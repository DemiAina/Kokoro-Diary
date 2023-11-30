package com.example.mentalhealthapp.adapter.viewPageAdapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mentalhealthapp.ui.onboarding.components.fragments.OnboardingFragment;
import com.example.mentalhealthapp.ui.onboarding.components.onBoardingPage;

import java.util.ArrayList;

public class OnBoardingApdater extends FragmentStateAdapter {

    private ArrayList<onBoardingPage> onBoardingPages;

    public OnBoardingApdater(FragmentActivity fragmentActivity, ArrayList<onBoardingPage> pages){
        super(fragmentActivity);
        this.onBoardingPages = pages;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        onBoardingPage page = onBoardingPages.get(position);
        return OnboardingFragment.newInstance(page);
    }

    public int getItemCount(){
        return onBoardingPages.size();
    }
}
