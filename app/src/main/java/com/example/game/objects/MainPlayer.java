package com.example.game.objects;

import android.graphics.Rect;

import com.example.game.clases.GameManager;
import com.example.my_framework.AnimationFW;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectFW;
import com.example.game.utilits.UtilResource;
import com.example.my_framework.utilits.UtilTimerDelay;

public class MainPlayer extends ObjectFW {

    private final int GRAVITY_PLAYER = -3;

    private final int MAX_SPEED = 15;
    private final int MIN_SPEED = 1;
    private AnimationFW animMainPlayer;
    private AnimationFW animMainPlayerBoost;
    private AnimationFW animExplosionPlayer;
    private AnimationFW animPlayerShieldsOn;
    private AnimationFW animPlayerShieldsBoost;
    boolean boosting;
    CoreFW coreFW;
    private int shieldsPlayer;
    boolean hitEnemy;
    boolean isGameOver;
    static boolean shieldsOn;
    UtilTimerDelay timerOnShieldHit,timerOnGameOver,timerShieldsOn;

    public MainPlayer(CoreFW coreFW,int maxScreenX, int maxScreenY,int minScreenY) {
        x=20;
        y=200;
        speed=GameManager.SPEED_ANIM;
        shieldsPlayer=3;

        boosting=false;
        hitEnemy=false;
        isGameOver=false;
        shieldsOn=false;

        timerOnShieldHit =new UtilTimerDelay();
        timerOnGameOver=new UtilTimerDelay();
        timerShieldsOn=new UtilTimerDelay();

        radius =UtilResource.spritePlayer.get(0).getWidth()/4;

        this.coreFW=coreFW;
        this.maxScreenX=maxScreenX;
        this.maxScreenY=maxScreenY- UtilResource.spritePlayer.get(0).getHeight();
        this.minScreenY=minScreenY;
        initAnimation();

    }

    private void initAnimation() {
        animMainPlayer=new AnimationFW(speed,UtilResource.spritePlayer.get(0),
                UtilResource.spritePlayer.get(1),
                UtilResource.spritePlayer.get(2),
                UtilResource.spritePlayer.get(3));
        animMainPlayerBoost=new AnimationFW(speed,UtilResource.spritePlayerBoost.get(0),
                UtilResource.spritePlayerBoost.get(1),
                UtilResource.spritePlayerBoost.get(2),
                UtilResource.spritePlayerBoost.get(3));
        animExplosionPlayer =new AnimationFW(speed,UtilResource.spriteExplosionPlayer.get(0),
                UtilResource.spriteExplosionPlayer.get(1),
                UtilResource.spriteExplosionPlayer.get(2),
                UtilResource.spriteExplosionPlayer.get(3));
        animPlayerShieldsOn=new AnimationFW(speed,UtilResource.spritePlayerShieldsOn.get(0),
                UtilResource.spritePlayerShieldsOn.get(1),
                UtilResource.spritePlayerShieldsOn.get(2),
                UtilResource.spritePlayerShieldsOn.get(3));
        animPlayerShieldsBoost =new AnimationFW(speed,UtilResource.spritePlayerShieldsOnBoost.get(0),
                UtilResource.spritePlayerShieldsOnBoost.get(1),
                UtilResource.spritePlayerShieldsOnBoost.get(2),
                UtilResource.spritePlayerShieldsOnBoost.get(3));

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

        if (timerShieldsOn.timerDelay(5)){
            shieldsOn=false;
        }

        if (boosting){
            if(shieldsOn){
                animPlayerShieldsBoost.runAnimation();
            } else if (shieldsOn){
                animPlayerShieldsOn.runAnimation();
            } else
            animMainPlayerBoost.runAnimation();
        }
        else animMainPlayer.runAnimation();

        hitBox=new Rect(x,y,UtilResource.spritePlayer.get(0).getWidth(),UtilResource.spritePlayer.get(0).getHeight());
        if (isGameOver){
            animExplosionPlayer.runAnimation();
        }
    }

    public void drawing(GraphicsFW graphicsFW){
        if(!isGameOver){
            if(!hitEnemy){
                if (boosting){
                    if (shieldsOn){
                        animPlayerShieldsBoost.drawingAnimation(graphicsFW,x,y);
                    } else
                        animMainPlayerBoost.drawingAnimation(graphicsFW,x,y);
                }
                else if (shieldsOn){
                    animPlayerShieldsOn.drawingAnimation(graphicsFW,x,y);
                } else
                    animMainPlayer.drawingAnimation(graphicsFW,x,y);
            } else {
                graphicsFW.drawTexture(UtilResource.shieldHitEnemy,x,y);
                if(timerOnShieldHit.timerDelay(0.2)){
                    hitEnemy=false;
                } else
                    hitEnemy=true;
            }
        } else {
            animExplosionPlayer.drawingAnimation(graphicsFW,x,y);
            if(timerOnGameOver.timerDelay(0.5)){
                GameManager.gameOver=true;
            }
        }

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

    public int getShieldsPlayer(){
        return shieldsPlayer;
    }

    public void hitEnemy() {
        if (!shieldsOn){
            shieldsPlayer--;
            if (shieldsPlayer<0){
                UtilResource.soundExplode.play(2f);
                isGameOver=true;
                timerOnGameOver.startTimer();
            }
        }
        hitEnemy=true;
        timerOnShieldHit.startTimer();
    }

    public static boolean isShieldsOn() {
        return shieldsOn;
    }

    public void hitProtector() {
        shieldsOn=true;
        timerShieldsOn.startTimer();
    }
}
