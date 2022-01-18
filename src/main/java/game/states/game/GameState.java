package game.states.game;

import game.Application;
import game.control.game.GameController;
import game.gui.GUI;
import game.model.game.GameModel;
import game.states.State;
import game.view.game.GameView;

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
