package com.example.game.scenes;

import android.graphics.Color;

import com.example.game.R;
import com.example.game.clases.GameManager;
import com.example.game.utilits.SettingsGame;
import com.example.game.utilits.UtilResource;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class GameScene extends SceneFW {

    GameState gameState;

    GameManager gameManager;

    //Состояния игры
    enum GameState {
        READY, RUNNING, PAUSE, GAME_OVER
    }


    protected GameScene(CoreFW coreFW) {
        super(coreFW);
        gameState=GameState.READY;
        gameManager=new GameManager(coreFW,sceneWidth,sceneHeight);

        if (SettingsGame.musicOn){
            UtilResource.musicGame.play(true,2f);
        }
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
        SettingsGame.addDistance(gameManager.getmPassedDistance());
        if (coreFW.getTouchListenerFW().getTouchUp(250,360,100,35)){
            coreFW.setScene(new GameScene(coreFW));
        }
        if (coreFW.getTouchListenerFW().getTouchUp(250,420,100,35)){
            coreFW.setScene(new MainMenuScene(coreFW));
        }
    }
    private void drawingStateGameOver() {
        graphicsFW.clearScene(Color.BLACK);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_gameOver),
                250,300,Color.WHITE,30,null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_restart),
                250,360,Color.WHITE,30,null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_distance)+" : "+gameManager.getmPassedDistance(),
                250,200,Color.WHITE,30,null);
        graphicsFW.drawText(coreFW.getString(R.string.txt_gameScene_stateGameOver_exit),
                250,420,Color.WHITE,30,null);
    }

    private void updateStatePause() {
        if (coreFW.getTouchListenerFW().getTouchUp(0, sceneHeight, sceneWidth, sceneHeight)) {
            gameState = GameState.RUNNING;
        }
    }
    private void drawingStatePause() {
        coreFW.getGraphicsFW().drawText("ПАУЗА",300,300,Color.GREEN,50,null);
    }

    private void updateStateRunning() {
        gameManager.update();
        if (GameManager.gameOver){
            gameState=GameState.GAME_OVER;
        }
        if (coreFW.isPressedKeyBack()){
            gameState=GameState.PAUSE;
            coreFW.setPressedKeyBack(false);
        }
    }
    private void drawingStateRunning() {
        graphicsFW.clearScene(Color.BLACK);

        gameManager.drawing(coreFW,graphicsFW);
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
        UtilResource.musicGame.stop();
    }

    @Override
    public void resume() {
        if (SettingsGame.musicOn){
            UtilResource.musicGame.play(true,2f);
        }
    }

    @Override
    public void dispose() {

    }
}
