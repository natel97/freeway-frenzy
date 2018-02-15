package com.freeway_frenzy.game_object.destroyable;

import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.GameObject;
import com.freeway_frenzy.game_object.base_classes.Destroyable;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Van extends Destroyable {

    public Van(int x, int y, Direction dir, ConcurrentLinkedQueue<GameObject> these) {
        super(x, y, new Texture("car_red.png"), 128, 256, 150, 5, dir, these);
    }

    @Override
    public void step(Float delta) {
        super.move(delta);
    }

}
