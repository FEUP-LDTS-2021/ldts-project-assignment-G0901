package game.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.game.TrackModel;
import game.view.game.TrackView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackViewTest {
    private GUI gui;
    private TextGraphics graphics;
    private TrackModel track;
    private TrackView view;
    private int width, height;

    @BeforeEach
    void setUp() {
        width = 20;
        height = 20;
        graphics = mock(TextGraphics.class);
        gui = mock(GUI.class);
        //TrackModel track = mock(TrackModel.class);
        track = new TrackModel();

        when(graphics.getSize()).thenReturn(new TerminalSize(width, height));

        //when(track.getBackgroundColor()).thenReturn("test");
        //when(track.getDistance()).thenReturn(0);
        //when(track.getTerrainColor()).thenReturn();

        view = new TrackView(track);
    }

    @Test
    void testTrackView() throws IOException
    {
        view.drawElements(gui);
        gui.graphics = graphics;
        verify(graphics, times(width * height)).fillRectangle(any(TerminalPosition.class), any(TerminalSize.class), anyChar());
    }
}
