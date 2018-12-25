package com.cgi.sdm_project.igu.juego.loop.equilibrio;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.loop.Loop;
import com.cgi.sdm_project.igu.juego.loop.ResultadoActivity;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.reglas.Equilibrio;
import com.github.anastr.speedviewlib.PointerSpeedometer;


public class EquilibrioActivity extends Loop implements SensorEventListener {
    private Equilibrio equilibrio;

    private TextView txtWarm;
    private Button btnGo;
    private PointerSpeedometer gauge;

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private double sensorVal;
    private double target;

    private long lastUpdate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equilibrio);

        equilibrio = (Equilibrio) Juego.getInstance().getJuegoActual();
        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());

        customizeGauge();

        target = Math.random() * 20 - 10;
        lastUpdate = 0L;

        txtWarm = findViewById(R.id.txtWarm);
        btnGo = findViewById(R.id.btnReady);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR);
    }

    @Override
    protected void onDestroy() {
        //Resetea el juego para la próxima vez
        equilibrio.fallo();
        super.onDestroy();
    }

    /**
     * Personaliza el medidor
     */
    private void customizeGauge() {
        gauge = findViewById(R.id.speedometer);
        gauge.setUnit("");
    }

    /**
     * Actualiza el textView en función de lo cerca que esté el usuario de acertar
     */
    private void updateHotWarm() {
        double diff = Math.abs(target - sensorVal) / 2;
        if (diff <= 1) {
            txtWarm.setText(getString(R.string.ardiendo));
            txtWarm.setTextColor(Color.RED);
        } else if (diff > 1 && diff <= 2) {
            txtWarm.setText(getString(R.string.caliente));
            txtWarm.setTextColor(Color.YELLOW);
        } else if (diff > 2 && diff <= 6) {
            txtWarm.setText(getString(R.string.templado));
            txtWarm.setTextColor(Color.YELLOW);
        } else if (diff > 6 && diff <= 8) {
            txtWarm.setText(getString(R.string.frio));
            txtWarm.setTextColor(Color.CYAN);
        } else if (diff > 8) {
            txtWarm.setText(getString(R.string.helado));
            txtWarm.setTextColor(Color.CYAN);
        }
    }

    /**
     * Cuando el usuario cree que ya tiene la solución le da a listo y se comprueba si es correcta
     *
     * @param v
     */
    public void ready(View v) {
        checkResult();
        Intent mIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        startActivity(mIntent);
        finish();
    }

    private void checkResult() {
        if (Math.abs(target - sensorVal) / 2 < 0.5)
            equilibrio.acierto();
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        float z = event.values[0];

        long curTime = System.currentTimeMillis();

        if ((curTime - lastUpdate) > 100) {
            sensorVal = z;
            gauge.speedPercentTo((int) (50 - z * 5));
            updateHotWarm();
            lastUpdate = curTime;
        }
    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }


    @Override
    protected void onResume() {
        super.onResume();
        Sensor accelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null) {
            mSensorManager.registerListener(this, accelerometer,
                    SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
