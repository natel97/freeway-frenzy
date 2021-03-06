package com.freeway_frenzy;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.freeway_frenzy.screens.MainGame;

public class FFGame extends Game {
	SpriteBatch batch;
	Texture img;
    public Viewport viewport;
    private Camera camera;
	
	@Override
	public void create () {
		camera = new PerspectiveCamera();
	    viewport = new StretchViewport(1920, 1080, camera);
		batch = new SpriteBatch();
		setScreen(new MainGame(this));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
	
	@Override
	public void dispose () {
	}
	public Camera getCamera(){ return this.camera; }
	
	public SpriteBatch getSpriteBatch() { return this.batch; }
}
