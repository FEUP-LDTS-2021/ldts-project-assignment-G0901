package control;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
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
        car_model = new CarModel(new Position(20, 10));
        track_model = new TrackModel();
        car_view = new CarView(car_model);
        track_view = new TrackView();

        view.initScreen();
      
        try {
            while (true) {
                view.clear();
                track_view.draw(view.getGraphics(), track_model);
                car_view.draw(view.getGraphics());
                view.getScreen().refresh();
                com.googlecode.lanterna.input.KeyStroke key = view.getScreen().readInput();
                processKey(key, car_model);
                view.getScreen().refresh();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processKey(com.googlecode.lanterna.input.KeyStroke key, CarModel model) {
        System.out.println(key);

        switch (key.getKeyType()) {
            case ArrowLeft -> model.moveLeft();
            case ArrowRight -> model.moveRight();

        }
    }
}

