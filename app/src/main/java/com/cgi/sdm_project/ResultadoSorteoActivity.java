package com.cgi.sdm_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridLayout;

import com.cgi.sdm_project.logica.sorteo.Sorteo;

import java.util.Objects;

public class ResultadoSorteoActivity extends AppCompatActivity {
    private Sorteo sorteo;

    private GridLayout resultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_sorteo);

        sorteo = Objects.requireNonNull(getIntent().getExtras(), "No se han recibido los datos del sorteo").getParcelable(SortearActivity.SORTEO);
        Log.i("SORTEO", sorteo.toString());

        resultados = findViewById(R.id.gridResultados);
    }
}
