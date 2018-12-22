package com.cgi.sdm_project;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.cgi.sdm_project.util.Conf;

public class BackgroundSoundService extends Service {
    private static final String TAG = null;
    MediaPlayer player;

    public IBinder onBind(Intent arg0) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {

        player = MediaPlayer.create(this, R.raw.cancionfondo);
        player.setLooping(true); // Establecer bucle para que se repita la cancion
        player.setVolume(Conf.getInstancia().getVolumen(),Conf.getInstancia().getVolumen());
        player.start();
        return Service.START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }
}