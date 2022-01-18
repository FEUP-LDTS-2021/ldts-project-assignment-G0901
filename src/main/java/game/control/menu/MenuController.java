package game.control.menu;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.GameModel;
import game.model.menu.MenuModel;
import game.model.rules.RulesModel;
import game.states.GameState;
import game.states.RulesState;

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
                break;
            case ENTER:
               if (getModel().whichSelected() == 0)
                   app.setState(new GameState(new GameModel(getModel().getSize())));
               else if (getModel().whichSelected() == 1) {
                   app.setState(new RulesState(new RulesModel(getModel().getSize())));
               }
               else if (getModel().whichSelected() == 3)
                   app.setState(null);
                break;
        }



    }
}
