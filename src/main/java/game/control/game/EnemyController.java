package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.game.GameModel;

import java.util.Random;

public class EnemyController extends Controller<GameModel>  {

    public EnemyController(GameModel model) {
        super(model);
    }

    public void step(Application application, GUI.ACTION action){
        generateEnemies();
        for (CarModel enemy: getModel().getEnemies()) {
            enemy.moveY(getModel().getVelocity());
        }
    }

    private void generateEnemies() {
        Random random = new Random();
        int lane = random.nextInt(2 + 1) - 1;
        if (getModel().getEnemies().isEmpty()) {
            getModel().addEnemy(new CarModel(lane, getModel().getHeight() / 2));
        }
        else {
            if (getModel().getEnemies().get(0).getY() > getModel().getHeight() &&
            getModel().getEnemies().size() < 2) {
                getModel().getEnemies().remove(0);
                getModel().addEnemy(new CarModel(lane, getModel().getHeight() / 2));
            }
        }
    }
}
