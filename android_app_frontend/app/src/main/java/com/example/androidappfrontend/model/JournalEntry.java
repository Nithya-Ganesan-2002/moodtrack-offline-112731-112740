package com.example.androidappfrontend.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 * PUBLIC_INTERFACE
 * JournalEntry – Represents a daily journal entry
 */
@Entity(tableName = "journal_entries")
public class JournalEntry {
    @PrimaryKey
    @NonNull
    public String date; // format: yyyy-MM-dd

    public String content;

    public JournalEntry(@NonNull String date, String content) {
        this.date = date;
        this.content = content;
    }
}
