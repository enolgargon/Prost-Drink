package com.cgi.sdm_project.util.singletons;

import android.media.MediaPlayer;

import com.cgi.sdm_project.R;
import com.cgi.sdm_project.util.Conf;

/**
 * Clase que aplica el patrón singleton para tener una única instancia del objeto MediaPlayer, que
 * se encarga de reproducir la música de fondo de la aplicación
 *
 * @author Jorge Iturrioz
 * @version 24-12-2018
 */

public class MediaPlayerSingleton {

    private static MediaPlayer mediaPlayer = null;
    public static final int MAX_VOLUMEN = 100;

    private MediaPlayerSingleton() {
    }

    public static MediaPlayer getInstance() {

        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer
                    .create(AppSingleton.getInstance().getContext(), R.raw.cancionfondo);
            mediaPlayer.setLooping(true);

            float volume = (float) (1 - (Math.log(MAX_VOLUMEN - Conf.getInstancia().getVolumen()) / Math.log(MAX_VOLUMEN)));
            mediaPlayer.setVolume(volume, volume);
        }
        return mediaPlayer;
    }

    public static void destroyMediaPlayer() {
        mediaPlayer = null;
    }
}
