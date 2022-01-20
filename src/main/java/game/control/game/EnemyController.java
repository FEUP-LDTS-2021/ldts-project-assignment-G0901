package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.CarModel;
import game.model.game.GameModel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnemyController extends Controller<GameModel>  {

    public EnemyController(GameModel model) {
        super(model);
    }

    public void step(Application application, GUI.ACTION action){
        generateEnemies();
        moveEnemies();
    }

    private void moveEnemies() {
        for (CarModel enemy: getModel().getEnemies()) {
            enemy.moveY(getModel().getVelocity());
        }
    }

    private void generateEnemies() {
        if (getModel().getTrackModel().getDistance() < 100) return;
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
        List<Character> colors = Arrays.asList('Y', 'R', 'G', 'W', 'U');
        Random random = new Random();
        int lane = random.nextInt(2 + 1) - 1;
        CarModel new_enemy = new CarModel(lane, 35);
        new_enemy.setColor(colors.get(random.nextInt(colors.size())));
        getModel().addEnemy(new_enemy);
    }
}
