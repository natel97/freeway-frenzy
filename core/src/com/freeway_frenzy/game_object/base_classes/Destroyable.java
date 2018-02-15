package com.freeway_frenzy.game_object.base_classes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.freeway_frenzy.GameObject;
import com.freeway_frenzy.game_object.base_classes.Damager;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Destroyable extends GameObject {
	private GlobalVars globalVars;
	public void destroyInstance() {
		these.remove(this);
	}

	public enum Direction {
		UP(0,1), DOWN(0,-1), LEFT(-1,0), RIGHT(1,0);
		
		protected final int changeX;
		protected final int changeY;
		
		Direction(int cx, int cy){
			this.changeX = cx;
			this.changeY = cy;
		}
	}
	
	
	private int hp, speed;
	private Direction dir;
	private int MAX_HEALTH;
	private ConcurrentLinkedQueue<GameObject> these;
	
	
	public Destroyable(int x, int y, Texture tex, int width, int height, int hp, int speed, Direction dir, ConcurrentLinkedQueue<GameObject> destroyableList, GlobalVars globalVars) {
		super(x, y, tex, width, height);
		this.globalVars = globalVars;
		this.hp = hp;
		this.speed = speed;
		this.dir = dir;
		this.MAX_HEALTH = hp;
		this.these = destroyableList;
	}

	public void collide(Damager d) {
		this.hp -= d.getDamage();
		super.draw = this.hp > 0;
		if(!draw){
			globalVars.money += 100;
		}
	}

	public void move(double delta) {		
		super.x += (int)(dir.changeX * this.speed * delta * 60);
		super.y += (int)(dir.changeY * this.speed * delta * 60);
	}

	@Override
	public void draw(ShapeRenderer shape){
		this.draw = this.hp > 0;
		if(!draw){
			these.remove(this);
		}
		if((selected || hp < MAX_HEALTH) && hp > 0) {
			super.draw(shape);
			shape.set(ShapeRenderer.ShapeType.Filled);
			shape.setColor(Color.RED);
			shape.rect(x - width/2, y + height, width, 10);
			shape.setColor(Color.GREEN);
			shape.rect(x - width/2, y + height, ((float)hp / (float)MAX_HEALTH) * width, 10);
		}
	}
}
