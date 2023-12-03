package com.example.mentalhealthapp.repository.Database;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mentalhealthapp.model.mood.Mood;
import com.example.mentalhealthapp.model.mood.MoodEntry;
import com.example.mentalhealthapp.repository.DAO.MoodDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {MoodEntry.class}, version = 1)
public abstract class MoodDatabase extends RoomDatabase {

    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.getMainLooper());
    private static MoodDatabase instance;

    public abstract MoodDAO moodDAO();

    public static synchronized MoodDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MoodDatabase.class, "mood_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
        }
    };
}
