package game.control.game;

import game.Application;
import game.control.Controller;
import game.gui.GUI;
import game.model.game.EnemyModel;

public class EnemyController extends Controller<EnemyModel>  {
    public EnemyController(EnemyModel model) {
        super(model);
    }

    public void step(Application application, GUI.ACTION action){getModel().getCloser(1);} //TO D0 create speed structure
}
