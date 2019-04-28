package com.mygdx.robot_wars;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Logger;
import com.mygdx.game_helpers.AssetLoader;
import com.mygdx.screens.MainMenuScreen;

public class RobotWars extends Game {
	private static Logger logger = new Logger("RobotWars");

	@Override
	public void create () {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		logger.setLevel(Logger.DEBUG);

        AssetLoader.getInstance().load();
        setScreen(new MainMenuScreen(this));
	}

	@Override
	public void dispose() {
		AssetLoader.getInstance().dispose();
		super.dispose();
	}
}
