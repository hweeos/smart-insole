package com.example.smartinsole;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private LineChart pressureChart;
    private TextView tvImageViewPerson;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        pressureChart = root.findViewById(R.id.pressureChart);
        tvImageViewPerson = root.findViewById(R.id.textViewUserProfile);

        // Call method to set up pressure chart
        setupPressureChart();



        return root;
    }

    private void setupPressureChart() {
        // Sample pressure readings data
        List<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1, 20));
        entries.add(new Entry(2, 30));
        entries.add(new Entry(3, 25));
        entries.add(new Entry(4, 35));
        entries.add(new Entry(5, 40));

        // Create a LineDataSet from the entries
        LineDataSet dataSet = new LineDataSet(entries, "Pressure Readings");

        // Add the LineDataSet to a list of LineDataSets
        List<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);

        // Create a LineData object from the list of LineDataSets
        LineData lineData = new LineData(dataSets);

        // Set the LineData to the LineChart
        pressureChart.setData(lineData);

        // Refresh the chart to update its appearance
        pressureChart.invalidate();
    }

}
