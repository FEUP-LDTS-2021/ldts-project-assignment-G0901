package game.control;

import game.Application;
import game.control.menu.SelectTrackController;
import game.gui.GUI;
import game.model.menu.SelectTrackModel;
import game.states.game.GameState;
import game.states.menu.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SelectTrackControllerTest {
    private SelectTrackController controller;
    private SelectTrackModel model;
    private Application app;

    @BeforeEach
    void setUp() {
        app = Mockito.mock(Application.class);
        model = Mockito.mock(SelectTrackModel.class);
        controller = new SelectTrackController(model);
    }

    @Test
    void stepRight() {
        controller.step(app, GUI.ACTION.RIGHT);

        verify(model, times(1)).nextItem();
    }

    @Test
    void stepLeft() {
        controller.step(app, GUI.ACTION.LEFT);

        verify(model, times(1)).previousItem();
    }

    @Test
    void testSelection() {
        Mockito.when(model.getSelected()).thenReturn("Monza");

        controller.step(app, GUI.ACTION.ENTER);

        Mockito.verify(app, Mockito.times(1)).setState(any(GameState.class));
    }

    @Test
    void testEscape() {
        controller.step(app, GUI.ACTION.ESC);

        verify(app, times(1)).setState(any(MenuState.class));
    }

    @Test
    void testQuit() {
        controller.step(app, GUI.ACTION.QUIT);

        verify(app, times(1)).setState(null);
    }
}
