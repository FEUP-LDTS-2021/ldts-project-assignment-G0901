package game.view;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.Size;
import game.model.game.CarModel;
import game.model.Position;
import game.view.game.CarView;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

public class CarViewTest {
    private GUI gui;
    private CarModel model;
    private CarView view;

    @BeforeEach
    void setUp() throws IOException{
        gui = new GUI(new Size(40,40));
        model = mock(CarModel.class);
        when(model.getLane()).thenReturn(0);
        view = new CarView(model);
    }

    @Test
    void testCarView() throws IOException {
        view.drawElements(gui);
        verify(model, times(2)).getY();
    }
}
