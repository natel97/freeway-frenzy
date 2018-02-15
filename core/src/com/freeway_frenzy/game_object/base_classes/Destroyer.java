package com.freeway_frenzy.game_object.base_classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.freeway_frenzy.GameObject;
import com.freeway_frenzy.game_object.base_classes.Damager;
import com.freeway_frenzy.game_object.base_classes.Destroyable;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public abstract class Destroyer extends GameObject {
	protected int range;
	protected ConcurrentLinkedQueue<Damager> deadlyThings;
	protected int upgradeCost;
	protected int damageByWeapon = 50;

	public Destroyer(int x, int y, int width, int height, Texture tex, int range) {
		super(x,y,tex, width, height);
		this.range = range;
		deadlyThings = new ConcurrentLinkedQueue<>();
	}
	
	public int getRange() {return this.range; }
	public int getUpgradeCost() { return this.upgradeCost; }

	public void upgrade(){
		System.out.println("inside upgrade!");
		this.upgradeCost += upgradeCost * .25;
		this.range += 50;
		this.damageByWeapon += 10;
	}

	public abstract void shootSomething(com.freeway_frenzy.game_object.base_classes.Destroyable destroyable);

	@Override
	public void draw(ShapeRenderer shape){
		super.draw(shape);
		if(this.selected){
			shape.set(ShapeRenderer.ShapeType.Line);
			shape.circle(x, y, range);
		}
	}

	@Override
	public void draw(SpriteBatch batch){
		super.draw(batch);
		deadlyThings.forEach(x->x.draw(batch));
	}


	public void findNearbyThingsToHit(List<com.freeway_frenzy.game_object.base_classes.Destroyable> objects){
		List<Destroyable> nearby = objects.stream().filter(x ->
					Math.sqrt(
							((this.x - x.getX()) * (this.x - x.getX()))
									+
									((this.y - x.getY()) * (this.y - x.getY()))
					) < this.range && x.isDraw()
		).collect(Collectors.toList());

		if(nearby.size() > 0){
			shootSomething(nearby.get(0));
		}
	}
	@Override
	public void step(Float delta){
		deadlyThings.stream().filter(x -> x.isDraw()).forEach(x -> x.step(delta));
	}

    public void setPosition(int x, int y){
		this.x = x;
		this.y = y;
	}
}
