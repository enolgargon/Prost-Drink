package com.cgi.sdm_project.util.singletons;

import android.media.MediaPlayer;

import com.cgi.sdm_project.R;

public class MediaPlayerSingleton {

    private static MediaPlayer mediaPlayer = null;

    /**
     * Atributo que determina si el reproductor estaba funcionando originalmente o no
     * Utilizado por las activities para saber si tienen que retomar la reproducción de la música
     * de fondo
     */

    //private static boolean wasPlaying = false;

    private MediaPlayerSingleton() {
    }

    public static MediaPlayer getInstance() {

        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer
                    .create(AppSingleton.getInstance().getContext(), R.raw.cancionfondo);
            mediaPlayer.setLooping(true);
        }
        return mediaPlayer;
    }

    /*
    public static void setWasPlaying(boolean option) {
        wasPlaying = option;
    }

    public static boolean wasPlaying() {
        return wasPlaying;
    }
*/
    public static void destroyMediaPlayer(){
        mediaPlayer = null;
    }
}
