package com.example.androidappfrontend;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * PUBLIC_INTERFACE
 * MainActivity – Hosts the bottom navigation and initializes the privacy-first MoodMate app
 */
public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_MoodMate);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        // Show privacy-focused UX notice only once on app first launch (example, for user trust)
        Toast.makeText(this, "All data stays privately on your device – MoodMate works fully offline.", Toast.LENGTH_LONG).show();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        
        // set first selected fragment
        loadFragment(new MoodLogFragment());

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment fragment;
            int id = item.getItemId();
            if (id == R.id.nav_journal) {
                fragment = new JournalFragment();
            } else if (id == R.id.nav_trends) {
                fragment = new TrendsFragment();
            } else /* if (id == R.id.nav_mood) */ {
                fragment = new MoodLogFragment();
            }
            return loadFragment(fragment);
        });
    }

    // PUBLIC_INTERFACE
    private boolean loadFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
        return true;
    }
}
