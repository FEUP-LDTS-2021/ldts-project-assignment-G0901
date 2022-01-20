package game.states.menu;

import game.Application;
import game.control.menu.MenuController;
import game.gui.GUI;
import game.model.menu.MenuModel;
import game.states.State;
import game.view.menu.GenericTabView;
import game.view.menu.MenuView;

import java.io.IOException;

public class MenuState extends State<MenuModel> {
    public MenuState(MenuModel model) {
        super(model);
        view = new MenuView(model);
        controller = new MenuController(model);
    }

    @Override
    public void step(Application app, GUI gui) throws IOException {
        GUI.ACTION action = gui.getAction();
        controller.step(app, action);
        view.draw(gui);
    }
}
