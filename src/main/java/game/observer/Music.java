package game.observer;

import game.Application;
import game.states.game.GameState;
import game.states.menu.MenuState;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Music extends Observer {
    private Application app;
    private Clip clip;
    private URL menu_song;
    private URL game_song;
    private AudioInputStream ais;

    public Music(Application app) throws LineUnavailableException {
        this.app = app;
        menu_song = getClass().getResource("/sound/f1_theme_retro.wav");
        game_song = getClass().getResource("/sound/race_song.wav");
        clip = AudioSystem.getClip();
        app.addObserver(this);
    }

    public Music(Application app, Clip clip) {
        this.app = app;
        this.clip = clip;
        menu_song = getClass().getResource("/sound/f1_theme_retro.wav");
        game_song = getClass().getResource("/sound/race_song.wav");
    }

    @Override
    public void update() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.stop();
        clip.close();

        if (app.getState() instanceof GameState) {
            ais = AudioSystem.getAudioInputStream(game_song);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);


        }
        else if (app.getState() instanceof MenuState) {
            ais = AudioSystem.getAudioInputStream(menu_song);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            try {
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
            }
            catch (IllegalArgumentException ignored) {
            }
        }

    }

}
