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
        loadOther(graphicsFW);
        loadAudio(coreFW);
        loadSpritePlayerShieldsOn(graphicsFW);
        loadGifts(graphicsFW);
    }

    private void loadGifts(GraphicsFW graphicsFW) {
        UtilResource.spriteProtector=new ArrayList<>();

        UtilResource.spriteProtector.add(graphicsFW.newSprite(UtilResource.textureAtlas,256,192,32,32));
        UtilResource.spriteProtector.add(graphicsFW.newSprite(UtilResource.textureAtlas,288,192,32,32));
        UtilResource.spriteProtector.add(graphicsFW.newSprite(UtilResource.textureAtlas,320,192,32,32));
        UtilResource.spriteProtector.add(graphicsFW.newSprite(UtilResource.textureAtlas,352,192,32,32));

    }

    private void loadSpritePlayerShieldsOn(GraphicsFW graphicsFW) {
        UtilResource.spritePlayerShieldsOn=new ArrayList<>();
        UtilResource.spritePlayerShieldsOnBoost=new ArrayList<>();


        UtilResource.spritePlayerShieldsOn.add(graphicsFW.newSprite(UtilResource.textureAtlas,0,128,64,64));
        UtilResource.spritePlayerShieldsOn.add(graphicsFW.newSprite(UtilResource.textureAtlas,64,128,64,64));
        UtilResource.spritePlayerShieldsOn.add(graphicsFW.newSprite(UtilResource.textureAtlas,128,128,64,64));
        UtilResource.spritePlayerShieldsOn.add(graphicsFW.newSprite(UtilResource.textureAtlas,192,128,64,64));

        UtilResource.spritePlayerShieldsOnBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,0,192,64,64));
        UtilResource.spritePlayerShieldsOnBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,64,192,64,64));
        UtilResource.spritePlayerShieldsOnBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,128,192,64,64));
        UtilResource.spritePlayerShieldsOnBoost.add(graphicsFW.newSprite(UtilResource.textureAtlas,192,192,64,64));

    }

    private void loadAudio(CoreFW coreFW) {
        UtilResource.musicGame=coreFW.getAudioFW().newMusic("music.ogg");
        UtilResource.soundHit=coreFW.getAudioFW().newSound("hit.ogg");
        UtilResource.soundExplode=coreFW.getAudioFW().newSound("explode.ogg");
        UtilResource.soundTouch=coreFW.getAudioFW().newSound("touch.ogg");

    }

    private void loadOther(GraphicsFW graphicsFW) {
        UtilResource.shieldHitEnemy=graphicsFW.newSprite(UtilResource.textureAtlas,0,128,64,64);
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
        UtilResource.spriteExplosionPlayer=new ArrayList<>();

        UtilResource.spriteExplosionPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,256,256,64,64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,320,256,64,64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,384,256,64,64));
        UtilResource.spriteExplosionPlayer.add(graphicsFW.newSprite(UtilResource.textureAtlas,448,256,64,64));


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
