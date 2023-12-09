package com.example.mentalhealthapp.ui.Journal.fragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.adapter.recycleView.JournalAdapter;
import com.example.mentalhealthapp.viewModel.journalViewModel;
import com.example.mentalhealthapp.model.Journal.JournalEntry;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class JournalFragment extends Fragment {

    private journalViewModel journalViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.journal_layout, container, false);
        journalViewModel = new ViewModelProvider(requireActivity()).get(journalViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.journal_entries_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final JournalAdapter adapter = new JournalAdapter();
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = view.findViewById(R.id.add_journal_entry_fab);
        fab.setOnClickListener(v -> showAddJournalEntryDialog());

        journalViewModel.getAllJournalEntries().observe(getViewLifecycleOwner(), adapter::setEntries);
        return view;
    }

    private void showAddJournalEntryDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_journal_entry, null);

        EditText titleEditText = dialogView.findViewById(R.id.journal_entry_title);
        EditText contentEditText = dialogView.findViewById(R.id.journal_entry_content);

        builder.setView(dialogView)
                .setTitle("New Journal Entry")
                .setPositiveButton("Save", (dialog, id) -> {
                    String title = titleEditText.getText().toString();
                    String content = contentEditText.getText().toString();
                    saveJournalEntry(title, content);
                })
                .setNegativeButton("Cancel", (dialog, id) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void saveJournalEntry(String title, String content) {
        JournalEntry newEntry = new JournalEntry(title, content, System.currentTimeMillis());
        journalViewModel.insert(newEntry);
    }
}
