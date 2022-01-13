package game.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.Application;
import game.gui.GUI;
import game.model.CarModel;
import game.model.GameModel;
import game.model.Model;
import game.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

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
        assertEquals(28, model.getPosition().getX());
        carController.step(app, GUI.ACTION.RIGHT);
        carController.step(app, GUI.ACTION.RIGHT);
        assertEquals(52, model.getPosition().getX());
    }

}