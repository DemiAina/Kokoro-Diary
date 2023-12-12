package com.example.mentalhealthapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mentalhealthapp.repository.HealthRepository;

public class healthViewModel extends AndroidViewModel {
    private final HealthRepository healthRepository;
    private final LiveData<Integer> stepsLiveData;

    public healthViewModel(@NonNull Application application) {
        super(application);
        healthRepository = new HealthRepository(application);
        stepsLiveData = healthRepository.getStepsLiveData();
    }
    public LiveData<Integer> getStepsLiveData() {
        return stepsLiveData;
    }
}
