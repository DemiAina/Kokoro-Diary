package com.example.mentalhealthapp.repository;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class HealthRepository implements SensorEventListener{
    private SensorManager sensorManager;
    private Sensor stepSensor;
    private Sensor heartRateSensor;
    private final MutableLiveData<Integer> stepsLiveData = new MutableLiveData<>();
    private final MutableLiveData<Float> heartRateLiveData = new MutableLiveData<>();

    public HealthRepository(Context context){
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        sensorManager.registerListener((SensorEventListener) this, stepSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            int steps = (int) event.values[0];
            stepsLiveData.postValue((int) event.values[0]);
            stepsLiveData.postValue(steps);
            Log.d("HealthRepository", "Steps updated: " + steps);
        } else if (event.sensor.getType() == Sensor.TYPE_HEART_RATE) {
            heartRateLiveData.postValue(event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // TODO: handle accuracy
    }

    public LiveData<Integer> getStepsLiveData() {
        return stepsLiveData;
    }

    public LiveData<Float> getHeartRateLiveData() {
        return heartRateLiveData;
    }
}
