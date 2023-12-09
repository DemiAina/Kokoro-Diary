package com.example.mentalhealthapp.model.Journal;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "journal_entry")
public class JournalEntry {

    public JournalEntry(String title, String content, long timestamp) {
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
    }
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String content;

    private long timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
