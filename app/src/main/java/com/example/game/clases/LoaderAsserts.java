package com.example.game.clases;


import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.game.utilits.UtilResource;

import java.util.ArrayList;

//Загрузчик картинок
public class LoaderAsserts {
    public LoaderAsserts(CoreFW coreFW, GraphicsFW graphicsFW){
        loadTexture(graphicsFW);
        loadSpritePlayer(graphicsFW);
        loadSpriteEnemy(graphicsFW);
    }

    private void loadSpriteEnemy(GraphicsFW graphicsFW) {
        UtilResource.spriteEnemy=new ArrayList<>();
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas,256,0,64,64));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas,320,0,64,64));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas,384,0,64,64));
        UtilResource.spriteEnemy.add(graphicsFW.newSprite(UtilResource.textureAtlas,448,0,64,64));
    }

    private void loadSpritePlayer(GraphicsFW graphicsFW) {
        UtilResource.spritePlayer=new ArrayList<>();
        UtilResource.spritePlayerBoost=new ArrayList<>();


        //добавляем в лист массив человечков из файла texture_atlas.png
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,0,0,64,64));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,64,0,64,64));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,128,0,64,64));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,192,0,64,64));

        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,0,64,64,64));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,64,64,64,64));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,128,64,64,64));
        UtilResource.spritePlayerBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,192,64,64,64));
    }

    private void loadTexture(GraphicsFW graphicsFW){
        UtilResource.textureAtlas=graphicsFW.newTexture("texture_atlas.png");
    }
}
