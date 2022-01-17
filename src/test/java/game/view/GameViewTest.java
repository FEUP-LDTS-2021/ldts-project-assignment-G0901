package game.view;

import com.googlecode.lanterna.TerminalSize;
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
        trackView = Mockito.mock(TrackView.class);
        carView = Mockito.mock(CarView.class);
        gui = Mockito.mock(GUI.class);

        model = new GameModel(new TerminalSize(40,40), "test");
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
