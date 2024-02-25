package com.example.game.objects;


import android.graphics.Rect;

import com.example.game.clases.GameManager;
import com.example.game.utilits.UtilResource;
import com.example.my_framework.AnimationFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.ObjectFW;
import com.example.my_framework.utilits.UtilRandomFW;
import com.example.my_framework.utilits.UtilTimerDelay;

public class Protector extends ObjectFW {
    private AnimationFW animProtector;

    //endregion

    //region Main methods
    public Protector(int maxScreenX, int maxScreenY, int minScreenY) {
        init(maxScreenX, maxScreenY, minScreenY);
    }

    public void update(double speedPlayer) {
        x -= speed;
        x -= speedPlayer;

        if (x < minScreenX) {
            y = UtilRandomFW.getGap(minScreenY, maxScreenY);
        }
        animProtector.runAnimation();

        hitBox = new Rect(x, y,
                UtilResource.spriteEnemy.get(0).getWidth(),
                UtilResource.spriteEnemy.get(0).getHeight());
    }

    public void drawing(GraphicsFW graphicsGame) {
        animProtector.drawingAnimation(graphicsGame, x, x);
    }
    //endregion

    //region Methods
    private void init(int maxScreenX, int maxScreenY, int minScreenY) {
        this.maxScreenX = maxScreenX;
        this.maxScreenY = maxScreenY - UtilResource.spriteProtector.get(0).getHeight();
        this.minScreenY = minScreenY;
        this.minScreenX = 0;
        x = maxScreenX;
        y = UtilRandomFW.getGap(minScreenY, maxScreenY);

        radius = UtilResource.spriteProtector.get(0).getWidth() / 4;
        hitBox = new Rect(x, y,
                UtilResource.spriteProtector.get(0).getWidth(),
                UtilResource.spriteProtector.get(0).getHeight());
        animProtector = new AnimationFW(GameManager.SPEED_ANIM,
                UtilResource.spriteProtector.get(0),
                UtilResource.spriteProtector.get(1),
                UtilResource.spriteProtector.get(2),
                UtilResource.spriteProtector.get(3));
    }
}
