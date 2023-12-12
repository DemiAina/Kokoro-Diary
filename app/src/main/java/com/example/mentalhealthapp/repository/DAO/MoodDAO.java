package com.example.mentalhealthapp.repository.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.mentalhealthapp.model.mood.MoodEntry;
import java.util.List;

/**
 * Data Access Object (DAO) for mood entries.
 * This interface provides methods to interact with the mood entries in the database.
 */
@Dao
public interface MoodDAO {

    /**
     * Inserts a mood entry into the database.
     * 
     * @param moodEntry The mood entry to insert.
     */
    @Insert
    void insert(MoodEntry moodEntry);

    /**
     * Retrieves all mood entries from the database.
     * 
     * @return A LiveData object containing a list of mood entries.
     */
    @Query("SELECT * FROM moods")
    LiveData<List<MoodEntry>> getAllMoods();

    /**
     * Retrieves mood entries for a specific day, based on the start and end timestamps of the day.
     * 
     * @param dayStart The start timestamp of the day.
     * @param dayEnd The end timestamp of the day.
     * @return A LiveData object containing a list of mood entries within the specified day.
     */
    @Query("SELECT * FROM moods WHERE timestamp >= :dayStart AND timestamp <= :dayEnd")
    LiveData<List<MoodEntry>> getMoodsForDay(long dayStart, long dayEnd);
}

