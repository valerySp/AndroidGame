package com.example.game.utilits;

import android.content.SharedPreferences;

import com.example.my_framework.CoreFW;

public class SettingsGame {

    public static boolean musicOn = true;
    public static boolean soundOn = true;
    public static int[] distance = {2500, 2000, 1500, 1000, 500};

    public static void saveSettings(CoreFW coreFW) {
        SharedPreferences.Editor editor = coreFW.getSharedPreferences().edit();
        editor.clear();
        //editor.putBoolean("soundOn",soundOn);
        //editor.putBoolean("musicOn",musicOn);
        for (int i = 0; i < 5; i++) {
            editor.putInt("passedDistance" + i, distance[i]);
        }
        editor.apply();
    }
    public static void loadSettings(CoreFW coreFW) {
        //soundOn = coreFW.getSharedPreferences().getBoolean("soundOn",true);
        //musicOn = coreFW.getSharedPreferences().getBoolean("musicOn",true);
        for (int i = 0; i < 5; i++) {
            distance[i] = coreFW
                    .getSharedPreferences()
                    .getInt("passedDistance" + i, distance[i]);
        }
    }


    public static void addDistance(int values) {
        int pref=0;
        for (int i = 1; i < 5; i++) {
            if (distance[i] < values) {
                pref=distance[i];
                distance[i] = values;
                distance[i-1]=pref;
                break;
            }
        }
    }
}
