package com.brettzonick.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.loaders.BitmapFontLoader;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.brettzonick.game.Garbageman;
import com.brettzonick.game.game.world.GestureHandler;
import com.brettzonick.game.game.world.GetInput;

/**
 * Created by dpearson6225 on 9/25/2017.
 */

public class MainMenuScreen implements Screen {
    Garbageman game;

    Texture playButtonActive;
    Texture playButtonInactive;

    private Stage stage = new Stage();
    private TextureAtlas atlas;
    private Skin skin;
    private Table table;
    private BitmapFont font;
   // private TextButton playButton;
    private TextButton.TextButtonStyle bbstyle;
    private ImageButton playButton;
    private final int pbHeight = 250;
    private final int pbWidth = 350;
    Image TEST;

    public MainMenuScreen(Garbageman game){
        InputProcessor inputProcessorOne = new GetInput();
        InputProcessor inputProcessorTwo = new GestureDetector(new GestureHandler());
        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(inputProcessorOne);
        inputMultiplexer.addProcessor(inputProcessorTwo);
        Gdx.input.setInputProcessor(inputMultiplexer);
        this.game = game;
        playButtonActive = new Texture("assets/playButton.png");
        playButtonInactive = new Texture("assets/playButtonActive.png");
    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(stage);

       /* font = new BitmapFont(Gdx.files.internal("assets/font1.fnt"));
        skin = new Skin();

        stage = new Stage(new ScreenViewport());
        playButton = new TextButton("PLAY", skin);*/


       // skin = new Skin();
       // skin.add("test", new Texture("assets/playButton.png"));
       //bbstyle = skin.get("playButton", TextButton.TextButtonStyle.class);
      // playButton = new TextButton("Play", skin)
       /* skin = new Skin();
        skin.add("test", new Texture("assets/playButton.png"));
        TEST = new Image(skin, "test");*/

        Skin playButtonSkin = new Skin();
        playButtonSkin.add("play", new Texture("assets/playButton.png"));
        playButtonSkin.add("playDown", new Texture("assets/playButtonActive.png"));

        ImageButton.ImageButtonStyle playImgStyle = new ImageButton.ImageButtonStyle();
        playImgStyle.imageUp = playButtonSkin.getDrawable("play");
        playImgStyle.imageDown = playButtonSkin.getDrawable("playDown");

        playButton = new ImageButton(playImgStyle);
        playButton.setSize(pbWidth, pbHeight);
        playButton.setPosition( (game.window_width-pbWidth)/2, (game.window_height-pbHeight)/2);
        playButton.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game));
                return true;
            }
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("UP");
            }
        });
        playButton.setVisible(true);


        System.out.println("called");
    }

    @Override
    public void render(float delta) {



        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //stage.addActor(TEST);
        stage.addActor(playButton);
        game.batch.begin();


       /* TEST.setPosition(150, 150);
        TEST.addListener(new ClickListener(){
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                TEST.moveBy(x-TEST.getWidth()/2, y- TEST.getHeight()/2);
            }
        });*/
      //  game.batch.draw(playButtonActive, (Garbageman.window_width-350)/2, (Garbageman.window_height-150)/2);


        //System.out.println(Gdx.input.getX());



        if (Gdx.input.isKeyPressed(Input.Keys.Q)){
            Gdx.app.exit();
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.F)){
            game.setScreen(new GameScreen(game));
        }

        stage.draw();
        game.batch.end();//leave this at the end
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
