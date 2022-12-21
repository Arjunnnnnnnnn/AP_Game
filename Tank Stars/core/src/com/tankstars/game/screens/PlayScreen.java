package com.tankstars.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tankstars.game.TankStars;
import com.tankstars.game.scenes.HUD;
import com.tankstars.game.sprite.Projectile;
import com.tankstars.game.sprite.Tank;
import com.tankstars.game.tools.B2WorldCreater;


public class PlayScreen implements Screen {
    private TankStars game;
    private OrthographicCamera gamecam;
    private Viewport gameport;
    private HUD hud;

    private TmxMapLoader maploader;

    private OrthogonalTiledMapRenderer maprenderer;
    private TiledMap map;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Tank player1, player2;
    private Projectile projectile;
    private Texture tankpic1, tankpic2;


    private int p1tank;
    int p, jump, power1, power2;
    int angle1, angle2;

    public PlayScreen(TankStars game, int p1tank, int p2tank) {
        this.game = game;
        gamecam = new OrthographicCamera();
        gameport = new FitViewport((TankStars.v_width) / TankStars.PPM, (TankStars.v_height) / TankStars.PPM, gamecam);
        hud = new HUD(game.batch);

        maploader = new TmxMapLoader();
        map = maploader.load("Map1.tmx");
        maprenderer = new OrthogonalTiledMapRenderer(map, 1 / TankStars.PPM);
        gamecam.position.set(gameport.getWorldWidth() / 2, gameport.getWorldHeight() / 2, 0);

        world = new World(new Vector2(0, -10), true);
        b2dr = new Box2DDebugRenderer();

        if (p1tank == 1)
            tankpic1 = new Texture("tank1.png");
        else if (p1tank == 2)
            tankpic1 = new Texture("tank2.png");
        else if (p1tank == 3)
            tankpic1 = new Texture("tank3.png");

        if (p2tank == 1)
            tankpic2 = new Texture("tank1.png");
        else if (p2tank == 2)
            tankpic2 = new Texture("tank2.png");
        else if (p2tank == 3)
            tankpic2 = new Texture("tank3.png");



        player1 = new Tank(world, tankpic1, true);
        player1.defineTank(200, 400);

        player2 = new Tank(world, tankpic2, false);
        player2.defineTank(1300, 400);

        p = 1;
        jump = 2;
        angle1 = 40;
        power1 = 50;
        angle2 = 40;
        power2 = 50;

        new B2WorldCreater(world, map, gamecam);

    }





    @Override
    public void show() {

    }

    public void handleInput(float dt){
        if(p == 1){
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && jump > 0){
                player1.body.applyLinearImpulse(new Vector2(0,5f), player1.body.getWorldCenter(), true);
                jump -= 1;
            }


            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                player1.body.applyLinearImpulse(new Vector2(0.05f,0), player1.body.getWorldCenter(), true);
            }


            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                player1.body.applyLinearImpulse(new Vector2(-0.05f,0), player1.body.getWorldCenter(), true);
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                if (angle1 < 180 ){
                    angle1 += 5;
                    hud.updateAngle1(angle1);
                }
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                if (angle1 >= 0){
                    angle1 += -5;
                    hud.updateAngle1(angle1);
                }
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                if (power1 < 100){
                    power1 += 5;
                    hud.updatePowe1(power1);
                }
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
                if (power1 > 0){
                    power1 += -5;
                    hud.updatePowe1(power1);
                }
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
                projectile = new Projectile(world);
                projectile.defineProjectile(player1.body.getPosition().x, player1.body.getPosition().y + (2 / TankStars.PPM));
                double dx = power1*Math.cos(Math.toRadians(angle1));
                double dy = power1*Math.sin(Math.toRadians(angle1));
                float x = (float) dx;
                float y = (float) dy;
                projectile.body.applyLinearImpulse(new Vector2(x, y), projectile.body.getWorldCenter(), true);
                p = 2;
                jump = 2;
            }
        }
        else if (p == 2){
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && jump > 0){
                player2.body.applyLinearImpulse(new Vector2(0,5f), player1.body.getWorldCenter(), true);
                jump -= 1;
            }


            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                player2.body.applyLinearImpulse(new Vector2(0.05f,0), player1.body.getWorldCenter(), true);
            }


            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                player2.body.applyLinearImpulse(new Vector2(-0.05f,0), player1.body.getWorldCenter(), true);
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                if (angle2 < 180 ){
                    angle2 += 5;
                    hud.updateAngle2(angle2);
                }
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                if (angle2 >= 0){
                    angle2 += -5;
                    hud.updateAngle2(angle2);
                }
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
                if (power2 < 100){
                    power2 += 5;
                    hud.updatePowe2(power2);
                }
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
                if (power2 > 0){
                    power2 += -5;
                    hud.updatePowe2(power2);
                }
            }

            if (Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
                p = 1;
                jump = 2;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE))
            game.setScreen(new MenuScreen1(game));
    }

    public void update(float dt){
        handleInput(dt);

        world.step(1/60f, 6, 2);

        player1.update(dt);
        player2.update(dt);

        gamecam.update();
        maprenderer.setView(gamecam);
    }


    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        maprenderer.render();

        b2dr.render(world, gamecam.combined);

        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        player1.draw(game.batch);
        player2.draw(game.batch);
        game.batch.end();

        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);
        hud.stage.draw();


    }

    @Override
    public void resize(int width, int height) {
        gameport.update(width, height);
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
        map.dispose();
        world.dispose();
        maprenderer.dispose();
        b2dr.dispose();
        hud.dispose();
    }
}
