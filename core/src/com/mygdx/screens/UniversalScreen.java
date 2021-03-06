package com.mygdx.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.info.Configuration;
import com.mygdx.lang_helpers.ExtendedShapeRenderer;

public abstract class UniversalScreen implements Screen, InputProcessor {
    protected Game game;
    protected OrthographicCamera camera;
    protected SpriteBatch batcher;
    protected ExtendedShapeRenderer shapeRenderer;

    protected float scaleX;
    protected float scaleY;

    public UniversalScreen(Game game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(true, Configuration.windowWidth, Configuration.windowHeight);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
        shapeRenderer = new ExtendedShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        Gdx.input.setInputProcessor(this);

        this.scaleX = Configuration.windowWidth / (float)Gdx.graphics.getWidth();
        this.scaleY = Configuration.windowHeight / (float)Gdx.graphics.getHeight();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        this.scaleX = Configuration.windowWidth / (float)Gdx.graphics.getWidth();
        this.scaleY = Configuration.windowHeight / (float)Gdx.graphics.getHeight();
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        this.scaleX = Configuration.windowWidth / (float)Gdx.graphics.getWidth();
        this.scaleY = Configuration.windowHeight / (float)Gdx.graphics.getHeight();
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
