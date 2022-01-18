package game.states.menu;

import game.Application;
import game.control.menu.GameOverController;
import game.gui.GUI;
import game.model.menu.GameOverModel;
import game.states.State;
import game.view.menu.GameOverView;

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
