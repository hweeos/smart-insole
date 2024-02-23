package com.example.smartinsole;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.SearchView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

public class SettingsFragment extends Fragment {

    private EditText editTextPressureThreshold;
    private EditText editTextTemperatureThreshold;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        editTextPressureThreshold = view.findViewById(R.id.editTextPressureThreshold);
        editTextTemperatureThreshold = view.findViewById(R.id.editTextTemperatureThreshold);

        // Load and display saved threshold values
        loadThresholdValues();

        // Setup Save button click listener
        Button btnSave = view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveThresholdValues();
            }
        });

        return view;

    }

    // Method to load and display saved threshold values
    private void loadThresholdValues() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        float pressureThreshold = sharedPreferences.getFloat("pressure_threshold", 0.0f);
        float temperatureThreshold = sharedPreferences.getFloat("temperature_threshold", 0.0f);

        editTextPressureThreshold.setText(String.valueOf(pressureThreshold));
        editTextTemperatureThreshold.setText(String.valueOf(temperatureThreshold));
    }

    // Method to save threshold values to SharedPreferences
    private void saveThresholdValues() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();

        float pressureThreshold = Float.parseFloat(editTextPressureThreshold.getText().toString());
        float temperatureThreshold = Float.parseFloat(editTextTemperatureThreshold.getText().toString());

        editor.putFloat("pressure_threshold", pressureThreshold);
        editor.putFloat("temperature_threshold", temperatureThreshold);
        editor.apply();

        Toast.makeText(requireContext(), "Threshold values saved successfully", Toast.LENGTH_SHORT).show();
    }

}
