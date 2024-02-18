package com.example.game.scenes;

import android.graphics.Color;

import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class GameScene extends SceneFW {
    protected GameScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {

    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText("ИГРОВАЯ СЦЕНА",100,150,Color.GREEN,60,null );
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
