package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.GameModel;
import game.model.game.TrackModel;

public class TrackController extends Controller<GameModel> {
    public TrackController(GameModel model) {
        super(model);
    }

    public void step(Application application, GUI.ACTION action)
    {
        getModel().moveTrack();
    }

}
