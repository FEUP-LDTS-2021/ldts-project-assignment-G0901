package game.control.menu;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.GameModel;
import game.model.menu.MenuModel;
import game.states.GameState;

public class MenuController extends Controller<MenuModel> {
    public MenuController(MenuModel model) {
        super(model);
    }

    public void step(Application app, GUI.ACTION action) {
        switch (action){
            case UP:
                getModel().previousItem();
                break;
            case DOWN:
                getModel().nextItem();
                break;
            case ESC:
                app.setState(null);
            case ENTER:
               if (getModel().whichSelected() == 0) app.setState(new GameState(new GameModel()));
               // TODO  finish conditions for rest of states (rules, about);
                break;
        }



    }
}
