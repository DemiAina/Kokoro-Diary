package com.example.mentalhealthapp.repository.DAO;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.mentalhealthapp.model.Journal.JournalEntry;

import java.util.List;
@Dao
public interface JournalDAO {
        @Insert
        void insert(JournalEntry journalEntry);

        @Query("SELECT * FROM journal_entry ORDER BY timestamp DESC")
        LiveData<List<JournalEntry>> getAllJournalEntries();
}
