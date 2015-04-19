package com.mygdx.game.entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.TextureManager;

public class Background extends Entity {

	public Background(Texture texture, Vector2 pos, Vector2 direction) {

		super(TextureManager.BACKGROUND, pos, direction);

	}

	@Override
	public void update() {
		pos.add(direction);
		
	}

}
