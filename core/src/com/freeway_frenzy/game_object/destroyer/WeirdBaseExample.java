package com.freeway_frenzy.game_object.destroyer;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;
import com.freeway_frenzy.game_object.base_classes.Destroyable;
import com.freeway_frenzy.game_object.base_classes.Destroyer;
import com.freeway_frenzy.game_object.base_classes.GlobalVars;
import com.freeway_frenzy.game_object.damager.BallThing;

public class WeirdBaseExample extends Destroyer {
    Long lastShotTime;
    int timeOut;
    GlobalVars globalVars;
    public WeirdBaseExample(int x, int y, int range, int purchasedCost, GlobalVars globalVars){
        super(x ,y, 160, 160, new Texture("platform_shoot_thing.png"), range, purchasedCost, globalVars);
        this.range = range;
        lastShotTime = 1l;
        this.timeOut = 500;
        this.globalVars = globalVars;
    }

    @Override
    public void step(Float delta) {
        super.step(delta);
    }

    @Override
    public void shootSomething(Destroyable destroyable) {
        if(lastShotTime + this.timeOut < TimeUtils.millis()) {
            this.lastShotTime = TimeUtils.millis();
            deadlyThings.add(new BallThing(this.x, this.y, destroyable, deadlyThings, this.damageByWeapon, globalVars));
        }
    }
}
