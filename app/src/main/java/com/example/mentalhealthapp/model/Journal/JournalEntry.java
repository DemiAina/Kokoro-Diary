package com.example.mentalhealthapp.model.Journal;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Represents a journal entry in the database.
 * This class defines the structure of the journal entry table including its columns.
 */
@Entity(tableName = "journal_entry")
public class JournalEntry {

    /**
     * Constructs a JournalEntry object.
     *
     * @param title     The title of the journal entry.
     * @param content   The content of the journal entry.
     * @param timestamp The timestamp indicating when the entry was created or modified.
     */
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

    /**
     * Gets the unique identifier of the journal entry.
     *
     * @return The unique identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the journal entry.
     *
     * @param id The unique identifier to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the title of the journal entry.
     *
     * @return The title of the journal entry.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the journal entry.
     *
     * @param title The title to set for the journal entry.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the content of the journal entry.
     *
     * @return The content of the journal entry.
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the journal entry.
     *
     * @param content The content to set for the journal entry.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the timestamp of the journal entry.
     *
     * @return The timestamp indicating when the entry was created or modified.
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp of the journal entry.
     *
     * @param timestamp The timestamp to set for the journal entry.
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
