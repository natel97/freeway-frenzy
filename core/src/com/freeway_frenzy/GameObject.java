package com.freeway_frenzy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject {
	
	protected int x, y, width, height;
	protected Texture tex;
	protected boolean draw;
	
	public GameObject(int x, int y, Texture tex, int width, int height) {
		this.x = x;
		this.y = y;
		this.tex = tex;
		this.width = width;
		this.height = height;
		this.draw = true;
	}
	
	public GameObject() {}

	public int getX() { return x; };
	public int getY() { return y; };
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public Texture getImage() { return tex; };
	
	public abstract void step(Float delta);
	
	public void draw(SpriteBatch batch) {
		if(draw) {
			batch.draw(tex, x-width/2, y-height/2,width, height);
		}
	}

}	
