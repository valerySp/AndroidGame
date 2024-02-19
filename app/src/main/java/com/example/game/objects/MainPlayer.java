package com.example.game.objects;

import com.example.game.clases.AnimationGame;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectFW;
import com.example.my_framework.utilits.UtilResource;

public class MainPlayer extends ObjectFW {

    private final int GRAVITY_PLAYER = -3;
    private final int MAX_SPEED = 15;
    private final int MIN_SPEED = 1;

    private AnimationGame animMainPlayer;

    public MainPlayer(int maxScreenX, int maxScreenY,int minScreenY) {
        x=20;
        y=200;
        speed=1;
        this.maxScreenX=maxScreenX;
        this.maxScreenY=maxScreenY- UtilResource.spritePlayer.get(0).getHeight();
        animMainPlayer=new AnimationGame(speed,UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1),
                UtilResource.spritePlayer.get(2),
                UtilResource.spritePlayer.get(3));
    }

    public void update(){
        y-=speed+GRAVITY_PLAYER;
        if(y<minScreenY){
            y=minScreenY;
        }
        if (y>maxScreenY){
            y=maxScreenY;
        }
    }

    public void drawing(GraphicsFW graphicsFW){
        animMainPlayer.drawingAnimation(graphicsFW,x,y);
    }
}
