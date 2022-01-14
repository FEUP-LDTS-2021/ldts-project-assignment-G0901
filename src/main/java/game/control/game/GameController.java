package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.GameModel;

public class GameController extends Controller<GameModel> {
    public TrackController track_controller;
    public CarController car_controller;
    public EnemyController enemy_controller;

    public GameController(GameModel model) {
        super(model);
        track_controller = new TrackController(model.getTrackModel());
        car_controller = new CarController(model.getCarModel());
        enemy_controller = new EnemyController(model.getEnemyModel());
    }

    public void step(Application application, GUI.ACTION action) {
        track_controller.step(application, action);
        car_controller.step(application, action);
        enemy_controller.step(application, action);
    }
}