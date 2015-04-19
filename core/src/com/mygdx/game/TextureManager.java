package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	
	String alien1 = "alien1.png";	// Capital ship
	String alien2 = "alien2.png";
	String alien3 = "alien3.png";
	String alien4 = "alien4.png";
	
	String[] aliens = { alien1, alien2, alien3, alien4 };
	
	public static Texture PLAYER = new Texture(Gdx.files.internal("space_alien_fighter.png"));
	public static Texture BACKGROUND = new Texture(Gdx.files.internal("space_background.png"));
	public static Texture MISSILE = new Texture(Gdx.files.internal("space_laser.png"));
	public static Texture ENEMY = new Texture(Gdx.files.internal("alien4.png"));
	public static Texture GAME_WON = new Texture(Gdx.files.internal("victory_screen.png"));
	public static Texture GAME_OVER = new Texture(Gdx.files.internal("game_over_screen.png"));
	
}
