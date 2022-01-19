package game.states;

import com.googlecode.lanterna.TerminalSize;
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
        //model = Mockito.mock(SelectTrackModel.class);
        app = Mockito.mock(Application.class);
        //gui = Mockito.mock(GUI.class);

        model = new SelectTrackModel();
        view = Mockito.mock(SelectTrackView.class);
        controller = Mockito.mock(SelectTrackController.class);
        gui = new GUI(new TerminalSize(1, 1));

        state = new SelectTrackState(model);
    }

    @Test
    void testStep() throws IOException {
        state.step(app, gui);

        //Mockito.verify(gui, Mockito.times(1)).getAction();
        //Mockito.verify(controller, Mockito.times(1)).step(app, gui.getAction());
        //Mockito.verify(view, Mockito.times(1)).draw(gui);
    }
}
