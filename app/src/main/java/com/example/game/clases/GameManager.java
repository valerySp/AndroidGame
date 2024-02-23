package com.example.game.clases;


import com.example.game.generator.GeneratorBackGround;
import com.example.game.generator.GeneratorEnemy;
import com.example.game.objects.MainPlayer;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;

//Управляет объектами
public class GameManager {

    private int maxScreenX;
    private int maxScreenY;
    private int minScreenX;
    private int minScreenY;
    GeneratorBackGround gbg;
    GeneratorEnemy generatorEnemy;

    MainPlayer mainPlayer;

    public GameManager (CoreFW coreFW,int sceneWidth, int sceneHeight){
        this.maxScreenX=sceneWidth;
        this.maxScreenY=sceneHeight;
        minScreenX=0;
        minScreenY=0;
        gbg=new GeneratorBackGround(sceneWidth,sceneHeight);
        generatorEnemy=new GeneratorEnemy(sceneWidth,sceneHeight,minScreenY);
        mainPlayer=new MainPlayer(coreFW,maxScreenX,maxScreenY,minScreenY);
    }

    public void update(){
        gbg.update(mainPlayer.getSpeedPlayer());
        mainPlayer.update();
        generatorEnemy.update(mainPlayer.getSpeedPlayer());
    }

    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW){
        mainPlayer.drawing(graphicsFW);
        gbg.drawing(graphicsFW);
        generatorEnemy.drawing(graphicsFW);
    }
}
