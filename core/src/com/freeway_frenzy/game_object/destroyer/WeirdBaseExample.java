package com.freeway_frenzy.game_object.destroyer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;
import com.freeway_frenzy.game_object.base_classes.Destroyable;
import com.freeway_frenzy.game_object.base_classes.Destroyer;
import com.freeway_frenzy.game_object.damager.BallThing;

public class WeirdBaseExample extends Destroyer {
    Long lastShotTime;
    int timeOut;
    public WeirdBaseExample(int x, int y, int range){
        super(x ,y, 160, 160, new Texture("platform_shoot_thing.png"), range);
        System.out.println("Creating weird base example thing at position:  " + x + "   " + y);
        lastShotTime = 1l;
        this.timeOut = 500;
    }

    @Override
    public void step(Float delta) {
        super.step(delta);
    }

    @Override
    public void shootSomething(Destroyable destroyable) {
        if(lastShotTime + this.timeOut < TimeUtils.millis()) {
            this.lastShotTime = TimeUtils.millis();
            deadlyThings.add(new BallThing(this.x, this.y, destroyable, deadlyThings));
        }
    }
}
