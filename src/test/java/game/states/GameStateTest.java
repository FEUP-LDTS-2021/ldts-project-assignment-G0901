package game.states;

import game.Application;
import game.control.GameController;
import game.gui.GUI;
import game.model.GameModel;
import game.view.GameView;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;


public class GameStateTest {
    private GameState gameState;
    private GameModel model;
    private GUI gui;
    private Application app;
    private GameController gameController;
    private GameView gameView;

    @Test
    public void step() throws IOException {
        gui = Mockito.mock(GUI.class);
        app = Mockito.mock(Application.class);
        gameController = Mockito.mock(GameController.class);
        gameView = Mockito.mock(GameView.class);

        model = new GameModel();
        gameState = new GameState(model);
        gameState.view = gameView;
        gameState.controller = gameController;

        gameState.step(app, gui);

        Mockito.verify(gameController, Mockito.times(1)).step(app, gui.getAction());
        Mockito.verify(gameView, Mockito.times(1)).draw(gui);

    }
}
