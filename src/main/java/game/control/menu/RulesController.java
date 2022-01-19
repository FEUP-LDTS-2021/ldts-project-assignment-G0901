package game.control.menu;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.model.menu.RulesModel;
import game.states.menu.MenuState;

public class RulesController extends Controller<RulesModel> {
    public RulesController(RulesModel model) {super(model);}

    public void step(Application app, GUI.ACTION action) {
        if (action == GUI.ACTION.QUIT)
            app.setState(null);
        if (action == GUI.ACTION.ENTER || action == GUI.ACTION.ESC)
            app.setState(new MenuState(new MenuModel()));
    }

}
