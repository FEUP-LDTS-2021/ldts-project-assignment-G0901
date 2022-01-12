package game.view;

import game.gui.GUI;
import game.model.GameModel;
import game.model.TrackModel;

import java.io.IOException;

public class GameView extends View<GameModel> {
    TrackView track_view; //TODO Change views into subclass
    CarView car_view;

    public GameView(GameModel model) {
        super(model);
        this.track_view = new TrackView();
        this.car_view = new CarView();
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        track_view.draw(gui.getGraphics(), model.getTrackModel());
        car_view.draw(gui.getGraphics(), model.getCarModel());
        gui.refresh();

    }
}