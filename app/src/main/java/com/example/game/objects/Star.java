package com.example.game.objects;

import com.example.my_framework.ObjectFW;
import com.example.my_framework.utilits.UtilRandomFW;

public class Star extends ObjectFW {

    public Star(int sceneWidth,int sceneHeight) {
        this.maxScreenX=sceneWidth;
        this.maxScreenY=sceneHeight;
        this.minScreenX=0;
        this.minScreenY=0;
        this.speed =2;
        this.x = UtilRandomFW.getCasualNumber(maxScreenX);
        this.y = UtilRandomFW.getCasualNumber(maxScreenY);
    }

    public void update(){
        x-=speed;
        if(x<0){
            x=maxScreenX;
            y = UtilRandomFW.getCasualNumber(maxScreenY);
        }
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
