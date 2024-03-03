package com.example.game.scenes;

import android.graphics.Color;

import com.example.game.R;
import com.example.game.interfaces.TaskComplete;
import com.example.game.tasks.LoaderTask;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class LoaderResourceScene extends SceneFW implements TaskComplete {

    private static int progressLoader;

    public LoaderResourceScene(CoreFW coreFW) {
        super(coreFW);
        progressLoader=0;
        LoaderTask loaderTask=new LoaderTask(coreFW,this);
        loaderTask.execute();
    }

    public static void setProgressLoader(int progressLoader) {
        LoaderResourceScene.progressLoader = progressLoader;
    }

    @Override
    public void update() {

    }

    @Override
    public void drawing() {
        coreFW.getGraphicsFW().clearScene(Color.BLACK);
        coreFW.getGraphicsFW().drawText(coreFW.getString(R.string.loading),100,100,Color.GREEN,50,null);
        coreFW.getGraphicsFW().drawLine(0,500,progressLoader,500,Color.GREEN);
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

    @Override
    public void onComplete() {
        coreFW.setScene(new MainMenuScene(coreFW));
    }
}
