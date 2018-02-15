package com.freeway_frenzy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.freeway_frenzy.game_object.base_classes.Destroyable;
import com.freeway_frenzy.game_object.base_classes.GlobalVars;

public abstract class GameObject {
	
	protected int x, y, width, height;
	protected Texture tex;
	protected boolean draw;
	protected boolean selected;
	
	public GameObject(int x, int y, Texture tex, int width, int height) {
		this.x = x;
		this.y = y;
		this.tex = tex;
		this.width = width;
		this.height = height;
		this.draw = true;
		this.selected = false;
	}
	
	public GameObject() {}

	public Texture getImage() { return tex; }
	public GameObject setSelect(boolean bool) {
		this.selected = !this.selected && bool;
		return this;
	}
	public boolean isSelected() { return this.selected; }
	public boolean isAtPosition(float x, float y){
	    return ((x < (this.x + width/2)) && (y < (this.y + height/2)) && (x > (this.x - width/2)) && (y > (this.y - height/2)));
    }
	
	public abstract void step(Float delta);
	public void draw(SpriteBatch batch){
		if(draw) {
			batch.draw(tex, x-(width/2), y-(height/2),width, height);
		}
		else{
			if(this.getClass() == Destroyable.class){
				((Destroyable)this).destroyInstance();
			}
		}
	}
	public void draw(ShapeRenderer shapeRenderer) {
		if(selected){
			shapeRenderer.set(ShapeRenderer.ShapeType.Line);
			shapeRenderer.rect(x-width/2, y-height/2, width, height);
		}
	}
	public int getX() { return this.x; }
	public int getY() { return this.y; }
	public boolean isDraw() { return this.draw; }

}
