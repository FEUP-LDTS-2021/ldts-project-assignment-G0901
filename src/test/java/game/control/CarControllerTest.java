package game.control;

import game.Application;
import game.control.game.CarController;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.game.GameModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CarControllerTest {
    private CarController car_controller;
    private CarModel car_model;
    private GameModel game_model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        app = mock(Application.class);
        gui = mock(GUI.class);

        car_model = mock(CarModel.class);
        game_model = mock(GameModel.class);
        when(game_model.getCarModel()).thenReturn(car_model);

        car_controller = new CarController(game_model);
    }

    @Test
    void moveLeft()  {
        when(car_model.getLane()).thenReturn(0);

        car_controller.step(app, GUI.ACTION.LEFT);

        verify(car_model,times(1)).moveLeft();
    }

    @Test
    void moveLeftLimit() {
        when(car_model.getLane()).thenReturn(-1);

        car_controller.step(app, GUI.ACTION.LEFT);

        verify(car_model,times(0)).moveLeft();

    }

    @Test
    void moveRight()  {
        when(car_model.getLane()).thenReturn(0);

        car_controller.step(app, GUI.ACTION.RIGHT);

        verify(car_model,times(1)).moveRight();
    }

    @Test
    void moveRightLimit() {
        when(car_model.getLane()).thenReturn(1);

        car_controller.step(app, GUI.ACTION.RIGHT);

        verify(car_model,times(0)).moveRight();
    }
}