package com.example.mentalhealthapp.repository.DAO;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mentalhealthapp.model.Journal.JournalEntry;

import java.util.List;
@Dao
public interface JournalDAO {
        @Insert
        void insert(JournalEntry journalEntry);

        @Delete
        void delete(JournalEntry journalEntry);

        @Update
        void update(JournalEntry journalEntry);

        @Query("SELECT * FROM journal_entry ORDER BY timestamp DESC")
        LiveData<List<JournalEntry>> getAllJournalEntries();
}
