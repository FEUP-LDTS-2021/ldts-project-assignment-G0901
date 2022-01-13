package game.view;

import game.gui.GUI;
import game.model.GameModel;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class GameViewTest {
    private GameView view;
    private GameModel model;
    private TrackView trackView;
    private CarView carView;
    private GUI gui;

    @Test
    public void drawElements() throws IOException {
       trackView = Mockito.mock(TrackView.class);
       carView = Mockito.mock(CarView.class);
       gui = Mockito.mock(GUI.class);

       model = new GameModel();
       view = new GameView(model);

       view.track_view = trackView;
       view.car_view = carView;

       view.drawElements(gui);

       Mockito.verify(trackView, Mockito.times(1)).draw(gui.getGraphics(), model.getTrackModel());
       Mockito.verify(carView, Mockito.times(1)).draw(gui.getGraphics(), model.getCarModel());


    }
}
