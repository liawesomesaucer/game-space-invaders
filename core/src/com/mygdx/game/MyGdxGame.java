package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.screen.GameScreen;
import com.mygdx.game.screen.ScreenManager;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background_img;
	public static int WIDTH = 960, HEIGHT = 1704;

	
	@Override
	public void create () {
		batch = new SpriteBatch();

		
		batch.begin();
		background_img = new Texture(Gdx.files.internal("space_background.png"));
		batch.end();
		
		ScreenManager.setScreen( new GameScreen());
		
	}
	
	@Override
	public void dispose() {
		
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().dispose();
		
		batch.dispose();
		
	}
	
	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		batch.draw(background_img, 0, 0);
		batch.end();
		
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().update();
		
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().render(batch);
		
	}
	
	@Override
	public void resize( int width, int height ) {
		
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().resize(width, height);
	}
	
	@Override
	public void pause() {
		
		if (ScreenManager.getCurrentScreen() != null)
			ScreenManager.getCurrentScreen().pause();
		
	}
}
