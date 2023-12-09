package com.example.mentalhealthapp.repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import com.example.mentalhealthapp.model.Journal.JournalEntry;
import com.example.mentalhealthapp.repository.DAO.JournalDAO;
import com.example.mentalhealthapp.repository.Database.JournalDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JournalRepository {
    private JournalDAO journalDAO;

    private LiveData<List<JournalEntry>> allJournalEntries;
    private ExecutorService executorService = Executors.newSingleThreadExecutor();
    private Handler handler = new Handler(Looper.getMainLooper());

    public JournalRepository(Application application){
        JournalDatabase database = JournalDatabase.getInstance(application);
        journalDAO = database.JournalDAO();
        allJournalEntries = journalDAO.getAllJournalEntries();
    }

    public void insert(JournalEntry journalEntry){
        executorService.execute(()->{
            journalDAO.insert(journalEntry);
        });
    }

    public LiveData<List<JournalEntry>> getAllJournalEntries(){return allJournalEntries;}

}
