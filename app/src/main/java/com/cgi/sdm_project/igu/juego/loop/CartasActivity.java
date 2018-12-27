package com.cgi.sdm_project.igu.juego.loop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Cartas;

public class CartasActivity extends AppCompatActivity {
    private Cartas regla;

    private ImageView blanco;
    private Button btnDerecha, btnIzquierda;
    private LinearLayout puntos, cartas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartas);

        regla = (Cartas) Juego.getInstance().getJuegoActual();

        blanco = new ImageView(this);
        blanco.setImageResource(R.drawable.blanco);

        btnDerecha = findViewById(R.id.btnCartasDerecha);
        btnIzquierda = findViewById(R.id.btnCartasIzquierda);
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
        cartas.addView(blanco);
    }

    private void mostrarPuntos(boolean acierto) {

    }

    private void mostrarCarta() {
        cartas.removeView(blanco);
        ImageView img = new ImageView(this);
        img.setImageResource(regla.getActual().getRes());
        cartas.addView(img);
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

        regla.siguienteCarta();
        modificarTextoBotones();
        mostrarCartaBlanco();
    }
}
