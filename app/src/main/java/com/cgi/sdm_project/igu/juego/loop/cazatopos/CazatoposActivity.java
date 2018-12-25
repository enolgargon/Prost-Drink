package com.cgi.sdm_project.igu.juego.loop.cazatopos;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.igu.juego.loop.Loop;
import com.cgi.sdm_project.igu.juego.loop.ResultadoActivity;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.IFinJuego;
import com.cgi.sdm_project.logica.juego.reglas.Cazatopos;


/**
 * Contiene el jugo de los topos y gestiona el loop de éste
 *
 * @author Samuel
 */
public class CazatoposActivity extends Loop implements IFinJuego {
    private final static int SECONDS = 30;
    private final static int TICKMS = 100;

    private Cazatopos cazatopos;
    private CountDownTimer loop;

    /**
     * Áreas donde el jugador puede hacer click
     */
    private ImageButton[] inputs;

    /**
     * Tick actual del juego     *
     */
    private int ticks;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topos);

        this.cazatopos = (Cazatopos) Juego.getInstance().getJuegoActual();
        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());

        inputs = new ImageButton[]{findViewById(R.id.topo0),
                findViewById(R.id.topo1),
                findViewById(R.id.topo2),
                findViewById(R.id.topo3),
                findViewById(R.id.topo4),
                findViewById(R.id.topo5)
        };
        for (int i = 0; i < inputs.length; i++) {
            inputs[i].setOnClickListener(new TopoListener(i));
        }

        launchGame();
    }

    /**
     * Crea y lanza el loop del juego que durará @SECONDS segundos
     */
    void launchGame() {
        loop = new CountDownTimer(SECONDS * 1000, TICKMS) {

            @Override
            public void onTick(long millisUntilFinished) {
                updateTopos(millisUntilFinished);
                ticks++;
            }


            @Override
            public void onFinish() {
                findViewById(R.id.topoBoard).setVisibility(View.INVISIBLE);
                findViewById(R.id.txtFinTopos).setVisibility(View.VISIBLE);
                findViewById(R.id.btnContinuar).setVisibility(View.VISIBLE);
            }
        };
        ticks = 0;
        loop.start();
    }

    /**
     * Pinta el estado actual del tablero
     */
    private void paintTopos() {
        for (int i = 0; i < inputs.length; i++) {
            inputs[i].setImageDrawable(cazatopos.getCasillas()[i].getImg());
        }
    }

    /**
     * cambia las casillas del tablero, aumentando la dificultad progresiva
     *
     * @param ticksLeft
     */
    private void updateTopos(long ticksLeft) {
        Log.i("tick", "" + ticks);
        int tickRatio = SECONDS * 1000 / TICKMS;
        //EASY
        if (ticks <= tickRatio / 3 && ticks % 18 == 0) {
            cazatopos.actualizarTablero(1);
            paintTopos();
        }
        //MEDIUM
        if (ticks > tickRatio / 3 && ticks <= tickRatio * 2 / 3 && ticks % 18 == 0) {
            cazatopos.actualizarTablero(2);
            paintTopos();
        }
        //HARD
        if (ticks > tickRatio * 2 / 3 && ticks <= tickRatio * 8 / 10 && ticks % 15 == 0) {
            cazatopos.actualizarTablero(2);
            paintTopos();
        }
        //OH BOI
        else if (ticks > tickRatio * 8 / 10 && ticks % 12 == 0) {
            cazatopos.actualizarTablero(3);
            paintTopos();
        }

    }

    @Override
    public void cargarSiguienteJuego(View view) {
        Intent mIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        startActivity(mIntent);
        finish();
    }

    /**
     * Implementación extendida de OnClickListener para conocer qué casilla se ha pulsado
     */
    class TopoListener implements View.OnClickListener {
        private int casilla;

        public TopoListener(int i) {
            this.casilla = i;
        }

        @Override
        public void onClick(View v) {
            cazatopos.getCasillas()[casilla].click();
            inputs[casilla].setImageDrawable(getDrawable(R.drawable.hole));
        }
    }
}
