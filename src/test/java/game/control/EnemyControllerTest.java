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

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class EnemyControllerTest {
    private EnemyController controller;
    private TrackModel track_model;
    private GameModel game_model;
    private Application app;
    private GUI gui;

    @BeforeEach
    void setUp() {
        app = mock(Application.class);
        gui = mock(GUI.class);

        track_model = Mockito.mock(TrackModel.class);
        when(track_model.getDistance()).thenReturn(200);
        game_model = mock(GameModel.class);
        when(game_model.getTrackModel()).thenReturn(track_model);

        controller = new EnemyController(game_model);
    }

    @Test
    void testMove() {
        CarModel enemy = Mockito.mock(CarModel.class);
        when(game_model.getEnemies()).thenReturn(List.of(enemy));

        controller.step(app, GUI.ACTION.ENTER);

        Mockito.verify(enemy, Mockito.times(1)).moveY(anyInt());
    }

    @Test
    void testGenerate() {
        when(game_model.getEnemies()).thenReturn(List.of());

        controller.step(app, GUI.ACTION.ENTER);

        verify(game_model, Mockito.times(1)).addEnemy(any(CarModel.class));
    }

    @Test
    void testGenerateDelay() {
        when(track_model.getDistance()).thenReturn(0);

        controller.step(app, GUI.ACTION.ENTER);

        verify(game_model, Mockito.times(0)).addEnemy(any(CarModel.class));
    }

    @Test
    void testGeneratePosition() {
        CarModel enemy = Mockito.mock(CarModel.class);
        when(enemy.getY()).thenReturn(30);
        when(game_model.getEnemies()).thenReturn(List.of(enemy));

        controller.step(app, GUI.ACTION.ENTER);

        verify(game_model, Mockito.times(0)).addEnemy(any(CarModel.class));
    }

    @Test
    void testRemoval() {
        CarModel enemy = Mockito.mock(CarModel.class);
        when(enemy.getY()).thenReturn(300);
        List<CarModel> enemies = new ArrayList<>() {{add(enemy);}};
        when(game_model.getEnemies()).thenReturn(enemies);

        controller.step(app, GUI.ACTION.ENTER);

        verify(game_model, Mockito.times(1)).addEnemy(any(CarModel.class));
    }
}