package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.TrackModel;

public class TrackController extends Controller<TrackModel> {
    public TrackController(TrackModel track_model) {
        super(track_model);
    }

    public void step(Application application, GUI.ACTION action)
    {
        getModel().move(1);
    }

}
