package com.example.mentalhealthapp.repository.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mentalhealthapp.model.mood.MoodEntry;

import java.util.List;

@Dao
public interface MoodDAO {
    @Insert
    void insert(MoodEntry moodEntry);

    @Query("SELECT * FROM moods")
    LiveData<List<MoodEntry>> getAllMoods();

    @Query("SELECT * FROM moods WHERE timestamp >= :dayStart AND timestamp <= :dayEnd")
    LiveData<List<MoodEntry>> getMoodsForDay(long dayStart, long dayEnd);
}
