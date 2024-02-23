package com.example.game.generator;

import com.example.game.objects.Enemy;
import com.example.my_framework.GraphicsFW;

import java.util.ArrayList;

public class GeneratorEnemy {
    private int maxScreenX;
    private int maxScreenY;
    private int minScreenX;
    private int minScreenY;
    ArrayList<Enemy> enemyArrayList;

    public GeneratorEnemy(int sceneWidth, int sceneHeight,int minScreenY) {
        this.maxScreenX=sceneWidth;
        this.maxScreenY=sceneHeight;
        this.minScreenX=minScreenY;
        this.minScreenY=0;
        enemyArrayList=new ArrayList<>();
    }
    
    public void update(double speedPlayer){
        if (enemyArrayList.size()<3){
            addEnemy(speedPlayer,3);
        }
        for (int i = 0; i <enemyArrayList.size() ; i++) {
            enemyArrayList.get(i).update(speedPlayer);
        }

    }

    private void addEnemy(double speedPlayer,int amountEnemy) {
        for (int i = 0; i < amountEnemy; i++) {
            enemyArrayList.add(new Enemy(maxScreenX,maxScreenY,minScreenY,1));
        }
    }

    public void drawing(GraphicsFW graphicsFW){
        for (int i = 0; i < enemyArrayList.size(); i++) {
            enemyArrayList.get(i).drawing(graphicsFW);
        }
    }

}
