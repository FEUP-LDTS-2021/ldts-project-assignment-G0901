package game.states;

import game.Application;
import game.control.menu.GameOverController;
import game.gui.GUI;
import game.model.menu.GameOverModel;
import game.states.menu.GameOverState;
import game.view.menu.GameOverView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameOverStateTest {
    private GameOverState state;
    private GameOverModel model;
    private GUI gui;
    private Application app;
    private GameOverController controller;
    private GameOverView view;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        app = Mockito.mock(Application.class);

        controller = Mockito.mock(GameOverController.class);
        view = Mockito.mock(GameOverView.class);
        model = new GameOverModel("Monza");

        state = new GameOverState(model);

        state.view = view;
        state.controller = controller;
    }

    @Test
    public void step() throws IOException {
        state.step(app, gui);

        Mockito.verify(gui, Mockito.times(1)).getAction();
        Mockito.verify(controller, Mockito.times(1)).step(app, gui.getAction());
        Mockito.verify(view, Mockito.times(1)).draw(gui);
    }
}
