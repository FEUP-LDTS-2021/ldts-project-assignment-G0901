package game.view.game;

import game.gui.GUI;
import game.model.game.GameModel;
import game.view.View;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GameView extends View<GameModel> {
    public TrackView track_view; //TODO Change views into subclass
    public CarView car_view;

    public GameView(GameModel model) {
        super(model);
        this.track_view = new TrackView();
        this.car_view = new CarView(model.getCarModel());
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        track_view.draw(gui.getGraphics(), model.getTrackModel());
        car_view.drawElements(gui);
        gui.refresh();

    }
}