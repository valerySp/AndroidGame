package com.example.game;

import com.example.game.scenes.LoaderResourceScene;
import com.example.my_framework.CoreFW;
import com.example.my_framework.SceneFW;

public class Main extends CoreFW {

    public SceneFW getStartScene(){
        //загружаем в игру картинки
        return new LoaderResourceScene(this);
    }
}