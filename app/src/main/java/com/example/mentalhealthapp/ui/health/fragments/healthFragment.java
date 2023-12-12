package com.example.mentalhealthapp.ui.health.fragments;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mentalhealthapp.R;
import com.example.mentalhealthapp.repository.HealthRepository;
import com.example.mentalhealthapp.viewModel.healthViewModel;

public class healthFragment extends Fragment {
    private TextView stepsTextView;
    private healthViewModel HealthViewModel;

    private SensorManager sensorManager;
    private HealthRepository HealthRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sensorManager = (SensorManager) requireActivity().getSystemService(Context.SENSOR_SERVICE);
        HealthRepository = new HealthRepository(requireContext());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        HealthViewModel = new ViewModelProvider(requireActivity()).get(healthViewModel.class);
        View view = inflater.inflate(R.layout.excerise_layout, container, false);
        stepsTextView = view.findViewById(R.id.steps_text_view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        HealthViewModel = new ViewModelProvider(this).get(healthViewModel.class);
        HealthViewModel.getStepsLiveData().observe(getViewLifecycleOwner(), steps -> {
            Log.d("HealthFragment", "Observed steps: " + steps);
            stepsTextView.setText("Steps: " + steps);
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        sensorManager.registerListener(HealthRepository,
                sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(HealthRepository);
    }
}
