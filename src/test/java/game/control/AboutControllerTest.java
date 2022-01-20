package game.control;

import game.Application;
import game.control.menu.AboutController;
import game.gui.GUI;
import game.model.menu.AboutModel;
import game.states.menu.MenuState;
import game.view.menu.AboutView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;

public class AboutControllerTest {
    private AboutController controller;
    private AboutModel model;
    private AboutView view;
    private Application app;
    private GUI gui;


    @BeforeEach
    void setUp() {
        model = Mockito.mock(AboutModel.class);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);

        controller = new AboutController(model);
    }

    @Test
    void stepEnter() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ENTER);
        controller.step(app, gui.getAction());
        Mockito.verify(app, Mockito.times(1)).setState(any(MenuState.class));
    }

    @Test
    void stepEsc() throws IOException {
        Mockito.when(gui.getAction()).thenReturn(GUI.ACTION.ESC);
        controller.step(app, gui.getAction());
        Mockito.verify(app, Mockito.times(1)).setState(any(MenuState.class));
    }
}
