package game.control.menu;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.GameModel;
import game.model.menu.MenuModel;
import game.model.menu.SelectTrackModel;
import game.states.game.GameState;
import game.states.menu.MenuState;

public class SelectTrackController extends Controller<SelectTrackModel> {
    public SelectTrackController(SelectTrackModel model) {
        super(model);
    }

    public void step(Application app, GUI.ACTION action) {
        if (action == GUI.ACTION.RIGHT)
            getModel().nextItem();
        if (action == GUI.ACTION.LEFT)
            getModel().previousItem();
        if (action == GUI.ACTION.ENTER)
            app.setState(new GameState(new GameModel(getModel().getSize(),
                    getModel().getCurrentTrack())));
        if (action == GUI.ACTION.ESC)
            app.setState(new MenuState(new MenuModel(getModel().getSize())));
        if (action == GUI.ACTION.QUIT)
            app.setState(null);
    }
}
