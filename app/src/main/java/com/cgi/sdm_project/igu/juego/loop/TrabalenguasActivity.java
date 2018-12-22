package com.cgi.sdm_project.igu.juego.loop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.logica.juego.Juego;
import com.cgi.sdm_project.logica.juego.activities.InicioJuego;
import com.cgi.sdm_project.logica.juego.reglas.Trabalenguas;

import java.util.ArrayList;
import java.util.List;

public class TrabalenguasActivity extends Loop implements InicioJuego, TextToSpeech.OnInitListener{
    private Trabalenguas trabalenguas;
    private FloatingActionButton speakButton;
    private ImageButton reproducir;
    private Button continuar;
    private TextView inputText, trabalenguasTxt, intentosTxt;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trabalenguas);
        trabalenguas = (Trabalenguas) Juego.getInstance().getJuegoActual();

        ((TextView) findViewById(R.id.txtJugador)).setText(Juego.getInstance().getJugadorActual().toString());
        ((TextView) findViewById(R.id.lblTrabalenguas)).setText(trabalenguas.getTexto());


        //Asignación atributos
        intentosTxt = findViewById(R.id.txtIntentos);
        inputText = findViewById(R.id.txtInput);
        trabalenguasTxt = findViewById(R.id.lblTrabalenguas);
        speakButton = findViewById(R.id.btnSpeak);
        reproducir = findViewById(R.id.btnTTS);
        continuar = findViewById(R.id.btnContinuar);

        //Set número de intentos inicial
        intentosTxt.setText(String.valueOf(trabalenguas.getIntentos()));

        handleAudioIO();
    }

    /**
     * Se encarga de la asignación de listeners para la entrada y salida de audio por voz
     */
    private void handleAudioIO() {
        speakButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Lanza una actividad con el reconocimiento de voz
                Intent intent= new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                        "Repite el trabalenguas");
                startActivityForResult(intent, 0);
            }
        });
        final TextToSpeech tts = new TextToSpeech(this, this);
        reproducir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tts.speak(trabalenguasTxt.getText().toString(), TextToSpeech.QUEUE_ADD,
                        null, null);
            }
        });
    }

    /**
     * Procesa entrada de audio por micrófono
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == RESULT_OK)
        {
            ArrayList<String> matches =
                    data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            checkRespuesta(matches);
        }
    }

    /**
     * Comprueba entrada y la compara con el trabalenguas de la regla, si el resultado es correcto
     * se pinta en verde y se permite el progreso al siguiente juego.
     * Si no es correcto, se recalcula el número de intentos restantes y si se llega a 0 intentos,
     * se desbloquea el botón de continuar.
     * @param matches
     * @return
     */
    private boolean checkRespuesta(List<String> matches) {
        for (String m: matches){
            if (m.toLowerCase().equals(trabalenguas.getTexto().toLowerCase())){
                inputText.setText(m);
                Log.i("tts", m);
                inputText.setTextColor(Color.GREEN);
                continuar.setVisibility(View.VISIBLE);
                speakButton.setClickable(false);
                trabalenguas.atreverse();
                return true;
            }
        }
        inputText.setText(matches.get(0));
        inputText.setTextColor(Color.RED);
        continuar.setVisibility(View.VISIBLE);
        boolean flag = trabalenguas.reducirIntentos();
        intentosTxt.setText(String.valueOf(trabalenguas.getIntentos()));
        if (flag){
            continuar.setVisibility(View.VISIBLE);
            intentosTxt.setTextColor(Color.RED);
            speakButton.setClickable(false);
        }
        return false;
    }

    public void continuar(View view) {
        Intent mIntent = new Intent(getApplicationContext(), ResultadoActivity.class);
        startActivity(mIntent);
        finish();
    }

    @Override
    public void onInit(int status) {

    }
}
