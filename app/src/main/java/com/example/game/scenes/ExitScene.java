package com.example.game.scenes;

import android.graphics.Color;

import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class ExitScene extends SceneFW {

    public ExitScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {
        if (coreFW.getTouchListenerFW().getTouchUp(150,250,100,35)){
            coreFW.finish();
        }
        if (coreFW.getTouchListenerFW().getTouchUp(150,300,100,35)){
            coreFW.setScene(new MainMenuScene(coreFW));
        }
    }

    @Override
    public void drawing() {
        coreFW.getGraphicsFW().clearScene(Color.BLACK);
        coreFW.getGraphicsFW().drawText("Точно хотите выйти",150,200,Color.RED,50,null);
        coreFW.getGraphicsFW().drawText("ДА",150,250,Color.RED,35,null);
        coreFW.getGraphicsFW().drawText("НЕТ",150,300,Color.RED,35,null);
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
