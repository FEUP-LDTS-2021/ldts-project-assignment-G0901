package game.model;

import game.model.game.CarModel;
import game.model.game.GameModel;
import game.model.game.TrackModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class GameModelTest {
    private GameModel game;
    private CarModel car;
    private TrackModel track;
    private EnemyModel enemy;

    @BeforeEach
    void setUp() {
        car = mock(CarModel.class);
        track = mock(TrackModel.class);
        enemy = mock(EnemyModel.class);
        game = new GameModel();
    }

    @Test
    void testSetGet(){
        game.setCarModel(car);
        game.setTrackModel(track);
        game.setEnemyModel(enemy);
        assertEquals(car,game.getCarModel());
        assertEquals(track,game.getTrackModel());
        assertEquals(enemy,game.getEnemyModel());
    }

}
