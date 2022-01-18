package game.control.game_over;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.GameModel;
import game.model.menu.MenuModel;
import game.model.game_over.GameOverModel;
import game.states.GameState;
import game.states.MenuState;

public class GameOverController extends Controller<GameOverModel> {
    public GameOverController(GameOverModel model) {
        super(model);
    }

    public void step(Application app, GUI.ACTION action) {
        switch (action) {
            case UP:
                getModel().previousItem();
                break;
            case DOWN:
                getModel().nextItem();
                break;
            case ESC:
                app.setState(null);
                break;
            case ENTER:
                if (getModel().whichSelected() == 0) {
                    app.setState(new GameState(new GameModel(getModel().getSize(),getModel().getTrack())));
                }
                else if (getModel().whichSelected() == 1)
                    app.setState(new MenuState(new MenuModel(getModel().getSize())));
                break;
        }

    }
}