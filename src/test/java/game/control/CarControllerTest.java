package game.control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import game.Application;
import game.gui.GUI;
import game.model.CarModel;
import game.model.GameModel;
import game.model.Model;
import game.model.Position;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameControllerTest {
    /*@Test
    public void CheckKeys()  {
        GameController controller = new GameController();
        CarModel model = new CarModel(new Position(30,20));
        com.googlecode.lanterna.input.KeyStroke key = new KeyStroke(KeyType.ArrowLeft);
        controller.processKey(key, model);
        controller.processKey(key, model);
        assertEquals(18, model.getPosition().getX());

        com.googlecode.lanterna.input.KeyStroke key2 = new KeyStroke(KeyType.ArrowRight);
        controller.processKey(key2, model);
        controller.processKey(key2, model);
        controller.processKey(key2, model);
        assertEquals(42, model.getPosition().getX());


    }*/

    private GameController controller;
    private TrackController trackController;
    private CarController carController;
    private CarModel model;
    private Application app;
    private GUI gui;

    @Test
    public void step() throws IOException {
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