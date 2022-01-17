package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.game.GameModel;

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
        handleCollisions();

        track_controller.step(application, action);
        car_controller.step(application, action);
        enemy_controller.step(application, action);
    }

    private void handleCollisions() {
        CarModel player = getModel().getCarModel();
        for (CarModel enemy : getModel().getEnemies()) {
            if (checkCollision(player, enemy)) {
                System.out.println("HIT");
            }
        }
    }

    public Boolean checkCollision(CarModel player, CarModel enemy) {
        System.out.println(player.getHeight());
        if (player.getLane() == enemy.getLane()) {
            return (player.getY() <= enemy.getY() + enemy.getHeight() &&
                    enemy.getY() <= player.getY() + player.getHeight());
        }
        return false;
    }
}