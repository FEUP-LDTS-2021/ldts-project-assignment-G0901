package game.states.menu;

import game.Application;
import game.control.menu.AboutController;
import game.gui.GUI;
import game.model.menu.AboutModel;
import game.states.State;
import game.view.menu.AboutView;

import java.io.IOException;

public class AboutState extends State<AboutModel> {
    public AboutState(AboutModel model) {
        super(model);
        view = new AboutView(model);
        controller = new AboutController(model);
    }

    @Override
    public void step(Application app, GUI gui) throws IOException {
        GUI.ACTION action = gui.getAction();
        controller.step(app, action);
        view.draw(gui);
    }
}
