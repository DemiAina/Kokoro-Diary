package com.example.mentalhealthapp.ui.Journal.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.model.Journal.JournalEntry;
import com.example.mentalhealthapp.ui.MainActivity;
import com.example.mentalhealthapp.viewModel.journalViewModel;

public class JournalDetailFragment extends Fragment {

    private journalViewModel journalViewModel;

    private static final String ARG_JOURNAL_TITLE = "journal_title";
    private static final String ARG_JOURNAL_CONTENT = "journal_content";


    public static JournalDetailFragment newInstance(int entryId, String title, String content) {
        JournalDetailFragment fragment = new JournalDetailFragment();
        Bundle args = new Bundle();
        args.putInt("entry_id", entryId);
        args.putString("entry_title", title);
        args.putString("entry_content", content);
        fragment.setArguments(args);
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.journal_edit_text_layout, container, false);
        journalViewModel = new ViewModelProvider(requireActivity()).get(journalViewModel.class);
        EditText titleEditText = view.findViewById(R.id.edit_text_journal_title);
        EditText contentEditText = view.findViewById(R.id.edit_text_journal_content);

        if (getArguments() != null) {
            titleEditText.setText(getArguments().getString("entry_title"));
            contentEditText.setText(getArguments().getString("entry_content"));
        }

        Button saveButton = view.findViewById(R.id.button_save_journal);
        saveButton.setOnClickListener(v -> {
            String updatedTitle = titleEditText.getText().toString();
            String updatedContent = contentEditText.getText().toString();
            int entryId = getArguments().getInt("entry_id");
            updateJournalEntry(entryId, updatedTitle, updatedContent);
            Toast.makeText(getContext(), "Journal entry deleted", Toast.LENGTH_SHORT).show();
            getParentFragmentManager().popBackStack();
        });


        return view;
    }

    private void updateJournalEntry(int entryID, String updatedTitle, String updatedContent) {

        JournalEntry updatedEntry = new JournalEntry(updatedTitle, updatedContent, System.currentTimeMillis());
        updatedEntry.setId(entryID);
        journalViewModel.update(updatedEntry);

    }
}
