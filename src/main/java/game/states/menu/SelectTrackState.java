package game.states.menu;

import game.Application;
import game.control.menu.SelectTrackController;
import game.gui.GUI;
import game.model.menu.SelectTrackModel;
import game.states.State;
import game.view.menu.SelectTrackView;

import java.io.IOException;

public class SelectTrackState extends State<SelectTrackModel> {
    public SelectTrackState(SelectTrackModel model) {
        super(model);
        view = new SelectTrackView(model);
        controller = new SelectTrackController(model);
    }

    @Override
    public void step(Application app, GUI gui) throws IOException {
        GUI.ACTION action = gui.getAction();
        controller.step(app, action);
        view.draw(gui);
    }
}
