package game.model;

import game.model.game.TrackModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackModelTest {
    private TrackModel track;

    @Test
    void testLoading() {
        track = new TrackModel();

        track.loadTrack("Monza");

        assertEquals("#99CCFF", track.getBackgroundColor());
    }

    @Test
    void testMovement() {
        track = new TrackModel();

        track.move(100);

        assertEquals(100, track.getDistance());
    }
}
