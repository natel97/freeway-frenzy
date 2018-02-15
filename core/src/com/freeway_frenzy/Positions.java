package com.freeway_frenzy;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.freeway_frenzy.game_object.base_classes.Destroyer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Positions {
	public Positions(){
		this.destroyerTracker = new HashMap<>();
	}
	public List<Destroyer> getDestroyers() { return new ArrayList<>(this.destroyerTracker.values()); }
	private HashMap<DestroyerPositions, Destroyer> destroyerTracker;

	public void drawEachDestroyer(SpriteBatch spriteBatch) {
		destroyerTracker.values().forEach(x -> x.draw(spriteBatch));
	}
	public void drawEachDestroyer(ShapeRenderer shape){
		destroyerTracker.values().forEach(x -> x.draw(shape));
	}

	public Destroyer getDestroyerFromPosition(DestroyerPositions lastTouchedPosition) {
		return destroyerTracker.get(lastTouchedPosition);
	}

	public enum Sidewalks {
		SIDEWALK1(64), SIDEWALK2(576), SIDEWALK3(1344), SIDEWALK4(1856);
		public final int x;

		Sidewalks(int x) {
			this.x = x;
		}
	}

	public enum Lanes {
		LANE1(224), LANE2(416), LANE3(1504), LANE4(1664);
		public final int x;

		Lanes(int x){
			this.x = x;
		}
	}

	public enum DestroyerPositions{
		A1(700, 100), A2(880, 100), A3(1060, 100), B1(700, 280), B2(880, 280), B3(1060, 280), C1(700, 460), C2(880, 460), C3(1060, 460), D1(700, 640), D2(880, 640), D3(1060, 640), E1(700, 820), E2(880, 820), E3(1060, 820);

		public final int x;
		public final int y;
		DestroyerPositions(int x, int y) {
			this.x = x + 80;
			this.y = y + 80;
		}
	}
	public boolean spaceOccupied(DestroyerPositions position){
		return destroyerTracker.containsKey(position);
	}
	public boolean addDestroyerAtPosition(DestroyerPositions position, Destroyer d){
		if(spaceOccupied(position)){
			return false;
		}
		destroyerTracker.put(position, d);
		return true;
	}

	public DestroyerPositions getBlockByPosition(float x, float y){
		for(DestroyerPositions position : DestroyerPositions.values()) {
				if((x < (position.x + 80)) && (y < (position.y + 80)) && (x > (position.x - 80)) && (y > (position.y - 80))) {
					return position;
				}
			}
			return null;
		}

	public void destroyAtPosition(DestroyerPositions position){
		destroyerTracker.remove(position);
	}
}
