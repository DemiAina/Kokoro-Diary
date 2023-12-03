package com.example.mentalhealthapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mentalhealthapp.model.mood.Mood;
import com.example.mentalhealthapp.model.mood.MoodEntry;
import com.example.mentalhealthapp.repository.Database.MoodDatabase;
import com.example.mentalhealthapp.repository.MoodRepository;

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
}
