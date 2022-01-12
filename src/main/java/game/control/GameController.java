package game.control;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.GameModel;

import javax.sound.midi.Track;

    /*
public class GameController extends Controller<GameModel> {
    private GameModel

     */
public class GameController extends Controller<GameModel> {
    private TrackController track_controller;
    private CarController car_controller;

    public GameController(GameModel model) {
        super(model);
        track_controller = new TrackController(model.getTrackModel());
        car_controller = new CarController(model.getCarModel());
    }

    public void step(Application application, GUI.ACTION action) {
        track_controller.step(application, action);
        car_controller.step(application, action);
    }
}