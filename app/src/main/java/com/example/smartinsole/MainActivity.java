package com.example.smartinsole;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        // Set DashboardFragment as default fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new DashboardFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item -> {
                Fragment selectedFragment = null;

                if (item.getItemId() == R.id.action_dashboard) {
                    selectedFragment = new DashboardFragment();
                } else if (item.getItemId() == R.id.action_notifications) {
                    selectedFragment = new NotificationFragment();
                } else if (item.getItemId() == R.id.action_settings) {
                    selectedFragment = new SettingsFragment();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();

                return true;
            };

}