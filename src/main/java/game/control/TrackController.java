package game.control;

import game.Application;
import game.gui.GUI;
import game.model.TrackModel;

public class TrackController extends Controller<TrackModel> {
    public TrackController(TrackModel track_model) {
        super(track_model);
    }

    public void step(Application application, GUI.ACTION action)
    {
        getModel().move(1);
    }

}
