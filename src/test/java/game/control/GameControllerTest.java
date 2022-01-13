package game.control;

import game.Application;
import game.gui.GUI;
import game.model.GameModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameControllerTest {
    private GameController controller;
    private TrackController trackController;
    private CarController carController;
    private GameModel model;
    private Application app;
    private GUI gui;

    @Test
    public void step() throws IOException {
        trackController = Mockito.mock(TrackController.class);
        carController = Mockito.mock(CarController.class);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);

        model = new GameModel();
        controller = new GameController(model);

        controller.track_controller = trackController;
        controller.car_controller = carController;

        controller.step(app, gui.getAction());

        Mockito.verify(trackController, Mockito.times(1)).step(app, gui.getAction());
        Mockito.verify(carController, Mockito.times(1)).step(app, gui.getAction());

    }
}
