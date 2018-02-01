package com.freeway_frenzy.game_object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.freeway_frenzy.GameObject;

public abstract class Destroyable extends GameObject {
	int hp, speed;
	SpriteBatch batch;
	int x, y, width, height;
	
	public Destroyable(int x, int y, Texture tex, int width, int height, int hp, int speed) {
		super(x, y, tex, width, height);
		this.hp = hp;
		this.speed = speed;
	}
	
	public void collide(Destroyer d) {
		this.hp -= d.damage;
		super.draw = this.hp > 0;
	}

}
