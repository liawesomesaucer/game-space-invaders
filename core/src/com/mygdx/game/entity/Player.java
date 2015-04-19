package com.mygdx.game.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.TextureManager;
import com.mygdx.game.camera.OrthoCamera;

public class Player extends Entity {
	
	private final EntityManager entityManager;
	private final OrthoCamera camera;
	private long lastFire;
	private long ySpeed;

	public Player(Vector2 pos, Vector2 direction, EntityManager entityManager, OrthoCamera camera) {
		super(TextureManager.PLAYER, pos, direction);
		this.entityManager = entityManager;
		this.camera = camera;
	}

	@Override
	public void update() {
		pos.add(direction);
		
		int dir = 0;
		if (Gdx.input.isTouched()) {
			Vector2 touch = camera.unprojectCoordinates(Gdx.input.getX(), Gdx.input.getY());
			if (touch.x > MyGdxGame.WIDTH / 2)
				dir = 2;
			else
				dir = 1;
		}
			
		
		
		if (Gdx.input.isKeyPressed(Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT) || dir == 1)	// Left
			setDirection(-600, 0);
			
		else if (Gdx.input.isKeyPressed(Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT) || dir == 2) // right
			setDirection(600, 0);
		
//		else if (Gdx.input.isKeyPressed(Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP)){ // up
//			setDirection(0, 500);
//			ySpeed = 8;
//		}
//		
//		else if (Gdx.input.isKeyPressed(Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN)){ // down
//			setDirection(0, -400);
//			ySpeed = -1;
//		}
//		
		else {
			setDirection(0, 0);
			ySpeed = 0;
		}
			
		
		if (System.currentTimeMillis() - lastFire >= 400) {
			entityManager.addEntity(new Missile(pos.cpy().add(67, 100), ySpeed));
			lastFire = System.currentTimeMillis();
		
		}
	}

}
