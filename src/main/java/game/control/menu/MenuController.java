package game.control.menu;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.model.menu.RulesModel;
import game.states.menu.MenuState;
import game.states.menu.RulesState;
import game.model.menu.SelectTrackModel;
import game.states.menu.SelectTrackState;


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
            case QUIT:
                app.setState(null);
            case ENTER:
               if (getModel().whichSelected() == 0)
                   app.setState(new SelectTrackState(new SelectTrackModel(getModel().getSize())));
               else if (getModel().whichSelected() == 1) {
                   app.setState(new RulesState(new RulesModel(getModel().getSize())));
               }
               else if (getModel().whichSelected() == 3)
                   app.setState(null);
                break;
        }
    }
}
