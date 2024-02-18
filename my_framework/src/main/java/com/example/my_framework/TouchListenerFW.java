package com.example.my_framework;

import android.view.MotionEvent;
import android.view.View;

public class TouchListenerFW implements View.OnTouchListener  {

    private float touchX;
    private float touchY;

    private boolean isTouchDown;
    private boolean isTouchUp;

    private float sceneWidth;
    private float sceneHeight;

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        synchronized (this) {
            isTouchDown = false;
            isTouchUp = false;
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touchX = event.getX() * sceneWidth;
                    touchY = event.getY() * sceneHeight;
                    isTouchDown = true;
                    isTouchUp = false;
                    break;
                case MotionEvent.ACTION_UP:
                    touchX = event.getX() * sceneWidth;
                    touchY = event.getY() * sceneHeight;
                    isTouchDown = false;
                    isTouchUp = true;
                    break;
            }
        }
        return true;
    }

    public boolean getTouchUp(int x, int y, int touchWidth, int touchHeight) {
        if (isTouchUp) {
            //Проверка области нажатия
            if (touchX >= x && touchX <= x + touchWidth - 1 && touchY <= y && touchY >= y - (touchHeight - 1)) {
                isTouchUp = false;
                return true;
            }
        }
        return false;
    }

    public boolean getTouchDown(int x, int y, int touchWidth, int touchHeight) {
        if (isTouchDown) {
            //Проверка области нажатия
            if (touchX >= x && touchX <= x + touchWidth - 1 && touchY <= y && touchY >= y - (touchHeight - 1)) {
                isTouchDown = false;
                return true;
            }
        }
        return false;
    }

    public TouchListenerFW(View view,float sceneWidth, float sceneHeight) {
        view.setOnTouchListener(this);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }
}
