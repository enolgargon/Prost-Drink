package com.cgi.sdm_project.igu.juego.loop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Brujula;

import java.util.Observable;
import java.util.Observer;


public class BrujulaActivity extends Loop implements Observer, InicioJuego {
    private Brujula regla;
    private ImageView imgAguja;

    private View brujula;
    private TextView contador;
    private TextView instrucciones;
    private Button empezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brujula);

        brujula = findViewById(R.id.brujula);
        contador = findViewById(R.id.txtContador);
        imgAguja = findViewById(R.id.imgAguja);
        instrucciones = findViewById(R.id.txtInstrucciones);
        empezar = findViewById(R.id.btnEmpezar);

        brujula.setVisibility(View.INVISIBLE);
        contador.setVisibility(TextView.INVISIBLE);

        regla = ((Brujula) Juego.getInstance().getJuegoActual());
        regla.addObserver(this);
    }

    public void empezar(View view) {
        ocultarInstrucciones();
        new Thread(new Jugar()).start();
    }

    private void ocultarInstrucciones() {
        instrucciones.setVisibility(TextView.INVISIBLE);
        empezar.setVisibility(Button.INVISIBLE);
        instrucciones.invalidate();
        instrucciones.requestLayout();
    }

    private void mostrarResultado() {
        Intent i = new Intent(this, ResultadoActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Float)
            imgAguja.setRotation((float) arg);
        else if (o instanceof Brujula)
            imgAguja.setRotation(((Brujula) o).getAngle());
        else
            throw new RuntimeException();
    }

    private class Jugar implements Runnable {
        private int i;

        @Override
        public void run() {
            while (BrujulaActivity.this.regla.juega()) {
                mostrarContador();
                mostrarBrujula();
            }

            BrujulaActivity.this.mostrarResultado();
        }

        @SuppressLint("SetTextI18n")
        private void mostrarContador() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    contador.setVisibility(TextView.VISIBLE);
                }
            });

            for (i = 3; i > 0; i--) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        BrujulaActivity.this.contador.setText(Integer.toString(i));
                    }
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    contador.setVisibility(TextView.INVISIBLE);
                }
            });
        }

        private void mostrarBrujula() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    brujula.setVisibility(View.VISIBLE);
                }
            });

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    brujula.setVisibility(View.INVISIBLE);
                }
            });
        }
    }
}
