package game.control;

import game.Application;
import game.control.game.TrackController;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.game.GameModel;
import game.model.game.TrackModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TrackControllerTest {
    private TrackController controller;
    private TrackModel track_model;
    private CarModel car_model;
    private GameModel game_model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        track_model = mock(TrackModel.class);
        car_model = mock(CarModel.class);
        game_model = new GameModel(car_model,track_model);
        controller = new TrackController(game_model);
        app = mock(Application.class);
        gui = mock(GUI.class);
    }

    @Test
    void step() throws IOException {
        controller.step(app, gui.getAction());
        verify(track_model,times(1)).move(anyInt());
    }
}
