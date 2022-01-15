package game.control;

import game.Application;
import game.control.game.CarController;
import game.model.game.CarModel;
import game.gui.GUI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarControllerTest {
    private CarController carController;
    private CarModel model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        model = new CarModel();
        carController = new CarController(model);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void step()  {
        carController.step(app, GUI.ACTION.LEFT);
        assertEquals(-1, model.getLane());
        carController.step(app, GUI.ACTION.RIGHT);
        carController.step(app, GUI.ACTION.RIGHT);
        assertEquals(1, model.getLane());
    }

}