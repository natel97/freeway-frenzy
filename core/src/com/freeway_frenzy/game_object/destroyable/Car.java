package com.freeway_frenzy.game_object.destroyable;

import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.game_object.Destroyable;

public class Car extends Destroyable{
	
	public Car(int x, int y) {
		super(x, y, new Texture("badlogic.jpg"), 128, 256, 100, 5);
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		
	}

}
