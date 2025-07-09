package com.example.androidappfrontend.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;

/**
 * PUBLIC_INTERFACE
 * JournalEntryDao – Data access object for journal entries
 */
@Dao
public interface JournalEntryDao {
    @Insert
    void insert(JournalEntry entry);

    @Update
    void update(JournalEntry entry);

    @Delete
    void delete(JournalEntry entry);

    @Query("SELECT * FROM journal_entries WHERE date = :date LIMIT 1")
    JournalEntry getJournalForDate(String date);
}
