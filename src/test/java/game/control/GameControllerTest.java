package game.control;

import game.Application;
import game.control.game.CarController;
import game.control.game.EnemyController;
import game.control.game.GameController;
import game.control.game.TrackController;
import game.gui.GUI;
import game.model.game.GameModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameControllerTest {
    private GameController controller;
    private TrackController trackController;
    private CarController carController;
    private EnemyController enemyController;
    private GameModel game_model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        trackController = Mockito.mock(TrackController.class);
        carController = Mockito.mock(CarController.class);
        enemyController = Mockito.mock(EnemyController.class);
        app = Mockito.mock(Application.class);
        gui = Mockito.mock(GUI.class);

        game_model = Mockito.mock(GameModel.class);
        controller = new GameController(game_model);

        controller.track_controller = trackController;
        controller.car_controller = carController;
        controller.enemy_controller = enemyController;
    }

    @Test
    void step() throws IOException {
        controller.step(app, gui.getAction());

        Mockito.verify(trackController, Mockito.times(1)).step(app, gui.getAction());
        Mockito.verify(carController, Mockito.times(1)).step(app, gui.getAction());
        Mockito.verify(enemyController, Mockito.times(1)).step(app,gui.getAction());

    }
}
