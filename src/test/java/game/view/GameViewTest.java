package game.view;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import game.gui.GUI;
import game.model.game.GameModel;
import game.view.game.CarView;
import game.view.game.GameView;
import game.view.game.TrackView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameViewTest {
    private GameView view;
    private GameModel model;
    private TrackView trackView;
    private CarView carView;
    private GUI gui;

    @BeforeEach
    void setUp() {
        TextGraphics graphics = Mockito.mock(TextGraphics.class);
        Mockito.when(graphics.getSize()).thenReturn(new TerminalSize(100, 100));
        gui = Mockito.mock(GUI.class);
        Mockito.when(gui.getGraphics()).thenReturn(graphics);

        trackView = Mockito.mock(TrackView.class);
        carView = Mockito.mock(CarView.class);

        model = new GameModel("Monza");
        view = new GameView(model);

        view.track_view = trackView;
        view.car_view = carView;
    }

    @Test
    void drawElements() throws IOException {
       view.drawElements(gui);

       Mockito.verify(trackView, Mockito.times(1)).drawElements(gui);
       Mockito.verify(carView, Mockito.times(1)).drawElements(gui);
    }
}
