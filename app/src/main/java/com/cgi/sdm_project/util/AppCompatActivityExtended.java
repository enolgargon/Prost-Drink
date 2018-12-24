package com.cgi.sdm_project.util;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

import com.cgi.sdm_project.util.singletons.MediaPlayerSingleton;

import static com.cgi.sdm_project.util.singletons.MediaPlayerSingleton.MAX_VOLUMEN;

/**
 * Clase intermediaria entre AppCompatActivity y MediaPlayerSingleton, que redefine los métodos
 * de los ciclos de vida de las activities para poder manejar a su vez un MediaPlayer
 *
 * @author Jorge Iturrioz
 * @version 24-12-2018
 */

public class AppCompatActivityExtended extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        MediaPlayer mediaPlayer = MediaPlayerSingleton.getInstance();
        Conf configurations = Conf.getInstancia();
        //Si inicialmente tiene sonido y no se estaba reproduciendo antes.
        if (configurations.getSonido()) {
            float volume = (float) (1 - (Math.log(MAX_VOLUMEN - Conf.getInstancia().getVolumen())
                    / Math.log(MAX_VOLUMEN)));
            mediaPlayer.setVolume(volume, volume);
            mediaPlayer.start();
        }
    }

    //En teoría el comportamiento de este
    @Override
    protected void onStart(){
        super.onStart();
        MediaPlayer mediaPlayer = MediaPlayerSingleton.getInstance();
        Conf configurations = Conf.getInstancia();
        //Si inicialmente tiene sonido y no se estaba reproduciendo antes.
        if (configurations.getSonido()) {
            float volume = (float) (1 - (Math.log(MAX_VOLUMEN - Conf.getInstancia().getVolumen())
                    / Math.log(MAX_VOLUMEN)));
            mediaPlayer.setVolume(volume, volume);
            mediaPlayer.start();
        }
    }

    @Override
    public void onPause() {
        MediaPlayer mediaPlayer = MediaPlayerSingleton.getInstance();
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            float volume = (float) (1 - (Math.log(MAX_VOLUMEN - Conf.getInstancia().getVolumen())
                    / Math.log(MAX_VOLUMEN)));
            mediaPlayer.setVolume(volume, volume);
        }
        super.onPause();
    }
}
