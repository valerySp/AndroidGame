package com.example.game.objects;

import android.graphics.Color;

import com.example.game.R;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;

public class HUD {
    private int passedDistance;
    private int currentSpeedPlayer;
    private int currentShieldsPlayer;

    private final CoreFW CORE_GAME;
    private final int HEIGHT_HUD = 50;

    public HUD(CoreFW coreGame) {
        this.CORE_GAME = coreGame;
    }

    public void update(int passedDistance, int currentSpeedPlayer, int currentShieldsPlayer) {
        this.passedDistance = passedDistance;
        this.currentSpeedPlayer = currentSpeedPlayer;
        this.currentShieldsPlayer = currentShieldsPlayer;
    }

    public void drawing(GraphicsFW graphicsGame){
        graphicsGame.drawLine(0,HEIGHT_HUD, graphicsGame.getWidthFrameBuffer(),HEIGHT_HUD, Color.WHITE);
        graphicsGame.drawText(CORE_GAME.getString(R.string.txt_hud_passedDistance)+":"+ passedDistance,
                10,30,Color.GREEN,25,null);
        graphicsGame.drawText(CORE_GAME.getString(R.string.txt_hud_currentSpeedPlayer)+":"+ currentSpeedPlayer,
                350,30,Color.GREEN,25,null);
        graphicsGame.drawText(CORE_GAME.getString(R.string.txt_hud_currentShieldsPlayer)+":"+ currentShieldsPlayer,
                650,30,Color.GREEN,25,null);
    }

    public int getHEIGHT_HUD() {
        return HEIGHT_HUD;
    }
}

