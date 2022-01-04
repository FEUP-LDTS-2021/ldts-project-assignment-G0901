package control;
import model.CarModel;
import model.Position;
import model.TrackModel;
import view.CarView;
import view.GameView;
import view.TrackView;

import java.io.IOException;

public class GameController {
    GameView view = new GameView();
    CarModel car_model;
    TrackModel track_model;
    CarView car_view;
    TrackView track_view;

    public void run() throws IOException {
        car_model = new CarModel(new Position(1,2));

        view.initScreen();
        while (true) {
            car_view = new CarView(car_model);
            track_view = new TrackView(track_model);
            track_view.draw(view.getGraphics());
            car_view.draw(view.getGraphics());
            view.getScreen().refresh();
        }
    }
}
