package com.example.game.objects;

import android.graphics.Rect;

import com.example.game.utilits.UtilResource;
import com.example.my_framework.AnimationFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectFW;
import com.example.my_framework.utilits.UtilRandomFW;

public class Enemy extends ObjectFW {

    private AnimationFW animEnemy;
    //endregion

    //region Main methods
    public Enemy(int maxScreenX, int maxScreenY, int minScreenY, int enemyType) {
        //init(maxScreenX, maxScreenY, minScreenY);
        //initTypeEnemy(enemyType);
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spriteEnemy.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;
        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        radius=UtilResource.spritePlayer.get(0).getWidth()/4;
        switch (enemyType){
            case 1:
                speed=UtilRandomFW.getGap(1,6);
                animEnemy=new AnimationFW(3,UtilResource.spriteEnemy.get(0),
                        UtilResource.spriteEnemy.get(1),
                        UtilResource.spriteEnemy.get(2),
                        UtilResource.spriteEnemy.get(3));
                break;
            case 2:
                speed=UtilRandomFW.getGap(5,11);
                break;
        }
    }

    private void init(int maxScreenX, int maxScreenY, int minScreenY) {

       // pRadius = ResourceGame.sSpriteEnemy.get(0).getWidth() / 4;
    }

    public void update(double speedPlayer) {
        x -= speed;
        x -= speedPlayer;
        if (x < minScreenX) {
            x = maxScreenX;
            y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        }
        animEnemy.runAnimation();

        hitBox=new Rect(x,y,UtilResource.spritePlayer.get(0).getWidth(),
                UtilResource.spritePlayer.get(0).getHeight());
    }

    public void drawing(GraphicsFW graphicsGame) {
        animEnemy.drawingAnimation(graphicsGame, x, y);
    }
    //endregion

    /*//region Methods
    private void initTypeEnemy(int enemyType) {
        switch (enemyType) {
            case 1:
                pSpeed = UtilRandomGame.getGap(1, 6);
                mAnimEnemy = new AnimationGame(3,
                        ResourceGame.sSpriteEnemy.get(0),
                        ResourceGame.sSpriteEnemy.get(1),
                        ResourceGame.sSpriteEnemy.get(2),
                        ResourceGame.sSpriteEnemy.get(3));
                break;
            case 2:
                pSpeed = UtilRandomGame.getGap(4, 9);
                break;
        }
    }*/
    //endregion
}
