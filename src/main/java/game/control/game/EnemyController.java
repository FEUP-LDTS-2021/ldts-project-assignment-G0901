package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.game.GameModel;

import java.util.List;
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
        List<CarModel> enemies = getModel().getEnemies();
        if (enemies.isEmpty()) {
            addEnemy();
        }
        else {
            if (enemies.get(enemies.size() - 1).getY() > 70) {
                addEnemy();
            }
            //remove older
            if (enemies.get(0).getY() > 100)
                enemies.remove(0);
        }
    }

    private void addEnemy() {
        Random random = new Random();
        int lane = random.nextInt(2 + 1) - 1;
        getModel().addEnemy(new CarModel(lane, 35));
    }
}
