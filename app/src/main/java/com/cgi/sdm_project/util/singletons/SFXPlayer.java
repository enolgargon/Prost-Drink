package com.cgi.sdm_project.util.singletons;


import android.media.AudioAttributes;
import android.media.SoundPool;


import com.cgi.sdm_project.util.Conf;

/**
 * Reproductor de efectos de audio
 *
 * @author Samuel
 */
public class SFXPlayer{
    private static SFXPlayer instance;

    private SoundPool mSoundPool;
    private int sfxID;

    public SFXPlayer(){
        AudioAttributes attr = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mSoundPool = new SoundPool.Builder().setMaxStreams(10)
                .setAudioAttributes(attr)
                .build();

    }

    public static SFXPlayer getInstance(){
        if (instance == null)
            instance = new SFXPlayer();
        return instance;
    }

    /**
     * Establece el audio a ejecutar, llámese antes de pedirle ejecutar audios (si no no reproducirá
     * ningún sonido)
     * @param id
     */
    public void setSFX(int id){
       sfxID = mSoundPool.load(AppSingleton.getInstance().getContext(), id, 1);
    }

    /**
     * Reproduce el sonido establecido anteriormente
     */
    public void playSFX(){
        float volume = (float)(1 - (Math.log(100 - Conf.getInstancia().getVolumen()) / Math.log(100)));
        mSoundPool.play(sfxID, volume, volume, 1, 0, 1);
    }

    /**
     * Libera los recursos asociados al reproductor, llámenlo cuando ya no lo necesiten
     */
    public void release(){
        mSoundPool.release();
        instance = null;
    }

}
