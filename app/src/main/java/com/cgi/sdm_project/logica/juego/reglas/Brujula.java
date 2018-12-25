package com.cgi.sdm_project.logica.juego.reglas;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.util.AppSingleton;

import java.util.Arrays;
import java.util.Observable;

public class Brujula extends Observable implements SensorEventListener, Tragable {
    private int intentos;
    private boolean logrado;

    private float[] mAccelerometerReading = new float[3];
    private float[] mMagnetometerReading = new float[3];
    private float[] mRotationMatrix = new float[9];

    private float[] mOrientationAngles = new float[3];

    public Brujula() {
        intentos = 3;
        logrado = false;

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

    public boolean juega() {
        if (Math.abs(getAngle()) < 5)
            logrado = true;

        return intentos-- != 0 && !logrado;
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
        return 3 + intentos;
    }

    @Override
    public String getResultado() {
        try {
            int resource = R.string.class.getField(nombreRespuesta()).getInt(R.string.class);
            return String.format(AppSingleton.getInstance().getContext().getString(resource), getTragos());
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return String.format(AppSingleton.getInstance().getContext().getString(R.string.resultado_generar), getTragos());
    }

    private String nombreRespuesta() {
        if (logrado)
            return "brujula_acierto" + ((int) (Math.random() * 2) + 1);
        return "brujula_fallo" + ((int) (Math.random() * 2) + 1);
    }
}
