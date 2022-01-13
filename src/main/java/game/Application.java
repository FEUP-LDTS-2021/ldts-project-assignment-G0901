package game;

import game.gui.GUI;
import game.model.GameModel;
import game.states.GameState;
import game.states.State;

import java.io.IOException;

public class Application {
    private State state;
    private GUI gui;

    public Application() {
        this.state = new GameState(new GameModel());
        this.gui = new GUI(80, 40);
    }

    public static void main(String[] args) throws IOException {
        new Application().run();
    }

    private void run() throws IOException {
        int FPS = 1;
        int frameTime = 20 / FPS;

        while (this.state != null)  {
            long startTime = System.currentTimeMillis();

            state.step(this, gui);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {}
        }
    }

    public void setState(State state) {
        this.state = state;
    }
}