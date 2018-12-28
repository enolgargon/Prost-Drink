package com.cgi.sdm_project.igu.juego.loop.memoria;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.loop.Loop;
import com.cgi.sdm_project.igu.juego.loop.ResultadoActivity;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.IFinJuego;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Memoria;
import com.cgi.sdm_project.util.adapters.MemoryCardAdapter;
import com.cgi.sdm_project.util.baraja.Carta;

import java.util.ArrayList;
import java.util.List;


/**
 * Juego para memorizar la posición de varias cartas y luego elegir una en concreto
 *
 * @author Samuel
 */
public class MemoriaActivity extends Loop implements IFinJuego {
    /**
     * Constante que representan los milisegundos que se darán para memorizar donde están las cartas
     */
    private final int MEMORY_TIME = 10000;

    private Memoria memoria;
    private RecyclerView board;
    private MemoryCardAdapter mAdapter;

    private ImageView imgTarget;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartasmemoria);

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        this.memoria = (Memoria) Juego.getInstance().getJuegoActual();
        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        imgTarget = findViewById(R.id.imgTarget);

        prepareBoard();
        launchGame();


    }

    /**
     * Prepara el tablero cargando las imágenes en el adapter
     */
    private void prepareBoard() {
        board = findViewById(R.id.memoryBoard);
        board.setLayoutManager(new GridLayoutManager(this, 4));
        List<Drawable> imgs = new ArrayList<Drawable>();
        List<Carta> cartas = memoria.getCartas();
        for (Carta c : cartas)
            imgs.add(getDrawable(c.getRes()));
        mAdapter = new MemoryCardAdapter(imgs, this);
        board.setAdapter(mAdapter);
    }

    /**
     * Lanza el juego, da @MEMORY_TIME segundos para aprenderse la posición de las cartas y tras
     * ese tiempo se ocultan y se muestra qué carta hay que buscar
     */
    private void launchGame() {
        board.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.ocultarCartas();
                imgTarget.setImageDrawable(mAdapter.getObjetivo());
            }
        }, MEMORY_TIME);
    }

    @Override
    public void cargarSiguienteJuego(View view) {
        Intent mIntent = new Intent(this, ResultadoActivity.class);
        startActivity(mIntent);
        finish();
    }

    /**
     * Es llamado por el onClick de la carta correcta para avisar al Activity.
     */
    public void notifySuccess() {
        memoria.acierto();
        mostrarBtnContinuar();
    }

    /**
     * Es llamado por el onClick de una carta incorrecta para avisar al Activity
     */
    public void notifyFailure() {
        memoria.fallo();
        mostrarBtnContinuar();
    }

    /**
     * Muestra el botón para pasar a la siguiente actividad
     */
    private void mostrarBtnContinuar() {
        findViewById(R.id.btnContinuar).setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
