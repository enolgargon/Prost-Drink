package com.cgi.sdm_project.igu.juego.loop;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.ContinuarRonda;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;

public class NotificacionActivity extends Loop implements InicioJuego {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        ((TextView) findViewById(R.id.txtNotificacion)).setText(Juego.getInstance().getNotificacion());
    }

    public void confirmarNotificacion(View view) {
        new ContinuarRonda().cargarSiguienteJuego(view);
        finish();
    }
}
