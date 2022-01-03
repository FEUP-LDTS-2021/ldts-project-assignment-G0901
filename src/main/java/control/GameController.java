package control;
import model.CarModel;
import view.GameView;

import java.io.IOException;

public class GameController {
    GameView view = new GameView();

    public void run() throws IOException {
        view.initScreen();
    }

    public void processKey(com.googlecode.lanterna.input.KeyStroke key, CarModel model) {

        }
}


