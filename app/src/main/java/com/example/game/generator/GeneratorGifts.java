package com.example.game.generator;

import com.example.game.objects.MainPlayer;
import com.example.game.objects.Protector;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.utilits.UtilTimerDelay;

public class GeneratorGifts {
    private Protector protector;
    private UtilTimerDelay timerProtector;
    private int mMaxScreenY;
    private int mMaxScreenX;
    private int mMinScreenY;
    private int mMinScreenX;
    //endregion

    //region Main methods
    public GeneratorGifts(int sceneWidth, int sceneHeight, int minScreenY) {
        init(sceneWidth, sceneHeight, minScreenY);
    }

    private void init(int sceneWidth, int sceneHeight, int minScreenY) {
        this.mMaxScreenX = sceneWidth;
        this.mMaxScreenY = sceneHeight;
        this.mMinScreenY = minScreenY;
        this.mMinScreenX = 0;
        protector = new Protector(mMaxScreenX, mMaxScreenY, minScreenY);
        timerProtector = new UtilTimerDelay();
        timerProtector.startTimer();
    }

    public void update(double speedPlayer) {
        if (timerProtector.timerDelay(8) && (!MainPlayer.isShieldsOn())) {
            protector.update(speedPlayer);
            if (protector.getX() < mMinScreenX) {
                protector = null;
                protector = new Protector(mMaxScreenX, mMaxScreenY, mMinScreenY);
                timerProtector.startTimer();
            }
        }
    }

    public void drawing(GraphicsFW graphicsGame) {
        protector.drawing(graphicsGame);
    }
    //endregion

    //region Methods
    public void hitProtectorWithPlayer() {
        protector = null;
        protector = new Protector(mMaxScreenX, mMaxScreenY, mMinScreenY);
        timerProtector.startTimer();
    }
    //endregion

    //region Get&Set
    public Protector getProtector() {
        return protector;
    }
}
