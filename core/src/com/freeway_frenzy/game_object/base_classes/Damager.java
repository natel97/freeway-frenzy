package com.freeway_frenzy.game_object.base_classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.freeway_frenzy.GameObject;

public abstract class Damager extends GameObject {
    private int damage;

    public Damager(int x, int y, Texture tex, int width, int height, int damage){
        super(x, y, tex, width, height);
        this.damage = damage;

    }
    public int getDamage() {return this.damage; }





}
