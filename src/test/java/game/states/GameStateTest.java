package game.states;

import game.Application;
import game.control.game.GameController;
import game.gui.GUI;
import game.model.game.GameModel;
import game.view.game.GameView;

import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        app = Mockito.mock(Application.class);
        gameController = Mockito.mock(GameController.class);
        gameView = Mockito.mock(GameView.class);

        model = new GameModel();
        gameState = new GameState(model);

        gameState.view = gameView;
        gameState.controller = gameController;

    }

    @Test
    public void step() throws IOException {
        gameState.step(app, gui);

        Mockito.verify(gameController, Mockito.times(1)).step(app, gui.getAction());
        Mockito.verify(gameView, Mockito.times(1)).draw(gui);
    }
}
