package game.control;

import game.Application;
import game.control.game.CarController;
import game.control.game.EnemyController;
import game.control.game.GameController;
import game.control.game.TrackController;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.game.GameModel;
import game.states.menu.GameOverState;
import game.states.menu.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
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

    @Test
    void stepQuit() throws IOException {
        controller.step(app, GUI.ACTION.QUIT);

        Mockito.verify(app, Mockito.times(1)).setState(null);
    }

    @Test
    void stepEsc() throws IOException {
        controller.step(app, GUI.ACTION.ESC);

        Mockito.verify(app, Mockito.times(1)).setState(Mockito.any(MenuState.class));
    }

    void setUpCollision() {
        car = Mockito.mock(CarModel.class);
        enemy = Mockito.mock(CarModel.class);

        when(car.getLane()).thenReturn(0);
        when(enemy.getLane()).thenReturn(0);

        when(car.getHeight()).thenReturn(5);
        when(enemy.getHeight()).thenReturn(5);

        when(car.getY()).thenReturn(10);

        when(game_model.getCarModel()).thenReturn(car);
        when(game_model.getEnemies()).thenReturn(List.of(enemy));
    }

    @Test
    void testCollisionBefore() {
        setUpCollision();
        when(enemy.getY()).thenReturn(0);

        controller.step(app, GUI.ACTION.RIGHT);

        Mockito.verify(app, Mockito.times(0)).setState(
                Mockito.any(GameOverState.class));
    }

    @Test
    void testCollisionFirstBorder() {
        setUpCollision();
        when(enemy.getY()).thenReturn(5);

        controller.step(app, GUI.ACTION.RIGHT);

        Mockito.verify(app, Mockito.times(1)).setState(
                Mockito.any(GameOverState.class));
    }

    @Test
    void testCollisionLastBorder() {
        setUpCollision();
        when(enemy.getY()).thenReturn(15);

        controller.step(app, GUI.ACTION.RIGHT);

        Mockito.verify(app, Mockito.times(1)).setState(
                Mockito.any(GameOverState.class));
    }

    @Test
    void testCollisionAfter() {
        setUpCollision();
        when(enemy.getY()).thenReturn(20);

        controller.step(app, GUI.ACTION.RIGHT);

        Mockito.verify(app, Mockito.times(0)).setState(
                Mockito.any(GameOverState.class));
    }

    @Test
    void testCollisionLane() {
        setUpCollision();
        when(enemy.getLane()).thenReturn(20);

        controller.step(app, GUI.ACTION.RIGHT);

        Mockito.verify(app, Mockito.times(0)).setState(
                Mockito.any(GameOverState.class));
    }

    void setUpScore() {
        car = Mockito.mock(CarModel.class);
        enemy = Mockito.mock(CarModel.class);

        when(car.getHeight()).thenReturn(10);
        when(car.getY()).thenReturn(10);
        when(game_model.getCarModel()).thenReturn(car);
    }

    @Test
    void testScoring() {
        setUpScore();
        when(enemy.getY()).thenReturn(20);
        when(game_model.getEnemies()).thenReturn(List.of(enemy));

        controller.step(app, GUI.ACTION.RIGHT);

        Mockito.verify(game_model, Mockito.times(0)).setScore(anyInt());
    }

    @Test
    void testNotScoring() {
        setUpScore();
        when(enemy.getY()).thenReturn(21);
        when(game_model.getEnemies()).thenReturn(List.of(enemy));

        controller.step(app, GUI.ACTION.RIGHT);

        Mockito.verify(game_model, Mockito.times(1)).setScore(anyInt());
    }
}
