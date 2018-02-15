package com.freeway_frenzy.screens;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.freeway_frenzy.FFGame;
import com.freeway_frenzy.GameObject;
import com.freeway_frenzy.Positions;
import com.freeway_frenzy.game_object.base_classes.Destroyable;
import com.freeway_frenzy.game_object.base_classes.Destroyable.Direction;
import com.freeway_frenzy.game_object.destroyable.Car;
import com.freeway_frenzy.game_object.destroyable.Truck;
import com.freeway_frenzy.game_object.destroyer.WeirdBaseExample;

public class MainGame implements Screen {

    private float xRatio(int x) { return x * (1920 / this.game.getCamera().viewportWidth);  }
    private float yRatio(int y) { return (1080 - (y) * (1080 / this.game.getCamera().viewportHeight)) * .97f; }

    private Positions positions;
	private FFGame game;
	private Texture tex;
	private List<GameObject> objects;
	private ShapeRenderer shapeRenderer;
	private int cursorX = 0;
	private int cursorY = 0;
	private boolean showStore = false;
	private Positions.DestroyerPositions lastTouchedPosition;

    public MainGame(FFGame game)  {
		this.game = game;
		this.tex = new Texture("background.png");
		objects = new ArrayList<>();
		shapeRenderer = new ShapeRenderer();

        shapeRenderer.setAutoShapeType(true);

        List<Music> songs = new LinkedList<>();

			songs.add(Gdx.audio.newMusic(Gdx.files.internal("Main.ogg")));
			songs.add(Gdx.audio.newMusic(Gdx.files.internal("SadSong.ogg")));
			songs.add(Gdx.audio.newMusic(Gdx.files.internal("AnotherSong.ogg")));
			songs.get(0).play();
			songs.get(0).setLooping(true);
			positions = new Positions();

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void render(float delta) {
		//Debug Stuff

		
		
		
		if(Math.floor(Math.random() * 100) == 1) {
			switch((int) Math.floor(Math.random() * 2)) {
				case 1: objects.add(new Car(Positions.Lanes.values()[(int) Math.floor(Math.random() * 4)].x, -128, Direction.UP, objects));
				break;
				case 0: objects.add(new Truck(Positions.Lanes.values()[(int) Math.floor(Math.random() * 4)].x, -128, Direction.UP, objects));
				break;
			}
		}
		
		//Before Drawing
		objects.forEach(x -> x.step(delta));
		positions.getDestroyers().forEach(x -> x.step(delta));
        positions.getDestroyers()
                .forEach(x -> x.findNearbyThingsToHit(objects.stream()
                        .filter(y -> y.getClass().getSuperclass() == Destroyable.class)
                        .map(z -> ((Destroyable)z)).collect(Collectors.toList()))
                );
		objects = objects.stream().filter(x -> x.getY() < 1200).collect(Collectors.toList());



		//Drawing
		game.getSpriteBatch().begin();

		game.getSpriteBatch().draw(tex, 0, 0);


		if(Gdx.input.justTouched()){
			objects.forEach(x -> x.setSelect(false));
			positions.getDestroyers().forEach(x -> x.setSelect(false));
			objects.stream().filter(x -> x.isAtPosition(xRatio(Gdx.input.getX()), yRatio(Gdx.input.getY()))).forEach(x -> x.setSelect(true));
			 lastTouchedPosition = positions.getBlockByPosition(xRatio(Gdx.input.getX()), yRatio(Gdx.input.getY()));
			if(lastTouchedPosition != null){
			    if(!positions.spaceOccupied(lastTouchedPosition)){
			        positions.addDestroyerAtPosition(lastTouchedPosition,new WeirdBaseExample(lastTouchedPosition.x, lastTouchedPosition.y,600));
                }
                else{
			        positions.getDestroyers().forEach(x -> x.setSelect(false));
			        positions.getDestroyerFromPosition(lastTouchedPosition).setSelect(true);
                }
            }
		}
        if (Gdx.input.isTouched()) {
            cursorX = (int) xRatio(Gdx.input.getX());
            cursorY = (int) yRatio(Gdx.input.getY());
        }


		objects.forEach(x -> x.draw(game.getSpriteBatch()));
		positions.drawEachDestroyer(game.getSpriteBatch());

		game.getSpriteBatch().end();

        shapeRenderer.begin();
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.circle(cursorX, cursorY, 10);
		objects.forEach(x -> x.draw(shapeRenderer));
        positions.drawEachDestroyer(shapeRenderer);
        shapeRenderer.end();
		
		//After Drawing


	}

	@Override
	public void resize(int width, int height) {
        this.game.getCamera().viewportWidth = width;
        this.game.getCamera().viewportHeight = height;
		
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
