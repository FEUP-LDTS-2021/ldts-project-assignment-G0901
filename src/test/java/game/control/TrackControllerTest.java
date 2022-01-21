package game.control;

import game.Application;
import game.control.game.TrackController;
import game.gui.GUI;
import game.model.game.GameModel;
import game.model.game.TrackModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class TrackControllerTest {
    private TrackController controller;
    private TrackModel track_model;
    private GameModel game_model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        app = mock(Application.class);
        gui = mock(GUI.class);

        game_model = mock(GameModel.class);

        controller = new TrackController(game_model);
    }

    @Test
    void step() throws IOException {
        controller.step(app, gui.getAction());
        verify(game_model,times(1)).moveTrack();
    }
}
