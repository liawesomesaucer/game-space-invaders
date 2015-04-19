package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.TextureManager;
import com.mygdx.game.camera.OrthoCamera;
import com.mygdx.game.screen.GameOverScreen;
import com.mygdx.game.screen.ScreenManager;

public class EntityManager {
	
	private final Player player;
	private final Array<Entity>  entities = new Array<Entity>();
	
	public EntityManager(int amount, OrthoCamera camera) {		// Amount of enemies to spawn
		player = new Player(new Vector2(230, 15), new Vector2(0, 0), this, camera);
		for (int i=0; i<amount; i++) {
			float x = MathUtils.random(0, MyGdxGame.WIDTH - TextureManager.ENEMY.getWidth());
			float y = MathUtils.random(MyGdxGame.HEIGHT, MyGdxGame.HEIGHT * 2);
			float speed = MathUtils.random(3, 8);
			addEntity(new Enemy(new Vector2(x, y), new Vector2(0, -speed)));
		}
	}
	
	public void update() {
		
		for (Entity e : entities) {
			e.update();
		}
		player.update();
		checkCollisions();
	}
	
	public void render(SpriteBatch sb) {
		for (Entity e : entities) 
			e.render(sb);
		for (Missile m : getMissiles())
			if (m.checkEnd())entities.removeValue(m, false); 
		
		player.render(sb);
	}
	
	public void checkCollisions() {
		for (Enemy e: getEnemies()) {
			for (Missile m : getMissiles()) {
				if (e.getBounds().overlaps(m.getBounds())) {
					entities.removeValue(e, false);
					entities.removeValue(m, false);
					if (gameOver()) {
						// end game, win
						ScreenManager.setScreen(new GameOverScreen(true));

					}
				}
			}
			
			if (e.getBounds().overlaps(player.getBounds())) {
				// end game, lost
				ScreenManager.setScreen(new GameOverScreen(false));

			}
		}
	}
	
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	private Array<Enemy> getEnemies() {
		Array<Enemy> ret = new Array<Enemy>();
		for (Entity e : entities)
			if (e instanceof Enemy) 
				ret.add( (Enemy) e);
		
		return ret;
	}
	
	private Array<Missile> getMissiles() {
		Array<Missile> ret = new Array<Missile>();
		for (Entity e : entities)
			if (e instanceof Missile)
				ret.add( (Missile) e);
		return ret;
	}
	
	public boolean gameOver() {
		return getEnemies().size <= 0;
	}
}
