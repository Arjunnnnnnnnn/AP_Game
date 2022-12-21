package com.tankstars.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;
import com.tankstars.game.TankStars;
import com.tankstars.game.screens.PlayScreen;

public class Projectile{

    public World world;
    public Body body;
    private  int speed;
    private  Texture texture;
    private Tank tank;

    float x, y;

    public boolean remove = false;

    public Projectile(World world){
        this.world = world;
        defineProjectile(x, y);

    }

    public void defineProjectile(float x, float y){
        BodyDef bdef = new BodyDef();
        bdef.position.set(x / TankStars.PPM, y / TankStars.PPM);
        CircleShape shape = new CircleShape();
        shape.setRadius(5 / TankStars.PPM);
        body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        fdef.shape = shape;
        body.createFixture(fdef);
    }

    public void update (float dt){

    }

}
