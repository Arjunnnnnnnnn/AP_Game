package com.tankstars.game.scenes;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;




public class MenuHUD implements Disposable {

    public Stage stage;
    private Viewport viewport;

    Label playernum;
    static Label tank;
    Label tank1;
    Label tank2;
    Label tank3;


    public MenuHUD(SpriteBatch sb){

        viewport = new FitViewport(1500, 750, new OrthographicCamera());
        stage = new Stage(viewport, sb);


        playernum = new Label(String.format("Player 1"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        playernum.setFontScale(4);
        playernum.setSize(100, 30);
        playernum.setPosition(1150, 650);


        tank = new Label(String.format("Tank 1"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        tank.setFontScale(3);
        tank.setSize(100, 30);
        tank.setPosition(1200, 550);



        tank1 = new Label(String.format("Tank 1"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        tank1.setFontScale(2);
        tank1.setSize(100, 30);
        tank1.setPosition(660, 650);


        tank2 = new Label(String.format("Tank 2"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        tank2.setFontScale(2);
        tank2.setSize(100, 30);
        tank2.setPosition(660, 400);


        tank3 = new Label(String.format("Tank 3"), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        tank3.setFontScale(2);
        tank3.setSize(100, 30);
        tank3.setPosition(660, 150);


        Table table = new Table();
        table.setFillParent(true);

        table.add(playernum);
        table.add(tank);
        table.add(tank1);
        table.add(tank2);
        table.add(tank3);


        stage.addActor(playernum);
        stage.addActor(tank);
        stage.addActor(tank1);
        stage.addActor(tank2);
        stage.addActor(tank3);


    }


    public static void update(int t){
        if (t == 1)
            tank.setText(String.format("Tank 1"));
        else if (t == 2)
            tank.setText(String.format("Tank 2"));
        else if (t == 3)
            tank.setText(String.format("Tank 3"));
    }

    public void updatePlayer(){
        playernum.setText(String.format("Player 2"));
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
