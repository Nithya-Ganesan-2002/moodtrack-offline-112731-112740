package com.example.androidappfrontend.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * PUBLIC_INTERFACE
 * MoodMateDatabase – Local app database holding mood and journal entries
 */
@Database(entities = {MoodEntry.class, JournalEntry.class}, version = 1)
public abstract class MoodMateDatabase extends RoomDatabase {
    private static volatile MoodMateDatabase INSTANCE;

    public abstract MoodEntryDao moodEntryDao();
    public abstract JournalEntryDao journalEntryDao();

    /**
     * PUBLIC_INTERFACE
     * Gets singleton database instance
     */
    public static MoodMateDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MoodMateDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MoodMateDatabase.class, "moodmate_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
