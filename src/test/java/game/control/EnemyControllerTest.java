package game.control;

import game.Application;
import game.control.game.EnemyController;
import game.gui.GUI;

import game.model.game.CarModel;
import game.model.game.GameModel;
import game.model.game.TrackModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class EnemyControllerTest {
    private EnemyController enemyController;
    private CarModel enemy_model;
    private GameModel game_model;
    private TrackModel track_model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        enemy_model = new CarModel(0,70);
        track_model = mock(TrackModel.class);
        enemyController = new EnemyController(game_model);
        app = mock(Application.class);
        gui = mock(GUI.class);
    }

    @Test
    void step() throws IOException {
        enemyController.step(app, gui.getAction());
        assertEquals(69, enemy_model.getY());
        enemyController.step(app, gui.getAction());
        enemyController.step(app, gui.getAction());
        assertEquals(67, enemy_model.getY());
    }

}