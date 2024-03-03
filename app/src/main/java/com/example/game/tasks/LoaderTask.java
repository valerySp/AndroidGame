package com.example.game.tasks;

import android.os.AsyncTask;

import com.example.game.interfaces.TaskComplete;
import com.example.game.scenes.LoaderResourceScene;
import com.example.game.utilits.SettingsGame;
import com.example.game.utilits.UtilResource;
import com.example.my_framework.CoreFW;
import com.example.my_framework.GraphicsFW;

import java.util.ArrayList;

public class LoaderTask extends AsyncTask<Void,Integer,Void> {

    private CoreFW mCoreFw;
    private TaskComplete mTaskComplete;

    public LoaderTask(CoreFW coreFW, TaskComplete taskComplete){
        mCoreFw=coreFW;
        mTaskComplete=taskComplete;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        loaderAsserts();
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        LoaderResourceScene.setProgressLoader(values[0]);
    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        mTaskComplete.onComplete();
    }

    private void loaderAsserts(){
        loadTexture(mCoreFw.getGraphicsFW());
        publishProgress(100);
        loadSpritePlayer(mCoreFw.getGraphicsFW());
        publishProgress(300);
        loadSpriteEnemy(mCoreFw.getGraphicsFW());
        publishProgress(500);
        loadOther(mCoreFw.getGraphicsFW());
        publishProgress(600);
        loadAudio(mCoreFw);
        loadSpritePlayerShieldsOn(mCoreFw.getGraphicsFW());
        publishProgress(800);
        loadGifts(mCoreFw.getGraphicsFW());
        publishProgress(800);
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
        SettingsGame.loadSettings(mCoreFw);
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
