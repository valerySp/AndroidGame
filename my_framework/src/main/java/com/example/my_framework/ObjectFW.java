package com.example.my_framework;

import android.graphics.Rect;

public class ObjectFW {
    protected int maxScreenX;
    protected int maxScreenY;
    protected int minScreenX;
    protected int minScreenY;
    protected int x;
    protected int y;
    protected double speed;

    protected Rect hitBox;
    protected double radius;
    //endregion

    //region Get&Set
    public int getMaxScreenX() {
        return maxScreenX;
    }

    public void setMaxScreenX(int maxScreenX) {
        this.maxScreenX = maxScreenX;
    }

    public int getMaxScreenY() {
        return maxScreenY;
    }

    public void setMaxScreenY(int maxScreenY) {
        this.maxScreenY = maxScreenY;
    }

    public int getMinScreenX() {
        return minScreenX;
    }

    public void setMinScreenX(int minScreenX) {
        this.minScreenX = minScreenX;
    }

    public int getMinScreenY() {
        return minScreenY;
    }

    public void setMinScreenY(int minScreenY) {
        this.minScreenY = minScreenY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double pSpeed) {
        this.speed = pSpeed;
    }

    public Rect getHitBox() {
        return hitBox;
    }

    public double getRadius() {
        return radius;
    }
    //endregion

}
