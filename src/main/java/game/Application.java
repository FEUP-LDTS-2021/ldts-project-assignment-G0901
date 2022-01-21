package game;

import com.googlecode.lanterna.TerminalSize;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.observer.Music;
import game.observer.Observer;
import game.states.State;
import game.states.menu.MenuState;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private TerminalSize size = new TerminalSize(180,80);
    private State state;
    private GUI gui;
    private Music music;
    private List<Observer> observers;

    public Application() throws LineUnavailableException {
        observers = new ArrayList<>();
        this.state = new MenuState(new MenuModel());
        this.gui = new GUI(size);
        music = new Music(this);
    }

    public static void main(String[] args) throws IOException, LineUnavailableException {
        new Application().run();
    }

    private void run() throws IOException {
        setState(state);
        int FPS = 1;
        int frameTime = 60 / FPS;

        while (this.state != null)  {
            long startTime = System.currentTimeMillis();

            state.step(this, gui);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {}
        }

        gui.getScreen().stopScreen();
        System.exit(0);
    }

    public void setState(State state) {
        this.state = state;

        try {
            notifyAllObservers();
        }
        catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public State getState() {
        return state;
    }

    public void notifyAllObservers() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        for (Observer observer : getObservers())
            observer.update();
    }

    public void addObserver(Observer observer) {getObservers().add(observer);}

    public List<Observer> getObservers() {
        return observers;
    }

}