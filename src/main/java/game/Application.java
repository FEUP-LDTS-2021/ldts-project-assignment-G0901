package game;

import com.googlecode.lanterna.TerminalSize;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.model.menu.SelectTrackModel;
import game.states.GameState;
import game.states.MenuState;
import game.states.SelectTrackState;
import game.states.State;

import java.io.IOException;

public class Application {
    private TerminalSize size = new TerminalSize(180,80);
    private State state;
    private GUI gui;

    public Application() {
        this.state = new MenuState(new MenuModel(size));
        //this.state = new SelectTrackState(new SelectTrackModel(size));
        //his.state = new GameState(new GameModel(size));
        this.gui = new GUI(size);
    }

    public static void main(String[] args) throws IOException {
        new Application().run();
    }

    private void run() throws IOException {
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
    }


}