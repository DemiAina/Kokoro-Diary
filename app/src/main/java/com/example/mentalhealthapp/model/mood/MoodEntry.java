package com.example.mentalhealthapp.model.mood;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Entity representing a mood entry in the database.
 * This class is used to store information about a user's mood at a specific timestamp.
 */
@Entity(tableName = "moods")
public class MoodEntry {

    /**
     * Constructs a new mood entry with the specified mood name and timestamp.
     * 
     * @param moodName The name of the mood.
     * @param timestamp The timestamp when the mood was recorded.
     */
    public MoodEntry(String moodName, long timestamp) {
        this.moodName = moodName;
        this.timestamp = timestamp;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String moodName;
    private long timestamp;

    /**
     * Gets the unique identifier of the mood entry.
     * 
     * @return The ID of the entry.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the mood entry.
     * 
     * @param id The ID to set for the entry.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the mood.
     * 
     * @return The mood name.
     */
    public String getMoodName() {
        return moodName;
    }

    /**
     * Sets the name of the mood.
     * 
     * @param moodName The name to set for the mood.
     */
    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    /**
     * Gets the timestamp when the mood was recorded.
     * 
     * @return The timestamp of the entry.
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp when the mood was recorded.
     * 
     * @param timestamp The timestamp to set for the entry.
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
