package com.freeway_frenzy.game_object.base_classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class OnScreenItem {
    private int x, y, width, height;
    private boolean visible;
    private Texture texture;

    public OnScreenItem(int x, int y, Texture texture, int width, int height, boolean visible){
        this.x = x;
        this.y = y;
        this.texture = texture;
        this.width = width;
        this.height = height;
        this.visible = visible;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x - width/2, y - height/2, width, height);
    }
    public void draw(ShapeRenderer shape){

    }
    public abstract void onClick();

    public int getX() { return this.x; }
    public int getY() { return this.y; }

    public void click(float x, float y){
        if ((x < (this.x + width/2)) && (y < (this.y + height/2)) && (x > (this.x - width/2)) && (y > (this.y - height/2))){
            this.onClick();
        }
    }

}
