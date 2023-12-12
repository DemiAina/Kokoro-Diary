package com.example.mentalhealthapp.repository.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.mentalhealthapp.model.mood.MoodEntry;
import com.example.mentalhealthapp.repository.DAO.MoodDAO;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Abstract database class for the mood module.
 * This class provides the database instance for mood entries.
 */
@Database(entities = {MoodEntry.class}, version = 1)
public abstract class MoodDatabase extends RoomDatabase {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static MoodDatabase instance;

    /**
     * Provides the DAO for mood entries.
     * 
     * @return MoodDAO instance.
     */
    public abstract MoodDAO moodDAO();

    /**
     * Returns a singleton instance of the MoodDatabase.
     * 
     * @param context Application context.
     * @return The single instance of MoodDatabase.
     */
    public static synchronized MoodDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MoodDatabase.class, "mood_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

