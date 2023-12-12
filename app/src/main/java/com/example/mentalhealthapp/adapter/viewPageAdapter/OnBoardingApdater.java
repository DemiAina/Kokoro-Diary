package com.example.mentalhealthapp.adapter.viewPageAdapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.mentalhealthapp.ui.onboarding.components.fragments.OnboardingFragment;
import com.example.mentalhealthapp.ui.onboarding.components.onBoardingPage;
import java.util.ArrayList;

/**
 * An adapter for the ViewPager2 widget that handles the display of onboarding screens.
 * This adapter manages the data model consisting of onboarding pages and adapts it to the ViewPager2.
 */
public class OnBoardingApdater extends FragmentStateAdapter {

    private ArrayList<onBoardingPage> onBoardingPages;

    /**
     * Constructs an OnBoardingAdapter.
     *
     * @param fragmentActivity The context of the FragmentActivity hosting the ViewPager2.
     * @param pages            A list of OnBoardingPage objects representing each page in the onboarding process.
     */
    public OnBoardingApdater(FragmentActivity fragmentActivity, ArrayList<onBoardingPage> pages) {
        super(fragmentActivity);
        this.onBoardingPages = pages;
    }

    /**
     * Creates the fragment for the given page in the onboarding process.
     *
     * @param position The position of the page to be displayed.
     * @return A new instance of OnboardingFragment representing the page at the specified position.
     */
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        onBoardingPage page = onBoardingPages.get(position);
        return OnboardingFragment.newInstance(page);
    }

    /**
     * Returns the total number of pages in the onboarding process.
     *
     * @return The total number of pages.
     */
    @Override
    public int getItemCount() {
        return onBoardingPages.size();
    }
}
