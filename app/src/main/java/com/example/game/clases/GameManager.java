package com.example.game.clases;


import com.example.game.generator.GeneratorBackGround;
import com.example.game.generator.GeneratorEnemy;
import com.example.game.objects.HUD;
import com.example.game.objects.MainPlayer;
import com.example.my_framework.CollisionDetect;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;

//Управляет объектами
public class GameManager {

    private int maxScreenX;
    private int maxScreenY;
    private int minScreenX;
    private int minScreenY;
    private int passedDistance;
    private int currentSpeedPlayer;
    private int currentShieldsPlayer;
    public static boolean gameOver;

    GeneratorBackGround gbg;
    GeneratorEnemy generatorEnemy;
    HUD hud;
    MainPlayer mainPlayer;

    public GameManager (CoreFW coreFW,int sceneWidth, int sceneHeight){
        hud=new HUD(coreFW);
        this.maxScreenX=sceneWidth;
        this.maxScreenY=sceneHeight;
        minScreenX=0;
        minScreenY=hud.getHEIGHT_HUD();
        gbg=new GeneratorBackGround(sceneWidth,sceneHeight,minScreenY);
        generatorEnemy=new GeneratorEnemy(sceneWidth,sceneHeight,minScreenY);
        mainPlayer=new MainPlayer(coreFW,maxScreenX,maxScreenY,minScreenY);
        gameOver=false;
    }

    public void update(){
        gbg.update(mainPlayer.getSpeedPlayer());
        mainPlayer.update();
        generatorEnemy.update(mainPlayer.getSpeedPlayer());
        passedDistance+=mainPlayer.getSpeedPlayer();
        currentSpeedPlayer= (int) mainPlayer.getSpeedPlayer()*60;
        currentShieldsPlayer=mainPlayer.getShieldsPlayer();

        hud.update(passedDistance,currentSpeedPlayer,currentShieldsPlayer);
        checkHit();

    }

    public void checkHit(){
        for (int i = 0; i < generatorEnemy.enemyArrayList.size(); i++) {
            if(CollisionDetect.collisionDetect(mainPlayer,generatorEnemy.enemyArrayList.get(i))){
                mainPlayer.hitEnemy();
                generatorEnemy.hitPlayer(generatorEnemy.enemyArrayList.get(i));
            }
        }
    }

    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW){
        mainPlayer.drawing(graphicsFW);
        gbg.drawing(graphicsFW);
        generatorEnemy.drawing(graphicsFW);
        hud.drawing(graphicsFW);
    }

    public int getPassedDistance(){
        return passedDistance;
    }
}
