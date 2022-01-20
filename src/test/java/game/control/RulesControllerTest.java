package game.control;

import game.Application;
import game.control.menu.RulesController;
import game.gui.GUI;
import game.model.menu.RulesModel;
import game.states.menu.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

public class RulesControllerTest {
    private RulesController controller;
    private MenuState menu_state;
    private RulesModel model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
        model = Mockito.mock(RulesModel.class);
        menu_state = Mockito.mock(MenuState.class);

        controller = new RulesController(model);
    }

    @Test
    void step() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ENTER);

        controller.step(app, gui.getAction());

        Mockito.verify(app, Mockito.times(1)).setState(any(MenuState.class));
    }

    @Test
    void stepQuit() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.QUIT);

        controller.step(app, gui.getAction());

        Mockito.verify(app, Mockito.times(1)).setState(null);
    }
}
