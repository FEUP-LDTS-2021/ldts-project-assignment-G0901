package control;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import model.CarModel;
import model.Position;
import view.CarView;
import view.GameView;

import java.io.IOException;

public class GameController {
    GameView view = new GameView();

    CarModel model = new CarModel(new Position(20, 10));
    CarView modelView = new CarView(model);
    public void run() throws IOException {
        view.initScreen();
        try {
            while (true) {
                view.clear();
                modelView.draw(view.getGraphics());
                view.getScreen().refresh();
                com.googlecode.lanterna.input.KeyStroke key = view.getScreen().readInput();
                processKey(key, model);
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

