/*package game.control;

import game.Application;
import game.control.menu.MenuController;
import game.gui.GUI;
import game.model.GameModelTest;
import game.model.game.GameModel;
import game.model.menu.MenuModel;
import game.states.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuControllerTest {
    private MenuController controller;
    private MenuModel model;
    private Application app;
    private GUI gui;
    private GameState game_state;

    @BeforeEach
    void setUp() {
        model = Mockito.mock(MenuModel.class);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
        game_state = Mockito.mock(GameState.class);

        controller = new MenuController(model);

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
}*/
