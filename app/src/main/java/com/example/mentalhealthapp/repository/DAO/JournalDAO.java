package com.example.mentalhealthapp.repository.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.mentalhealthapp.model.Journal.JournalEntry;
import java.util.List;

/**
 * Data Access Object (DAO) for journal entries.
 * This interface provides methods to interact with the journal entries in the database.
 */
@Dao
public interface JournalDAO {

    /**
     * Inserts a journal entry into the database.
     * 
     * @param journalEntry The journal entry to insert.
     */
    @Insert
    void insert(JournalEntry journalEntry);

    /**
     * Deletes a journal entry from the database.
     * 
     * @param journalEntry The journal entry to delete.
     */
    @Delete
    void delete(JournalEntry journalEntry);

    /**
     * Updates a journal entry in the database.
     * 
     * @param journalEntry The journal entry to update.
     */
    @Update
    void update(JournalEntry journalEntry);

    /**
     * Retrieves all journal entries from the database, ordered by their timestamp in descending order.
     * 
     * @return A LiveData object containing a list of journal entries.
     */
    @Query("SELECT * FROM journal_entry ORDER BY timestamp DESC")
    LiveData<List<JournalEntry>> getAllJournalEntries();
}
