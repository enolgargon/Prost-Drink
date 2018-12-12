package com.cgi.sdm_project.igu.juego.loop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.InicioJuego;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.reglas.Votacion;

public class VotacionActivity extends AppCompatActivity implements InicioJuego {
    private Votacion votacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacion);
        votacion = (Votacion) Juego.getInstance().getJuegoActual();

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        ((TextView) findViewById(R.id.txtTextoVotacion)).setText(votacion.getTexto());
        ((Button) findViewById(R.id.btnVotacionOpA)).setText(votacion.getOpciones()[0]);
        ((Button) findViewById(R.id.btnVotacionOpB)).setText(votacion.getOpciones()[1]);
    }

    private void siguiente(View v) {
        Intent mIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        startActivity(mIntent);
        finish();
    }

    public void opcionA(View v) {
        votacion.votar(0);
        siguiente(v);
    }

    public void opcionB(View v) {
        votacion.votar(1);
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
