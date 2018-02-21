package com.freeway_frenzy.game_object.damager;

import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.game_object.base_classes.Damager;
import com.freeway_frenzy.game_object.base_classes.Destroyable;
import com.freeway_frenzy.game_object.base_classes.GlobalVars;
import jdk.nashorn.internal.objects.Global;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BallThing extends Damager {
    public BallThing(int x, int y, Destroyable target, ConcurrentLinkedQueue<Damager> damagers, int damage, GlobalVars globalVars){
        super(x, y, new Texture("ball_thing.png"), 32,32, damage, globalVars, target, damagers);
        this.target = target;
        this.damagers = damagers;
    }

    @Override
    public void step(Float delta) {
        this.x += this.x < target.getX() ? 10 : -10;
        this.y += this.y < target.getY() ? 10 : -10;
        if(!target.isDraw()){
            damagers.remove(this);
        }

        if (target.isAtPosition(this.x, this.y)) {
            target.collide(this);
            damagers.remove(this);
        }
    }
}
