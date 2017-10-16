package com.brettzonick.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.BooleanArray;
import com.badlogic.gdx.utils.IntFloatMap;
import com.brettzonick.game.game.world.GetInput;
import com.brettzonick.game.screens.GameScreen;
import com.brettzonick.game.screens.MainMenuScreen;

public class Garbageman extends Game {
	public SpriteBatch batch;
	public static final int window_height = 720;
	public static final int window_width = 1280;
	@Override
	public void create () {
        //this.create();
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));

		//Gdx.input.setInputProcessor(new GetInput());
	}

	@Override
	public void render () {
       // this.render();
		super.render();


	}
	
	/*@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	*/


}
