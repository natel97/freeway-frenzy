package com.freeway_frenzy.game_object.destroyable;

import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.game_object.Destroyable;

public class Truck extends Destroyable {

    public Truck(int x, int y, Direction dir) {
        super(x, y, new Texture("truck_red.png"), 128, 256, 120, 5, dir);
        System.out.println("New Truck object:\tX: " + x + "\tY: " + y);
    }

    @Override
    public void step(Float delta) {
        super.move(delta);
    }
}
