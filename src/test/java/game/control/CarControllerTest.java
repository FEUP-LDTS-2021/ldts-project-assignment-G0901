/*package game.control;

import game.Application;
import game.control.game.CarController;
import game.model.game.CarModel;
import game.gui.GUI;

import game.model.game.GameModel;
import game.model.game.TrackModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CarControllerTest {
    private CarController carController;
    private CarModel car_model;
    private GameModel game_model;
    private TrackModel track_model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        car_model = mock(CarModel.class);
        track_model = mock(TrackModel.class);
        game_model = new GameModel(car_model,track_model);
        carController = new CarController(game_model);
        app = mock(Application.class);
        gui = mock(GUI.class);
    }

    @Test
    void step()  {
        carController.step(app, GUI.ACTION.LEFT);
        verify(car_model,times(1)).moveLeft();
        carController.step(app, GUI.ACTION.RIGHT);
        verify(car_model,times(1)).moveRight();
    }

}*/