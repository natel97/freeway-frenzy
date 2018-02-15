package com.freeway_frenzy.game_object.destroyable;

import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.GameObject;
import com.freeway_frenzy.game_object.base_classes.Destroyable;
import com.freeway_frenzy.game_object.base_classes.GlobalVars;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Padestrian extends Destroyable{

    public Padestrian(int x, int y, Destroyable.Direction dir, ConcurrentLinkedQueue<GameObject> these, GlobalVars globalVars) {
        super(x, y, new Texture("car_red.png"), 128, 256, 30, 1, dir, these, globalVars);
    }

    @Override
    public void step(Float delta) {
        super.move(delta);
    }

}
