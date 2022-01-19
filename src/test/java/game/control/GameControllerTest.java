package game.control;

import com.googlecode.lanterna.TerminalSize;
import game.Application;
import game.control.game.CarController;
import game.control.game.EnemyController;
import game.control.game.GameController;
import game.control.game.TrackController;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.game.GameModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class GameControllerTest {
    private GameController controller;
    private TrackController trackController;
    private CarController carController;
    private EnemyController enemyController;
    private GameModel game_model;
    private CarModel car, enemy;
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

    void setUpCollision() {
        car = Mockito.mock(CarModel.class);
        enemy = Mockito.mock(CarModel.class);

        when(car.getLane()).thenReturn(0);
        when(enemy.getLane()).thenReturn(0);

        when(car.getHeight()).thenReturn(5);
        when(enemy.getHeight()).thenReturn(5);

        when(car.getY()).thenReturn(10);
    }

    void setUpScore() {
        car = Mockito.mock(CarModel.class);
        enemy = Mockito.mock(CarModel.class);

        when(car.getHeight()).thenReturn(10);
        when(car.getY()).thenReturn(10);
    }

    @Test
    void testCollision1() {
        setUpCollision();
        when(enemy.getY()).thenReturn(0);

        Boolean collision = controller.checkCollision(car, enemy);

        assertFalse(collision);
    }

    @Test
    void testCollision2() {
        setUpCollision();
        when(enemy.getY()).thenReturn(9);

        Boolean collision = controller.checkCollision(car, enemy);

        assertTrue(collision);
    }

    @Test
    void testCollision3() {
        setUpCollision();
        when(enemy.getY()).thenReturn(14);

        Boolean collision = controller.checkCollision(car, enemy);

        assertTrue(collision);
    }

    @Test
    void testCollision4() {
        setUpCollision();
        when(enemy.getY()).thenReturn(20);

        Boolean collision = controller.checkCollision(car, enemy);

        assertFalse(collision);
    }

    @Test
    void testScore1() {
        setUpScore();
        when(enemy.getY()).thenReturn(20);

        Boolean score = controller.checkScore(car, enemy);

        assertFalse(score);
    }

    @Test
    void testScore2() {
        setUpScore();
        when(enemy.getY()).thenReturn(21);

        Boolean score = controller.checkScore(car, enemy);

        assertTrue(score);
    }
}
