package com.cgi.sdm_project.igu;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
 * @author Samuel
 */
public class ConfiguracionActivity extends AppCompatActivityExtended {

    private Switch swSonido;
    private SeekBar sbVolumen;
    private Spinner spIdioma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

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

    /*
    public void guardar(View view) {
        Conf conf = Conf.getInstancia();
        conf.setSonido(swSonido.isChecked());
        conf.setVolumen(sbVolumen.getProgress());
        conf.setIdioma(spIdioma.getSelectedItemPosition());

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

        Toast.makeText(getApplicationContext(), getString(R.string.CambiosGuardados),
                Toast.LENGTH_SHORT).show();

    }
    */

    /**
     * Redefinición del onDestroy que además se encarga de guardar los cambios realizados en la
     * activity de configuracion (this)
     */
    @Override
    protected void onDestroy() {

        Conf conf = Conf.getInstancia();
        conf.setSonido(swSonido.isChecked());
        conf.setVolumen(sbVolumen.getProgress());
        conf.setIdioma(spIdioma.getSelectedItemPosition());

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

        Toast.makeText(getApplicationContext(), getString(R.string.CambiosGuardados),
                Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }
}
