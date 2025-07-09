package com.example.androidappfrontend.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

/**
 * PUBLIC_INTERFACE
 * MoodEntry – Represents a daily mood value
 */
@Entity(tableName = "mood_entries")
public class MoodEntry {
    @PrimaryKey
    @NonNull
    public String date; // format: yyyy-MM-dd

    public int mood; // e.g. 1=happy, 2=neutral, 3=sad

    public MoodEntry(@NonNull String date, int mood) {
        this.date = date;
        this.mood = mood;
    }
}
