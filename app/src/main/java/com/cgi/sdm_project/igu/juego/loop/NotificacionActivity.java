package com.cgi.sdm_project.igu.juego.loop;

import android.content.Intent;
import android.os.Bundle;
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
    }

    @Override
    public void onBackPressed() {
        //Eliminar la opcion de volver hacia atrás ya que no interesa
    }
}
