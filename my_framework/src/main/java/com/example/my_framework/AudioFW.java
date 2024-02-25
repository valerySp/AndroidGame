package com.example.my_framework;

import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;

public class AudioFW  {

    private AssetManager assetManager;
    SoundPool soundPool;

    public AudioFW(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        assetManager = activity.getAssets();
        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        soundPool = new SoundPool.Builder().setAudioAttributes(audioAttributes).build();
    }

    public MusicFW newMusic(String fileName) {
        try {
            AssetFileDescriptor assetFileDescriptor = assetManager.openFd(fileName);
            return new MusicFW(assetFileDescriptor);
        } catch (IOException e) {
            throw new RuntimeException("Не возможно загрузить музыку");
        }
    }

    public SoundFW newSound(String fileName){
        AssetFileDescriptor assetFileDescriptor=null;
        try {
            assetFileDescriptor=assetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int sound=soundPool.load(assetFileDescriptor,0);
        return  new SoundFW(sound,soundPool);
    }
}
