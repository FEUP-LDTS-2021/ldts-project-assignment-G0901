package game.states;

import game.Application;
import game.control.GameController;
import game.gui.GUI;
import game.model.GameModel;
import game.view.GameView;

import java.io.IOException;

public class GameState extends State<GameModel> {

    public GameState(GameModel model)
    {
        super(model);
        this.view = new GameView(model);
        this.controller = new GameController(model);
    }

    @Override
    public void step(Application app, GUI gui) throws IOException {
        GUI.ACTION action = gui.getAction();
        controller.step(app, action);
        view.draw(gui);
    }
}
