package game.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.model.game.CarModel;
import game.model.Position;
import game.view.game.CarView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class CarViewTest {
    private TextGraphics graphics;
    private CarModel model;
    private CarView view;

    @BeforeEach
    void setUp() {
        graphics = mock(TextGraphics.class);
        model = mock(CarModel.class);
        when(model.getPosition()).thenReturn(new Position(0, 0));
        view = new CarView();
    }

    @Test
    void testCarView()  {
        view.draw(graphics, model);
        verify(graphics, times(1)).setBackgroundColor(any(TextColor.class));
    }
}
