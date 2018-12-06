package com.cgi.sdm_project.igu.juego.loop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Reglas.Votacion;

public class VotacionActivity extends AppCompatActivity {
    private Votacion votacion;

    public VotacionActivity(Votacion votacion) {
        this.votacion = votacion;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacion);

        ((TextView) findViewById(R.id.lblPregunta)).setText(votacion.getTexto());
        ((Button) findViewById(R.id.btnVotacionOpA)).setText(votacion.getOpciones()[0]);
        ((Button) findViewById(R.id.btnVotacionOpB)).setText(votacion.getOpciones()[1]);
    }

    public void contestar(View v) {
        Intent mIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        startActivity(mIntent);
    }
}
