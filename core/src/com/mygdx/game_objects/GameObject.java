package com.mygdx.game_objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game_helpers.AssetLoader;

import java.io.Serializable;


public abstract class GameObject implements IRenderable, Serializable {
    protected Vector2 velocity;
    protected Vector2 acceleration;
    protected Rectangle rect;
    protected Rectangle collisionRect;
    protected String name;

    public GameObject(float x, float y, float width, float height) {
        this.rect = new Rectangle(x, y, width, height);
        this.collisionRect = new Rectangle(x, y, width, height);
        this.velocity = new Vector2(0, 0);
        this.acceleration = new Vector2(0, 0);
    }

    public float getWidth() {
        return rect.width;
    }

    public float getHeight() {
        return rect.height;
    }

    public float getX() {
        return rect.x;
    }

    public float getY() {
        return rect.y;
    }

    public Rectangle getRect() {
        return rect;
    }

    public Rectangle getCollisionRect() {
        return collisionRect;
    }

    public void setPosition(float x, float y) {
        float dx = rect.x - collisionRect.x;
        float dy = rect.y - collisionRect.y;
        rect.x = x;
        rect.y = y;
        collisionRect.x = x - dx;
        collisionRect.y = y - dy;
    }

    public boolean contains(float x, float y) {
        return rect.contains(x, y);
    }

    public void update(float delta) {
        rect.x += delta * velocity.x;
        collisionRect.x += delta * velocity.x;
        rect.y += delta * velocity.y;
        collisionRect.y += delta * velocity.y;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocityX, float velocityY) {
        velocity.x = velocityX;
        velocity.y = velocityY;
    }
}
