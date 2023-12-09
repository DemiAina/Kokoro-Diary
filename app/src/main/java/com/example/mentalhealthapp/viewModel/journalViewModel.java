package com.example.mentalhealthapp.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mentalhealthapp.model.Journal.JournalEntry;
import com.example.mentalhealthapp.repository.JournalRepository;

import java.util.List;

public class journalViewModel extends AndroidViewModel {
    private JournalRepository repository;

    private LiveData<List<JournalEntry>> allJournalEntries;

    public journalViewModel(@NonNull Application application) {
        super(application);
        repository = new JournalRepository(application);
        allJournalEntries = repository.getAllJournalEntries();
    }

    public void insert(JournalEntry entry){
        repository.insert(entry);
    }

    public LiveData<List<JournalEntry>> getAllJournalEntries(){return allJournalEntries;}

}
