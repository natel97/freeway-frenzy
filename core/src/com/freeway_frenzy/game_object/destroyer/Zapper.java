package com.freeway_frenzy.game_object.destroyer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.TimeUtils;
import com.freeway_frenzy.game_object.base_classes.Destroyable;
import com.freeway_frenzy.game_object.base_classes.Destroyer;
import com.freeway_frenzy.game_object.base_classes.GlobalVars;
import com.freeway_frenzy.game_object.damager.Zap;

public class Zapper extends Destroyer {
    private long lastShotTime = 0;
    private long timeBetweenShots = 1000;

    public Zapper(int x, int y, int range, int purchasedCost, GlobalVars globalVars) {
        super(x, y, 160, 160, new Texture("zapper.png"), range, purchasedCost, globalVars);
        this.damageByWeapon = 10;
    }

    @Override
    public void shootSomething(Destroyable destroyable) {
        if(TimeUtils.millis() > lastShotTime + timeBetweenShots){
            this.lastShotTime = TimeUtils.millis();
            deadlyThings.add(new Zap(this.x, this.y, destroyable, deadlyThings, this.damageByWeapon / 10, globalVars));

        }
    }
}
