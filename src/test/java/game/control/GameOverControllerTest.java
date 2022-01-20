package game.control;

import game.Application;
import game.control.menu.GameOverController;
import game.gui.GUI;
import game.model.menu.GameOverModel;
import game.states.game.GameState;
import game.states.menu.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

public class GameOverControllerTest {
    private GameOverController controller;
    private GameOverModel model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);

        model = Mockito.mock(GameOverModel.class);

        controller = new GameOverController(model);
    }

    @Test
    void stepUp() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.UP);

        controller.step(app, gui.getAction());

        Mockito.verify(model, Mockito.times(1)).previousItem();
    }

    @Test
    void stepDown() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.DOWN);

        controller.step(app, gui.getAction());

        Mockito.verify(model, Mockito.times(1)).nextItem();
    }

    @Test
    void stepEsc() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ESC);

        controller.step(app, gui.getAction());

        Mockito.verify(app, Mockito.times(1)).setState(any(MenuState.class));
    }


    @Test
    void stepQuit() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.QUIT);

        controller.step(app, gui.getAction());

        Mockito.verify(app, Mockito.times(1)).setState(null);
    }

    @Test
    void stepEnter0() throws IOException {
        Mockito.when(model.getTrack()).thenReturn("Monza");
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ENTER);
        Mockito.when(model.getCurrentItem()).thenReturn(0);

        controller.step(app, gui.getAction());

        Mockito.verify(app, Mockito.times(1)).setState(any(GameState.class));
    }

    @Test
    void stepEnter1() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ENTER);
        Mockito.when(model.getCurrentItem()).thenReturn(1);

        controller.step(app, gui.getAction());

        Mockito.verify(app, Mockito.times(1)).setState(any(MenuState.class));
    }
}
