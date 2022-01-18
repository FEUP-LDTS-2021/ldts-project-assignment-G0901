package game.control;

import game.Application;
import game.control.game_over.GameOverController;
import game.gui.GUI;
import game.model.game_over.GameOverModel;
import game.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameOverControllerTest {
    private GameOverController controller;
    private GameOverModel model;
    private Application app;
    private GUI gui;
    private GameState game_state;

    @BeforeEach
    void setUp() {
        model = Mockito.mock(GameOverModel.class);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
        game_state = Mockito.mock(GameState.class);

        controller = new GameOverController(model);
    }

    @Test
    void step() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.UP);
        controller.step(app, gui.getAction());
        Mockito.verify(model, Mockito.times(1)).previousItem();


        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.DOWN);
        controller.step(app, gui.getAction());
        Mockito.verify(model, Mockito.times(1)).nextItem();


        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ESC);
        controller.step(app, gui.getAction());
        Mockito.verify(app, Mockito.times(1)).setState(null);

    }

}
