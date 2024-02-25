package com.example.my_framework;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

import java.io.IOException;

public class MusicFW implements MediaPlayer.OnCompletionListener {

    MediaPlayer mediaPlayer;
    boolean isPrepared=false;

    public MusicFW(AssetFileDescriptor assetFileDescriptor){
        mediaPlayer=new MediaPlayer();
        try {
            mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),assetFileDescriptor.getStartOffset(),
                    assetFileDescriptor.getLength());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        isPrepared=true;

        mediaPlayer.setOnCompletionListener(this);
    }

    public void play(boolean looping,float volume){
        if (mediaPlayer.isPlaying()){
            return;
        }
        synchronized (this){
            if (!isPrepared){
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mediaPlayer.setLooping(looping);
            mediaPlayer.setVolume(volume,volume);
            mediaPlayer.start();
        }
    }

    public void stop(){
        mediaPlayer.stop();
        synchronized (this){
            isPrepared=false;
        }
    }

    public void dispose() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        synchronized (this){
            isPrepared=false;
        }
    }
}
