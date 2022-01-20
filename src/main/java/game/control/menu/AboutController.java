package game.control.menu;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.menu.AboutModel;
import game.model.menu.MenuModel;
import game.states.menu.MenuState;

public class AboutController extends Controller<AboutModel> {
    public AboutController(AboutModel model) {super(model);}

    public void step(Application app, GUI.ACTION action) {
        if (action == GUI.ACTION.ENTER || action == GUI.ACTION.ESC)
            app.setState(new MenuState(new MenuModel()));
    }
}
