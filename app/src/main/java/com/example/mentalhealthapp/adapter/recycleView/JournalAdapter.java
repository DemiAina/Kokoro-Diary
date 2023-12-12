package com.example.mentalhealthapp.adapter.recycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.model.Journal.JournalEntry;


import java.util.ArrayList;
import java.util.List;


public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalViewHolder> {
    private List<JournalEntry> entries = new ArrayList<>();
    private OnItemClickListener listener;

    @NonNull
    @Override
    public JournalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.journal_items, parent, false);
        return new JournalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull JournalViewHolder holder, int position) {
        JournalEntry currentEntry = entries.get(position);
        holder.textViewTitle.setText(currentEntry.getTitle());
    }

    @Override
    public int getItemCount() {
        return entries.size();
    }

    public void setEntries(List<JournalEntry> entries) {
        this.entries = entries;
        notifyDataSetChanged();
    }

    public JournalEntry getNoteAt(int position) {
        return entries.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(JournalEntry entry);
    }

    class JournalViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView contentSnippet;

        //TODO : Might need to add the time stamp
        public JournalViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.journal_entry_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(entries.get(position));
                    }
                }
            });
        }
    }
}
