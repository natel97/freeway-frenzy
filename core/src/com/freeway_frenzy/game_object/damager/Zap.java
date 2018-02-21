package com.freeway_frenzy.game_object.damager;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.freeway_frenzy.game_object.base_classes.Damager;
import com.freeway_frenzy.game_object.base_classes.Destroyable;
import com.freeway_frenzy.game_object.base_classes.GlobalVars;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Zap extends Damager {
    long createTime;
    public Zap(int x, int y, Destroyable target, ConcurrentLinkedQueue<Damager> damagers, int damage, GlobalVars globalVars){
        super(x, y, null, 32,32, damage, globalVars, target, damagers);
        this.isDraw();
        draw = false;
        createTime = TimeUtils.millis();
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

    @Override
    public void draw(ShapeRenderer shape){
        if(!target.isDraw())
            damagers.remove(this);
        shape.set(ShapeRenderer.ShapeType.Filled);
        shape.setColor(Color.YELLOW);
        if(TimeUtils.millis() < createTime + 1000){
            shape.rectLine(new Vector2(this.x, this.y), new Vector2(target.getX(), target.getY()), 6);
            target.collide(this);
        }
        else{
            damagers.remove(this);
        }
    }
}
