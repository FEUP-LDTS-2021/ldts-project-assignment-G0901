package game.observer;

import game.Application;
import game.states.game.GameState;
import game.states.menu.MenuState;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Music extends Observer {
    Application app;
    Clip clip;
    URL menu_song;
    URL game_song;

    public Music(Application app) throws LineUnavailableException {
        this.app = app;
        menu_song = getClass().getResource("/sound/f1_theme_retro.wav");
        game_song = getClass().getResource("/sound/race_song.wav");
        clip = AudioSystem.getClip();
        app.addObserver(this);
    }

    @Override
    public void update() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        clip.stop();
        clip.close();

        if (app.getState() instanceof GameState) {
            AudioInputStream ais = AudioSystem.getAudioInputStream(game_song);
            clip = AudioSystem.getClip();
            clip.open(ais);
            clip.start();

        }
        else if (app.getState() instanceof MenuState) {
            AudioInputStream ais2 = AudioSystem.getAudioInputStream(menu_song);
            clip = AudioSystem.getClip();
            clip.open(ais2);
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
