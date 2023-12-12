package com.example.mentalhealthapp.repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.example.mentalhealthapp.model.mood.Mood;
import com.example.mentalhealthapp.model.mood.MoodEntry;
import com.example.mentalhealthapp.repository.DAO.MoodDAO;
import com.example.mentalhealthapp.repository.Database.MoodDatabase;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoodRepository {
    private MoodDAO moodDao;
    private LiveData<List<MoodEntry>> allMoods;

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.getMainLooper());

    public MoodRepository(Application application){
        MoodDatabase database = MoodDatabase.getInstance(application);
        moodDao = database.moodDAO();
        allMoods = moodDao.getAllMoods();
    }

    public void insertMood(Mood mood){
        executorService.execute(()->{
            MoodEntry moodEntry = new MoodEntry(mood.name(), System.currentTimeMillis());
            moodDao.insert(moodEntry);
        });
    }
    public LiveData<List<MoodEntry>> getMoodsForDay(long dayStart, long dayEnd) {
        return moodDao.getMoodsForDay(dayStart, dayEnd);
    }
    public LiveData<List<MoodEntry>> getAllMoods(){
        return  allMoods;
    }

}
