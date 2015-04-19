package com.mygdx.game.screen;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.camera.OrthoCamera;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.Player;

public class GameScreen extends Screen{
	
	private OrthoCamera camera;
	private EntityManager entityManager;

	@Override
	public void create() {
		System.out.println("Created");
		camera = new OrthoCamera();
		entityManager = new EntityManager(20, camera);
	}
	
	@Override
	public void update() {
		
		camera.update();
		entityManager.update();
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.setProjectionMatrix(camera.combined);
		
		entityManager.render(sb);
		
	}

	@Override
	public void resize(int width, int height) {
		System.out.println("Resize");
		camera.resize();
	}

	@Override
	public void dispose() {
		
	}
	

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	
}
