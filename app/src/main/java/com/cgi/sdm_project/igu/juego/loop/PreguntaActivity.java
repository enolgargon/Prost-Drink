package com.cgi.sdm_project.igu.juego.loop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.Pregunta;

public class PreguntaActivity extends AppCompatActivity implements InicioJuego {
    private Pregunta pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
        pregunta = (Pregunta) Juego.getInstance().getJuegoActual();

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        ((TextView) findViewById(R.id.lblPregunta)).setText(pregunta.getPregunta());
    }

    private void siguiente(View v) {
        Intent mIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        startActivity(mIntent);
        finish();
    }

    public void contestar(View v) {
        pregunta.contestar();
        siguiente(v);
    }

    public void pasar(View v) {
        pregunta.pasar();
        siguiente(v);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(getString(R.string.titulo_back));

        alertDialogBuilder
                .setMessage(getString(R.string.texto_back))
                .setCancelable(false)
                .setPositiveButton(getString(R.string.OK), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        salirJuego();
                    }
                })
                .setNegativeButton(getString(R.string.Cancelar), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void salirJuego() {
        super.onBackPressed();
    }
}
