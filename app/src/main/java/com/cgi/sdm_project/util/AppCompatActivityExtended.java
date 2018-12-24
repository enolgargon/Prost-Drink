package com.cgi.sdm_project.util;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;

import com.cgi.sdm_project.util.singletons.MediaPlayerSingleton;

public class AppCompatActivityExtended extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        MediaPlayer mediaPlayer = MediaPlayerSingleton.getInstance();
        Conf configurations = Conf.getInstancia();
        //Si inicialmente tiene sonido y no se estaba reproduciendo antes.
        if (configurations.getSonido()) {
            mediaPlayer.setVolume(configurations.getVolumen(), configurations.getVolumen());
            mediaPlayer.start();
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        MediaPlayer mediaPlayer = MediaPlayerSingleton.getInstance();
        Conf configurations = Conf.getInstancia();
        //Si inicialmente tiene sonido y no se estaba reproduciendo antes.
        if (configurations.getSonido()) {
            mediaPlayer.setVolume(configurations.getVolumen(), configurations.getVolumen());
            mediaPlayer.start();
        }
    }

    @Override
    public void onPause() {
        MediaPlayer mediaPlayer = MediaPlayerSingleton.getInstance();
        if (mediaPlayer.isPlaying())
            mediaPlayer.pause();
        super.onPause();
    }

    @Override
    public void onRestart(){
        MediaPlayer mediaPlayer = MediaPlayerSingleton.getInstance();
        mediaPlayer.start();
        super.onRestart();
    }
}
