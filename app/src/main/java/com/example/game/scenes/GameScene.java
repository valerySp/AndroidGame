package com.example.game.scenes;

import android.graphics.Color;

import com.example.game.R;
import com.example.game.generator.GeneratorBackGround;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class GameScene extends SceneFW {

    GameState gameState;
    GeneratorBackGround gbg;

    //Состояния игры
    enum GameState {
        READY, RUNNING, PAUSE, GAME_OVER
    }


    protected GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState=GameState.READY;
        gbg=new GeneratorBackGround(sceneWidth,sceneHeight);
    }

    @Override
    public void update() {
        if (gameState == GameState.READY) {
            updateStateReady();
        }
        if (gameState == GameState.RUNNING) {
            updateStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            updateStatePause();
        }
        if (gameState == GameState.GAME_OVER) {
            updateStateGameOver();
        }
    }

    @Override
    public void drawing() {
        graphicsFW.clearScene(Color.BLACK);
        
        if (gameState == GameState.READY) {
            drawingStateReady();
        }
        if (gameState == GameState.RUNNING) {
            drawingStateRunning();
        }
        if (gameState == GameState.PAUSE) {
            drawingStatePause();
        }
        if (gameState == GameState.GAME_OVER) {
            drawingStateGameOver();
        }
    }

    private void updateStateGameOver() {

    }
    private void drawingStateGameOver() {

    }

    private void updateStatePause() {

    }
    private void drawingStatePause() {

    }

    private void updateStateRunning() {
        gbg.update();
    }
    private void drawingStateRunning() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText("Scenes playing",
                250,300,Color.WHITE,60,null);
        gbg.drawing(graphicsFW);
    }

    private void updateStateReady() {
        if (coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)) {
            gameState = GameState.RUNNING;
        }
    }
    private void drawingStateReady() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateReady_ready),
                250,300,Color.WHITE,60,null);
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
