package com.cgi.sdm_project.logica.juego.reglas;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.cgi.sdm_project.util.AppSingleton;

import java.util.Arrays;
import java.util.Observable;

public class Brujula extends Observable implements SensorEventListener, Tragable {
    private float[] mAccelerometerReading = new float[3];
    private float[] mMagnetometerReading = new float[3];
    private float[] mRotationMatrix = new float[9];
    private float[] mOrientationAngles = new float[3];

    public Brujula() {
        SensorManager mSensorManager = (SensorManager) AppSingleton.getInstance().getContext().getSystemService(Context.SENSOR_SERVICE);

        Sensor accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null) {
            mSensorManager.registerListener(this, accelerometer,
                    SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
        }
        Sensor magneticField = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (magneticField != null) {
            mSensorManager.registerListener(this, magneticField,
                    SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
        }
    }

    public float getAngle() {
        return (float) Math.toDegrees(mOrientationAngles[0]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        setChanged();
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            mAccelerometerReading = Arrays.copyOf(event.values, event.values.length);
        } else if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            mMagnetometerReading = Arrays.copyOf(event.values, event.values.length);
        }

        updateOrientationAngles();
    }

    private void updateOrientationAngles() {
        SensorManager.getRotationMatrix(mRotationMatrix, null,
                mAccelerometerReading, mMagnetometerReading);

        SensorManager.getOrientation(mRotationMatrix, mOrientationAngles);

        notifyObservers(getAngle());
    }

    @Override
    public int getTragos() {
        return 0;
    }

    @Override
    public String getResultado() {
        return null;
    }
}
