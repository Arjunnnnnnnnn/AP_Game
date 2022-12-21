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

public class HUD implements Disposable {
    public Stage stage;
    private Viewport viewport;
    private Integer health1, health2;
    private static Integer power1, power2, angle1, angle2;
    Label healthlabel1;
    Label healthlabel2;
    Label powerlabel1;
    Label powerlabel2;
    Label anglelabel1;
    Label anglelabel2;

    public HUD(SpriteBatch sb){
        health1 = 100;
        health2 = 100;
        power1 = 50;
        power2 = 50;
        angle1 = 40;
        angle2 = 40;

        viewport = new FitViewport(1500, 750, new OrthographicCamera());
        stage = new Stage(viewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);

        healthlabel1 = new Label(String.format("Health: %03d", health1), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        healthlabel1.setPosition(10, 720);

        healthlabel2 = new Label(String.format("Health: %03d", health2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        healthlabel2.setPosition(1400, 720);

        powerlabel1 = new Label(String.format("Power: %03d", power1), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        powerlabel1.setPosition(10, 700);

        powerlabel2 = new Label(String.format("Power: %03d", power2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        powerlabel2.setPosition(1400, 700);

        anglelabel1 = new Label(String.format("Angle: %03d", angle1), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        anglelabel1.setPosition(10, 680);

        anglelabel2 = new Label(String.format("Angle: %03d", angle2), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        anglelabel2.setPosition(1400, 680);

        stage.addActor(healthlabel1);
        stage.addActor(healthlabel2);
        stage.addActor(powerlabel1);
        stage.addActor(powerlabel2);
        stage.addActor(anglelabel1);
        stage.addActor(anglelabel2);


    }


    public void updateAngle1(int angle){
        angle1 = angle;
        anglelabel1.setText(String.format("Angle: %03d", angle1));
    }

    public void updateAngle2(int angle){
        angle2 = angle;
        anglelabel2.setText(String.format("Angle: %03d", angle2));
    }

    public void updatePowe1(int power){
        power1 = power;
        powerlabel1.setText(String.format("Power: %03d", power1));
    }

    public void updatePowe2(int power){
        power2 = power;
        powerlabel2.setText(String.format("Power: %03d", power2));
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
