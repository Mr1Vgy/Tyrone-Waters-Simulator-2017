package com.brettzonick.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.brettzonick.game.Garbageman;

/**
 * Created by dpearson6225 on 9/25/2017.
 */

public class GameScreen implements Screen{

    Texture img;
    public static float x, y;
    public static final int SPEED = 1000;
    Garbageman game;
    boolean resetOnOpen = true;

    public GameScreen(Garbageman game){
        this.game = game;

    }

    @Override
    public void show() {
        System.out.println("");
        if (img == null) {
            img = new Texture("assets/tyrone.jpg");
            if (resetOnOpen) {
                x = 0;
                y = 0;
            }
        }
    }


    public static void move(float newx, float newy){
        x+= newx;
        y+= newy;
    }
    @Override
    public void render(float delta) {
        //System.out.println("" + Gdx.graphics.getDeltaTime());
        float plus = SPEED * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            move(plus, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){
            move(-plus, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            move(0, plus);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            move(0, -plus);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.G)){
            game.setScreen(new MainMenuScreen(game));
        }

        if (this.x > game.window_width){
            this.x = 0-img.getWidth();
        }
        else if (this.x < 0-img.getWidth()){
            this.x = game.window_width-img.getWidth()+img.getWidth();
        }
        if (this.y > game.window_height){
            this.y = 0-img.getHeight();
        }
        else if (this.y < 0-img.getHeight()){
            this.y = game.window_height-img.getHeight()+img.getHeight();
        }

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(img, x, y);
        game.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
