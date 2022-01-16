package game.control.game;

import com.googlecode.lanterna.TerminalSize;
import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.EnemyModel;
import game.model.game.GameModel;

public class EnemyController extends Controller<EnemyModel>  {
    GameModel game_model;
    TerminalSize size;

    public EnemyController(EnemyModel model, GameModel game_model) {
        super(model);
        this.game_model = game_model;
    }

    public void step(Application application, GUI.ACTION action){

        for (EnemyModel e: game_model.getEnemies()) {
            if (e.getPosition().getY() > 20)
                e.moveEnemyX();
            e.moveEnemyY(1);
        }

    } //TO D0 create speed structure
}
