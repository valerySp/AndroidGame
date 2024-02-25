package com.example.game.scenes;

import android.graphics.Color;

import com.example.game.Main;
import com.example.game.R;
import com.example.game.utilits.UtilResource;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class MainMenuScene extends SceneFW {

    public MainMenuScene(CoreFW coreFW) {
        super(coreFW);
    }

    @Override
    public void update() {
        if (coreFW.getTouchListenerFW().getTouchUp(20,300,100,50)){
            coreFW.setScene(new GameScene(coreFW));
            UtilResource.soundTouch.play(2f);
        }
        if (coreFW.getTouchListenerFW().getTouchUp(20,400,100,50)){
            coreFW.setScene(new TopDistance(coreFW));
            UtilResource.soundTouch.play(2f);
        }
    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_nameGame)
                , 100, 100,Color.BLUE, 60,null );
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_newGame), 20, 300,Color.BLUE, 40,null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_settings), 20, 350,Color.BLUE, 40,null );
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_results), 20, 400,Color.BLUE, 40,null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_mainMenu_exitGame), 20, 450,Color.BLUE, 40,null );
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
