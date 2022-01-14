package game.control;

import game.Application;
import game.gui.GUI;
import game.model.Model;
import game.model.TrackModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackControllerTest {
    private TrackController controller;
    private TrackModel model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        model = new TrackModel();
        controller = new TrackController(model);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void step() throws IOException {
        controller.step(app, gui.getAction());

        assertEquals(1, model.getDistance());
    }
}
