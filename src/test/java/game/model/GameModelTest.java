package game.model;

import game.model.game.CarModel;
import game.model.game.GameModel;
import game.model.game.TrackModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class GameModelTest {
    private GameModel game;
    private CarModel car;
    private TrackModel track;
    private CarModel enemy;

    @BeforeEach
    void setUp() {
        car = mock(CarModel.class);
        track = mock(TrackModel.class);
        enemy = mock(CarModel.class);
        game = new GameModel("Monza");
        game.setTrackModel(track);
    }

    @Test
    void testMoveTrack(){
        game.moveTrack();

        Mockito.verify(track, Mockito.times(1)).move(game.getVelocity());
    }

}