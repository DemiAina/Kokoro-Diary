package com.example.mentalhealthapp.model.mood;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "moods")
public class MoodEntry {

    public MoodEntry(String moodName, long timestamp){
        this.moodName = moodName;
        this.timestamp = timestamp;
    }
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String moodName;
    private long timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMoodName() {
        return moodName;
    }

    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
