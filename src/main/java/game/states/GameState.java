package game.states;

import game.Application;
import game.control.TrackController;
import game.gui.GUI;
import game.model.TrackModel;
import game.view.GameView;

import java.io.IOException;

public class GameState extends State<TrackModel> {

    public GameState(TrackModel model)
    {
        super(model);
        this.view = new GameView(model);
        this.controller = new TrackController(model);
    }

    @Override
    public void step(Application app, GUI gui) throws IOException {
       controller.step(app);
       view.draw(gui);
    }
}
