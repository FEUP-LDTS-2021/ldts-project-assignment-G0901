package game.model;

import game.model.game.TrackModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrackModelTest {
    private TrackModel track;

    String background_color = "#03fce8";
    String terrain_color1 = "#04de0f";
    String terrain_color2 = "#05ad0e";
    String kerb_color1 = "#e80505";
    String kerb_color2 = "#ffffff";
    String road_color = "#8f8f8f";

    @Test
    void testValues()
    {
        track = new TrackModel();
        assertEquals(background_color, track.getBackgroundColor());
        assertEquals(terrain_color1, track.getTerrainColor().get(0));
        assertEquals(terrain_color2, track.getTerrainColor().get(1));
        assertEquals(kerb_color1, track.getKerbColor().get(0));
        assertEquals(kerb_color2, track.getKerbColor().get(1));
        assertEquals(road_color, track.getRoadColor());
    }

    @Test
    void testSetters() {
        track = new TrackModel();
        track.setBackgroundColor("abc");
        track.setTerrainColor("abc", "def");
        track.setKerbColor("abc", "def");
        track.setRoadColor("abc");
        assertEquals("abc", track.getBackgroundColor());
        assertEquals("abc", track.getTerrainColor().get(0));
        assertEquals("def", track.getTerrainColor().get(1));
        assertEquals("abc", track.getKerbColor().get(0));
        assertEquals("def", track.getKerbColor().get(1));
        assertEquals("abc", track.getRoadColor());
    }
}
