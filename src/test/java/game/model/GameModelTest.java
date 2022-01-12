package game.model;

import game.model.CarModel;
import game.model.GameModel;
import game.model.TrackModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class GameModelTest {
    private GameModel game;

    @Test
    void testSetGet(){
        CarModel car = mock(CarModel.class);
        TrackModel track = mock(TrackModel.class);
        game = new GameModel();
        game.setCarModel(car);
        game.setTrackModel(track);
        assertEquals(car,game.getCarModel());
        assertEquals(track,game.getTrackModel());
    }

}
