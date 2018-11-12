package com.cgi.sdm_project.igu.juego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;

public class JuegoPreguntaActivity extends AppCompatActivity {
    private TextView pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
        pregunta = findViewById(R.id.lblPregunta);
        pregunta.setText(R.string.PreguntaEjemplo);
    }

    public void contestar(View v){
        Intent mIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        startActivity(mIntent);
    }
}
