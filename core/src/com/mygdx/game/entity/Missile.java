package com.mygdx.game.entity;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.TextureManager;

public class Missile extends Entity {

	public Missile(Vector2 pos, long currentSpeed) {
		super(TextureManager.MISSILE, pos, new Vector2(0, currentSpeed + 10));
	}

	@Override
	public void update() {
		pos.add(direction);
	}

	public boolean checkEnd() {
		return pos.y >= MyGdxGame.HEIGHT;
	}
}
