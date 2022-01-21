package game.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.game.CarModel;
import game.view.game.CarView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarViewTest {
    private GUI gui;
    private CarModel model;
    private CarView view;

    @BeforeEach
    void setUp() throws IOException{
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(graphics.getSize()).thenReturn(new TerminalSize(100, 100));
        gui = Mockito.mock(GUI.class);
        Mockito.when(gui.getGraphics()).thenReturn(graphics);

        model = Mockito.mock(CarModel.class);
        Mockito.when(model.getLane()).thenReturn(0);
        Mockito.when(model.getY()).thenReturn(75);
        view = new CarView(model);
    }

    @Test
    void testPerspective() throws IOException {
        view.drawElements(gui);

        assertEquals(0.5, view.getPerspective());
    }
}
