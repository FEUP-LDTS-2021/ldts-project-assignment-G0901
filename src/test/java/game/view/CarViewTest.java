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
import java.util.List;

import static org.mockito.Mockito.*;

public class CarViewTest {
    private GUI gui;
    private CarModel model;
    private CarView view;
    private List<String> car;
    private Character color;
    @BeforeEach
    void setUp() throws IOException{
        gui = new GUI(40,40);
        model = mock(CarModel.class);
        when(model.getLane()).thenReturn(0);
        view = new CarView(model);
        color = 'Y';
        car = view.loadSprite("car1.txt");
    }

    @Test
    void testCarView() throws IOException {
        view.drawElements(gui);
        //verify(view, times(1)).drawSprite(gui.graphics,car,color,10,model.getY());
        verify(model, times(2)).getY();
    }
}
