package com.example.game.objects;

import com.example.my_framework.AnimationFW;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectFW;
import com.example.game.utilits.UtilResource;

public class MainPlayer extends ObjectFW {

    private final int GRAVITY_PLAYER = -3;
    private final int MAX_SPEED = 15;
    private final int MIN_SPEED = 1;

    private AnimationFW animMainPlayer;
    private AnimationFW animMainPlayerBoost;
    boolean boosting;
    CoreFW coreFW;

    public MainPlayer(CoreFW coreFW,int maxScreenX, int maxScreenY,int minScreenY) {
        x=20;
        y=200;
        speed=1;
        boosting=false;
        this.coreFW=coreFW;
        this.maxScreenX=maxScreenX;
        this.maxScreenY=maxScreenY- UtilResource.spritePlayer.get(0).getHeight();
        animMainPlayer=new AnimationFW(speed,UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1),
                UtilResource.spritePlayer.get(2),
                UtilResource.spritePlayer.get(3));
        animMainPlayerBoost=new AnimationFW(speed,UtilResource.spritePlayerBoost.get(0),
                UtilResource.spritePlayerBoost.get(1),
                UtilResource.spritePlayerBoost.get(2),
                UtilResource.spritePlayerBoost.get(3));
    }

    public void update(){
        if (coreFW.getTouchListenerFW().getTouchDown(0,maxScreenY,maxScreenX,maxScreenY)){
            startBoosting();
        }
        if (coreFW.getTouchListenerFW().getTouchUp(0, maxScreenY, maxScreenX, maxScreenY)) {
            stopBoosting();
        }
        if (boosting) {
            speed += 0.1;
        } else speed -= 3;

        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }
        if (speed < MIN_SPEED) {
            speed = MIN_SPEED;
        }

        y-=speed+GRAVITY_PLAYER;
        if(y<minScreenY){
            y=minScreenY;
        }
        if (y>maxScreenY){
            y=maxScreenY;
        }
        if (boosting)
        animMainPlayerBoost.runAnimation();
        else animMainPlayer.runAnimation();
    }

    public void drawing(GraphicsFW graphicsFW){
        if (boosting)
        animMainPlayerBoost.drawingAnimation(graphicsFW,x,y);
        else animMainPlayer.drawingAnimation(graphicsFW,x,y);
    }

    private void stopBoosting() {
        boosting = false;
    }

    private void startBoosting() {
        boosting = true;
    }
    public double getSpeedPlayer() {
        return speed;
    }


}
