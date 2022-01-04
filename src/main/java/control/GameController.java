package control;
import view.GameView;

import java.io.IOException;

public class GameController {
    GameView view = new GameView();

    public void run() throws IOException {
        view.initScreen();
    }
}
