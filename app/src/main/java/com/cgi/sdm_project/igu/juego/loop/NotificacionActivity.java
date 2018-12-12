package com.cgi.sdm_project.igu.juego.loop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.InicioJuego;
import com.cgi.sdm_project.logica.juego.Juego;

public class NotificacionActivity extends AppCompatActivity implements InicioJuego {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        ((TextView) findViewById(R.id.txtNotificacion)).setText(Juego.getInstance().getNotificacion());
    }

    public void confirmarNotificacion(View view) {
        Intent i = new Intent(view.getContext(), Juego.getInstance().getSiguienteJuego());
        view.getContext().startActivity(i);
        finish();
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
