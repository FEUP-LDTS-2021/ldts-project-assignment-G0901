package game.model;

import game.model.game.CarModel;
import game.model.game.GameModel;
import game.model.game.TrackModel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class GameModelTest {
    private GameModel game_by_size;
    private GameModel game_by_elements;
    private CarModel car;
    private TrackModel track;
    private CarModel enemy;
    private int width, height;

    @BeforeEach
    void setUp() {
        width = 180;
        height = 80;
        car = mock(CarModel.class);
        track = mock(TrackModel.class);
        enemy = mock(CarModel.class);
        game_by_size = new GameModel(width,height);
        game_by_elements = new GameModel(car,track);
    }

    @Test
    void testSetGet(){
        game_by_size.setCarModel(car);
        game_by_size.setTrackModel(track);
        game_by_elements.addEnemy(enemy);
        assertEquals(car,game_by_size.getCarModel());
        assertEquals(track,game_by_size.getTrackModel());
        assertEquals(true,game_by_elements.getEnemies().contains(enemy));
        assertEquals((int)(80 * 0.90),game_by_size.getCarModel().getY());
    }

}
