package com.cgi.sdm_project.igu.juego.loop.memoria;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.loop.Loop;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.IFinJuego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.implementaciones.Memoria;
import com.cgi.sdm_project.util.adapters.MemoryCardAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * Juego para memorizar la posición de varias cartas y luego elegir una en concreto
 *
 * @author Samuel
 */
public class MemoriaActivity extends Loop implements InicioJuego, IFinJuego {
    /**
     * Constante que representan los milisegundos que se darán para memorizar donde están las cartas
     */
    private final int MEMORY_TIME = 2000;

    private Memoria memoria;
    private CountDownTimer loop;
    private RecyclerView board;
    private MemoryCardAdapter mAdapter;

    private ImageView imgTarget;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartasmemoria);

        this.memoria = (Memoria) Juego.getInstance().getJuegoActual();
        imgTarget = findViewById(R.id.imgTarget);

        prepareBoard();
        launchGame();


    }

    /**
     * Prepara el tablero cargando las imágenes en el adapter
     */
    private void prepareBoard() {
        board = findViewById(R.id.memoryBoard);
        board.setLayoutManager(new GridLayoutManager(this, 3));
        List<Drawable> imgs = new ArrayList<Drawable>();
        imgs.add(getDrawable(R.drawable.logo));
        imgs.add(getDrawable(R.drawable.topo));
        imgs.add(getDrawable(R.drawable.compass));
        imgs.add(getDrawable(R.drawable.trago));
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

    }

    /**
     * Es llamado por el onClick de la carta correcta para avisar al Activity.
     */
    public void notifySuccess() {
        //TODO implementación
        Log.i("SamUtil", "Acierto");
        findViewById(R.id.btnContinuar).setVisibility(View.VISIBLE);
    }

    /**
     * Es llamado por el onClick de una carta incorrecta para avisar al Activity
     */
    public void notifyFailure() {
        //TODO implementación
        Log.i("SamUtil", "has fallao loko");
    }
}
