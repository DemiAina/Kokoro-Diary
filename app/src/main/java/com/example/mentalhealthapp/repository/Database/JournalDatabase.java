package com.example.mentalhealthapp.repository.Database;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.mentalhealthapp.model.Journal.JournalEntry;
import com.example.mentalhealthapp.repository.DAO.JournalDAO;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Abstract database class for the journal module.
 * This class provides the database instance for journal entries.
 */
@Database(entities = {JournalEntry.class}, version = 1)
public abstract class JournalDatabase extends RoomDatabase {
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private static JournalDatabase instance;

    /**
     * Provides the DAO for journal entries.
     * 
     * @return JournalDAO instance.
     */
    public abstract JournalDAO JournalDAO();

    /**
     * Returns a singleton instance of the JournalDatabase.
     * 
     * @param context Application context.
     * @return The single instance of JournalDatabase.
     */
    public static synchronized JournalDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    JournalDatabase.class, "journal_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
