package com.freeway_frenzy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class GameObject {
	
	int x, y, width, height;
	Texture tex;
	
	public GameObject(int x, int y, Texture tex, int width, int height) {
		this.x = x;
		this.y = y;
		this.tex = tex;
		this.width = width;
		this.height = height;
	}
	
	public GameObject() {}

	public int getX() { return x; };
	public int getY() { return y; };
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
	public Texture getImage() { return tex; };
	
	public abstract void step();
	
	public void draw(SpriteBatch batch) {
		batch.draw(tex, x, y,width, height);
	}

}	
