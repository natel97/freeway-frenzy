package com.freeway_frenzy.game_object;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.freeway_frenzy.GameObject;

public abstract class Destroyable extends GameObject {
	public enum Direction {
		UP(0,1), DOWN(0,-1), LEFT(-1,0), RIGHT(1,0);
		
		protected final int changeX;
		protected final int changeY;
		
		Direction(int cx, int cy){
			this.changeX = cx;
			this.changeY = cy;
		}
	}
	
	
	int hp, speed;
	SpriteBatch batch;
	Direction dir;
	
	
	public Destroyable(int x, int y, Texture tex, int width, int height, int hp, int speed, Direction dir) {
		super(x, y, tex, width, height);
		this.hp = hp;
		this.speed = speed;
		this.dir = dir;
	}
	
	public void collide(Destroyer d) {
		this.hp -= d.damage;
		super.draw = this.hp > 0;
	}
	
	public void move(double delta) {		
		super.x += (int)(dir.changeX * this.speed * delta * 60);
		super.y += (int)(dir.changeY * this.speed * delta * 60);
	}

}
