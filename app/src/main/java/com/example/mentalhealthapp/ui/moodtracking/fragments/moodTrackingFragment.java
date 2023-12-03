package com.example.mentalhealthapp.ui.moodtracking.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.model.mood.Mood;
import com.example.mentalhealthapp.ui.MainActivity;
import com.example.mentalhealthapp.viewModel.moodTrackingViewModel;

public class moodTrackingFragment extends Fragment {
    private static final String TAG = "moodTrackingFragment";
    private moodTrackingViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mood_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(moodTrackingViewModel.class);

        CardView happyMoodCard = view.findViewById(R.id.happy_card);
        happyMoodCard.setOnClickListener(v -> {

            viewModel.selectMood(Mood.HAPPY);
            Toast.makeText(getContext(), "Mood saved as happy", Toast.LENGTH_SHORT).show();
            backToMainActivity();
        });

    }
    private void backToMainActivity(){
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}
