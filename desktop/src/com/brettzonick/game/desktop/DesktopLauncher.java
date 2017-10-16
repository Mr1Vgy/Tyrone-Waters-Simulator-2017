package com.brettzonick.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.brettzonick.game.Garbageman;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Tyrone Water Simulator 2017";
		config.foregroundFPS = 60;
		config.resizable = false;
		config.height = 720;
		config.width = 1280;
		config.forceExit = false;
		new LwjglApplication(new Garbageman(), config);
	}
}
