package com.freeway_frenzy.screens;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.stream.Collectors;

import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.audio.*;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.freeway_frenzy.FFGame;
import com.freeway_frenzy.GameObject;
import com.freeway_frenzy.Positions;
import com.freeway_frenzy.game_object.Destroyable.Direction;
import com.freeway_frenzy.game_object.destroyable.Car;
import com.freeway_frenzy.game_object.destroyable.Truck;

public class MainGame implements Screen {

	Stage stage;
	
	final int BOX_SIZE = 160;
	final int XOFFSET = -20;
	final int YOFFSET = 100;
	final int SPACE_BETWEEN = 20;
	private FFGame game;
	private Texture tex;
	private List<GameObject> objects;
	private ShapeRenderer shapeRenderer;
	private List<Music> songs;
	
	public MainGame(FFGame game)  {
		this.game = game;
		this.tex = new Texture("background.png");
		objects = new ArrayList<>();
		shapeRenderer = new ShapeRenderer();
		stage = new Stage();
		this.songs = new LinkedList<>();
		try {
			songs.add(Gdx.audio.newMusic(Gdx.files.internal("Main.ogg")));
			songs.add(Gdx.audio.newMusic(Gdx.files.internal("SadSong.ogg")));
			songs.add(Gdx.audio.newMusic(Gdx.files.internal("AnotherSong.ogg")));
			songs.get(0).play();
			songs.get(0).setLooping(true);
		}

		catch (Exception e){
			//no sound lol
		}

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
			switch((int) Math.floor(Math.random() * 2)) {
				case 1: objects.add(new Car(Positions.Lanes.values()[(int) Math.floor(Math.random() * 4)].x, -128, Direction.UP));
				break;
				case 0: objects.add(new Truck(Positions.Lanes.values()[(int) Math.floor(Math.random() * 4)].x, -128, Direction.UP));
				break;
			}
		}

		
		
		//Before Drawing
		objects.forEach(x -> x.step(delta));

		objects = objects.stream().filter(x -> x.getY() < 1200).collect(Collectors.toList());



		//Drawing
		game.getSpriteBatch().begin();

		game.getSpriteBatch().draw(tex, 0, 0);


		if(Gdx.input.justTouched()){
			objects.forEach(x -> x.setSelect(false));
			objects.stream().filter(x -> x.isAtPosition(game.getCamera().unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0)))).forEach(x -> x.setSelect(true));
		}

		objects.forEach(x -> x.draw(game.getSpriteBatch(), shapeRenderer));

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
