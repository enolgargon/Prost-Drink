package com.cgi.sdm_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        resultado = findViewById(R.id.txtResultado);
        resultado.setText(R.string.ResultadoEjemplo);
    }

    public void siguiente(View view){
        Intent mIntent = new Intent(getApplicationContext(), JuegoPreguntaActivity.class);
        startActivity(mIntent);
    }
}
