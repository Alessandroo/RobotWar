package com.mygdx.robot_wars.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.info.Configuration;
import com.mygdx.robot_wars.RobotWars;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Configuration.windowWidth;
        config.height = Configuration.windowHeight;
		new LwjglApplication(new RobotWars(), config);
	}
}
