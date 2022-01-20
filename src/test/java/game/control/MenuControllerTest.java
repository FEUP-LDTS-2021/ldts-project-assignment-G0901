package game.control;

import game.Application;
import game.control.menu.MenuController;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.states.menu.AboutState;
import game.states.menu.RulesState;
import game.states.menu.SelectTrackState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

public class MenuControllerTest {
    private MenuController controller;
    private MenuModel model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        model = Mockito.mock(MenuModel.class);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);

        controller = new MenuController(model);

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
    void stepQuit() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.QUIT);

        controller.step(app, gui.getAction());

        Mockito.verify(app, Mockito.times(1)).setState(null);

    }

    @Test
    void stepEnter0() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ENTER);
        Mockito.when(model.getCurrentItem()).thenReturn(0);

        controller.step(app, gui.getAction());

        Mockito.verify(app, Mockito.times(1)).setState(any(SelectTrackState.class));
    }

    @Test
    void stepEnter1() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ENTER);
        Mockito.when(model.getCurrentItem()).thenReturn(1);

        controller.step(app, gui.getAction());

        Mockito.verify(app, Mockito.times(1)).setState(any(RulesState.class));

    }

    @Test
    void stepEnter2() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ENTER);
        Mockito.when(model.getCurrentItem()).thenReturn(2);

        controller.step(app, gui.getAction());

        Mockito.verify(app, Mockito.times(1)).setState(any(AboutState.class));

    }

    @Test
    void stepEnter3() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ENTER);
        Mockito.when(model.getCurrentItem()).thenReturn(3);

        controller.step(app, gui.getAction());

        Mockito.verify(app, Mockito.times(1)).setState(null);
    }
}
