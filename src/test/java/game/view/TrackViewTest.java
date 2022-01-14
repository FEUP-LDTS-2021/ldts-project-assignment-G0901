package game.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.model.game.TrackModel;
import game.view.game.TrackView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackViewTest {
    private TextGraphics graphics;
    private TrackModel track;
    private TrackView view;
    private int width, height;

    @BeforeEach
    void setUp() {
        width = 20;
        height = 20;
        graphics = mock(TextGraphics.class);
        //TrackModel track = mock(TrackModel.class);
        track = new TrackModel();

        when(graphics.getSize()).thenReturn(new TerminalSize(width, height));

        //when(track.getBackgroundColor()).thenReturn("test");
        //when(track.getDistance()).thenReturn(0);
        //when(track.getTerrainColor()).thenReturn();

        view = new TrackView();
    }

    @Test
    void testTrackView() throws IOException
    {
        view.draw(graphics, track);
        verify(graphics, times(width * height)).fillRectangle(any(TerminalPosition.class), any(TerminalSize.class), anyChar());
    }
}
