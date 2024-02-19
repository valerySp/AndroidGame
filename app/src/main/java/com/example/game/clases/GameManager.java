package com.example.game.clases;


import com.example.game.objects.MainPlayer;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;

//Управляет объектами
public class GameManager {

    private int maxScreenX;
    private int maxScreenY;
    private int minScreenX;
    private int minScreenY;

    MainPlayer mainPlayer;

    public GameManager (CoreFW coreFW,int sceneWidth, int sceneHeight){
        this.maxScreenX=sceneWidth;
        this.maxScreenY=sceneHeight;
        minScreenX=0;
        minScreenY=0;
        mainPlayer=new MainPlayer(maxScreenX,maxScreenY,minScreenY);
    }

    public void update(){
        mainPlayer.update();
    }

    public void drawing(CoreFW coreFW, GraphicsFW graphicsFW){
        mainPlayer.drawing(graphicsFW);
    }
}
