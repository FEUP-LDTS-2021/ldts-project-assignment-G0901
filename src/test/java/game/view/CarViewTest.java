package game.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.Position;
import game.view.game.CarView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class CarViewTest {
    private GUI gui;
    private CarModel model;
    private CarView view;

    @BeforeEach
    void setUp() {
        gui = mock(GUI.class);
        model = mock(CarModel.class);
        when(model.getLane()).thenReturn(0);
        view = new CarView(model);
    }

    @Test
    void testCarView() throws IOException {
        view.draw(gui);
        verify(gui.graphics, times(1)).setBackgroundColor(any(TextColor.class));
    }
}
