package com.tankstars.game.tools;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.tankstars.game.TankStars;

public class B2WorldCreater {

    public B2WorldCreater(World world, TiledMap map, OrthographicCamera gamecam){
        Viewport gameport = new FitViewport((TankStars.v_width) / TankStars.PPM, (TankStars.v_height) / TankStars.PPM, gamecam);

        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for (MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / TankStars.PPM, (rect.getY() + rect.getHeight() / 2) / TankStars.PPM);

            body = world.createBody(bdef);

            shape.setAsBox((rect.getWidth() / 2) / TankStars.PPM, (rect.getHeight() / 2) / TankStars.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

//        for (MapObject object : map.getLayers().get(2).getObjects().getByType(PolygonMapObject.class)){
//            PolygonMapObject poly = (PolygonMapObject) object;
//            float[] vertices = poly.getPolygon().getTransformedVertices();
//            float scalex = gameport.getScreenHeight()/gameport.getWorldWidth() / TankStars.PPM;
//            float scaley = gameport.getScreenHeight()/gameport.getWorldHeight() / TankStars.PPM;
//            Vector2 centroid = new Vector2(((vertices[0] + vertices[2] + vertices[4]) / 3 * scalex) / TankStars.PPM, ((vertices[1] + vertices[3] + vertices[5]) / 3 * scaley) / TankStars.PPM);
//            Vector2[] worldvertices = new Vector2[3];
//
//            for (int i = 0; i < 3; i++){
//                Vector2 current = new Vector2((vertices[i*2]) / TankStars.PPM, (vertices[i*2+1]) / TankStars.PPM);
//                worldvertices[i] = current;
//            }

//            shape.set(worldvertices);
//            bdef.type = BodyDef.BodyType.StaticBody;
//            bdef.position.set(centroid);
//            body = world.createBody(bdef);
//
//            fdef.shape = shape;
//            body.createFixture(fdef);
//        }

    }
}
