package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.game.scenes.MainMenuScene;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class Main extends CoreFW {

    public SceneFW getStartScene(){
        return new MainMenuScene(this);
    }
}