package com.tankstars.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;


// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(TankStars.v_width, TankStars.v_height);
		config.setForegroundFPS(60);
		config.setTitle("Tank Stars");
		new Lwjgl3Application(new TankStars(), config);
	}
}
