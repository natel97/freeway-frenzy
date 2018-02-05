package com.freeway_frenzy.screens;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.FFGame;
import com.freeway_frenzy.GameObject;
import com.freeway_frenzy.Positions;
import com.freeway_frenzy.game_object.Destroyable.Direction;
import com.freeway_frenzy.game_object.destroyable.Car;

public class MainMenu implements Screen {
	
	final int BOX_SIZE = 160;
	
	public enum position{
		
	}
	
	private FFGame game;
	private Texture tex;
	private List<GameObject> objects;
	
	public MainMenu(FFGame game) {
		this.game = game;
		this.tex = new Texture("background.png");
		objects = new LinkedList<GameObject>();
		
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
		objects.forEach(x -> {
			x.step(delta);
			
		});
		
		objects = objects.stream().filter(x -> x.getY() < 1200).collect(Collectors.toList());
		
		
		//Drawing
		game.getSpriteBatch().begin();
		
		game.getSpriteBatch().draw(tex, 0, 0);
		objects.stream().filter(x -> x.getY() < 1200).forEach(x -> x.draw(game.getSpriteBatch()));
		
		//Draw grid lines
		
		for(int x = 0; x < 1920; x+= BOX_SIZE) {
			//Implement this!
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
