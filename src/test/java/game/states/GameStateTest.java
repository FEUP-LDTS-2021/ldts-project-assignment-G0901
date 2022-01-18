package game.states;

import game.Application;
import game.control.game.GameController;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.game.GameModel;
import game.states.game.GameState;
import game.view.game.GameView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.when;


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

        model = Mockito.mock(GameModel.class);
        when(model.getCarModel()).thenReturn(Mockito.mock(CarModel.class));

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
