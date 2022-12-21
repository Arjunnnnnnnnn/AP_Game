package com.tankstars.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import com.tankstars.game.TankStars;

public class Tank extends Sprite {
    public World world;
    public Body body;
    private Texture tankpic;
    private int x, y;
    private boolean runningRight;

    public Tank(World world, Texture pic, boolean right){
        this.world = world;

        runningRight = right;

        defineTank(x, y);
        tankpic = pic;
        setBounds(0, 0, 25 / TankStars.PPM, 25 / TankStars.PPM);
        setRegion(tankpic);
    }

    public void update(float dt){
        setPosition(body.getPosition().x - (getWidth() / 2), body.getPosition().y - (getHeight() / 2));

        if((body.getLinearVelocity().x < 0 || !runningRight) && !isFlipX()){
            flip(true, false);
            runningRight = false;
        }
        else if ((body.getLinearVelocity().x > 0 || runningRight) && isFlipX()){
            flip(true, false);
            runningRight = true;
        }
    }

    public void defineTank(float x, float y){
        BodyDef bdef = new BodyDef();
        bdef.position.set(x / TankStars.PPM, y / TankStars.PPM);
        bdef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(10 / TankStars.PPM, 6 / TankStars.PPM);

        fdef.shape =shape;
        body.createFixture(fdef);
    }
}
