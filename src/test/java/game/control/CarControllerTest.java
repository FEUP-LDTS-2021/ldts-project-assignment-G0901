package game.control;

import game.Application;
import game.control.game.CarController;
import game.gui.GUI;
import game.model.game.CarModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarControllerTest {
    private CarController carController;
    private CarModel model;
    private Application app;
    private GUI gui;

    @Test
    public void step()  {
        model = new CarModel();
        carController = new CarController(model);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);

        carController.step(app, GUI.ACTION.LEFT);
        assertEquals(28, model.getPosition().getX());
        carController.step(app, GUI.ACTION.RIGHT);
        carController.step(app, GUI.ACTION.RIGHT);
        assertEquals(52, model.getPosition().getX());
    }

}