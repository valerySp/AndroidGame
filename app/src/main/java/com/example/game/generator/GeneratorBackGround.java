package com.example.game.generator;

import android.graphics.Color;

import com.example.game.objects.Star;
import com.example.my_framework.GraphicsFW;

import java.util.ArrayList;

public class GeneratorBackGround {

    public ArrayList<Star> starArrayList=new ArrayList<Star>();

    public GeneratorBackGround(int sceneWidth,int sceneHeight){
        int starsSpeak = 50;//Максимальное количество звезд
        for (int i = 0; i < starsSpeak; i++) {
            //Цикл создает звезды и помещет их в массив
            Star star = new Star(sceneWidth, sceneHeight);
            starArrayList.add(star);
        }
    }

    public void update(double speedPlayer) {
        for (int i = 0; i < starArrayList.size(); i++) {
            //Производим обновление каждой звезды в массиве
            starArrayList.get(i).update(speedPlayer);
        }
    }

    public void drawing(GraphicsFW graphicsGame) {
        for (int i = 0; i < starArrayList.size(); i++) {
            //Прорисовка каждой звезды в массиве
            graphicsGame.drawPixel(starArrayList.get(i).getX(),
                    starArrayList.get(i).getY(), Color.WHITE);
        }
    }
}
