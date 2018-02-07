package com.freeway_frenzy.screens;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.freeway_frenzy.FFGame;
import com.freeway_frenzy.GameObject;
import com.freeway_frenzy.Positions;
import com.freeway_frenzy.game_object.Destroyable.Direction;
import com.freeway_frenzy.game_object.destroyable.Car;

public class MainMenu implements Screen {
	
	final int BOX_SIZE = 160;
	final int XOFFSET = -20;
	final int YOFFSET = 100;
	final int SPACE_BETWEEN = 20;
	
	public enum position{
		
	}
	
	private FFGame game;
	private Texture tex;
	private List<GameObject> objects;
	private ShapeRenderer shapeRenderer;
	
	public MainMenu(FFGame game) {
		this.game = game;
		this.tex = new Texture("background.png");
		objects = new LinkedList<>();
		shapeRenderer = new ShapeRenderer();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		//Debug Stuff
		if(Gdx.input.justTouched()) {
			System.out.println("X: " + Gdx.input.getX() + "\tY: " + Gdx.input.getY());
		}
		
		
		
		if(Math.floor(Math.random() * 100) == 1) {
			objects.add(new Car(Positions.Lanes.values()[(int) Math.floor(Math.random() * 4)].x, -128, Direction.UP));
		}
		
		
		
		//Before Drawing
		objects.forEach(x -> x.step(delta));

		objects = objects.stream().filter(x -> x.getY() < 1200).collect(Collectors.toList());
		
		
		//Drawing
		game.getSpriteBatch().begin();
		
		game.getSpriteBatch().draw(tex, 0, 0);
		objects.stream().filter(x -> x.getY() < 1200).forEach(x -> x.draw(game.getSpriteBatch()));
		
		//Draw grid

        for (Positions.DestroyerPositions pos : Positions.DestroyerPositions.values()) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(Color.RED);
            shapeRenderer.rect(pos.x, pos.y, BOX_SIZE, BOX_SIZE);
            shapeRenderer.end();
        }


		game.getSpriteBatch().end();
		
		//After Drawing
	}

	@Override
	public void resize(int width, int height) {
		this.game.viewport.update(width, height);
		
	}

	@Override
	public void pause() {
		System.out.println("PAUSED");
		
	}

	@Override
	public void resume() {
		System.out.println("RESUME");
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
