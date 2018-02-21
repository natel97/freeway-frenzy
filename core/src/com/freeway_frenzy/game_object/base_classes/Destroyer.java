package com.freeway_frenzy.game_object.base_classes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.freeway_frenzy.GameObject;
import com.freeway_frenzy.game_object.base_classes.Damager;
import com.freeway_frenzy.game_object.base_classes.Destroyable;
import com.freeway_frenzy.game_object.destroyer.WeirdBaseExample;
import com.freeway_frenzy.game_object.on_screen_display.UpgradeBTN;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public abstract class Destroyer extends GameObject implements Cloneable {
	protected int range, upgradeCost, damageByWeapon, purchasedCost;
	protected ConcurrentLinkedQueue<Damager> deadlyThings;
	private BitmapFont font;
	protected UpgradeBTN upgrade;
	protected boolean wasSelected;

	public Destroyer(int x, int y, int width, int height, Texture tex, int range, int purchasedCost, GlobalVars globalVars) {
		super(x,y,tex, width, height, globalVars);
		System.out.println("I am dragonborn!" + this);
		this.range = range;
		deadlyThings = new ConcurrentLinkedQueue<>();
		font = new BitmapFont();
		font.getData().setScale(2);
		this.upgradeCost = (int)(purchasedCost * 1.25);
		this.damageByWeapon = 30;
		upgrade = new UpgradeBTN(x, y, this, this.globalVars);
		this.purchasedCost = purchasedCost;
	}

	public void refreshButton(){
		this.upgrade = new UpgradeBTN(x, y, this, this.globalVars);
	}
	
	public int getRange() {return this.range; }
	public int getUpgradeCost() { return this.upgradeCost; }

	public void upgrade(){
		System.out.println("I am upgrading!" + this);
		System.out.println("Before: " + this.upgradeCost + "\t" + this.range + "\t" + this.damageByWeapon);
		this.upgradeCost *= 1.2;
		this.range += 10;
		this.damageByWeapon += 10;
		System.out.println("After: " + this.upgradeCost + "\t" + this.range + "\t" + this.damageByWeapon);
	}

	public abstract void shootSomething(com.freeway_frenzy.game_object.base_classes.Destroyable destroyable);

	@Override
	public void draw(ShapeRenderer shape){
		super.draw(shape);
		if(this.selected){
			shape.set(ShapeRenderer.ShapeType.Line);
			shape.circle(x, y, this.range);
		}

		deadlyThings.forEach(x -> x.draw(shape));
	}

	@Override
	public GameObject setSelect(boolean bool){
		if(this.selected){
			wasSelected = true;
		}
		return super.setSelect(bool);
	}

	@Override
	public void drawLater(SpriteBatch batch){
		super.drawLater(batch);
		if(this.selected){
			batch.setColor(Color.WHITE);
			font.draw(batch,"Range: " + this.range + "\nDamage: "+ this.damageByWeapon + "\nUpgrade Cost: " + this.upgradeCost,x + 128, y + 128);
			batch.setColor(globalVars.money > this.upgradeCost ? Color.WHITE : Color.RED);
			batch.draw(this.upgrade.getTexture(), this.x + 128, this.y - 72, 256, 64);
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
	public Destroyer clone(){
		try {
			Destroyer d =  (Destroyer) super.clone();
			d.refreshButton();
			return d;
		}
		catch (Exception e){
		}
		return null;
	}

	public int getPurchasedCost() {
		return purchasedCost;
	}

	@Override
	public boolean isAtPosition(float x, float y){
		if((x < (this.x + 384)) && (y < (this.y-8)) && (x > (this.x + 128)) && (y > (this.y - 72))) {
			upgrade.onClick();
		}
		return super.isAtPosition(x, y);
	}


}
