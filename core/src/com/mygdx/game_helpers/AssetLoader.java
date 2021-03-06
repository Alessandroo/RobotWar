package com.mygdx.game_helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.info.Configuration;

import java.util.HashMap;


public class AssetLoader {
    // Singleton
    private static AssetLoader instance;

    private AssetLoader() {
    }

    public static AssetLoader getInstance() {
        if (instance == null) {
            instance = new AssetLoader();
        }
        return instance;
    }

    private HashMap<Integer, Texture> backgroundTextures;
    public HashMap<Integer, TextureRegion> backgrounds;

    private Texture robotTilesTexture;
    public HashMap<String, TextureRegion> robotTiles;
    private Texture robotsTexture;
    public HashMap<String, Animation> robots;
    public Animation mineBotExplosing;

    private Texture enemiesTexture;
    public HashMap<String, Animation> enemies;
    public Animation simpleEnemyFall;

    private Texture bulletsTexture;
    public HashMap<String, TextureRegion> bullets;
    public TextureRegion littleGem;
    public TextureRegion bigGem;
    public TextureRegion heart;
    public TextureRegion gemIcon;

    private Texture mainMenuBackgroundTexture;
    public TextureRegion mainMenuBackground;

    private Texture menuIconsTexture;
    public TextureRegion levelTile;
    public TextureRegion lockedLevel;
    public TextureRegion toMenu;
    public TextureRegion nextLevel;
    public TextureRegion replayLevel;
    public TextureRegion enemyTimeScale;
    public TextureRegion enemyTimeFiller;

    private Texture effectsTexture;
    public Animation explose;


    // Music and sounds
    public Music menuMusic;
    public Music gameMusic;
    public Music selectLevelMusic;
    public Sound explosionSound;
    public Sound gemSound;
    public Sound shotSound;
    public Sound iceShotSound;


    public void load() {
        backgroundTextures = new HashMap<Integer, Texture>();
        backgrounds = new HashMap<Integer, TextureRegion>();

        // Load textures from disk
        robotTilesTexture = new Texture(Gdx.files.internal("gui/robot_tiles.png"));
        robotsTexture = new Texture(Gdx.files.internal("robots/robots.png"));
        enemiesTexture = new Texture(Gdx.files.internal
                ("enemies/enemies.png"));
        bulletsTexture = new Texture(Gdx.files.internal("littles/littles.png"));
        mainMenuBackgroundTexture = new Texture(Gdx.files.internal
                ("backgrounds/main_menu_background_stub.png"));
        menuIconsTexture = new Texture(Gdx.files.internal
                ("gui/menu_icons.png"));
        effectsTexture = new Texture(Gdx.files.internal
                ("effects/effects.png"));

        // Load robot tiles
        robotTiles = new HashMap<String, TextureRegion>();
        robotTiles.put("GemBot", new TextureRegion(robotTilesTexture, 75, 0,
                75, 82));
        robotTiles.get("GemBot").flip(false, true);
        robotTiles.put("GunnerBot", new TextureRegion(robotTilesTexture, 0,
                0, 75, 82));
        robotTiles.get("GunnerBot").flip(false, true);
        robotTiles.put("AirBot", new TextureRegion(robotTilesTexture, 225,
                0, 75, 82));
        robotTiles.get("AirBot").flip(false, true);
        robotTiles.put("ShieldBot", new TextureRegion(robotTilesTexture, 150,
                0, 75, 82));
        robotTiles.get("ShieldBot").flip(false, true);
        robotTiles.put("MineBot", new TextureRegion(robotTilesTexture, 300,
                0, 75, 82));
        robotTiles.get("MineBot").flip(false, true);
        robotTiles.put("IceBot", new TextureRegion(robotTilesTexture, 375,
                0, 75, 82));
        robotTiles.get("IceBot").flip(false, true);

        // Load bullets
        bullets = new HashMap<String, TextureRegion>();
        bullets.put("GunnerBotBullet", new TextureRegion(bulletsTexture, 222,
                14, 50, 32));
        bullets.put("HelicopterEnemyBomb", new TextureRegion(bulletsTexture,
                292, 2, 51, 61));
        bullets.put("IceBotBullet", new TextureRegion(bulletsTexture,
                348, 0, 105, 54));

        bullets.get("GunnerBotBullet").flip(false, true);
        bullets.get("HelicopterEnemyBomb").flip(false, true);
        bullets.get("IceBotBullet").flip(false, true);

        // Load main menu
        mainMenuBackground = new TextureRegion(mainMenuBackgroundTexture, 0,
                0, Configuration.windowWidth, Configuration.windowHeight);
        mainMenuBackground.flip(false, true);
        levelTile = new TextureRegion(menuIconsTexture, 0, 0, 75, 75);
        levelTile.flip(false, true);
        lockedLevel = new TextureRegion(menuIconsTexture, 75, 0, 75, 75);
        lockedLevel.flip(false, true);

        // Load winscreen icons
        toMenu = new TextureRegion(menuIconsTexture, 0, 84, 142, 142);
        toMenu.flip(false, true);
        nextLevel = new TextureRegion(menuIconsTexture, 142, 84, 142,
                142);
        nextLevel.flip(false, true);
        replayLevel = new TextureRegion(menuIconsTexture, 142 * 2, 84, 142,
                142);
        replayLevel.flip(false, true);

        // Load gems
        littleGem = new TextureRegion(bulletsTexture, 140, 0, 64, 64);
        littleGem.flip(false, true);
        bigGem = new TextureRegion(bulletsTexture, 63, 0, 71, 61);
        bigGem.flip(false, true);

        // Load hud icons
        heart = new TextureRegion(bulletsTexture, 0, 0, 56, 56);
        heart.flip(false, true);
        gemIcon = new TextureRegion(bulletsTexture, 463, 0, 40, 64);
        gemIcon.flip(false, true);
        enemyTimeScale = new TextureRegion(menuIconsTexture, 177, 24, 401, 27);
        enemyTimeScale.flip(false, true);
        enemyTimeFiller = new TextureRegion(menuIconsTexture, 179, 57, 378, 12);
        enemyTimeFiller.flip(false, true);

        // Load enemies
        enemies = new HashMap<String, Animation>();
        // Load simple enemy frames
        int width = 198;
        int height = 150;
        TextureRegion[] simpleEnemyFrames = {new TextureRegion
                (enemiesTexture, 0, 0, width, height), new TextureRegion
                (enemiesTexture, width, 0, width, height), new TextureRegion
                (enemiesTexture, width * 2, 0, width, height), new TextureRegion
                (enemiesTexture, width * 3, 0, width, height)};

        for (TextureRegion frame : simpleEnemyFrames) {
            frame.flip(false, true);
        }

        Animation simpleEnemyAnimation = new Animation(0.3f, simpleEnemyFrames);
        simpleEnemyAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        enemies.put("SimpleEnemy", simpleEnemyAnimation);

        // Load simple enemy destroying frames
        width = 250;
        height = 150;
        TextureRegion[] simpleEnemyFallFrames = new TextureRegion[6];
        for (int i = 0; i < 6; i++) {
            TextureRegion frame = new TextureRegion(enemiesTexture, width * i,
                    151, width, height);
            frame.flip(false, true);
            simpleEnemyFallFrames[i] = frame;
        }

        simpleEnemyFall = new Animation(0.1f, simpleEnemyFallFrames);
        simpleEnemyFall.setPlayMode(Animation.PlayMode.NORMAL);

        // Load helicopter enemy frames
        width = 150;
        height = 90;
        TextureRegion[] helicopterEnemyFrames = new TextureRegion[5];
        for (int i = 0; i < 5; i++) {
            TextureRegion frame = new TextureRegion(enemiesTexture, width * i,
                    404, width, height);
            frame.flip(false, true);
            helicopterEnemyFrames[i] = frame;
        }

        Animation helicopterEnemyAnimation = new Animation(0.2f, helicopterEnemyFrames);
        helicopterEnemyAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        enemies.put("HelicopterEnemy", helicopterEnemyAnimation);

        // Load bomb helicopter enemy frames
        width = 150;
        height = 90;
        TextureRegion[] helicopterBombEnemyFrames = new TextureRegion[5];
        for (int i = 0; i < 5; i++) {
            TextureRegion frame = new TextureRegion(enemiesTexture, width * i,
                    494, width, height);
            frame.flip(false, true);
            helicopterBombEnemyFrames[i] = frame;
        }

        Animation helicopterBombEnemyAnimation = new Animation(0.2f,
                helicopterBombEnemyFrames);
        helicopterBombEnemyAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        enemies.put("HelicopterBombEnemy", helicopterBombEnemyAnimation);

        // Load robot animations
        robots = new HashMap<String, Animation>();

        // Load GunnerBot animation
        TextureRegion[] gunnerBotFrames = new TextureRegion[7];
        for (int i = 0; i < 7; i++) {
            TextureRegion frame = new TextureRegion(robotsTexture, 100 * i,
                    0, 100, 100);
            frame.flip(false, true);
            gunnerBotFrames[i] = frame;
        }

        Animation gunnerbotAnimation = new Animation(0.2f, gunnerBotFrames);
        gunnerbotAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        robots.put("GunnerBot", gunnerbotAnimation);

        // Load GemBot animation
        TextureRegion[] gemBotFrames = new TextureRegion[7];
        for (int i = 0; i < 7; i++) {
            TextureRegion frame = new TextureRegion(robotsTexture, 100 * i,
                    100, 100, 100);
            frame.flip(false, true);
            gemBotFrames[i] = frame;
        }

        Animation gembotAnimation = new Animation(0.2f, gemBotFrames);
        gembotAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        robots.put("GemBot", gembotAnimation);

        // Load AirBot animation
        TextureRegion[] airBotFrames = new TextureRegion[5];
        for (int i = 0; i < 5; i++) {
            TextureRegion frame = new TextureRegion(robotsTexture, 100 * i,
                    200, 100, 100);
            frame.flip(false, true);
            airBotFrames[i] = frame;
        }

        Animation airBotAnimation = new Animation(0.2f, airBotFrames);
        airBotAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        robots.put("AirBot", airBotAnimation);

        // Load ShieldBot animation
        TextureRegion[] shieldBotFrames = new TextureRegion[5];
        for (int i = 0; i < 5; i++) {
            TextureRegion frame = new TextureRegion(robotsTexture, 100 * i,
                    300, 100, 100);
            frame.flip(false, true);
            shieldBotFrames[i] = frame;
        }

        Animation shieldBotAnimation = new Animation(0.2f, shieldBotFrames);
        shieldBotAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        robots.put("ShieldBot", shieldBotAnimation);

        // Load MineBot animation
        TextureRegion[] mineBotFrames = new TextureRegion[5];
        for (int i = 0; i < 5; i++) {
            TextureRegion frame = new TextureRegion(robotsTexture, 100 * i,
                    400, 100, 100);
            frame.flip(false, true);
            mineBotFrames[i] = frame;
        }

        Animation mineBotAnimation = new Animation(0.2f, mineBotFrames);
        mineBotAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        robots.put("MineBot", mineBotAnimation);

        TextureRegion[] mineBotExploseFrames = new TextureRegion[5];
        for (int i = 0; i < 5; i++) {
            TextureRegion frame = new TextureRegion(robotsTexture, 100 * i,
                    500, 100, 100);
            frame.flip(false, true);
            mineBotExploseFrames[i] = frame;
        }

        mineBotExplosing = new Animation(0.1f, mineBotExploseFrames);
        mineBotExplosing.setPlayMode(Animation.PlayMode.NORMAL);

        // Load IceBot animation
        TextureRegion[] iceBotFrames = new TextureRegion[5];
        for (int i = 0; i < 5; i++) {
            TextureRegion frame = new TextureRegion(robotsTexture, 100 * i,
                    600, 100, 100);
            frame.flip(false, true);
            iceBotFrames[i] = frame;
        }

        Animation iceBotAnimation = new Animation(0.2f, iceBotFrames);
        iceBotAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        robots.put("IceBot", iceBotAnimation);


        // Load effects animations
        TextureRegion[] explosingFrames = new TextureRegion[16];
        int k = 0;
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                TextureRegion frame = new TextureRegion(effectsTexture, 64 * j,
                        64 * i, 64, 64);
                frame.flip(false, true);
                explosingFrames[k] = frame;
                k++;
            }
        }

        explose = new Animation(0.1f, explosingFrames);
        explose.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);


        // Load music and sounds
        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/menu.mp3"));
        selectLevelMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/levels.mp3"));
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/game.mp3"));
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.mp3"));
        gemSound = Gdx.audio.newSound(Gdx.files.internal("sounds/gem.mp3"));
        shotSound = Gdx.audio.newSound(Gdx.files.internal("sounds/shot.mp3"));
        iceShotSound = Gdx.audio.newSound(Gdx.files.internal("sounds/ice_shot.mp3"));
    }

    public void dispose() {
        for (Integer key : backgroundTextures.keySet()) {
            backgroundTextures.get(key).dispose();
        }

        robotTilesTexture.dispose();
        robotsTexture.dispose();
        enemiesTexture.dispose();
        bulletsTexture.dispose();
        mainMenuBackgroundTexture.dispose();
        menuIconsTexture.dispose();
        effectsTexture.dispose();

        menuMusic.dispose();
        selectLevelMusic.dispose();
        gameMusic.dispose();
        explosionSound.dispose();
        gemSound.dispose();
        shotSound.dispose();
        iceShotSound.dispose();
    }

    public void disposeBackgroundsExcept(int levelNumber) {
        for (Integer key : backgroundTextures.keySet()) {
            if (key != levelNumber) {
                backgroundTextures.get(key).dispose();
                backgroundTextures.remove(key);
                backgrounds.remove(key);
            }
        }
    }

    public TextureRegion getLevelBackground(int levelNumber) {
        if (!backgroundTextures.containsKey(levelNumber) || !backgrounds
                .containsKey(levelNumber)) {
            backgroundTextures.put(levelNumber, new Texture(Gdx.files.internal
                    ("backgrounds/level" + levelNumber + ".png")));
            TextureRegion background = new TextureRegion(backgroundTextures.get
                    (levelNumber));
            background.flip(false, true);
            backgrounds.put(levelNumber, background);
        }
        return backgrounds.get(levelNumber);
    }
}
