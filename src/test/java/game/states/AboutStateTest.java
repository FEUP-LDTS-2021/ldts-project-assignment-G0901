package game.states;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.Application;
import game.control.menu.AboutController;
import game.gui.GUI;
import game.model.menu.AboutModel;
import game.states.menu.AboutState;
import game.view.menu.AboutView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;


public class AboutStateTest {
    private AboutState state;
    private AboutController controller;
    private AboutModel model;
    private AboutView view;
    private GUI gui;
    private Application app;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        app = Mockito.mock(Application.class);
        controller = Mockito.mock(AboutController.class);
        view = Mockito.mock(AboutView.class);

        model = new AboutModel();
        state = new AboutState(model);

        state.view = view;
        state.controller = controller;
    }

    @Test
    void step() throws IOException {
        state.step(app, gui);

        Mockito.verify(controller, Mockito.times(1)).step(app, gui.getAction());
        Mockito.verify(view, Mockito.times(1)).draw(gui);    }

}