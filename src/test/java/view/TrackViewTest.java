package view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import model.TrackModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TrackViewTest {

    @Test
    public void testTrackView() throws IOException
    {
        TextGraphics graphics = mock(TextGraphics.class);
        TrackModel track = mock(TrackModel.class);

        TrackView view = new TrackView(track);
        view.draw(graphics);
        verify(graphics, times(1)).setForegroundColor(any(TextColor.class));
    }
}
