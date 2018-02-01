package com.freeway_frenzy.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.freeway_frenzy.FFGame;

public class MainMenu implements Screen {
	
	private FFGame game;
	private Texture tex;
	
	public MainMenu(FFGame game) {
		this.game = game;
		this.tex = new Texture("background.png");
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		game.getSpriteBatch().begin();
		game.getSpriteBatch().draw(tex, 0, 0);

		game.getSpriteBatch().end();
		
	}

	@Override
	public void resize(int width, int height) {
		this.game.viewport.update(width, height);
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
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
