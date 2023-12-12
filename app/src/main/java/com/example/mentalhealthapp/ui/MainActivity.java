package com.example.mentalhealthapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.model.mood.MoodEntry;
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
                    .addToBackStack(null)
                    .commit();
            }
        );

        CardView journalCard = findViewById(R.id.journal_card);
        journalCard.setOnClickListener(v -> {
            findViewById(R.id.main_acc).setVisibility(View.GONE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.journal_layout, new JournalFragment())
                    .addToBackStack(null)
                    .commit();
        });

        CardView healthCard = findViewById(R.id.health_card);
        healthCard.setOnClickListener(v -> {
            findViewById(R.id.main_acc).setVisibility(View.GONE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.excerise_layout, new healthFragment())
                    .addToBackStack(null)
                    .commit();

        });

        moodViewModel.getAllMoods().observe(this, this::updateMoodScore);

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
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            findViewById(R.id.main_acc).setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }
}