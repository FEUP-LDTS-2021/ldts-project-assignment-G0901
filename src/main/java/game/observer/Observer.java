package game.observer;

import game.Application;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public abstract class Observer {
    protected Application app;

    public abstract void update() throws UnsupportedAudioFileException, IOException, LineUnavailableException;
}
