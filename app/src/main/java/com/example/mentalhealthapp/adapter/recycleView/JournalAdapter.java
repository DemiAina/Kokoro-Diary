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

/**
 * Adapter for a RecyclerView that displays journal entries.
 * This adapter manages the data model and adapts it to a RecyclerView, which can be populated within a UI component.
 */
public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.JournalViewHolder> {
    private List<JournalEntry> entries = new ArrayList<>();
    private OnItemClickListener listener;

    /**
     * Called when RecyclerView needs a new {@link RecyclerView.ViewHolder} of the given type to represent
     * an item.
     *
     * @param parent   The ViewGroup into which the new View will be added.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View for the journal item.
     */
    @NonNull
    @Override
    public JournalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.journal_items, parent, false);
        return new JournalViewHolder(itemView);
    }

    /**
     * Called by RecyclerView to display the data at the specified position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the item.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull JournalViewHolder holder, int position) {
        JournalEntry currentEntry = entries.get(position);
        holder.textViewTitle.setText(currentEntry.getTitle());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return entries.size();
    }

    /**
     * Updates the data set of the adapter and notifies the RecyclerView to refresh.
     *
     * @param entries New data set of journal entries.
     */
    public void setEntries(List<JournalEntry> entries) {
        this.entries = entries;
        notifyDataSetChanged();
    }

    /**
     * Retrieves a journal entry at the specified position.
     *
     * @param position Position of the item in the adapter.
     * @return The journal entry at the specified position.
     */
    public JournalEntry getNoteAt(int position) {
        return entries.get(position);
    }

    /**
     * Sets a click listener to handle item clicks.
     *
     * @param listener The listener that handles the item clicks.
     */
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    /**
     * Interface to handle clicks on items within this adapter.
     */
    public interface OnItemClickListener {
        void onItemClick(JournalEntry entry);
    }

    /**
     * ViewHolder class for the journal entries. Holds the views for the individual entries in the RecyclerView.
     */
    class JournalViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;

        /**
         * Constructs the ViewHolder with a view of the journal item.
         *
         * @param itemView The view of the journal item.
         */
        public JournalViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.journal_entry_title);

            // Set a click listener on the item view
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

