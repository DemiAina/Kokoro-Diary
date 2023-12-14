package com.example.mentalhealthapp.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.model.mood.MoodEntry;
import com.example.mentalhealthapp.ui.Journal.fragments.JournalDetailFragment;
import com.example.mentalhealthapp.ui.Journal.fragments.JournalFragment;
import com.example.mentalhealthapp.ui.health.fragments.healthFragment;
import com.example.mentalhealthapp.ui.moodtracking.fragments.moodTrackingFragment;
import com.example.mentalhealthapp.viewModel.moodTrackingViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private moodTrackingViewModel moodViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moodViewModel = new ViewModelProvider(this).get(moodTrackingViewModel.class);

        CardView feelingCard = findViewById(R.id.feeling_card);
        feelingCard.setOnClickListener(v -> {
            findViewById(R.id.main_acc).setVisibility(View.GONE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.mood_layout, new moodTrackingFragment())
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
            }
        );

        CardView journalCard = findViewById(R.id.journal_card);
        journalCard.setOnClickListener(v -> {
            findViewById(R.id.main_acc).setVisibility(View.GONE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.journal_layout, new JournalFragment())
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();
        });

        CardView healthCard = findViewById(R.id.health_card);
        healthCard.setOnClickListener(v -> {
            findViewById(R.id.main_acc).setVisibility(View.GONE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.excerise_layout, new healthFragment())
                    .setReorderingAllowed(true)
                    .addToBackStack(null)
                    .commit();

        });

        moodViewModel.getAllMoods().observe(this, this::updateMoodScore);

        if (savedInstanceState != null) {
            boolean isMainAccVisible = savedInstanceState.getBoolean("MAIN_ACC_VISIBILITY", true);
            findViewById(R.id.main_acc).setVisibility(isMainAccVisible ? View.VISIBLE : View.GONE);
        }

    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        boolean isMainAccVisible = findViewById(R.id.main_acc).getVisibility() == View.VISIBLE;
        outState.putBoolean("MAIN_ACC_VISIBILITY", isMainAccVisible);
    }

    private void updateMoodScore(List <MoodEntry> moodEntries) {
        if (moodEntries == null || moodEntries.isEmpty()) {
            return;
        }

        int totalScore = 0;
        for (MoodEntry entry : moodEntries) {
            switch (entry.getMoodName()) {
                case "HAPPY":
                    totalScore += 2;
                    break;
                case "OK":
                    totalScore += 1;
                    break;
                case "SAD":
                    totalScore -= 0.5;
                    break;
            }
        }

        double averageScore = (double) totalScore / moodEntries.size();

        ImageView moodIconView = findViewById(R.id.mood_icon);

        TextView moodScoreView = findViewById(R.id.tvMoodToday);
        if (averageScore >= 1.5) {
            moodScoreView.setText("Mood today : Happy");
            moodIconView.setImageResource(R.drawable.baseline_mood_24);
        } else if (averageScore >= 0.5) {
            moodScoreView.setText("Mood today : OK");
            moodIconView.setImageResource(R.drawable.baseline_sentiment_neutral_24);
        } else {
            moodScoreView.setText("Mood today : Sad");
            moodIconView.setImageResource(R.drawable.baseline_sentiment_very_dissatisfied_24);
        }
    }


    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.journal_detail);

        if (currentFragment instanceof JournalFragment || currentFragment instanceof JournalDetailFragment) {
            // When in a Journal fragment, hide main activity's content before popping
            findViewById(R.id.main_acc).setVisibility(View.GONE);
        }

        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            // If back stack has only one entry, show main activity's content and pop
            findViewById(R.id.main_acc).setVisibility(View.VISIBLE);
            getSupportFragmentManager().popBackStack();
        }
    }

}