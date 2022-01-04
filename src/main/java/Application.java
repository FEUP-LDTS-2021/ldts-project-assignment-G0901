import control.GameController;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        GameController controller = new GameController();
        controller.run();
    }
}