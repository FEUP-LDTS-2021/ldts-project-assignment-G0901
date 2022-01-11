package game.view;

import game.gui.GUI;
import game.model.TrackModel;

import java.io.IOException;

public class GameView extends View<TrackModel> {
    TrackView track_view; //TODO Change views into subclass

    public GameView(TrackModel model) {
        super(model);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        track_view = new TrackView();
        track_view.draw(gui.getGraphics(), model);
        gui.refresh();

    }
}