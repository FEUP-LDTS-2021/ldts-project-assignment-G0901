package game.control.menu;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.GameModel;
import game.model.menu.GameOverModel;
import game.model.menu.MenuModel;
import game.states.game.GameState;
import game.states.menu.MenuState;

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
                app.setState(new MenuState(new MenuModel()));
                break;
            case QUIT:
                app.setState(null);
            case ENTER:
                if (getModel().getCurrentItem() == 0) {
                    app.setState(new GameState(new GameModel(getModel().getTrack())));
                }
                else if (getModel().getCurrentItem() == 1)
                    app.setState(new MenuState(new MenuModel()));
                break;
        }

    }
}