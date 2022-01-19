package view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import model.CarModel;
import model.Position;
import org.junit.jupiter.api.Test;

import java.io.IOError;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class CarViewTest {

    @Test
    public void testCarView() throws IOException {
        TextGraphics graphics = mock(TextGraphics.class);
        CarModel model = mock(CarModel.class);
        when(model.getPosition()).thenReturn(new Position(0, 0));

        CarView view = new CarView(model);
        view.draw(graphics);
        verify(graphics, times(1)).setBackgroundColor(any(TextColor.class));
    }
}
