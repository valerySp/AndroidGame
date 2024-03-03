package com.example.game.clases;


import com.example.game.generator.GeneratorBackGround;
import com.example.game.generator.GeneratorEnemy;
import com.example.game.generator.GeneratorGifts;
import com.example.game.objects.HUD;
import com.example.game.objects.MainPlayer;
import com.example.game.utilits.UtilResource;
import com.example.my_framework.CollisionDetect;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;

//Управляет объектами
public class GameManager {

    public static final int SPEED_ANIM = 3;
    private int mPassedDistance;
    public static boolean gameOver;

    GeneratorBackGround gbg;
    GeneratorEnemy generatorEnemy;
    GeneratorGifts generatorGifts;
    HUD hud;
    MainPlayer mainPlayer;

    public GameManager (CoreFW coreFW,int sceneWidth, int sceneHeight){
        hud=new HUD(coreFW);
        //mMinScreenX=0;
        int mMinScreenY = hud.getHEIGHT_HUD();
        gbg=new GeneratorBackGround(sceneWidth,sceneHeight, mMinScreenY);
        generatorEnemy=new GeneratorEnemy(sceneWidth,sceneHeight, mMinScreenY);
        generatorGifts=new GeneratorGifts(sceneWidth,sceneHeight, mMinScreenY);
        mainPlayer=new MainPlayer(coreFW, sceneWidth, sceneHeight, mMinScreenY);
        gameOver=false;
    }

    public void update(){

        gbg.update(mainPlayer.getSpeedPlayer());
        mainPlayer.update();
        generatorEnemy.update(mainPlayer.getSpeedPlayer());
        generatorGifts.update(mainPlayer.getSpeedPlayer());

        mPassedDistance +=mainPlayer.getSpeedPlayer();
        int mCurrentSpeedPlayer = (int) mainPlayer.getSpeedPlayer() * 60;
        int mCurrentShieldsPlayer = mainPlayer.getShieldsPlayer();

        hud.update(mPassedDistance, mCurrentSpeedPlayer, mCurrentShieldsPlayer);

        checkHit();

    }

    public void checkHit(){
        for (int i = 0; i < generatorEnemy.enemyArrayList.size(); i++) {
            if(CollisionDetect.collisionDetect(mainPlayer,generatorEnemy.enemyArrayList.get(i))){
                UtilResource.soundHit.play(2f);
                mainPlayer.hitEnemy();
                generatorEnemy.hitPlayer(generatorEnemy.enemyArrayList.get(i));
            }
        }
        if (CollisionDetect.collisionDetect(mainPlayer, generatorGifts.getProtector())){
            hitPlayerWithProtector();
        }
    }

    private void hitPlayerWithProtector() {
        mainPlayer.hitProtector();
        generatorGifts.hitProtectorWithPlayer();
    }

    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW){
        mainPlayer.drawing(graphicsFW);
        gbg.drawing(graphicsFW);
        generatorEnemy.drawing(graphicsFW);
        generatorGifts.drawing(graphicsFW);
        hud.drawing(graphicsFW);
    }

    public int getmPassedDistance(){
        return mPassedDistance;
    }
}
