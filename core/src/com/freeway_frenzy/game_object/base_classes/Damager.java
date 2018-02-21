package com.freeway_frenzy.game_object.base_classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.freeway_frenzy.GameObject;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Damager extends GameObject {
    private int damage;
    protected Destroyable target;
    protected ConcurrentLinkedQueue<Damager> damagers;

    public Damager(int x, int y, Texture tex, int width, int height, int damage, GlobalVars globalVars,Destroyable target, ConcurrentLinkedQueue<Damager> damagers){
        super(x, y, tex, width, height, globalVars);
        this.damage = damage;
        this.target = target;
        this.damagers = damagers;
    }
    public int getDamage() {return this.damage; }






}
