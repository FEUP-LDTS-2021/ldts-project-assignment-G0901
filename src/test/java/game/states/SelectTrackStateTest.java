package game.states;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.Application;
import game.control.menu.SelectTrackController;
import game.gui.GUI;
import game.model.menu.SelectTrackModel;
import game.states.menu.SelectTrackState;
import game.view.menu.SelectTrackView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class SelectTrackStateTest {
    private SelectTrackState state;
    private SelectTrackModel model;
    private SelectTrackController controller;
    private SelectTrackView view;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        gui = Mockito.mock(GUI.class);
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(graphics.getSize()).thenReturn(new TerminalSize(1, 1));
        Mockito.when(gui.getGraphics()).thenReturn(graphics);

        app = Mockito.mock(Application.class);

        controller = Mockito.mock(SelectTrackController.class);
        view = Mockito.mock(SelectTrackView.class);

        model = new SelectTrackModel();

        state = new SelectTrackState(model);

        state.view = view;
        state.controller = controller;
    }

    @Test
    void testStep() throws IOException {
        state.step(app, gui);

        Mockito.verify(gui, Mockito.times(1)).getAction();
        Mockito.verify(controller, Mockito.times(1)).step(app, gui.getAction());
        Mockito.verify(view, Mockito.times(1)).draw(gui);
    }
}
