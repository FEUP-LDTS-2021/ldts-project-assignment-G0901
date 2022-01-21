package game.control.menu;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.menu.AboutModel;
import game.model.menu.MenuModel;
import game.model.menu.RulesModel;
import game.model.menu.SelectTrackModel;
import game.states.menu.AboutState;
import game.states.menu.RulesState;
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
                break;
            case ENTER:
               if (getModel().getCurrentItem() == 0)
                   app.setState(new SelectTrackState(new SelectTrackModel()));
               else if (getModel().getCurrentItem() == 1) {
                   app.setState(new RulesState(new RulesModel()));
               }
               else if(getModel().getCurrentItem() == 2) {
                   app.setState(new AboutState(new AboutModel()));
               }
               else if (getModel().getCurrentItem() == 3)
                   app.setState(null);
               break;
        }
    }
}
