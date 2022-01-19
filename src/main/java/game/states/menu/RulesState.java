package game.states.menu;

import game.Application;
import game.control.menu.RulesController;
import game.gui.GUI;
import game.model.menu.RulesModel;
import game.states.State;
import game.view.menu.RulesView;

import java.io.IOException;

public class RulesState extends State<RulesModel> {
    public RulesState(RulesModel model) {
        super(model);
        view = new RulesView(model);
        controller = new RulesController(model);
    }

    @Override
    public void step(Application app, GUI gui) throws IOException {
        GUI.ACTION action = gui.getAction();
        controller.step(app, action);
        view.draw(gui);
    }
}
