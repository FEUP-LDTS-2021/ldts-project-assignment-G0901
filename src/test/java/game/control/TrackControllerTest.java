package game.control;

import game.Application;
import game.control.game.TrackController;
import game.gui.GUI;
import game.model.game.TrackModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackControllerTest {
    private TrackController controller;
    private TrackModel model;
    private Application app;
    private GUI gui;

    @Test
    public void step() throws IOException {
        model = new TrackModel();
        controller = new TrackController(model);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);

        controller.step(app, gui.getAction());

        assertEquals(1, model.getDistance());
    }
}
