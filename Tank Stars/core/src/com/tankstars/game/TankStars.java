package com.tankstars.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.tankstars.game.screens.MenuScreen1;
import com.tankstars.game.screens.MenuScreen2;
import com.tankstars.game.screens.StartScreen;


public class TankStars extends Game {
	public static final int v_width = 1500;
	public static final int v_height = 750;
	public static final float PPM = 100;
	public SpriteBatch batch;


	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new StartScreen(this));


	}

	@Override
	public void render () {
		super.render();
	}



}
