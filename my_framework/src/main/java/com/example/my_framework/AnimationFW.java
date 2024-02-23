package com.example.my_framework;

import android.graphics.Bitmap;

public class AnimationFW {

    double speedAnimation;
    int delayIndex;
    int countFrames;
    int frames;

    Bitmap sprite;
    Bitmap sprite1;
    Bitmap sprite2;
    Bitmap sprite3;
    Bitmap sprite4;

    public AnimationFW(double speedAnimation, Bitmap sprite1,
                       Bitmap sprite2, Bitmap sprite3,
                       Bitmap sprite4) {
        sprite=sprite1;
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        this.sprite3 = sprite3;
        this.sprite4 = sprite4;
        this.speedAnimation=speedAnimation;
        frames=4;
    }

    //Запускаем анимацию
    public void runAnimation(){
        delayIndex++;
        if (delayIndex>speedAnimation){
            delayIndex=0;
            nextFrame();
        }
    }

    private void nextFrame() {
        if (countFrames==0){
            sprite=sprite1;
        }
        if (countFrames==1){
            sprite=sprite2;
        }
        if (countFrames==2){
            sprite=sprite3;
        }
        if (countFrames==3){
        }
        countFrames++;
        if (countFrames>frames){
            countFrames=0;
        }
    }

    public void drawingAnimation(GraphicsFW graphicsFW,int x,int y){
        graphicsFW.drawTexture(sprite,x,y);
    }
}
