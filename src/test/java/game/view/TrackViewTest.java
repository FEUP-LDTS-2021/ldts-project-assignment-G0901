package game.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.model.game.TrackModel;
import game.view.game.TrackView;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackViewTest {

    @Test
    public void testTrackView() throws IOException
    {
        int width = 20, height = 20;
        TextGraphics graphics = mock(TextGraphics.class);
        //TrackModel track = mock(TrackModel.class);
        TrackModel track = new TrackModel();

        when(graphics.getSize()).thenReturn(new TerminalSize(width, height));

        //when(track.getBackgroundColor()).thenReturn("test");
        //when(track.getDistance()).thenReturn(0);
        //when(track.getTerrainColor()).thenReturn();


        TrackView view = new TrackView();
        view.draw(graphics, track);
        verify(graphics, times(width * height)).fillRectangle(any(TerminalPosition.class), any(TerminalSize.class), anyChar());
    }
}
