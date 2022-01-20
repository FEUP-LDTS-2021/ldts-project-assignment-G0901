package game.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.game.TrackModel;
import game.view.game.TrackView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackViewTest {
    private GUI gui;
    private TextGraphics graphics;
    private TrackModel track;
    private TrackView view;
    private TerminalSize size;

    @BeforeEach
    void setUp() {
        size = new TerminalSize(100, 100);
        graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(graphics.getSize()).thenReturn(size);
        gui = Mockito.mock(GUI.class);
        Mockito.when(gui.getGraphics()).thenReturn(graphics);

        track = new TrackModel();

        view = new TrackView(track);
    }

    @Test
    void testTrackView() throws IOException
    {
        view.drawElements(gui);

        verify(graphics, times(size.getColumns()
                * size.getRows())).fillRectangle(any(TerminalPosition.class),
                any(TerminalSize.class), anyChar());
    }
}
