package game.states;

import game.Application;
import game.control.game_over.GameOverController;
import game.gui.GUI;
import game.model.game_over.GameOverModel;
import game.view.game_over.GameOverView;

import java.io.IOException;

public class GameOverState extends State<GameOverModel> {
    public GameOverState(GameOverModel model) {
        super(model);
        view = new GameOverView(model);
        controller = new GameOverController(model);

    }

    @Override
    public void step(Application app, GUI gui) throws IOException {
        GUI.ACTION action = gui.getAction();
        controller.step(app, action);
        view.draw(gui);
    }
}
