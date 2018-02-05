package com.freeway_frenzy.game_object.destroyable;

import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.game_object.Destroyable;

public class Car extends Destroyable{
	
	public Car(int x, int y, Direction dir) {
		super(x, y, new Texture("car_red.png"), 128, 256, 100, 5, dir);
	}

	@Override
	public void step(Float delta) {
		super.move(delta);
	}

}
