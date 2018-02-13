package com.freeway_frenzy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameObject extends Actor {
	
	protected int x, y, width, height;
	protected Texture tex;
	protected boolean draw;
	protected boolean selected;
	
	public GameObject(int x, int y, Texture tex, int width, int height) {
		this.x = x;
		this.y = y;
		this.tex = tex;
		this.width = width;
		this.height = height;
		this.draw = true;
		this.selected = false;
	}
	
	public GameObject() {}

	public Texture getImage() { return tex; }
	public GameObject setSelect(boolean bool){ this.selected = bool; return this; }
	public boolean isSelected() { return this.selected; }
	public boolean isAtPosition(Vector3 vector){
	    System.out.println(vector);
	    return ((vector.x < (this.x + width/2)) && (vector.y < (this.y + height/2)) && (vector.x > (this.x - width/2)) && (vector.y > (this.y - height/2)));
    }
	
	public abstract void step(Float delta);
	
	public void draw(SpriteBatch batch, ShapeRenderer shapeRenderer) {
		if(draw) {
			batch.draw(tex, x-width/2, y-height/2,width, height);
		}

		if(selected){
		    shapeRenderer.setAutoShapeType(true);
		    shapeRenderer.begin();
            shapeRenderer.set(ShapeRenderer.ShapeType.Line);
            shapeRenderer.rectLine(new Vector2(x-width/2, y-height/2), new Vector2(x+width/2, y+height/2), 2);
            shapeRenderer.end();
		}
	}

}	
