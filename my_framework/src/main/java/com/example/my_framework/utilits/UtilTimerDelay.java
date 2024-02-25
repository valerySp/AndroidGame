package com.example.my_framework.utilits;

public class UtilTimerDelay {

    private double startTime;
    private double nowTime;
    private double elapsedTime;
    private final double SECOND = 1000000000;

    public void startTimer() {
        startTime = System.nanoTime() / SECOND;
    }

    public boolean timerDelay(double second) {
        nowTime = System.nanoTime() / SECOND;
        elapsedTime = nowTime - startTime;
        return elapsedTime > second;
    }
}
