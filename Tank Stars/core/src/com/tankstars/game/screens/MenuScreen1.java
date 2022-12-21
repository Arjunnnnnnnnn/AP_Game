package com.tankstars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.tankstars.game.TankStars;
import com.tankstars.game.scenes.MenuHUD;

public class MenuScreen1 implements Screen {

    private TankStars game;
    private Texture bg, tank1, tank2, tank3, start;
    public int p1tank, p;

    private MenuHUD menuHUD;
    public MenuScreen1(TankStars game){
        this.game = game;
        menuHUD = new MenuHUD(game.batch);

        bg = new Texture("MainMenuBg.png");
        tank1 = new Texture("tank1.png");
        tank2 = new Texture("tank2.png");
        tank3 = new Texture("tank3.png");
        start = new Texture("StartPlayButton.png");

        p1tank = 1;
        p = 1;

    }


    public void handleInput(float dt){
        if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
            if(p1tank < 3)
                p1tank += 1;
            menuHUD.update(p1tank);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
            if (p1tank > 1)
                p1tank -= 1;
            menuHUD.update(p1tank);
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            menuHUD.update(p1tank);
            game.setScreen(new MenuScreen2(game, p1tank));
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            game.setScreen(new StartScreen(game));
    }

    public void update(float dt){
        handleInput(dt);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        update(delta);

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();
        game.batch.draw(bg, 0, 0);
        game.batch.draw(tank1,250,540, 400, 240);
        game.batch.draw(tank2,250,290, 400, 240);
        game.batch.draw(tank3,250,40, 400, 240);
        game.batch.draw(start, 1100, 300, 300, 80);
        game.batch.end();

        game.batch.setProjectionMatrix(menuHUD.stage.getCamera().combined);
        menuHUD.stage.draw();
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
        bg.dispose();
        tank1.dispose();
        tank2.dispose();
        tank3.dispose();
        menuHUD.dispose();
    }
}
