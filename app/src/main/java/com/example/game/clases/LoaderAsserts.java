package com.example.game.clases;


import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;
import com.example.my_framework.utilits.UtilResource;

import java.util.ArrayList;

//Загрузчик картинок
public class LoaderAsserts {
    public LoaderAsserts(CoreFW coreFW, GraphicsFW graphicsFW){
        loadTexture(graphicsFW);
        loadSpritePlayer(graphicsFW);
    }

    private void loadSpritePlayer(GraphicsFW graphicsFW) {
        UtilResource.spritePlayer=new ArrayList<>();
        //добавляем в лист массив человечков из файла texture_atlas.png
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,0,0,64,64));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,64,0,64,64));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,128,0,64,64));
        UtilResource.spritePlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,256,0,64,64));
    }

    private void loadTexture(GraphicsFW graphicsFW){
        UtilResource.textureAtlas=graphicsFW.newTexture("texture_atlas.png");
    }
}
