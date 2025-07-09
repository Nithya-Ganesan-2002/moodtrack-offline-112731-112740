package com.example.androidappfrontend.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Delete;
import java.util.List;

/**
 * PUBLIC_INTERFACE
 * MoodEntryDao – Data access object for mood entries
 */
@Dao
public interface MoodEntryDao {
    @Insert
    void insert(MoodEntry entry);

    @Update
    void update(MoodEntry entry);

    @Delete
    void delete(MoodEntry entry);

    @Query("SELECT * FROM mood_entries WHERE date = :date LIMIT 1")
    MoodEntry getMoodForDate(String date);

    @Query("SELECT * FROM mood_entries ORDER BY date DESC LIMIT 30")
    List<MoodEntry> getRecentMoods();
}
