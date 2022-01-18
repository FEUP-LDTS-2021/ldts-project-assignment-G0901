package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.game.GameModel;
import game.model.menu.GameOverModel;
import game.model.menu.MenuModel;
import game.states.menu.GameOverState;
import game.states.menu.MenuState;

public class GameController extends Controller<GameModel> {
    public TrackController track_controller;
    public CarController car_controller;
    public EnemyController enemy_controller;

    public GameController(GameModel model) {
        super(model);
        track_controller = new TrackController(model);
        car_controller = new CarController(model);
        enemy_controller = new EnemyController(model);
    }

    public void step(Application application, GUI.ACTION action) {
        if (action == GUI.ACTION.QUIT)
            application.setState(null);
        if (action == GUI.ACTION.ESC)
            application.setState(new MenuState(new MenuModel(getModel().getSize())));

        handleCollisions(application);



        track_controller.step(application, action);
        car_controller.step(application, action);
        enemy_controller.step(application, action);
    }

  
    private void handleCollisions(Application application) {
        CarModel player = getModel().getCarModel();
        for (CarModel enemy : getModel().getEnemies()) {
            if (checkCollision(player, enemy)) {
                application.setState(new GameOverState(new GameOverModel(getModel().getSize(),getModel().getTrack())));
            }
        }
    }

    public Boolean checkCollision(CarModel player, CarModel enemy) {
        if (player.getLane() == enemy.getLane()) {
            return (player.getY() <= enemy.getY() + enemy.getHeight() &&
                    enemy.getY() <= player.getY() + player.getHeight());
        }
        return false;
    }
}