package com.cgi.sdm_project.igu.juego.loop;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Cartas;

public class CartasActivity extends AppCompatActivity implements InicioJuego {
    private Cartas regla;

    private ImageView actual;
    private Button btnDerecha, btnIzquierda;
    private TextView txtFin;
    private LinearLayout puntos, cartas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartas);

        regla = (Cartas) Juego.getInstance().getJuegoActual();
        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());

        btnDerecha = findViewById(R.id.btnCartasDerecha);
        btnIzquierda = findViewById(R.id.btnCartasIzquierda);
        txtFin = findViewById(R.id.txtFin);
        puntos = findViewById(R.id.points_view);
        cartas = findViewById(R.id.cartas_view);

        modificarTextoBotones();
        mostrarCartaBlanco();
    }

    private void modificarTextoBotones() {
        btnDerecha.setText(regla.getOpcionDerecha());
        btnIzquierda.setText(regla.getOpcionIzquierda());
    }

    private void mostrarCartaBlanco() {
        actual = new ImageView(this);
        actual.setImageResource(R.drawable.blanco);
        cartas.addView(actual);
    }

    private void mostrarPuntos(boolean acierto) {
        ImageView img = new ImageView(this);
        img.setImageResource(acierto ? R.drawable.correcto : R.drawable.incorrecto);
        puntos.addView(img);
    }

    private void mostrarCarta() {
        actual.setImageResource(regla.getActual().getRes());
    }

    private void mostrarFin() {
        btnIzquierda.setVisibility(Button.GONE);
        btnDerecha.setVisibility(Button.GONE);
        txtFin.setVisibility(TextView.VISIBLE);
    }

    public void pulsarIzquierda(View view) {
        registrarPulsacion(Cartas.RESPUESTA_IZQUIERDA);
    }

    public void pulsarDerecha(View view) {
        registrarPulsacion(Cartas.RESPUESTA_DERECHA);
    }

    private void registrarPulsacion(boolean boton) {
        mostrarPuntos(regla.jugar(boton));
        mostrarCarta();

        if (regla.isFinished()) {
            mostrarFin();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    verResultado();
                }
            }, 3000);
        }

        modificarTextoBotones();
        mostrarCartaBlanco();
    }

    private void verResultado() {
        Intent intent = new Intent(this, ResultadoActivity.class);
        startActivity(intent);
        finish();
    }
}
