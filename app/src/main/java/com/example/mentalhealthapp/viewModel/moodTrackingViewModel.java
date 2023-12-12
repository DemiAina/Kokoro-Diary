package com.example.mentalhealthapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.mentalhealthapp.model.mood.Mood;
import com.example.mentalhealthapp.model.mood.MoodEntry;
import com.example.mentalhealthapp.repository.MoodRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class moodTrackingViewModel extends AndroidViewModel {

    private MoodRepository repository;
    private LiveData<List<MoodEntry>> allMoods;

    public moodTrackingViewModel(@NonNull Application application){
        super(application);
        repository = new MoodRepository(application);
        allMoods = repository.getAllMoods();
    }

    public void selectMood(Mood mood){
        repository.insertMood(mood);
    }

    public void insert(Mood mood){
        repository.insertMood(mood);
    }

    public LiveData<List<MoodEntry>> getAllMoods(){
        return allMoods;
    }

    public LiveData<Double> getAverageMoodScoreForDate(LocalDate date) {
        long dayStart = date.atStartOfDay(ZoneId.systemDefault()).toEpochSecond() * 1000;
        long dayEnd = date.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toEpochSecond() * 1000 - 1;

        LiveData<List<MoodEntry>> dayMoods = repository.getMoodsForDay(dayStart, dayEnd);
        MutableLiveData<Double> averageScore = new MutableLiveData<>();

        dayMoods.observeForever(new Observer<List<MoodEntry>>() {
            @Override
            public void onChanged(List<MoodEntry> moodEntries) {
                averageScore.setValue(calculateAverageMoodScore(moodEntries));
            }
        });

        return averageScore;
    }

    private double calculateAverageMoodScore(List<MoodEntry> moodEntries) {
        if (moodEntries == null || moodEntries.isEmpty()) {
            return 0;
        }
        int totalScore = 0;
        for (MoodEntry entry : moodEntries) {
            totalScore += moodToScore(entry.getMoodName());
        }
        return (double) totalScore / moodEntries.size();
    }

    private int moodToScore(String moodName) {
        switch (Mood.valueOf(moodName)) {
            case HAPPY: return 2;
            case OK: return 1;
            case SAD: return 0;
            default: throw new IllegalArgumentException("Unknown mood: " + moodName);
        }
    }
}
