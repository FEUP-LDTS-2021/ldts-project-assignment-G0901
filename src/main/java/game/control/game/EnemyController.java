package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.EnemyModel;
import game.model.game.GameModel;

public class EnemyController extends Controller<EnemyModel>  {
    GameModel game_model;
    public EnemyController(EnemyModel model, GameModel game_model) {
        super(model);
        this.game_model = game_model;
    }

    public void step(Application application, GUI.ACTION action){
        for (EnemyModel e: game_model.getEnemies()) {
            if (e.getPosition().getY() > 20)
                e.getCloserX();
            e.getCloserY(1);
        }

    } //TO D0 create speed structure
}
