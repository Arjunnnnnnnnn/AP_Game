package com.tankstars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tankstars.game.TankStars;

public class StartScreen implements Screen {

    private TankStars game;
    private Stage stage;
    private Texture texture;
    private Viewport viewport;


    public StartScreen(TankStars game){
        this.game = game;
        viewport = new FitViewport((TankStars.v_width) / TankStars.PPM, (TankStars.v_height) / TankStars.PPM, new OrthographicCamera());
        texture = new Texture("StartScreen.png");
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(texture, 0, 0);
        game.batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            game.setScreen(new MenuScreen1(game));
            dispose();
        }

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
        texture.dispose();
    }
}
