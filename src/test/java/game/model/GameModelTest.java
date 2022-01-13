package game.model;

import game.model.CarModel;
import game.model.GameModel;
import game.model.TrackModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class GameModelTest {
    private GameModel game;
    private CarModel car;
    private TrackModel track;

    @BeforeEach
    void setUp() {
        car = mock(CarModel.class);
        track = mock(TrackModel.class);
        game = new GameModel();
    }

    @Test
    void testSetGet(){
        game.setCarModel(car);
        game.setTrackModel(track);
        assertEquals(car,game.getCarModel());
        assertEquals(track,game.getTrackModel());
    }

}
