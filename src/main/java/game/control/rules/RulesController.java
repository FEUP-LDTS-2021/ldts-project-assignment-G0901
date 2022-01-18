package game.control.rules;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.model.rules.RulesModel;
import game.states.MenuState;

public class RulesController extends Controller<RulesModel> {
    public RulesController(RulesModel model) {super(model);}

    public void step(Application app, GUI.ACTION action) {
        if (action == GUI.ACTION.ENTER)
            app.setState(new MenuState(new MenuModel(getModel().getSize())));
    }

}
