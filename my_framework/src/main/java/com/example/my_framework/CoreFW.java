package com.example.my_framework;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CoreFW extends AppCompatActivity {

    private final float FRAME_BUFFER_WIDTH = 800;
    private final float FRAME_BUFFER_HEIGHT = 600;

    private AudioFW audioFW;
    private LoopFW loopFW;
    private GraphicsFW graphicsFW;
    private Display display;
    private Point sizeDisplay;
    private Bitmap frameBuffer;
    private SceneFW sceneFW;
    private float sceneWidth;
    private float sceneHeight;
    private boolean stateOnPause;
    private boolean stateOnResume;
    private TouchListenerFW touchListenerFW;
    private SharedPreferences sharedPreferences;
    private final String SETTINGS= "settings";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        init();

        setContentView(loopFW);
    }

    public CoreFW() {

    }

    public void init(){
        sizeDisplay=new Point();
        display=getWindowManager().getDefaultDisplay();
        display.getSize(sizeDisplay);
        frameBuffer=Bitmap.createBitmap((int) FRAME_BUFFER_WIDTH, (int) FRAME_BUFFER_HEIGHT,
                Bitmap.Config.ARGB_8888);
        sceneWidth = FRAME_BUFFER_WIDTH / sizeDisplay.x;
        sceneHeight = FRAME_BUFFER_HEIGHT / sizeDisplay.y;

        loopFW = new LoopFW(this, frameBuffer);
        graphicsFW = new GraphicsFW(getAssets(), frameBuffer);
        audioFW=new AudioFW(this);


        stateOnPause=false;
        stateOnResume=false;

        touchListenerFW=new TouchListenerFW(loopFW,sceneWidth,sceneHeight);
        sceneFW=getStartScene();
        sharedPreferences=getSharedPreferences(SETTINGS,MODE_PRIVATE);


        /*audioGame = new AudioGame(this);
        mTouchListenerGame = new TouchListenerGame(mLoopGame, mSceneWidth, mSceneHeight);
        mSceneGame = getStartScene();
        mIsPressedKeyBack = false;*/

    }
    public void onResume() {
        super.onResume();
        sceneFW.resume();
        loopFW.startGame();
    }

    public void onPause() {
        super.onPause();
        sceneFW.pause();
        loopFW.stopGame();
        stateOnPause=true;
        if (isFinishing()) {
            sceneFW.dispose();
        }
    }

    public AudioFW getAudioFW() {
        return audioFW;
    }

    public GraphicsFW getGraphicsFW() {
        return graphicsFW;
    }

    public TouchListenerFW getTouchListenerFW(){
        return touchListenerFW;
    }

    public void setScene(SceneFW sceneGame) {
        if (sceneGame == null) {
            throw new IllegalArgumentException("Невозможно загрузить сцену");
        }
        this.sceneFW.pause();
        this.sceneFW.dispose();
        sceneGame.resume();
        sceneGame.update();
        this.sceneFW = sceneGame;
    }

    public SceneFW getCurrentScene() {
        return sceneFW;
    }

    public SceneFW getStartScene() {
        return sceneFW;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
