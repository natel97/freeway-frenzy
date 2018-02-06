package com.freeway_frenzy.game_object.destroyable;

import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.game_object.Destroyable;

public class Padestrian extends Destroyable{

    public Padestrian(int x, int y, Destroyable.Direction dir) {
        super(x, y, new Texture("car_red.png"), 128, 256, 30, 1, dir);
    }

    @Override
    public void step(Float delta) {
        super.move(delta);
    }

}
