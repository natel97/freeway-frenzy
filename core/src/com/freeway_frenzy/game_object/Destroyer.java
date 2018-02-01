package com.freeway_frenzy.game_object;

import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.GameObject;

public abstract class Destroyer extends GameObject {
	int damage, range;

	public Destroyer(int x, int y, int width, int height, Texture tex, int damage, int range) {
		super(x,y,tex, width, height);
		this.damage = damage;
		this.range = range;
	}
	
	public int getRange() {return this.range; }
	public int getDamage() {return this.damage; }

}
