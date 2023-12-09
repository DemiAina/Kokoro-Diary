package com.example.mentalhealthapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.ui.Journal.fragments.JournalFragment;
import com.example.mentalhealthapp.ui.moodtracking.fragments.moodTrackingFragment;

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

        CardView journalCard = findViewById(R.id.journal_card);
        journalCard.setOnClickListener(v -> {
            findViewById(R.id.main_acc).setVisibility(View.GONE);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.journal_layout, new JournalFragment())
                    .addToBackStack(null)
                    .commit();
        });
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