package com.cgi.sdm_project.igu;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.util.AppCompatActivityExtended;
import com.cgi.sdm_project.util.Conf;
import com.cgi.sdm_project.util.singletons.MediaPlayerSingleton;

import static com.cgi.sdm_project.util.singletons.MediaPlayerSingleton.MAX_VOLUMEN;
/**
 * Se encarga de guardar las preferencias del usuario en el SharedPreferences
 *
 * @author Samuel Cifuentes y Jorge Iturrioz
 */
public class ConfiguracionActivity extends AppCompatActivityExtended {

    private Switch swSonido;
    private SeekBar sbVolumen;
    private Spinner spIdioma;
    private boolean flagCreation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        flagCreation = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        getComponents();
        cargarPreferencias();

        setListeners();

    }

    /**
     * Simplemente se encarga de inicializar las variables que contienen los componentes relevantes
     * del layout
     */
    private void getComponents() {
        swSonido = findViewById(R.id.swSonido);
        sbVolumen = findViewById(R.id.sbVolumen);
        sbVolumen.setMax(100);
        spIdioma = findViewById(R.id.spIdioma);
    }

    /**
     * Añade listeners a los componentes para que cooperen de forma adecuada
     */
    private void setListeners() {

        //Si el switch se desactiva la barra se debe poner a 0
        swSonido.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sbVolumen.setProgress(50);
                }
                if (!isChecked) {
                    sbVolumen.setProgress(0);
                }
                guardarCambios();
            }
        });

        //Si la barra se pone a 0 el switch se debe desactivar, para cualquier otro valor, se deberá
        //activar
        sbVolumen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (seekBar.getProgress() == 0) {
                    swSonido.setChecked(false);
                } else {
                    swSonido.setChecked(true);
                }
                guardarCambios();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        spIdioma.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (flagCreation)
                    flagCreation = false;
                else {
                    guardarCambios();
                    finish();
                    overridePendingTransition(0, 0);
                    startActivity(getIntent());
                    overridePendingTransition(0, 0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Carga los valores almacenados en las preferencias
     */
    private void cargarPreferencias() {
        Conf conf = Conf.getInstancia();
        swSonido.setChecked(conf.getSonido());
        sbVolumen.setProgress(conf.getVolumen());
        spIdioma.setSelection(conf.getIdioma());
    }

    private void guardarCambios() {
        Conf conf = Conf.getInstancia();
        conf.setSonido(swSonido.isChecked());
        conf.setVolumen(sbVolumen.getProgress());
        conf.setIdioma(spIdioma.getSelectedItemPosition());
        Log.i("wtf", Conf.getInstancia().getIdioma() + "");

        MediaPlayer mediaPlayer = MediaPlayerSingleton.getInstance();

        if (!swSonido.isChecked() && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.release();
            MediaPlayerSingleton.destroyMediaPlayer();
        } else if (swSonido.isChecked()) {
            if (mediaPlayer.isPlaying())
                mediaPlayer.pause();
            float volume = (float) (1 - (Math.log(MAX_VOLUMEN - sbVolumen.getProgress())
                    / Math.log(MAX_VOLUMEN)));
            mediaPlayer.setVolume(volume, volume);
            mediaPlayer.start();
        }
    }

    /**
     * Redefinición del onDestroy donde también se indica que se han guardado los cambios
     */
    @Override
    public void onDestroy() {
        Toast.makeText(getApplicationContext(), getString(R.string.CambiosGuardados),
                Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
